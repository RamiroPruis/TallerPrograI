import escenarios.EscenarioSistemaConAlumnosCorrectos;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.NoEncontradoException;
import modelo.Alumno;
import modelo.IndiceDoble;
import modelo.Sistema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

class AgregarAlumnoTest {

    EscenarioSistemaConAlumnosCorrectos escenario;

    @BeforeEach
    void setUp() throws Exception {
        escenario = new EscenarioSistemaConAlumnosCorrectos();
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testAgregaAlumnoCorrecto() {

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

        } catch (ClaveYaExistenteException e) {
            fail("No podemos hacer nada al respecto si es este metodo quien automaticamente crea el legajo");
        } catch (DatoInvalidoException e) {
            fail("No deberia haberse lanzado esta excepcion ya que el mail es valido");
        }

    }

    @Test
    void testAgregaAlumnoSinAtributos() {

        Sistema sistema = escenario.getSistema();
        Alumno alumno = new Alumno();
        IndiceDoble<Alumno> alumnos = sistema.getAlumnos();

        try {
            sistema.agregarAlumno(alumno);
            assertTrue(alumnos.contieneValor(alumno));
            try {
                assertEquals(alumno, alumnos.buscarPorClavePrimaria(alumno.getClavePrimaria()));
            } catch (NoEncontradoException e) {
                fail("No deberia no encontrarse el alumno");
            }

        } catch (ClaveYaExistenteException e) {
            fail("No podemos hacer nada al respecto si es este metodo quien automaticamente crea el legajo");
        } catch (DatoInvalidoException e) {
            fail("No deberia haberse lanzado esta excepcion ya que el mail es valido");
        }

    }


    @Test
    void testAgregaAlumnoIncorrectoRepetido() {
        Sistema sistema = escenario.getSistema();
        Alumno alumno = new Alumno("roberto", "Suipacha 3456", "roberto@mail"); //El alumno ya existe en el escenario (distinta instancia)

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
    void testAgregaAlumnoIncorrectoDatoInvalidoSinNull() {
        Sistema sistema = escenario.getSistema();
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        Alumno alumno2 = new Alumno("Ramiro2", "Avenidaa", "@");//Mail solo arroba
        Alumno alumno2_3 = new Alumno("", "", "@");//Mail solo arroba y strings vacios nombre y direccion
        Alumno alumno3 = new Alumno("Ramiro3", "Avenidaa", "@a");//Mail sin caracter antes del arroba
        Alumno alumno3_3 = new Alumno("", "", "@a");//Mail sin caracter antes del arroba y direccion y nombre strings vacios
        Alumno alumno4 = new Alumno("Ramiro4", "Avenidaa", "a@");//Mail sin caracter despues del arroba
        Alumno alumno4_3 = new Alumno("", "", "a@");//Mail sin caracter despues del arroba y strings vacios
        Alumno alumno5 = new Alumno("Ramiro4", "", "hola@gmail.com");//Mail correcto y direccion string vacio
        Alumno alumno5_1 = new Alumno("", "Avenidaa", "hola@gmail.com");//Mail correcto y nombre string vacio


        alumnos.add(alumno2);
        alumnos.add(alumno2_3);
        alumnos.add(alumno3);
        alumnos.add(alumno3_3);
        alumnos.add(alumno4);
        alumnos.add(alumno4_3);
        alumnos.add(alumno5);
        alumnos.add(alumno5_1);


        for (Alumno value : alumnos) {
            try {
                sistema.agregarAlumno(value);
                fail("No deberia agregarse el alumno correctamente " + "El que fallo:" + value.getApellidoNombre() + " Con una direccion: " + value.getDomicilio() + " Con un mail : " + value.getMail());
            } catch (ClaveYaExistenteException e) {
                fail("No deberia existir la clave primaria");
            } catch (DatoInvalidoException e) {

            }
        }


    }


    @Test
    void testAgregaAlumnoIncorrectoDatoInvalidoConNull() {
        Sistema sistema = escenario.getSistema();
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        Alumno alumno = new Alumno("Ramiro", "Avenidaa", null);//Mail nulo
        Alumno alumno2_1 = new Alumno(null, "Avenidaa", "@");//Mail solo arroba y null el nombre
        Alumno alumno2_2 = new Alumno("Ramiro2", null, "@");//Mail solo arroba y null la direccion
        Alumno alumno3_1 = new Alumno(null, "Avenidaa", "@a");//Mail sin caracter antes del arroba y nombre null
        Alumno alumno3_2 = new Alumno("Ramiro3", null, "@a");//Mail sin caracter antes del arroba y direccion null
        Alumno alumno4_1 = new Alumno(null, "Avenidaa", "a@");//Mail sin caracter despues del arroba y nombre null
        Alumno alumno4_2 = new Alumno("Ramiro4", null, "a@");//Mail sin caracter despues del arroba y direccion null
        Alumno alumno5_2 = new Alumno(null, "Avenidaa", "hola@gmail.com");//Mail correcto y nombre nulo
        Alumno alumno5_3 = new Alumno("Ramiro5", null, "hola@gmail.com");//Mail correcto y direccion nulo
        Alumno alumno5_4 = new Alumno(null, null, "hola@gmail.com");//Mail correcto y ambos nulos

        alumnos.add(alumno);
        alumnos.add(alumno2_1);
        alumnos.add(alumno2_2);
        alumnos.add(alumno3_1);
        alumnos.add(alumno3_2);
        alumnos.add(alumno4_1);
        alumnos.add(alumno4_2);
        alumnos.add(alumno5_2);
        alumnos.add(alumno5_3);
        alumnos.add(alumno5_4);


        for (Alumno value : alumnos) {
            try {
                sistema.agregarAlumno(value);
                fail("No deberia agregarse el alumno correctamente " + "El que fallo:" + value.getApellidoNombre() + " Con una direccion: " + value.getDomicilio() + " Con un mail : " + value.getMail());
            } catch (ClaveYaExistenteException e) {
                fail("No deberia existir la clave primaria");
            } catch (DatoInvalidoException e) {

            }
        }


    }

}
