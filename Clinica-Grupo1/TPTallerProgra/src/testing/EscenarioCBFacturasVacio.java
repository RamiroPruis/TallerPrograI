package testing;

import modelo.Clinica;

public class EscenarioCBFacturasVacio {
	
	private Clinica clinica = Clinica.getInstance();
	
	public EscenarioCBFacturasVacio(){
		
	}
	
	public Clinica getClinica(){
		return clinica;
	}

}
