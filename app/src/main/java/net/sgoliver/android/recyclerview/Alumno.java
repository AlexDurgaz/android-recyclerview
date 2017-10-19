package net.sgoliver.android.recyclerview;

import android.widget.ImageView;

public class Alumno
{
    private String nombre;
    private String apellidos;
    private String sexo;


    public Alumno(String nombre, String apellidos, String sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellidos(){
        return apellidos;
    }
}
