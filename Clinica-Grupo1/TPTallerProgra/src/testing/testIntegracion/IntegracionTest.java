package testing.testIntegracion;

import static org.mockito.Mockito.*;

import controlador.Controlador;
import modelo.Clinica;
import modelo.PacienteFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import personas.Joven;
import personas.Medico;
import personas.Nino;
import personas.Paciente;
import testing.escenarios.ClinicaCargadaEscenario;
import testing.escenarios.ClinicaVaciaEscenario;
import testing.testCajaNegra.ClinicaVaciaTest;
import vista.IVistaMedico;
import vista.IVistaPaciente;
import vista.Ventana;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class IntegracionTest {
  Clinica clinica;

    @Before
    public void setUp() throws Exception{
        clinica = mock(Clinica.class);

    }

    @After
    public void tearDown (){

    }

    @Test
    public void topDownTest(){
        Ventana ventana = new Ventana();
        Controlador controlador = new Controlador(ventana,ventana,ventana,ventana);


        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
