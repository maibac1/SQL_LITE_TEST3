package com.example.sql_lite_test.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.example.sql_lite_test.modelos.Usuario;

public class DataBaseQueryUsuario {

    private Context context;

    public DataBaseQueryUsuario(Context context) {
        this.context = context;
    }

    public String insertarUsuario(Usuario u){
        String nombreUsuario=u.getNombre();
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contenido= new ContentValues();
        contenido.put(Config.COLUMNA_NOMBRE_USUARIO,u.getNombre());
        contenido.put(Config.COLUMNA_PASSWORD,u.getPassword());

        try{
            sqLiteDatabase.insertOrThrow(Config.TABLA_USUARIO,null,contenido);
        }
        catch(SQLiteException e){
            Toast.makeText(context, "Falló la inserción: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }finally {
            sqLiteDatabase.close();
        }
        return nombreUsuario;
    }
}
