package UI;

import excepciones.NoExisteLegajoException;
import negocio.Negocio;

import javax.swing.*;
import java.awt.*;

public class Ventana extends Component implements IVista{

    /**
     * Metodo que delega a la capa de negocio la peticion del certificado con un legajo no verificado.
     * <b>Post: De ser posible, genera un certificado en base a un legajo y lo muestra. Si no, lanza una excepcion.</b> <br>
     * @param Legajo
     */
    public void pedirCertificado(Integer Legajo){
        try {
            Negocio.getInstance().pedirCertificado(Legajo);
            this.mostrarCertificado();
        } catch (NoExisteLegajoException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra por una ventana emergente el mensaje recibido por parametro
     * <b>Pre:</b> El mensaje debe ser no nulo, debe existir. <br>
     * @param Mensaje
     */
    public void mostrarEstado(String Mensaje){
        assert Mensaje!=null : "Mensaje invalido";
        assert Mensaje!="" : "No hay mensaje para mostrar";
        JOptionPane.showMessageDialog(this,Mensaje);
    }

    /**
     * Muestra por pantalla los datos del certificado emitido.
     * <b>Pre:</b>  El certificado debe haber sido generado previamente. <br>
     */
    public void mostrarCertificado(){
        assert Negocio.getInstance().certificado!=null: "No hay certificado existente";
        System.out.println("Apellido, Nombre:" + Negocio.getInstance().traerApellidoyNombre());
        System.out.println("Legajo: " + Negocio.getInstance().certificado.getLegajo());
    }

}
