package modelo;

import excepciones.NoExisteLegajoException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Grupo2
 * Clase que representa el certificado de notas de un alumno.
 */
public class Certificado {
    private static int legajos=0;
    private HashMap<Integer,Alumno> alumnos = new HashMap<Integer,Alumno>();


    public Certificado(){

    }

    public void pedirCertificado(int Legajo) throws NoExisteLegajoException {
        Alumno alumno = alumnos.get(Legajo);
        if (alumno != null){

        }
        else
            throw new NoExisteLegajoException();
    }

    public String traerApellidoyNombre(){

    }

    public String traerEstado(String Materia){

    }
}
