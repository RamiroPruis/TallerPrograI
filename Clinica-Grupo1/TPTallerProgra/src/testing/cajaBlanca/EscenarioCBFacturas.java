package testing.cajaBlanca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeSet;

import excepciones.HabitacionOcupadaException;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import infraestructura.Factura;
import infraestructura.HabitacionPrivada;
import infraestructura.Prestacion;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import personas.Joven;
import personas.Mayor;
import personas.Paciente;

public class EscenarioCBFacturas {
	
	private Clinica clinica = Clinica.getInstance();
	
	public EscenarioCBFacturas(){
		TreeSet<Factura> facturas = new TreeSet<>();
		ArrayList <Prestacion> prestaciones = new ArrayList <Prestacion>();
		
		IMedico medico = null;
		try {
			medico = MedicoFactory.getMedico("444","Nombre 4", "Apellido 4", "Ciudad 4", "444", "Domicilio 4", "Mat 4", "Cirujia", "Permanente", "Magister");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HabitacionPrivada habitacion = new HabitacionPrivada(1,100);
		habitacion.setCantDias(2);
		
		Paciente pacienteMayor = new Mayor("222","Nombre 2", "Apellido 2", "Ciudad 2", "222", "Domicilio 2");
		
		
		Paciente pacienteJoven = new Joven("333","Nombre 3", "Apellido 3", "Ciudad 3", "333", "Domicilio 3");
		
		/*
		clinica.derivarMedico(pacienteJoven, medico);
		clinica.derivarMedico(pacienteMayor, medico);
		
		try {
			clinica.derivarHabitacion(pacienteMayor, habitacion);
			clinica.derivarHabitacion(pacienteJoven, habitacion);
		} catch (HabitacionOcupadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Factura factMayor = new Factura(1,new GregorianCalendar(2021,Calendar.NOVEMBER,24),pacienteMayor);
		Factura factJoven = new Factura(2,new GregorianCalendar(2021,Calendar.NOVEMBER,6),pacienteJoven);
		
		factMayor.asignarHabitacion(habitacion);
		factMayor.asignarMedico(medico);
		
		factJoven.asignarHabitacion(habitacion);
		factJoven.asignarMedico(medico);
		
		
		facturas.add(factMayor);
		facturas.add(factJoven);
		
		
		clinica.setFacturas(facturas);
	}
	
	public Clinica getClinica(){
		return clinica;
	}

}
