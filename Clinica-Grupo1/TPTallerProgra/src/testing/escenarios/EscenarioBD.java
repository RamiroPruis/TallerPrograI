package testing.escenarios;

import excepciones.NoExisteRangoEtarioException;
import modelo.BDdePacientes;
import modelo.PacienteFactory;
import personas.Joven;
import personas.Mayor;
import personas.Nino;
import personas.Paciente;

public class EscenarioBD {
	
	private BDdePacientes basePacientes = new BDdePacientes();
	
	public EscenarioBD(){
				
		basePacientes.altaDePaciente(new Nino("111","Nombre 1", "Apellido 1", "Ciudad 1", "111", "Domicilio 1"));
		basePacientes.altaDePaciente(new Joven("222","Nombre 2", "Apellido 2", "Ciudad 2", "222", "Domicilio 2"));
		basePacientes.altaDePaciente(new Mayor("333","Nombre 3", "Apellido 3", "Ciudad 3", "333", "Domicilio 3"));
			
	}
	
	public BDdePacientes getBase(){
		return basePacientes;
	}

}
