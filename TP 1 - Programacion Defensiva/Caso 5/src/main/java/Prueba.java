import modelo.Juego;
import negocio.Monitor;
import vista.Ivista;

public class Prueba {
    public static void main(String[] args) {
        Ivista vista = new Ivista();
        Juego.getInstance().iniciarJuego();
        Monitor.getInstance().setVista(vista);


    }
}
