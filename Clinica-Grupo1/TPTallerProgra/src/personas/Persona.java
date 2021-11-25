package personas;

import java.io.Serializable;

public abstract class Persona implements Serializable{
protected String DNI,nombre,apellido,ciudad,telefono,domicilio;

	//Constructores
	public Persona(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio) {
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.domicilio = domicilio;
	}
/**
 * preguntar por el sueldo base
 * 
 * 
 */

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
	return nombre;
}
	public String getApellido() {
	return apellido;
}
	public void setDNI(String dNI) {
		DNI = dNI;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Persona persona = (Persona) o;

		if (getDNI() != null ? !getDNI().equals(persona.getDNI()) : persona.getDNI() != null) return false;
		if (getNombre() != null ? !getNombre().equals(persona.getNombre()) : persona.getNombre() != null) return false;
		if (getApellido() != null ? !getApellido().equals(persona.getApellido()) : persona.getApellido() != null)
			return false;
		if (ciudad != null ? !ciudad.equals(persona.ciudad) : persona.ciudad != null) return false;
		if (telefono != null ? !telefono.equals(persona.telefono) : persona.telefono != null) return false;
		return domicilio != null ? domicilio.equals(persona.domicilio) : persona.domicilio == null;
	}

	@Override
	public int hashCode() {
		int result = getDNI() != null ? getDNI().hashCode() : 0;
		result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
		result = 31 * result + (getApellido() != null ? getApellido().hashCode() : 0);
		result = 31 * result + (ciudad != null ? ciudad.hashCode() : 0);
		result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
		result = 31 * result + (domicilio != null ? domicilio.hashCode() : 0);
		return result;
	}
}
