package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Alumno {
    private int nroLegajo;
    private String nombre;
    private String apellido;
    private HashMap<String,Materia> materias=new HashMap<String,Materia>();

    public Alumno(int nroLegajo, String nombre, String apellido) {
        this.nroLegajo = nroLegajo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setMateria(String materia, String condicion, int nota){
        this.materias.put(materia, new Materia(condicion,nota));
    }

    public void setMateria(String materia, String condicion){
        this.materias.put(materia, new Materia(condicion));
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Materia getMateria(String materia) {
        return materias.get(materia);
    }

    public HashMap<String, Materia> getMaterias() {
        return materias;
    }

    public int getNroLegajo(){
        return this.nroLegajo;
    }
}
