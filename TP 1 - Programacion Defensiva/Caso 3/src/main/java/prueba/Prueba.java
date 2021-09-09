package prueba;

import UI.VentanaInicio;
import modelo.Alumno;
import modelo.Facultad;
import negocio.Negocio;

public class Prueba {
    public static void main(String[] args) {

        Alumno a1 = new Alumno(9999,"Mariano","Garcia");
        a1.setMateria("Historia","Aprobada",9);
        a1.setMateria("Matematica","A cursar");
        a1.setMateria("Literatura","Aprobada",9);
        Alumno a2 = new Alumno(10150,"Ramiro","Pruis");
        Alumno a3 = new Alumno(12490,"Joaquin","Fioriti");
        a3.setMateria("Fisica","Cursada");
        Alumno a4 = new Alumno(43850,"Camila","Ezama");

        Facultad.getInstance().addAlumno(a1);
        Facultad.getInstance().addAlumno(a2);
        Facultad.getInstance().addAlumno(a3);
        Facultad.getInstance().addAlumno(a4);


        Negocio.getInstance().setVista(new VentanaInicio());
    }
}
