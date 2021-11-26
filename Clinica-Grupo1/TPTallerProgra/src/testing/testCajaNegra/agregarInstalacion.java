package testing.testCajaNegra;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import infraestructura.HabitacionCompartida;
import infraestructura.Prestacion;
import modelo.HistoriaClinica;
import testing.escenarios.EscenarioHistoriaClinica;

public class agregarInstalacion {
	
	EscenarioHistoriaClinica escenario;

	@Before
	public void setUp() throws Exception {
		escenario = new EscenarioHistoriaClinica();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		HabitacionCompartida hab = new HabitacionCompartida(22,222);
		HabitacionCompartida habNO = new HabitacionCompartida(33,333);
		
		HistoriaClinica historia = escenario.getHistoria();
		
		historia.agregarInstalacion(hab);
		
		boolean cond = false;
		Iterator<Prestacion> it = historia.getPrestaciones().iterator();
		while(it.hasNext() && !cond){
			Prestacion presta = it.next();
			if (presta.getPrestacion().equals(hab.toString())) {
			//if (presta.getPrestacion().equals(habNO.toString())) { //deberia enviar error
				cond = true;
			}
		}
		if (!cond) {
			fail("No se agrego la prestacion Instalacion");
		}
		
		
	}

}
