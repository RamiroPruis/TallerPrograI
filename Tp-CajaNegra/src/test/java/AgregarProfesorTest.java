import escenarios.EscenarioSistemaConProfesores;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.NoEncontradoException;
import modelo.Alumno;
import modelo.IndiceDoble;
import modelo.Profesor;
import modelo.Sistema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

public class AgregarProfesorTest {
    EscenarioSistemaConProfesores escenario;

    @BeforeEach
    void setUp() {
        escenario = new EscenarioSistemaConProfesores();
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testAgregaProfesorCorrecto() {

        Sistema sistema = escenario.getSistema();
        Profesor profesor = new Profesor("Joaquin Fioriti", "Avenida", "joaquinfioriti@hotmail.com", "754254");
        IndiceDoble<Profesor> profesores = sistema.getProfesores();

        try {
            sistema.agregarProfesor(profesor);
            assertTrue(profesores.contieneValor(profesor));
            try {
                assertEquals(profesor, profesores.buscarPorClavePrimaria(profesor.getClavePrimaria()));
            } catch (NoEncontradoException e) {
                fail("No deberia no encontrarse el profesor");
            }

        } catch (ClaveYaExistenteException e) {
            fail("No podemos hacer nada al respecto si es este metodo quien automaticamente crea el legajo");
        } catch (DatoInvalidoException e) {
            fail("No deberia haberse lanzado esta excepcion ya que el mail es valido");
        }
    }

    @Test
    void testAgregaProfesorSinAtributos() {

        Sistema sistema = escenario.getSistema();
        Profesor profesor = new Profesor();
        IndiceDoble<Profesor> profesores = sistema.getProfesores();

        try {
            sistema.agregarProfesor(profesor);
            assertTrue(profesores.contieneValor(profesor));
            try {
                assertEquals(profesor, profesores.buscarPorClavePrimaria(profesor.getClavePrimaria()));
            } catch (NoEncontradoException e) {
                fail("No deberia no encontrarse el profesor");
            }

        } catch (ClaveYaExistenteException e) {
            fail("No podemos hacer nada al respecto si es este metodo quien automaticamente crea el legajo");
        } catch (DatoInvalidoException e) {
            fail("No deberia haberse lanzado esta excepcion ya que el mail es valido");
        }

    }

    @Test
    void testAgregaProfesorIncorrectoRepetido() {
        Sistema sistema = escenario.getSistema();
        Profesor profesor = new Profesor("Guille", "Avenida", "guille@gmail.com", "123123"); //El profe ya existe en el escenario (distinta instancia)

        try {
            sistema.agregarProfesor(profesor);
            sistema.agregarProfesor(profesor);//Agregamos la misma instancia dos veces
            fail("No deberia agregar profesor repetido");
        } catch (ClaveYaExistenteException e) {

        } catch (DatoInvalidoException e) {
            fail("No deberia ser invalido ");
        }


    }

    @Test
    void testAgregaProfesorIncorrectoDatoInvalidoSinNull() {
        Sistema sistema = escenario.getSistema();
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        Profesor profesor2 = new Profesor("Ramiro2", "Avenidaa", "@", "123");//Mail solo arroba
        Profesor profesor2_3 = new Profesor("", "", "@","123");//Mail solo arroba y strings vacios nombre y direccion
        Profesor profesor3 = new Profesor("Ramiro3", "Avenidaa", "@a","123");//Mail sin caracter antes del arroba
        Profesor profesor3_3 = new Profesor("", "", "@a","123");//Mail sin caracter antes del arroba y direccion y nombre strings vacios
        Profesor profesor4 = new Profesor("Ramiro4", "Avenidaa", "a@","123");//Mail sin caracter despues del arroba
        Profesor profesor4_3 = new Profesor("", "", "a@","123");//Mail sin caracter despues del arroba y strings vacios
        Profesor profesor5 = new Profesor("Ramiro4", "", "hola@gmail.com","123");//Mail correcto y direccion string vacio
        Profesor profesor5_1 = new Profesor("", "Avenidaa", "hola@gmail.com","");//Mail correcto y nombre string vacio y telefono vacio


        profesores.add(profesor2);
        profesores.add(profesor2_3);
        profesores.add(profesor3);
        profesores.add(profesor3_3);
        profesores.add(profesor4);
        profesores.add(profesor4_3);
        profesores.add(profesor5);
        profesores.add(profesor5_1);


        for (Profesor value : profesores) {
            try {
                sistema.agregarProfesor(value);
                fail("No deberia agregarse el alumno correctamente " + "El que fallo:" + value.getApellidoNombre() + " Con una direccion: " + value.getDomicilio() + " Con un mail : " + value.getMail());
            } catch (ClaveYaExistenteException e) {
                fail("No deberia existir la clave primaria");
            } catch (DatoInvalidoException e) {

            }
        }
    }

    @Test
    void testAgregaProfesorIncorrectoDatoInvalidoConNull() {
        Sistema sistema = escenario.getSistema();
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        Profesor profesor = new Profesor("Ramiro", "Avenidaa", null,"123");//Mail nulo
        Profesor profesor2 = new Profesor("Ramiro", "Avenidaa", null,"123");//Mail nulo
        Profesor profesor2_1 = new Profesor(null, "Avenidaa", "@","123");//Mail solo arroba y null el nombre
        Profesor profesor2_2 = new Profesor("Ramiro2", null, "@","123");//Mail solo arroba y null la direccion
        Profesor profesor3_1 = new Profesor(null, "Avenidaa", "@a","123");//Mail sin caracter antes del arroba y nombre null
        Profesor profesor3_2 = new Profesor("Ramiro3", null, "@a","123");//Mail sin caracter antes del arroba y direccion null
        Profesor profesor4_1 = new Profesor(null, "Avenidaa", "a@","123");//Mail sin caracter despues del arroba y nombre null
        Profesor profesor4_2 = new Profesor("Ramiro4", null, "a@","123");//Mail sin caracter despues del arroba y direccion null
        Profesor profesor5_2 = new Profesor(null, "Avenidaa", "hola@gmail.com","123");//Mail correcto y nombre nulo
        Profesor profesor5_3 = new Profesor("Ramiro5", null, "hola@gmail.com","123");//Mail correcto y direccion nulo
        Profesor profesor5_4 = new Profesor(null, null, "hola@gmail.com", null);//Mail correcto y los demas nulos

        profesores.add(profesor);
        profesores.add(profesor);
        profesores.add(profesor);
        profesores.add(profesor);
        profesores.add(profesor);
        profesores.add(profesor);
        profesores.add(profesor);
        profesores.add(profesor);
        profesores.add(profesor);
        profesores.add(profesor);


        for (Profesor value : profesores) {
            try {
                sistema.agregarProfesor(value);
                fail("No deberia agregarse el alumno correctamente " + "El que fallo:" + value.getApellidoNombre() + " Con una direccion: " + value.getDomicilio() + " Con un mail : " + value.getMail());
            } catch (ClaveYaExistenteException e) {
                fail("No deberia existir la clave primaria");
            } catch (DatoInvalidoException e) {

            }
        }


    }


}
