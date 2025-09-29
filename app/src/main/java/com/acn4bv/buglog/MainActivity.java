package com.acn4bv.buglog;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
    private Button btnReportar;

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

        // Evento obligatorio: click en Reportar
        btnReportar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                reportar();
            }
        });

    }

    private void reportar() {
        String nombre = etNombreJuego.getText().toString().trim();
        String desc   = etDescripcion.getText().toString().trim();

        int posPlat = spPlataforma.getSelectedItemPosition();
        int posTipo = spTipoBug.getSelectedItemPosition();
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


        com.acn4bv.buglog.Bug nuevo = new com.acn4bv.buglog.Bug(nombre, plataforma, tipo, gravedad, desc);
        com.acn4bv.buglog.BugRepository.add(nuevo);

        toast(R.string.bug_reportado);


        etNombreJuego.setText("");
        etDescripcion.setText("");
        spPlataforma.setSelection(0);
        spTipoBug.setSelection(0);
        rgGravedad.clearCheck();
    }

    private void toast(int resId) { Toast.makeText(this, resId, Toast.LENGTH_SHORT).show(); }
}
