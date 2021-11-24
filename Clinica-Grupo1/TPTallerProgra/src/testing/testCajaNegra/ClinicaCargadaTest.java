package testing.testCajaNegra;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoExisteRangoEtarioException;
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

        try {
            IMedico medico = MedicoFactory.getMedico("1234","Adolf","Spinelli","Mar del Plata","231412413","Lopez 1234","A245","Cirujia","Permanente","Magister");
            int matricula = Integer.parseInt(medico.getMatricula());

            clinica.agregarMedico(medico);

            assertEquals(medico,clinica.buscaMedico(matricula));

        } catch (NoExisteEspecialidadException | NoExisteContratacionException | NoExistePosgradoException e) {
            fail("Deberia crear el medico correctamente");
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


}
