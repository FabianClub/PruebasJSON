package com.simonclubproduction.prueba2json;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    Alumno datosAlumno;
    SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject escuela = new JSONObject();
        JSONArray nuevosAlumnos = new JSONArray();

        dateFormat = new SimpleDateFormat("d/MM/yyyy");

        try {

            datosAlumno = new Alumno("0001", "Fabián Marcelo",
                    "Arias", "23928823", 10,
                    new Date(74, 10, 28));
            nuevosAlumnos.put(datosAlumno.obtenerObjetoJSON());

            datosAlumno = new Alumno("0002", "Gabriel Guillermo",
                    "Pereyra", "24651248", 9.25F,
                    new Date(75, 6, 15));
            nuevosAlumnos.put(datosAlumno.obtenerObjetoJSON());


            escuela.put("alumnos", nuevosAlumnos);

            Log.i("MENSAJE", escuela.toString() + "\n \n ");


            JSONArray alumnos = escuela.getJSONArray("alumnos");

            for (int a = 0; a < alumnos.length(); a++) {
                JSONObject itemJSONObject = alumnos.getJSONObject(a);
                Log.i("MENSAJE", " \nLegajo " + (itemJSONObject.get("legajo")) + ": " +
                        itemJSONObject.get("nombre") + " " + itemJSONObject.get("apellido")
                        + "; DNI: " + itemJSONObject.get("DNI")
                        + "; Fecha de Nac: " + dateFormat.format(itemJSONObject.get("nacimiento"))
                        + " - Promedio: " + itemJSONObject.get("promedio") + "\n ");
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}