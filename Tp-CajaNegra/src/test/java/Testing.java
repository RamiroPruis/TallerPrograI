import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import escenarios.EscenarioSistemaConAlumnosCorrectos;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.NoEncontradoException;
import modelo.*;

import java.util.ArrayList;

class Testing {

    EscenarioSistemaConAlumnosCorrectos escenario;

    @BeforeEach
    void setUp() throws Exception {
        escenario = new EscenarioSistemaConAlumnosCorrectos();
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testAgregaAlumnoCorrecto(){
        Sistema sistema = escenario.getSistema();
        Alumno alumno = new Alumno("Joaquin Fioriti", "Avenida", "joaquinfioriti@hotmail.com");
        IndiceDoble<Alumno> alumnos = sistema.getAlumnos();

        try {
            sistema.agregarAlumno(alumno);
            assertTrue(alumnos.contieneValor(alumno));
            try {
                assertEquals(alumno, alumnos.buscarPorClavePrimaria(alumno.getClavePrimaria()));
            } catch (NoEncontradoException e) {
                fail("No deberia no encontrarse el alumno");
            }

        } catch (ClaveYaExistenteException e){
            fail("No podemos hacer nada al respecto si es este metodo quien automaticamente crea el legajo");
        } catch (DatoInvalidoException e) {
            fail("No deberia haberse lanzado esta excepcion ya que el mail es valido");
        }

    }

    @Test
    void testAgregaAlumnoIncorrectoRepetido() {
        Sistema sistema = escenario.getSistema();
        Alumno alumno = new Alumno("roberto","Suipacha 3456", "roberto@mail"); //El alumno ya existe en el escenario (distinta instancia)

        try {
            sistema.agregarAlumno(alumno);
            sistema.agregarAlumno(alumno);//Agregamos la misma instancia dos veces
            fail("No deberia agregar alumno repetido");
        } catch (ClaveYaExistenteException e) {

        } catch (DatoInvalidoException e) {
            fail("No deberia ser invalido ");
        }


    }

    @Test
    void testAgregaAlumnoIncorrectoDatoInvalido() {
        Sistema sistema = escenario.getSistema();
        Alumno alumno = new Alumno("Ramiro", "Avenidaa",null); //El alumno ya existe en el escenario (distinta instancia)
        Alumno alumno2 = new Alumno("Ramiro", "Avenidaa","@"); //El alumno ya existe en el escenario (distinta instancia)

        try {
            sistema.agregarAlumno(alumno);
            fail("No deberia agregarse el alumno correctamente porque no tiene arroba");
        } catch (ClaveYaExistenteException e) {
            fail("No deberia existir la clave primaria");
        } catch (DatoInvalidoException e) {

        }
    }

}
