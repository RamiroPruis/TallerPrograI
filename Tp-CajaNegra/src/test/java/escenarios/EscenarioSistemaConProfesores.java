package escenarios;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Profesor;
import modelo.Sistema;

public class EscenarioSistemaConProfesores {
    private Sistema sistema = new Sistema();

    public EscenarioSistemaConProfesores() {

        try {
            sistema.agregarProfesor(new Profesor("Guille", "Avenida", "guille@gmail.com", "123123"));
            sistema.agregarProfesor(new Profesor("leonel", "Avenida1", "leonel@gmail.com", "123321"));
            sistema.agregarProfesor(new Profesor("Adolfo", "Avenida2", "Adolfo@gmail.com", "321123"));
        } catch (ClaveYaExistenteException e) {
            e.printStackTrace();
        } catch (DatoInvalidoException e) {
            e.printStackTrace();
        }
    }

    public Sistema getSistema() {
        return sistema;
    }
}
