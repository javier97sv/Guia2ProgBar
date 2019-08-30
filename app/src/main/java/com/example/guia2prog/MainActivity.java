package com.example.guia2prog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    EditText edtCorreo, edtPass;
    Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCorreo = findViewById(R.id.edtCorreo);
        edtPass = findViewById(R.id.edtPass);
        btnInicio=findViewById(R.id.btnInicio);

        btnInicio.setOnLongClickListener(this);
    }


    public void OnClickDatos(View v){
        Intent in = new Intent(this, Datos.class);
        startActivity(in);
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.btnInicio:{
                if(edtCorreo.getText().toString().isEmpty() && edtPass.getText().toString().isEmpty()){
                    Toast.makeText(this, "Digite el correo y la contraseña", Toast.LENGTH_SHORT).show();
                } else if(edtCorreo.getText().toString().isEmpty()){
                    Toast.makeText(this, "Digite el correo", Toast.LENGTH_SHORT).show();
                } else if(edtPass.getText().toString().isEmpty()){
                    Toast.makeText(this, "Digite la contraseña", Toast.LENGTH_SHORT).show();
                } else{
                    Intent in = new Intent(this, Barra.class);
                    in.putExtra("Correo", edtCorreo.getText().toString());
                    startActivity(in);
                }
                break;
            }
        }
        return false;
    }
}
