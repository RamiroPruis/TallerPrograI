package negocio;

import modelo.*;
import ui.IVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador
 */
public class Negocio implements ActionListener {
    public static Negocio instance = null;
    private IVista vista;

    private Negocio() {

    }

    public static Negocio getInstance() {
        Negocio respuesta;
        if (instance == null) {
            instance = new Negocio();
            respuesta = instance;
        } else
            respuesta = instance;

        return respuesta;
    }


    public IVista getVista() {
        return vista;
    }

    public void setVista(IVista vista) {
        this.vista = vista;

    }

    /**
     * Pre: Recibe el numero de mesas ya validado
     * post:Delega la responsabilidad de abrir el local al metodo de BeerHouse
     *
     * @param cantMesas
     */
    private void abrirLocal(int cantMesas) {

        try {
            BeerHouse.getInstance().abrirLocal(cantMesas);
            JOptionPane.showMessageDialog(this.vista, "Se ha abierto el local");
        } catch (MesasInvalidoException e) {

            JOptionPane.showMessageDialog(this.vista, "La cantidad de mesas debe ser mayor que cero y menor que 50");
        }
    }

    /**
     * Pre: La mesa elegida no debe estar ocupada
     * Post:
     *
     * @param nroMesa
     * @return Instancia de la mesa seleccionada
     */
    private Mesa ocuparMesa(int nroMesa) {
        Mesa mesa = null;
        try {
            mesa = BeerHouse.getInstance().ocuparMesa(nroMesa);
            JOptionPane.showMessageDialog(this.vista, "Se ha ocupado la mesa");
        } catch (MesaOcupadaException e) {
            JOptionPane.showMessageDialog(this.vista, e.getWhy());
        }

        return mesa;
    }

    private double cerrarMesa(int nroMesa) {
        double importe = 0;
        try {
            importe = BeerHouse.getInstance().cerrarMesa(nroMesa);
            JOptionPane.showMessageDialog(this.vista, "La mesa se ha cerrado");
        } catch (MesaLibreException e) {
            JOptionPane.showMessageDialog(this.vista, e.getWhy());
        }
        return importe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int cantidad = 0;
        if (e.getActionCommand().equalsIgnoreCase("abrirLocal")) {
            abrirLocal(this.vista.abrirLocal());
        } else if (e.getActionCommand().equalsIgnoreCase("ocuparMesa"))
            ocuparMesa(this.vista.ocuparMesa());
        else if (e.getActionCommand().equalsIgnoreCase("cerrarMesa"))
            cerrarMesa(this.vista.cerrarMesa());
    }
}
