package testing.testCajaNegra;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import infraestructura.Prestacion;
import modelo.HistoriaClinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import testing.escenarios.EscenarioHistoriaClinica;

public class AgregarPracticaTest {
	
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
		
		IMedico medico = null;
		IMedico medicoNO =null;
		
		try {
			medico = MedicoFactory.getMedico("444","Nombre 4", "Apellido 4", "Ciudad 4", "444", "Domicilio 4", "Mat 4", "Cirujia", "Permanente", "Magister");
			medicoNO = MedicoFactory.getMedico("555","Nombre 5", "Apellido 5", "Ciudad 5", "555", "Domicilio 5", "Mat 5", "Cirujia", "Permanente", "Magister");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//No envio ningun mensaje si fallan porque asumo que el Factory ya esta testeado
		
		HistoriaClinica historia = escenario.getHistoria();
		
		historia.agregarPractica(medico);
		
		boolean cond = false;
		Iterator<Prestacion> it = historia.getPrestaciones().iterator();
		while(it.hasNext() && !cond){
			Prestacion presta = it.next();
			if (presta.getPrestacion().equals(medico.getNombre()+" "+medico.getMatricula())) {
			//if (presta.getPrestacion().equals(medicoNO.getNombre()+" "+medicoNO.getMatricula())) {  //deberia enviar error
				cond = true;
			}
		}
		if (!cond) {
			fail("No se agrego la prestacion Practica");
		}					
		
	}	

}
