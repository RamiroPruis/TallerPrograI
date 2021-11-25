package infraestructura;

import java.io.Serializable;
import java.util.Objects;

import personas.Paciente;

public class SalaDeEspera implements Serializable{

	//Atributos
	private boolean ocupada;
    private Paciente paciente;
	
	//Constructores
	public SalaDeEspera() {
		this.ocupada = false;
		this.paciente=null;
	}
	
	//Metodos
	public boolean isOcupada() {
		return this.ocupada;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void ocupaSalaDeEspera(Paciente paciente) {
		this.paciente=paciente;
		this.ocupada=true;
	}
	public void desocupar() {
		this.ocupada = false;
		this.paciente=null;		
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SalaDeEspera that = (SalaDeEspera) o;

		if (isOcupada() != that.isOcupada()) return false;
		return getPaciente() != null ? getPaciente().equals(that.getPaciente()) : that.getPaciente() == null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ocupada, paciente);
	}

	@Override
	public String toString() {
		return "SalaDeEspera [paciente=" + paciente + "]";
	}
	
	
	
}
