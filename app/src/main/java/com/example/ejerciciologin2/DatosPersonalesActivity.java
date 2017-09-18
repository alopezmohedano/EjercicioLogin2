package com.example.ejerciciologin2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatosPersonalesActivity extends AppCompatActivity implements View.OnClickListener{
    EditText nombre;
    EditText apellido1;
    EditText apellido2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);
        Button btn = (Button)findViewById(R.id.btnSiguiente);
        btn.setOnClickListener(this);
        Button btn2 = (Button)findViewById(R.id.btnSalir);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSiguiente:
                nombre = (EditText)findViewById(R.id.txtNombre);
                apellido1 = (EditText)findViewById(R.id.txtApellido1);
                apellido2 = (EditText)findViewById(R.id.txtApellido2);

                if (nombre.getText().toString().equals("") || apellido1.getText().toString().equals("") || apellido2.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "¡Todos los campos deben estar rellenos!", Toast.LENGTH_SHORT).show();
                } else {
                    finish();
                    Intent intent = new Intent(DatosPersonalesActivity.this, DatosDireccionActivity.class);
                    intent.putExtra("nombre",nombre.getText().toString());
                    intent.putExtra("apellido1",apellido1.getText().toString());
                    intent.putExtra("apellido2",apellido2.getText().toString());
                    this.startActivity(intent);
                }
                break;
            case R.id.btnSalir:
                finish();
                break;
        }
    }
}