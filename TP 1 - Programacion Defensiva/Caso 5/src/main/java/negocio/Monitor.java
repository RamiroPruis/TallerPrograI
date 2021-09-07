package negocio;

import exceptions.EstadoInvalidoException;
import exceptions.NumeroInvalidoException;
import modelo.Juego;
import vista.Ivista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Monitor implements ActionListener {
    private static Monitor instance = null;
    private Ivista vista;


    private Monitor() {

    }

    public void setVista(Ivista vista) {
        this.vista = vista;
    }

    public static Monitor getInstance() {
        if (instance == null)
            instance = new Monitor();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("reset")) {
            Juego.getInstance().iniciarJuego();
            JOptionPane.showMessageDialog(vista, "El juego ha comenzado");
        } else if (e.getActionCommand().equalsIgnoreCase("probar")) {
            try {
                Juego.getInstance().probar(vista.getNumero());
                JOptionPane.showMessageDialog(vista, Juego.getInstance().getEstado());
            } catch (NumeroInvalidoException numeroInvalidoException) {
                JOptionPane.showMessageDialog(vista, numeroInvalidoException.getMessage());
            } catch (EstadoInvalidoException estadoInvalidoException) {
                JOptionPane.showMessageDialog(vista, estadoInvalidoException.getMessage());
            }
        }
    }
}
