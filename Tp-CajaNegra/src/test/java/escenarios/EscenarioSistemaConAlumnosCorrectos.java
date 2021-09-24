package escenarios;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;
import modelo.Sistema;

public class EscenarioSistemaConAlumnosCorrectos {

    private Sistema sistema = new Sistema();

    public EscenarioSistemaConAlumnosCorrectos(){


        try {
            sistema.agregarAlumno(new Alumno("Ramiro", "Avenidaa","ramiro@gmail.com"));
            sistema.agregarAlumno(new Alumno("Mata", "Avenida123", "mata@gmail.com"));
            sistema.agregarAlumno(new Alumno("Camila", "Avenida321", "camila@gmail.com"));
            sistema.agregarAlumno(new Alumno("Marianito Garcia", "Avenida432432", "marianito@gmail.com"));
            sistema.agregarAlumno(new Alumno("Igna", "Avenidas213123", "igna@gmail.com"));
            sistema.agregarAlumno(new Alumno("roberto","Suipacha 3456", "roberto@mail"));

        } catch (ClaveYaExistenteException e) {

        } catch (DatoInvalidoException e) {

        }

    }

    public Sistema getSistema() {
        return sistema;
    }

}