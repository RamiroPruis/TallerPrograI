package Negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Excepciones.NoExisteLaOperacionException;
import Excepciones.OperandosNoEnterosException;
import Modelo.Calcular;
import UI.IVista;

public class Monitor implements ActionListener{

	private static Monitor instance = null;
	private IVista vista;
	private Calcular calcular = new Calcular();
	
	public static Monitor getinstance() {
		if (Monitor.instance == null)
			Monitor.instance = new Monitor();
		return instance;		
	}
	
	private Monitor() {
		
	}
	
	public void setVista(IVista vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		double pri, seg;
		String op;
		if (e.getActionCommand().equals("Calcular")) {
			pri = vista.getPrimerOperando();
			if (pri!=-1) {
				seg = vista.getSegundoOperando();
				if (seg!=-1) {
					op = vista.getOperacion();
					if (op!="") {
							try {
								vista.MostrarResultado(this.calcular.Calcular(pri,seg,op));
							} catch(OperandosNoEnterosException a) {
								vista.MostrarEstado("Los operandos deben ser enteros positivos");
							} catch(NoExisteLaOperacionException a) {
								vista.MostrarEstado("Operacion inexistente");
							}
							
					}
				}				
			}			
			
		}
		
	}	

}
