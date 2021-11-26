package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.BDdePacientes;
import modelo.HistoriaClinica;
import personas.Mayor;
import personas.Paciente;

public class buscarPacienteTest {

	EscenarioBD escenario;
	
	@Before
	public void setUp() throws Exception {
		escenario = new EscenarioBD();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		BDdePacientes base = new BDdePacientes();
		Paciente paciente = new Mayor("444","Nombre 4", "Apellido 4", "Ciudad 4", "444", "Domicilio 4");
		//Paciente pacienteNo = new Nino("555","Nombre 5", "Apellido 5", "Ciudad 5", "555", "Domicilio 5");
		
		base.altaDePaciente(paciente); //Al agregarlo me aseguro que debe existir
		
		ArrayList<HistoriaClinica> pacientesBD = base.getPacientesBD();
		
		assertTrue(base.buscarPaciente(paciente));
		
	}

}
