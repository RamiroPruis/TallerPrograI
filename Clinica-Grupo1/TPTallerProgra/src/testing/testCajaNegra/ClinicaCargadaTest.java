package testing.testCajaNegra;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Habitacion;
import infraestructura.HabitacionPrivada;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;
import org.junit.*;
import personas.Paciente;
import testing.escenarios.ClinicaCargadaEscenario;

import static org.junit.Assert.*;

public class ClinicaCargadaTest {
    ClinicaCargadaEscenario clinicaCargadaEscenario;

    @Before
    public void setUp() throws Exception{
       clinicaCargadaEscenario = new ClinicaCargadaEscenario();
    }

    @After
    public void tearDown() throws Exception {
        Clinica.setInstance(null);
    }


    @Test
    public void buscaMedico() {
        Clinica clinica = clinicaCargadaEscenario.getClinica();


        IMedico medico = clinicaCargadaEscenario.getMedico();
        int matricula = Integer.parseInt(medico.getMatricula());


        assertEquals(medico,clinica.buscaMedico(matricula));


    }

    @Test
    public void egreso() {
        Clinica clinica = clinicaCargadaEscenario.getClinica();

        Paciente paciente = clinicaCargadaEscenario.getPaciente();
        assertTrue("El paciente no esta en la lista de atencion",clinica.getListaAtencion().contains(paciente));
        clinica.egreso(paciente);
        assertFalse("El paciente no deberia estar en la lista de atencion ",clinica.getListaAtencion().contains(paciente));

    }
}
