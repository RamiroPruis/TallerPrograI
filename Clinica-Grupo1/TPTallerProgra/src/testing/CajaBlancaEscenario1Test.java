package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;

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
		numeroFactura = 1;
		fechaSolicitud = new GregorianCalendar(2021,11,26);
		listaInsumos = null;
		//aleatorio debe ser 24
		
		clinica = escenario.getClinica();
		
		double rta = clinica.calculoImporteAdicionales(numeroFactura, fechaSolicitud, listaInsumos);
		
		System.out.println(rta);
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
