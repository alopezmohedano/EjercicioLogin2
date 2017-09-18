package com.example.ejerciciologin2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatosDireccionActivity extends AppCompatActivity implements View.OnClickListener {
    EditText direccion;
    EditText numero;
    EditText cp;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_direccion);
        Button btn = (Button)findViewById(R.id.btnSiguiente);
        btn.setOnClickListener(this);
        Button btn2 = (Button)findViewById(R.id.btnSalir);
        btn2.setOnClickListener(this);

        intent=this.getIntent();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSiguiente:
                direccion = (EditText)findViewById(R.id.txtDireccion);
                numero = (EditText)findViewById(R.id.txtNumero);
                cp = (EditText)findViewById(R.id.txtCP);
                intent=getIntent();

                if (direccion.getText().toString().equals("") || numero.getText().toString().equals("") || cp.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "¡Todos los campos deben estar rellenos!", Toast.LENGTH_SHORT).show();
                } else {
                    finish();
                    Intent intent2 = new Intent(DatosDireccionActivity.this, MostrarResumenActivity.class);
                    if (intent != null) {
                        if (intent.hasExtra("nombre")) {
                            intent2.putExtra("nombre", intent.getStringExtra("nombre"));
                        }
                        if (intent.hasExtra("apellido1")) {
                            intent2.putExtra("apellido1", intent.getStringExtra("apellido1"));
                        }
                        if (intent.hasExtra("apellido2")) {
                            intent2.putExtra("apellido2", intent.getStringExtra("apellido2"));
                        }
                    }
                    intent2.putExtra("direccion", direccion.getText().toString());
                    intent2.putExtra("numero", numero.getText().toString());
                    intent2.putExtra("cp", cp.getText().toString());
                    this.startActivity(intent2);
                }

                break;
            case R.id.btnSalir:
                finish();
                break;
        }
    }
}