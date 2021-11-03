package controlador;

import clinica.Clinica;
import exceptions.DiasInvalidosException;
import exceptions.PacienteInvalidoException;
import lugares.HabCompartida;
import lugares.HabPrivada;
import usuarios.Medico;
import usuarios.Paciente;
import vistas.IVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.GregorianCalendar;

public class Controlador implements WindowListener, ActionListener {

    private IVista ventanaMovimientos;
    private Clinica clinica = Clinica.getInstance();


    public Controlador(IVista ventanaMovimientos) {
        setVentanaMovimientos(ventanaMovimientos);
    }

    public void setVentanaMovimientos(IVista ventanaMovimientos) {
        this.ventanaMovimientos = ventanaMovimientos;
        this.ventanaMovimientos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        Paciente pacienteAct = this.ventanaMovimientos.getPacienteSelcted();
        Medico medicoAct = this.ventanaMovimientos.getMedicoSelected();

        if (action.equalsIgnoreCase("GenerarConsulta")){

            if (pacienteAct != null && medicoAct != null) {
                this.clinica.agregaConsultaAPaciente(pacienteAct, medicoAct);
            }
            else
                if (pacienteAct == null)
                    JOptionPane.showMessageDialog((Component) ventanaMovimientos,"Tiene que seleccionar un paciente");
                else
                    JOptionPane.showMessageDialog((Component) ventanaMovimientos,"Tiene que seleccionar un medico");
        }
        else if (action.equalsIgnoreCase("GenerarInternacion")){
            try{
                int dias = ventanaMovimientos.getCantidadDias();
                Clinica.getInstance().agregaInternacionAPaciente(pacienteAct,new HabCompartida(),dias);
            }
            catch (Exception x){
                JOptionPane.showMessageDialog((Component) ventanaMovimientos,"Seleccione una cantidad de dias valida");
            }

        }
        else if (action.equalsIgnoreCase("DardeAlta")){
            GregorianCalendar fecha = new GregorianCalendar();

            try {
                this.clinica.imprimeFacturaDePaciente(pacienteAct,fecha);
                Clinica.getInstance().getPacientes().remove(pacienteAct);
                ventanaMovimientos.actualizaListaPacientes(Clinica.getInstance().getPacientes());
            } catch (PacienteInvalidoException ex) {
               JOptionPane.showMessageDialog((Component) ventanaMovimientos,"Seleccione un paciente valido");
            }
        }
        else if (action.equalsIgnoreCase("Consultar")){
        	System.out.print("Boton Consultar");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.clinica.persistenciaFacturasOut();
        this.clinica.persistenciaMedicosOut();
        this.clinica.persistenciaPacientesOut();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
