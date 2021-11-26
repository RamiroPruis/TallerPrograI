package testing.cajaBlanca;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Clinica;
import org.mockito.MockedStatic;
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
			System.out.println(Util.createRandom());
			numeroFactura = 1;
			fechaSolicitud = new GregorianCalendar(2021,11,26);
			listaInsumos = null;

			clinica = escenario.getClinica();

			double rta = clinica.calculoImporteAdicionales(numeroFactura, fechaSolicitud, listaInsumos);

			System.out.println(rta);
		}


	}
	
	/*
	@Test
	public void testCamino2() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCamino3() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCamino4() {
		fail("Not yet implemented");
	}
	
	*/

}
