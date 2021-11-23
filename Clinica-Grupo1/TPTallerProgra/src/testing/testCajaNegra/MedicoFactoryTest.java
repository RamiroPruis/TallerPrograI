package testing.testCajaNegra;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import modelo.IMedico;
import modelo.MedicoFactory;


import org.junit.*;
import personas.Medico;
import testing.escenarios.MedicoCorrectoEscenario;
import testing.escenarios.MedicoIncorrectoEscenario;

import static org.junit.Assert.*;


public class MedicoFactoryTest {

    MedicoIncorrectoEscenario medicoIncorrecto;
    MedicoCorrectoEscenario medicoCorrecto;


    @Before
    public void setUp() throws Exception{
        medicoCorrecto = new MedicoCorrectoEscenario();
        medicoIncorrecto = new MedicoIncorrectoEscenario();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void getMedicoCorrecto() {
        try {
            IMedico medicoPrueba = MedicoFactory.getMedico(medicoCorrecto.dNI,medicoCorrecto.nombre,medicoCorrecto.apellido,medicoCorrecto.ciudad,medicoCorrecto.telefono,medicoCorrecto.domicilio,medicoCorrecto.matricula,medicoCorrecto.especialidad,medicoCorrecto.contratacion,medicoCorrecto.posgrado);
            assertNotNull(medicoPrueba);
        } catch (NoExisteEspecialidadException e) {
            fail("No deberia lanzar esta excepcion, porque tiene la especialidad bien definida");
        } catch (NoExisteContratacionException e) {
            fail("No deberia lanzar esta excepcion, porque tiene la contratacion bien definida");
        } catch (NoExistePosgradoException e) {
            fail("No deberia lanzar esta excepcion, porque tiene el posgrado bien definido");
        }
    }

    @Test
    public void getMedicoIncorrectoEspecialidad(){
        //Ponemos que lo unico que tenga erroneo sea la especialidad
        medicoIncorrecto.posgrado = medicoCorrecto.posgrado;
        medicoIncorrecto.contratacion = medicoCorrecto.contratacion;

        try {
            IMedico medicoPrueba = MedicoFactory.getMedico(medicoIncorrecto.dNI,medicoIncorrecto.nombre,medicoIncorrecto.apellido,medicoIncorrecto.ciudad,medicoIncorrecto.telefono,medicoIncorrecto.domicilio,medicoIncorrecto.matricula,medicoIncorrecto.especialidad,medicoIncorrecto.contratacion,medicoIncorrecto.posgrado);
            fail("Deberia tirar excepcion porque no tiene bien definida la especialidad");
        } catch (NoExisteEspecialidadException e) {

        } catch (NoExisteContratacionException e) {
            fail("No deberia lanzar esta excepcion, porque tiene la contratacion bien definida");
        } catch (NoExistePosgradoException e) {
            fail("No deberia lanzar esta excepcion, porque tiene el posgrado bien definido");
        }
    }

    @Test
    public void getMedicoIncorrectoContratacion(){
        //Ponemos que lo unico que tenga erroneo sea la especialidad
        medicoIncorrecto.posgrado = medicoCorrecto.posgrado;
        medicoIncorrecto.especialidad = medicoCorrecto.especialidad;

        try {
            IMedico medicoPrueba = MedicoFactory.getMedico(medicoIncorrecto.dNI,medicoIncorrecto.nombre,medicoIncorrecto.apellido,medicoIncorrecto.ciudad,medicoIncorrecto.telefono,medicoIncorrecto.domicilio,medicoIncorrecto.matricula,medicoIncorrecto.especialidad,medicoIncorrecto.contratacion,medicoIncorrecto.posgrado);
            fail("Deberia tirar excepcion porque no tiene bien definida la contratacion");
        } catch (NoExisteEspecialidadException e) {
            fail("No deberia lanzar esta excepcion, porque tiene la especialidad bien definida");
        } catch (NoExisteContratacionException e) {

        } catch (NoExistePosgradoException e) {
            fail("No deberia lanzar esta excepcion, porque tiene el posgrado bien definido");
        }
    }

    @Test
    public void getMedicoIncorrectoPosgrado(){
        //Ponemos que lo unico que tenga erroneo sea la especialidad
        medicoIncorrecto.contratacion = medicoCorrecto.contratacion;
        medicoIncorrecto.especialidad = medicoCorrecto.especialidad;

        try {
            IMedico medicoPrueba = MedicoFactory.getMedico(medicoIncorrecto.dNI,medicoIncorrecto.nombre,medicoIncorrecto.apellido,medicoIncorrecto.ciudad,medicoIncorrecto.telefono,medicoIncorrecto.domicilio,medicoIncorrecto.matricula,medicoIncorrecto.especialidad,medicoIncorrecto.contratacion,medicoIncorrecto.posgrado);
            fail("Deberia tirar excepcion porque no tiene bien definido el posgrado");
        } catch (NoExisteEspecialidadException e) {
            fail("No deberia lanzar esta excepcion, porque tiene la especialidad bien definida");
        } catch (NoExisteContratacionException e) {
            fail("No deberia lanzar esta excepcion, porque tiene la contratacion bien definida");
        } catch (NoExistePosgradoException e) {

        }
    }

}