package testing.cajaBlanca;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mockStatic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;

import modelo.Clinica;
import util.Util;

public class CajaBlancaEscenario2Test {
	
	int numeroFactura;
	GregorianCalendar fechaSolicitud;
	ArrayList<Double> listaInsumos;
	EscenarioCBFacturasVacio escenario;
	Clinica clinica;
	
	@Before
	public void setUp() throws Exception{
		escenario = new EscenarioCBFacturasVacio();		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCamino4() {
		try (MockedStatic<Util> utilMock = mockStatic(Util.class)){
			utilMock.when(Util::createRandom).thenReturn(3);
			assertEquals(Util.createRandom(),3);
			numeroFactura = 2;
			fechaSolicitud = new GregorianCalendar(2021,Calendar.NOVEMBER,26);
			listaInsumos = null;

			clinica = escenario.getClinica();

			double rta = clinica.calculoImporteAdicionales(numeroFactura, fechaSolicitud, listaInsumos);
			double rtaesperada = 0.0;
			
			assertTrue(rta==rtaesperada);
		}
	}

}
