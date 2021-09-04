package UI;


public interface IVista {
	double getPrimerOperando();
	double getSegundoOperando();
	String getOperacion();
	
	void MostrarEstado(String Mensaje);
	void MostrarResultado(double resultado);
	
}


