package controlador;

import clinica.Clinica;
import usuarios.Paciente;
import vistas.IVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class controlador implements WindowListener, ActionListener {

    private IVista ventanaMovimientos;


    public controlador(IVista ventanaMovimientos) {

    }

    public void setVentanaMovimientos(IVista ventanaMovimientos) {
        this.ventanaMovimientos = ventanaMovimientos;
        this.ventanaMovimientos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equalsIgnoreCase("GenerarConsulta")){
            //llama al modelo con paciente seleccionado
        }
        else if (action.equalsIgnoreCase("GeneraInternaciones")){
           //llama al modelo
        }
        else if (action.equalsIgnoreCase("DardeAlta")){
            //lama al modelo
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        Clinica.getInstance().persistenciaFacturasOut();
        Clinica.getInstance().persistenciaMedicosOut();
        Clinica.getInstance().persistenciaPacientesOut();
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
