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



	//Lo agregue para el testing
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClinicaDTO that = (ClinicaDTO) o;
		return nroOrden == that.nroOrden && nroFactura == that.nroFactura && Objects.equals(nombre, that.nombre) && Objects.equals(direccion, that.direccion) && Objects.equals(salaEspera, that.salaEspera) && Objects.equals(patio, that.patio) && Objects.equals(listaEspera, that.listaEspera) && Objects.equals(listaAtencion, that.listaAtencion) && Objects.equals(facturas, that.facturas) && Objects.equals(pacientes, that.pacientes) && Objects.equals(habitaciones, that.habitaciones) && Objects.equals(medicos, that.medicos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, direccion, salaEspera, patio, listaEspera, listaAtencion, facturas, pacientes, habitaciones, medicos, nroOrden, nroFactura);
	}
}
