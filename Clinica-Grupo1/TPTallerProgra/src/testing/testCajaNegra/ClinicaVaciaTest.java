package testing.testCajaNegra;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Habitacion;
import infraestructura.HabitacionPrivada;
import infraestructura.SalaDeEspera;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;


import personas.Paciente;
import testing.escenarios.ClinicaCargadaEscenario;
import testing.escenarios.ClinicaVaciaEscenario;

import org.junit.*;

import static org.junit.Assert.*;

public class ClinicaVaciaTest {
    ClinicaVaciaEscenario clinicaVaciaEscenario;

    @Before
    public void setUp() throws Exception {
       clinicaVaciaEscenario= new ClinicaVaciaEscenario();
    }

    //VER COMO ANDA CUANDO TESTEAMOS TODY JUNTO


    @After
    public void tearDown() throws Exception {
        Clinica.setInstance(null);
    }


    @Test
    public void ingresoPaciente() {
        Clinica clinicaAct = clinicaVaciaEscenario.getClinica();
        Paciente paciente;
        try {
            paciente = PacienteFactory.getPaciente("123456","Mariano","Garcia","Mar del Plata","2234534434","Lopez 1234","Mayor");
            clinicaAct.ingresoPaciente(paciente);
            assertTrue("Deberia encontrarse el paciente en la clinica",clinicaAct.getPacientes().buscarPaciente(paciente));
        } catch (NoExisteRangoEtarioException e) {
            fail("El Paciente deberia crearse correctamente");
        }
    }

    @Test
    public void derivaPacienteJovenTest () {
        Clinica clinicaActual = clinicaVaciaEscenario.getClinica();
        try {
            clinicaActual.ingresoPaciente(PacienteFactory.getPaciente("123456","Mariano","Garcia","Mar del Plata","2234534434","Lopez 1234","Mayor"));
            Paciente pacienteJoven = PacienteFactory.getPaciente("22345698","Ramiro","Pruis","Mar del Plata","2235982821","Jara 980", "Joven");
            SalaDeEspera sala = clinicaActual.getSalaEspera();
            clinicaActual.derivarPaciente(pacienteJoven);
            assertTrue("El paciente en la sala de espera deberia ser el Joven",sala.getPaciente().equals(pacienteJoven));
        } catch (NoExisteRangoEtarioException e) {
            e.printStackTrace();
        }
    }



    //EL PACIENTE NO ESTA ASOCIADO A LA CLINICA, Y DE TODAS FORMAS PUEDE ATENDERSE (Pre condicion confusa)
    //INCONSISTENCIA CON LA DOCUMENTACION.

    @Test
    public void atenderPacienteInvalido() {
        Clinica clinica = clinicaVaciaEscenario.getClinica();
        try {
            Paciente paciente = PacienteFactory.getPaciente("123456","Mariano","Garcia","Mar del Plata","2234534434","Lopez 1234","Mayor");
            //clinica.ingresoPaciente(paciente);
            clinica.atenderPaciente(paciente);
            assertFalse("El paciente no existe en la clinica, no deberia atenderse",clinica.getListaAtencion().contains(paciente));
        } catch (NoExisteRangoEtarioException e) {
            fail("El paciente deberia crearse correctamente");
        }
    }


    @Test
    public void agregarMedico() {
        Clinica clinica = clinicaVaciaEscenario.getClinica();

        try {
            IMedico medico = MedicoFactory.getMedico("123145","Mariano","Garcia","Mar del Plata","2234534434","Lopez 1234","A1432","Cirujia","Permanente","Magister");
            clinica.agregarMedico(medico);
            assertEquals(medico,clinica.buscaMedico(Integer.parseInt(medico.getMatricula())));
        } catch (NoExisteEspecialidadException e) {
            fail("No deberia lanzar la excepcion, la especialidad es valida");
        } catch (NoExisteContratacionException e) {
            fail("No deberia lanzar la excepcion, la contratacion es valida");
        } catch (NoExistePosgradoException e) {
            fail("No deberia lanzar la excepcion, el posgrado es valido");
        }


    }

    @Test
    public void asignarHabitacion() {
        Clinica clinica = clinicaVaciaEscenario.getClinica();
        Habitacion habitacion = new HabitacionPrivada(2,100);


    }



    @Test
    public void derivarHabitacion() {
    }





    @Test
    public void buscaHabitacion() {
    }

    @Test
    public void buscaUltima() {
    }

    @Test
    public void reporteMedico() {
    }

    @Test
    public void buscaHistoria() {
    }

    @Test
    public void buscaFacturas() {
    }
}