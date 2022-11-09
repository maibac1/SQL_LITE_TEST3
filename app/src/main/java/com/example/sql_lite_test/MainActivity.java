package com.example.sql_lite_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sql_lite_test.Database.DataBaseQueryUsuario;
import com.example.sql_lite_test.modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText password;
    private Button agregarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = this.findViewById(R.id.editTextTextEmailAddress);
        password= this.findViewById(R.id.editTextTextPassword);
        agregarBtn=this.findViewById(R.id.button);

        agregarBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                Usuario usuarioNuevo= new Usuario();
                usuarioNuevo.setNombre(usuario.getText().toString());
                usuarioNuevo.setPassword(password.getText().toString());

                DataBaseQueryUsuario dbQeryUsuario = new DataBaseQueryUsuario(getBaseContext());

                dbQeryUsuario.insertarUsuario(usuarioNuevo);


            }

        });

    }
}