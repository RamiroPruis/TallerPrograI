package prueba;

import UI.Ventana;
import negocio.Negocio;

public class Prueba {
    public static void main(String[] args) {
        Negocio.getInstance().setVista(new Ventana());
    }
}
