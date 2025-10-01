package com.acn4bv.buglog;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNombreJuego, etDescripcion;
    private Spinner spPlataforma, spTipoBug;
    private RadioGroup rgGravedad;
    private Button btnReportar, btnVerLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombreJuego = findViewById(R.id.etNombreJuego);
        etDescripcion = findViewById(R.id.etDescripcion);
        spPlataforma  = findViewById(R.id.spPlataforma);
        spTipoBug     = findViewById(R.id.spTipoBug);
        rgGravedad    = findViewById(R.id.rgGravedad);
        btnReportar   = findViewById(R.id.btnReportar);
        btnVerLista   = findViewById(R.id.btnVerLista);

        // Configurar Spinner de Plataforma con estilo personalizado
        ArrayAdapter<CharSequence> adapterPlataforma = ArrayAdapter.createFromResource(
                this,
                R.array.plataformas,
                R.layout.spinner_item
        );
        adapterPlataforma.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spPlataforma.setAdapter(adapterPlataforma);

        // Configurar Spinner de Tipo de Bug con estilo personalizado
        ArrayAdapter<CharSequence> adapterTipoBug = ArrayAdapter.createFromResource(
                this,
                R.array.tipos_bug,
                R.layout.spinner_item
        );
        adapterTipoBug.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spTipoBug.setAdapter(adapterTipoBug);

        btnReportar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                reportar();
            }
        });

        btnVerLista.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListaBugsActivity.class));
            }
        });
    }

    private void reportar() {
        String nombre = etNombreJuego.getText().toString().trim();
        String desc   = etDescripcion.getText().toString().trim();

        int posPlat = spPlataforma.getSelectedItemPosition(); // 0 = "Seleccione plataforma"
        int posTipo = spTipoBug.getSelectedItemPosition();    // 0 = "Seleccione tipo"

        int checked = rgGravedad.getCheckedRadioButtonId();
        String gravedad = null;
        if (checked == R.id.rbBaja)  gravedad = getString(R.string.gravedad_baja);
        if (checked == R.id.rbMedia) gravedad = getString(R.string.gravedad_media);
        if (checked == R.id.rbAlta)  gravedad = getString(R.string.gravedad_alta);

        if (TextUtils.isEmpty(nombre)) { toast(R.string.error_nombre_vacio); return; }
        if (posPlat == 0)              { toast(R.string.error_plataforma);   return; }
        if (posTipo == 0)              { toast(R.string.error_tipo_bug);     return; }
        if (gravedad == null)          { toast(R.string.error_gravedad);     return; }
        if (TextUtils.isEmpty(desc))   { toast(R.string.error_descripcion);  return; }

        String plataforma = spPlataforma.getSelectedItem().toString();
        String tipo       = spTipoBug.getSelectedItem().toString();

        Bug nuevo = new Bug(nombre, plataforma, tipo, gravedad, desc);
        BugRepository.add(nuevo);

        toast(R.string.bug_reportado);

        // Limpieza de formulario
        etNombreJuego.setText("");
        etDescripcion.setText("");
        spPlataforma.setSelection(0);
        spTipoBug.setSelection(0);
        rgGravedad.clearCheck();
    }

    private void toast(int resId) { Toast.makeText(this, resId, Toast.LENGTH_SHORT).show(); }
}