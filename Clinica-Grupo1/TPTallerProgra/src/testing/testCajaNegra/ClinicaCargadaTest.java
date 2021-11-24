package testing.testCajaNegra;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import infraestructura.Habitacion;
import infraestructura.HabitacionPrivada;
import infraestructura.Prestacion;
import modelo.*;
import org.junit.*;
import personas.Medico;
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
    public void buscaMedicoCorrectoTest() {
        Clinica clinica = clinicaCargadaEscenario.getClinica();
        IMedico medico = clinicaCargadaEscenario.getMedico();
        int matricula = Integer.parseInt(medico.getMatricula());
        assertEquals(medico,clinica.buscaMedico(matricula));
    }


    @Test
    public void egresoCorrectoTest() {
        Clinica clinica = clinicaCargadaEscenario.getClinica();

        Paciente paciente = clinicaCargadaEscenario.getPaciente();
        assertTrue("El paciente no esta en la lista de atencion",clinica.getListaAtencion().contains(paciente));
        clinica.egreso(paciente);
        assertFalse("El paciente no deberia estar en la lista de atencion ",clinica.getListaAtencion().contains(paciente));

    }

    @Test
    public void buscaHabitacionCorrectaTest() {
        Clinica clinica = clinicaCargadaEscenario.getClinica();
        Habitacion habitacion = clinicaCargadaEscenario.getHabitacion();
        int nroHab = habitacion.getNroHabitacion();
        assertEquals("La habitación encontrada debería ser la correcta",habitacion,clinica.buscaHabitacion(nroHab));
    }

    @Test
    public void buscaHabitacionIncorrectaTest(){
        Clinica clinica = clinicaCargadaEscenario.getClinica();
        int nroHab = 234;
        assertEquals("La habitacion no se deberia encontrar",null,clinica.buscaHabitacion(nroHab));
    }

    @Test
    public void buscaUltimaCorrectaTest() {
        Clinica clinica = clinicaCargadaEscenario.getClinica();
        Paciente p1 = clinicaCargadaEscenario.getPaciente();
        IMedico medico = clinicaCargadaEscenario.getMedico();
        clinica.atenderPaciente(p1);
        Factura f1 = clinica.getFacturas().last();
        assertEquals("La factura deberia ser la ultima factura del paciente",f1,clinica.buscaUltima(p1));

    }


    @Test
    public void buscaHistoriaCorrectaTest() {
        Clinica clinica = clinicaCargadaEscenario.getClinica();
        Paciente p1 = clinicaCargadaEscenario.getPaciente();
        clinica.atenderPaciente(p1);
        int historia = p1.getNumeroHistoria();
        assertEquals("La historia clinica deberia haber sido encontrada correctamente",p1,clinica.buscaHistoria(historia).getPaciente());
    }

    @Test
    public void buscaHistoriaIncorrectaTest() {
        Clinica clinica = clinicaCargadaEscenario.getClinica();
        int historia = 290;
        assertThrows("Deberia haber lanzado Null Pointer Exception",NullPointerException.class,()->{clinica.buscaHistoria(historia).getPaciente();});
    }


}
