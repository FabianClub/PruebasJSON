package com.simonclubproduction.prueba2json;


import androidx.annotation.InspectableProperty;

import org.json.JSONObject;

import java.sql.Date;

class Alumno {
    String legajo, nombre, apellido, dni;
    float promedio;
    Date nacimiento;
    JSONObject nuevo;


    public Alumno(String legajo, String nombre, String apellido,
                  String dni, float promedio, Date nacimiento) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.promedio = promedio;
        this.nacimiento = nacimiento;

        try {
            nuevo = new JSONObject();
            nuevo.putOpt("legajo", legajo);
            nuevo.putOpt("nombre", nombre);
            nuevo.putOpt("apellido", apellido);
            nuevo.putOpt("DNI", dni);
            nuevo.putOpt("promedio", promedio);
            nuevo.putOpt("nacimiento", nacimiento);

        } catch (Exception e) {

        }
    }

    public JSONObject obtenerObjetoJSON() {
        return nuevo;
    }
}
