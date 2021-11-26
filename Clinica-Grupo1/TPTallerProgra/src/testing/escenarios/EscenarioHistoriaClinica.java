package testing.escenarios;

import java.util.ArrayList;

import infraestructura.Prestacion;
import modelo.HistoriaClinica;
import personas.Nino;
import personas.Paciente;

public class EscenarioHistoriaClinica {
	
	private Paciente paciente = new Nino("111","Nombre 1", "Apellido 1", "Ciudad 1", "111", "Domicilio 1");
    private ArrayList <Prestacion> prestaciones = new ArrayList <Prestacion>();
	
	private HistoriaClinica historia = new HistoriaClinica(paciente,prestaciones);
	
	public EscenarioHistoriaClinica() {
		//agregar cosas
	}
	
	public HistoriaClinica getHistoria(){
		return historia;
	}

}
