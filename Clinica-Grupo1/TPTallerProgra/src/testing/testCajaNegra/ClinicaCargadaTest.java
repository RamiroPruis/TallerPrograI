package testing.testCajaNegra;

import excepciones.NoExisteRangoEtarioException;
import modelo.Clinica;
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

}
