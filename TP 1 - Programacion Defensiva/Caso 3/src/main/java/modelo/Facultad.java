package modelo;

import java.util.HashMap;

public class Facultad {
    private static Facultad _instance=null;
    private HashMap<Integer,Alumno> alumnos = new HashMap<Integer,Alumno>();

    public Facultad() {
    }

    public static Facultad getInstance(){
        if (_instance == null)
            _instance = new Facultad();
        return _instance;
    }

    public void addAlumno(Alumno alumno){
        this.alumnos.put(alumno.getNroLegajo(),alumno);
    }

    public Alumno getAlumno(int legajo){
        return alumnos.get(legajo);
    }
}
