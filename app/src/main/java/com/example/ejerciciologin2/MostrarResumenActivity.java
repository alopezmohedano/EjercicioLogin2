package com.example.ejerciciologin2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarResumenActivity extends AppCompatActivity implements View.OnClickListener {
    TextView nombre, apellidos, direccion, numero, cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_resumen);

        Button btn2 = (Button)findViewById(R.id.btnSalir);
        btn2.setOnClickListener(this);

        nombre = (TextView)findViewById(R.id.tvNombre);
        apellidos = (TextView)findViewById(R.id.tvApellidos);
        direccion = (TextView)findViewById(R.id.tvDireccion);
        numero = (TextView)findViewById(R.id.tvNumero);
        cp = (TextView)findViewById(R.id.tvCP);

        Intent intent = this.getIntent();
        if (intent != null) {
            if (intent.hasExtra("nombre")) {
                nombre.setText(intent.getStringExtra("nombre"));
            }
            if (intent.hasExtra("apellido1") && intent.hasExtra("apellido2")) {
                apellidos.setText(intent.getStringExtra("apellido1") + " " + intent.getStringExtra("apellido2"));
            }
            if (intent.hasExtra("direccion")) {
                direccion.setText(intent.getStringExtra("direccion"));
            }
            if (intent.hasExtra("numero")) {
                numero.setText(intent.getStringExtra("numero"));
            }
            if (intent.hasExtra("cp")) {
                cp.setText(intent.getStringExtra("cp"));
            }
        }
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}