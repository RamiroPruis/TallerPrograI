package Modelo;

import Excepciones.NoExisteLaOperacionException;
import Excepciones.OperandosNoEnterosException;

public class Calcular {
	
	double ultimoResultado;
	
	/**
	 * Efectua el calculo y si es posible lo informa
	 * @param PrimerOperando
	 * @param SegundoOperando
	 * @param Operacion
	 * @return Devuelve el resultado de la operacion
	 * Lanza una excepcion cuando los operandos no son enteros positivos o cuando la operacion no existe
	 */
	public double Calcular(double PrimerOperando, double SegundoOperando, String Operacion) throws OperandosNoEnterosException,NoExisteLaOperacionException{
		if (PrimerOperando<0 || PrimerOperando % 2 !=0 || SegundoOperando<0 || SegundoOperando % 2 !=0) {
			throw new OperandosNoEnterosException("Algun operando no es entero positivo");
		}		
		switch(Operacion) {
		case "Suma":
			ultimoResultado = PrimerOperando+SegundoOperando;
			return ultimoResultado;
		case "Resta":
			ultimoResultado = PrimerOperando-SegundoOperando;
			return ultimoResultado;
		case "Division":
			ultimoResultado = PrimerOperando/SegundoOperando;
			return ultimoResultado;
		case "Multiplicacion":
			ultimoResultado = PrimerOperando*SegundoOperando;
			return ultimoResultado;	
		default:
			throw new NoExisteLaOperacionException("La operacion no existe");
		}		
	}
	
	/**
	 * @return Devuelve el ultimo resultado obtenido
	 */
	double traerResultado() {
		return ultimoResultado;
	}

}
