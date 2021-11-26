package persistencia;

import java.io.Serializable;
import java.util.*;

import infraestructura.Factura;
import infraestructura.Habitacion;
import infraestructura.SalaDeEspera;
import modelo.BDdePacientes;
import modelo.IMedico;
import personas.Paciente;



public class ClinicaDTO implements Serializable
{
    private String nombre;
    private String direccion;
    private SalaDeEspera salaEspera = new SalaDeEspera();
    private ArrayList<Paciente> patio= new ArrayList<Paciente>();
    private Queue<Paciente> listaEspera= new LinkedList<Paciente>();
    private Queue<Paciente> listaAtencion= new LinkedList<Paciente>();
    private TreeSet<Factura> facturas= new TreeSet<>();
    private BDdePacientes pacientes = new BDdePacientes();
    private HashMap<Integer,Habitacion> habitaciones = new HashMap<Integer,Habitacion>();
    private HashMap<Integer,IMedico> medicos = new HashMap<Integer,IMedico>();
	private int nroOrden=0;
	private int nroFactura =0;
	
	
	

    public ClinicaDTO()
    {
    }

    public ClinicaDTO(String nombre, String direccion)
    {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
    }

    public String getNombre()
    {
	return nombre;
    }

    public void setNombre(String nombre)
    {
	this.nombre = nombre;
    }

    public String getDireccion()
    {
	return direccion;
    }

    public void setDireccion(String direccion)
    {
	this.direccion = direccion;
    }

	public SalaDeEspera getSalaEspera() {
		return salaEspera;
	}

	public void setSalaEspera(SalaDeEspera salaEspera) {
		this.salaEspera = salaEspera;
	}

	public ArrayList<Paciente> getPatio() {
		return patio;
	}

	public void setPatio(ArrayList<Paciente> patio) {
		this.patio = patio;
	}

	public Queue<Paciente> getListaEspera() {
		return listaEspera;
	}

	public void setListaEspera(Queue<Paciente> listaEspera) {
		this.listaEspera = listaEspera;
	}

	public Queue<Paciente> getListaAtencion() {
		return listaAtencion;
	}

	public void setListaAtencion(Queue<Paciente> listaAtencion) {
		this.listaAtencion = listaAtencion;
	}

	public TreeSet<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(TreeSet<Factura> facturas) {
		this.facturas = facturas;
	}

	public BDdePacientes getPacientes() {
		return pacientes;
	}

	public void setPacientes(BDdePacientes pacientes) {
		this.pacientes = pacientes;
	}

	public HashMap<Integer, Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(HashMap<Integer, Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public HashMap<Integer, IMedico> getMedicos() {
		return medicos;
	}

	public void setMedicos(HashMap<Integer, IMedico> medicos) {
		this.medicos = medicos;
	}

	public int getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}

	public int getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}



//	//Lo agregue para el testing
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		ClinicaDTO that = (ClinicaDTO) o;
//		System.out.println("holaaa");
//		return nroOrden == that.nroOrden && nroFactura == that.nroFactura && this.nombre.equals(that.nombre) && this.direccion.equals(that.direccion) && this.salaEspera.equals(that.salaEspera) && this.patio.equals(that.patio) && this.listaEspera.equals(that.listaEspera) && this.listaAtencion.equals(that.listaAtencion) && this.facturas.equals(that.facturas) && this.pacientes.equals(that.pacientes) && this.habitaciones.equals(that.habitaciones) && this.medicos.equals(that.medicos);
//	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ClinicaDTO that = (ClinicaDTO) o;



		if (getNroOrden() != that.getNroOrden()) return false;

		if (getNroFactura() != that.getNroFactura()) return false;

		if (getNombre() != null ? !getNombre().equals(that.getNombre()) : that.getNombre() != null) return false;

		if (getDireccion() != null ? !getDireccion().equals(that.getDireccion()) : that.getDireccion() != null)
			return false;

		if (getSalaEspera() != null ? !getSalaEspera().equals(that.getSalaEspera()) : that.getSalaEspera() != null)
			return false;

		if (getPatio() != null ? !getPatio().equals(that.getPatio()) : that.getPatio() != null) return false;

		if (getListaEspera() != null ? !getListaEspera().equals(that.getListaEspera()) : that.getListaEspera() != null)
			return false;


		if (getListaAtencion() != null ? !getListaAtencion().equals(that.getListaAtencion()) : that.getListaAtencion() != null)
			return false;


		if (getFacturas() != null ? !getFacturas().equals(that.getFacturas()) : that.getFacturas() != null)
			return false;

		if (getPacientes() != null ? !getPacientes().equals(that.getPacientes()) : that.getPacientes() != null)
			return false;

		if (getHabitaciones() != null ? !getHabitaciones().equals(that.getHabitaciones()) : that.getHabitaciones() != null)
			return false;

		if (getMedicos() != null){
			Iterator<Map.Entry<Integer, IMedico>> myIterator = this.getMedicos().entrySet().iterator();
			Iterator<Map.Entry<Integer, IMedico>> thatIterator = that.getMedicos().entrySet().iterator();
			Map.Entry<Integer, IMedico> myCurrent;
			Map.Entry<Integer, IMedico> thatCurrent;
			boolean condition = true;
			while (myIterator.hasNext() && thatIterator.hasNext()){
				myCurrent = myIterator.next();
				thatCurrent = thatIterator.next();
				if( !(myCurrent.getKey().equals(thatCurrent.getKey()) && myCurrent.getValue().equals(thatCurrent.getValue())))
					return false;

			}

			return myIterator.hasNext() == thatIterator.hasNext();
		}
		else{
			return that.getMedicos() == null;
		}





	}


}
