package UI;

import java.awt.event.ActionListener;

public interface IVista {

    void pedirCertificado(Integer Legajo);
    void mostrarEstado(String Mensaje);
    void mostrarCertificado();

    void addActionListener(ActionListener e);
    String getTextMateria();
    int getTextLegajo();
    void mostrarMensaje(String mensaje);

}
