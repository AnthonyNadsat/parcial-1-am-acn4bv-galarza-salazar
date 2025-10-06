package com.acn4bv.buglog;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListaBugsActivity extends AppCompatActivity {

    private LinearLayout containerBugs;
    private String filtroActual = "TODOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bugs);

        containerBugs = findViewById(R.id.containerBugs);

        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        cargarBugs();
        agregarBotonFlotanteFiltro();
    }

    private void agregarBotonFlotanteFiltro() {
        ViewGroup root = findViewById(android.R.id.content);
        Resources res   = getResources();

        int sizePx = res.getDimensionPixelSize(R.dimen.button_height);   // 48dp
        int padPx  = res.getDimensionPixelSize(R.dimen.padding_small);   // 8dp
        int mPx    = res.getDimensionPixelSize(R.dimen.margin_medium);   // 16dp

        // Botón circular
        ImageButton fab = new ImageButton(this);
        fab.setLayoutParams(new ViewGroup.LayoutParams(sizePx, sizePx));

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.parseColor("#6B7280")); // gris
        bg.setCornerRadius(sizePx / 2f);
        fab.setBackground(bg);
        fab.setPadding(padPx, padPx, padPx, padPx);

        // Icono del sistema (similar a filtro)
        fab.setImageResource(android.R.drawable.ic_menu_sort_by_size);
        fab.setColorFilter(Color.WHITE);

        // Envolver para posicionar con gravedad bottom|end
        LinearLayout wrapper = new LinearLayout(this);
        wrapper.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        wrapper.setGravity(Gravity.BOTTOM | Gravity.END);

        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(sizePx, sizePx);
        lp.rightMargin  = mPx;
        lp.bottomMargin = mPx;
        fab.setLayoutParams(lp);

        // Menú de opciones
        fab.setOnClickListener(v -> {
            PopupMenu menu = new PopupMenu(this, fab);
            menu.getMenu().add("Todos");
            menu.getMenu().add("Baja");
            menu.getMenu().add("Media");
            menu.getMenu().add("Alta");
            menu.setOnMenuItemClickListener(item -> {
                filtroActual = item.getTitle().toString().toUpperCase(); // TODOS/BAJA/MEDIA/ALTA
                cargarBugs();
                return true;
            });
            menu.show();
        });

        wrapper.addView(fab);
        root.addView(wrapper);
    }

    private void cargarBugs() {
        containerBugs.removeAllViews();

        List<Bug> todos = BugRepository.all();
        List<Bug> bugsFiltrados = filtrar(todos, filtroActual);

        if (bugsFiltrados.isEmpty()) {
            TextView empty = new TextView(this);
            empty.setText(getString(R.string.no_bugs));
            empty.setTextColor(getColor(R.color.text_secondary));
            empty.setTextSize(16f);
            empty.setGravity(Gravity.CENTER);
            empty.setPadding(0, 48, 0, 48);
            containerBugs.addView(empty);
            return;
        }

        Resources res = getResources();
        int marginTop = res.getDimensionPixelSize(R.dimen.margin_medium);
        int padding   = res.getDimensionPixelSize(R.dimen.padding_medium);

        for (Bug bug : bugsFiltrados) {
            containerBugs.addView(crearCard(bug, marginTop, padding));
        }
    }

    private List<Bug> filtrar(List<Bug> fuente, String filtro) {
        if ("TODOS".equals(filtro)) return fuente;

        List<Bug> out = new ArrayList<>();
        String target = filtro == null ? "" : filtro.toUpperCase();
        for (Bug bug : fuente) {
            String g = bug.getGravedad() == null ? "" : bug.getGravedad().toUpperCase();
            if (g.contains(target)) out.add(bug);
        }
        return out;
    }

    private LinearLayout crearCard(Bug bug, int marginTop, int padding) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setBackgroundResource(R.drawable.card_background);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.topMargin = marginTop;
        card.setLayoutParams(lp);
        card.setPadding(padding, padding, padding, padding);

        TextView badge = crearBadgeGravedad(bug.getGravedad());
        if (badge != null) card.addView(badge);

        TextView titulo = new TextView(this);
        titulo.setText(bug.getNombreJuego() + " • " + bug.getPlataforma() + " • " + bug.getTipo());
        titulo.setTextSize(14f);
        titulo.setTextColor(getColor(R.color.text_primary));
        titulo.setTypeface(null, android.graphics.Typeface.BOLD);
        titulo.setPadding(0, 12, 0, 0);

        TextView cuerpo = new TextView(this);
        cuerpo.setText(bug.getDescripcion());
        cuerpo.setTextColor(getColor(R.color.text_secondary));
        cuerpo.setTextSize(13f);
        cuerpo.setPadding(0, 8, 0, 0);

        card.addView(titulo);
        card.addView(cuerpo);

        return card;
    }

    private TextView crearBadgeGravedad(String gravedad) {
        if (gravedad == null) return null;

        String g = gravedad.toUpperCase();
        Integer color = null;
        String texto = null;

        if (g.contains("BAJA")) {
            texto = "PRIORIDAD BAJA";
            color = Color.parseColor("#10B981");
        } else if (g.contains("MEDIA")) {
            texto = "PRIORIDAD MEDIA";
            color = Color.parseColor("#F59E0B");
        } else if (g.contains("ALTA")) {
            texto = "PRIORIDAD ALTA";
            color = Color.parseColor("#EF4444");
        }

        if (texto == null || color == null) return null;

        TextView badge = new TextView(this);
        badge.setPadding(20, 8, 20, 8); // padding en px literal
        badge.setTextSize(12);
        badge.setTextColor(Color.WHITE);
        badge.setTypeface(null, android.graphics.Typeface.BOLD);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        badge.setLayoutParams(params);

        GradientDrawable bg = new GradientDrawable();
        bg.setCornerRadius(15);
        bg.setColor(color);

        badge.setText(texto);
        badge.setBackground(bg);
        return badge;
    }
}