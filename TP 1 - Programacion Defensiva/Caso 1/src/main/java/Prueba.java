import negocio.Negocio;
import ui.IVista;

public class Prueba {
    public static void main(String[] args) {

        Negocio.getInstance();
        Negocio.getInstance().setVista(new IVista());


    }
}
