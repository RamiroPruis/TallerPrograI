package testing.testIntegracion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import controlador.Controlador;
import excepciones.*;
import infraestructura.Factura;
import infraestructura.Habitacion;
import infraestructura.HabitacionPrivada;
import infraestructura.Prestacion;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
import java.lang.reflect.Executable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class IntegracionDescendenteTest {
    Factura facturaMock;
    @Before
    public void setUp() throws Exception{
        facturaMock = mock(Factura.class);
        ArrayList<Prestacion> prestaciones = new ArrayList<>();
        Prestacion prestacion1 = new Prestacion("",1,1);
        Prestacion prestacion2 = new Prestacion("fff",1,1);
        prestaciones.add(prestacion1);
        prestaciones.add(prestacion2);
        when(facturaMock.getPrestaciones()).thenReturn(prestaciones);
    }

    @After
    public void tearDown (){
      Clinica.setInstance(null);
    }

    @Test
    public void ramaHabitacionesTest(){
        Clinica clinica = Clinica.getInstance();

        IMedico medico;

      try {
        Paciente paciente = PacienteFactory.getPaciente("123412","Marianito","Garcia","mdq","223414141","","Nino");
        medico = MedicoFactory.getMedico("","Adolf","Spinelli","mdq","2223414123","","1432","Cirujia","Permanente","Magister");
        Habitacion habitacion = new HabitacionPrivada(1,500);
        clinica.asignarHabitacion(habitacion);

        clinica.ingresoPaciente(paciente);
        clinica.atenderPaciente(paciente);
        habitacion.setCantDias(3);

        clinica.derivarHabitacion(paciente,habitacion);
        clinica.egreso(paciente);

        assertNotNull(clinica.buscaUltima(paciente));


      } catch (NoExisteRangoEtarioException e) {
        fail("Deberia existir el rango Etario");
      } catch (NoExisteEspecialidadException e) {
        fail("Deberia existir la especialidad");
      } catch (NoExisteContratacionException e) {
        fail("Deberia existir la contratacion");
      } catch (NoExistePosgradoException e) {
        fail("Deberia existir el posgrado");
      } catch (HabitacionOcupadaException e) {
        fail("La habitacion no deberia estar ocupada");
      }
    }

    @Test
  public void ramaMedicoTest(){
      try {
        Clinica clinica = Clinica.getInstance();

        Paciente paciente = PacienteFactory.getPaciente("123412","Marianito","Garcia","mdq","223414141","","Nino");
        IMedico medico = MedicoFactory.getMedico("","Adolf","Spinelli","mdq","2223414123","","1432","Cirujia","Permanente","Magister");
        clinica.ingresoPaciente(paciente);
        clinica.atenderPaciente(paciente);
        clinica.agregarMedico(medico);
        clinica.derivarMedico(paciente,medico);

        assertNotNull(clinica.buscaUltima(paciente));
      } catch (NoExisteRangoEtarioException | NoExisteEspecialidadException | NoExisteContratacionException | NoExistePosgradoException e) {
        fail("Deberia crearse correctamente");
      }
    }

    @Test
  public void ramaFactura(){
      Clinica clinica = Clinica.getInstance();
      GregorianCalendar inicio,fin;


      inicio = new GregorianCalendar(2021,Calendar.NOVEMBER,23);
      fin = new GregorianCalendar(2021,Calendar.NOVEMBER,27);
      ArrayList<Factura> facturas = clinica.buscaFacturas(inicio,fin);
      assertNotEquals("Deberia encontrar facturas",0,facturas.size());

    }
}
