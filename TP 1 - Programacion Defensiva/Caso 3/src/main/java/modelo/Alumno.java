package modelo;

import java.util.ArrayList;

public class Alumno {
    private int nroLegajo;
    private String nombre;
    private String apellido;
    private ArrayList<Materia> materias=new ArrayList<Materia>();

    public Alumno(int nroLegajo, String nombre, String apellido) {
        this.nroLegajo = nroLegajo;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
