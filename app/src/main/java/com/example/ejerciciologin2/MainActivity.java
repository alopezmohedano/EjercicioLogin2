package com.example.ejerciciologin2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText usuario;
    EditText pass;
    Button btn;
    final String us = "usuario";
    final String pa = "prueba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btnEntrar);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        usuario = (EditText)findViewById(R.id.txtUsuario);
        pass = (EditText)findViewById(R.id.txtPass);

        if (usuario.getText().toString().equals("") || pass.getText().toString().equals("")) {
            Toast.makeText(v.getContext(), "¡Usuario y contraseña deben estar rellenos!", Toast.LENGTH_SHORT).show();
        } else {
            if (usuario.getText().toString().equals(us) && pass.getText().toString().equals(pa)) {
                Intent intent = new Intent(MainActivity.this, DatosPersonalesActivity.class);
                intent.putExtra("usuario",usuario.getText().toString());
                intent.putExtra("pass",pass.getText().toString());
                this.startActivity(intent);
            } else {
                Toast.makeText(v.getContext(), "¡Usuario y contraseña no coinciden!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
