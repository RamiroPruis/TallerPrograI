package Prueba;

import Negocio.Monitor;
import UI.Ventana;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monitor.getinstance().setVista(new Ventana());
	}

}

