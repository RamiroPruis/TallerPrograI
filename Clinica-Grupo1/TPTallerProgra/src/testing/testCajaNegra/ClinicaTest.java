package testing.testCajaNegra;

import excepciones.NoExisteRangoEtarioException;
import infraestructura.SalaDeEspera;
import modelo.Clinica;
import modelo.PacienteFactory;


import personas.Paciente;
import testing.escenarios.ClinicaCargadaEscenario;
import testing.escenarios.ClinicaVaciaEscenario;

import org.junit.*;

import static org.junit.Assert.*;

public class ClinicaTest {
    ClinicaVaciaEscenario clinicaVaciaEscenario;
    ClinicaCargadaEscenario clinicaCargadaEscenario;
    @Before
    public void setUp() throws Exception {
       clinicaVaciaEscenario= new ClinicaVaciaEscenario();
       clinicaCargadaEscenario = new ClinicaCargadaEscenario();
    }

    @After
    public void tearDown() throws Exception {
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
    public void MayorEnSalaDeEsperaTest () {
        Clinica clinicaAct = clinicaVaciaEscenario.getClinica();
        try {
            Paciente pacienteMayor = PacienteFactory.getPaciente("123456","Mariano","Garcia","Mar del Plata","2234534434","Lopez 1234","Mayor");
            Paciente pacienteJoven = PacienteFactory.getPaciente("22345698","Ramiro","Pruis","Mar del Plata","2235982821","Jara 980", "Joven");
            clinicaAct.derivarPaciente(pacienteJoven);
            SalaDeEspera sala = clinicaAct.getSalaEspera();
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
    public void egreso() {
        Clinica clinica = clinicaCargadaEscenario.getClinica();

        try {
            Paciente paciente = PacienteFactory.getPaciente("123456","Mariano","Garcia","Mar del Plata","2234534434","Lopez 1234","Mayor");
            clinica.egreso(paciente);
            assertFalse("El paciente no deberia estar en la lista de atencion ",clinica.getListaAtencion().contains(paciente));
        } catch (NoExisteRangoEtarioException e) {
            fail("El paciente deberia crearse correctamente");
        }
    }

    @Test
    public void agregarMedico() {
    }

    @Test
    public void asignarHabitacion() {
    }

    @Test
    public void derivarMedico() {
    }

    @Test
    public void derivarHabitacion() {
    }

    @Test
    public void buscaMedico() {
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