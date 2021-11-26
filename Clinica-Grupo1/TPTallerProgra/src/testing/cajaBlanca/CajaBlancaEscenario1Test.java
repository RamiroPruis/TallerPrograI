package testing.cajaBlanca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Clinica;
import org.mockito.MockedStatic;

import junit.framework.Assert;
import util.Util;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CajaBlancaEscenario1Test {
	
	int numeroFactura;
	GregorianCalendar fechaSolicitud;
	ArrayList<Double> listaInsumos;
	EscenarioCBFacturas escenario;
	Clinica clinica;
	
	@Before
	public void setUp() throws Exception{
		escenario = new EscenarioCBFacturas();		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCamino1() {

		try (MockedStatic<Util> utilMock = mockStatic(Util.class)){
			utilMock.when(Util::createRandom).thenReturn(24);
			assertEquals(Util.createRandom(),24);
			numeroFactura = 1;
			fechaSolicitud = new GregorianCalendar(2021,Calendar.NOVEMBER,26);
			listaInsumos = null;

			clinica = escenario.getClinica();

			double rta = clinica.calculoImporteAdicionales(numeroFactura, fechaSolicitud, listaInsumos);
			double rtaesperada = 962.3320000000001;			
					
			assertTrue(rta==rtaesperada);
		}
	}
	
	
	@Test
	public void testCamino2() {
		
		try (MockedStatic<Util> utilMock = mockStatic(Util.class)){
			utilMock.when(Util::createRandom).thenReturn(3);
			assertEquals(Util.createRandom(),3);
			numeroFactura = 2;
			fechaSolicitud = new GregorianCalendar(2021,Calendar.NOVEMBER,26);
			ArrayList<Double> listaInsumos = new ArrayList<Double>();
			listaInsumos.add(20.0);
			listaInsumos.add(10.0);

			clinica = escenario.getClinica();

			double rta = clinica.calculoImporteAdicionales(numeroFactura, fechaSolicitud, listaInsumos);
			double rtaesperada = 477.423;
			
			assertTrue(rta==rtaesperada);
		}
		
	}
	
	
	@Test
	public void testCamino3() {
		
		try (MockedStatic<Util> utilMock = mockStatic(Util.class)){
			utilMock.when(Util::createRandom).thenReturn(3);
			assertEquals(Util.createRandom(),3);
			numeroFactura = 2;
			fechaSolicitud = new GregorianCalendar(2021,Calendar.NOVEMBER,26);
			listaInsumos = null;

			clinica = escenario.getClinica();

			double rta = clinica.calculoImporteAdicionales(numeroFactura, fechaSolicitud, listaInsumos);
			double rtaesperada = 447.423;
					
			assertTrue(rta==rtaesperada);
		}
		
	}
	

}
