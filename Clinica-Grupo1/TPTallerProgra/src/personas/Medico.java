package personas;



import modelo.IMedico;

public class Medico extends Persona implements IMedico{
private String matricula,especialidad;	
private final double honorarioBasico=1000;

	//Constructores
	public Medico(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio, String matricula, String especialidad) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		this.matricula = matricula;
		this.especialidad = especialidad;
	}
	//Metodos

	@Override
	public double getHonorario() {
		return this.honorarioBasico;
		}
				
	@Override
	public String getMatricula() {
		return this.matricula;
	}
	@Override
	public String getEspecialidad() {
		return this.especialidad;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return nombre +" "+apellido+" " + matricula + " " + especialidad ;
				
	}

	@Override
	public boolean equals(IMedico o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Medico medico = (Medico) o;

		if (Double.compare(medico.honorarioBasico, honorarioBasico) != 0) return false;
		if (getMatricula() != null ? !getMatricula().equals(medico.getMatricula()) : medico.getMatricula() != null)
			return false;
		return getEspecialidad() != null ? getEspecialidad().equals(medico.getEspecialidad()) : medico.getEspecialidad() == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		long temp;
		result = 31 * result + (getMatricula() != null ? getMatricula().hashCode() : 0);
		result = 31 * result + (getEspecialidad() != null ? getEspecialidad().hashCode() : 0);
		temp = Double.doubleToLongBits(honorarioBasico);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}




