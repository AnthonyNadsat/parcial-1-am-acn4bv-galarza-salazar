package com.acn4bv.buglog;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListaBugsActivity extends AppCompatActivity {

    private LinearLayout containerBugs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bugs);

        containerBugs = findViewById(R.id.containerBugs);

        if (BugRepository.isEmpty()) {
            TextView empty = new TextView(this);
            empty.setText(getString(R.string.no_bugs));
            empty.setTextColor(getColor(R.color.text_secondary));
            empty.setTextSize(16f);
            empty.setGravity(android.view.Gravity.CENTER);
            empty.setPadding(0, 48, 0, 48);
            containerBugs.addView(empty);
            return;
        }

        int marginTop = (int) getResources().getDimension(R.dimen.margin_medium);
        int padding = (int) getResources().getDimension(R.dimen.padding_medium);

        for (Bug bug : BugRepository.all()) {
            LinearLayout card = new LinearLayout(this);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setBackgroundResource(R.drawable.card_background);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.topMargin = marginTop;
            card.setLayoutParams(lp);
            card.setPadding(padding, padding, padding, padding);

            // Título con info
            TextView titulo = new TextView(this);
            titulo.setText(bug.getNombreJuego() + " • " + bug.getPlataforma() + " • " + bug.getTipo() + " • " + bug.getGravedad());
            titulo.setTextSize(14f);
            titulo.setTextColor(getColor(R.color.text_primary));
            titulo.setTypeface(null, android.graphics.Typeface.BOLD);

            // Descripción
            TextView cuerpo = new TextView(this);
            cuerpo.setText(bug.getDescripcion());
            cuerpo.setTextColor(getColor(R.color.text_secondary));
            cuerpo.setTextSize(13f);
            cuerpo.setPadding(0, 8, 0, 0);

            card.addView(titulo);
            card.addView(cuerpo);

            containerBugs.addView(card);
        }
    }
}