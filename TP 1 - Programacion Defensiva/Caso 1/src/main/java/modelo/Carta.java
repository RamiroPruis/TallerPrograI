package modelo;

/**
 * Clase que simboliza un menu de una cerveceria
 */
public class Carta {
    private Productos[] productos = new Productos[5];

    public void actualiza() {
        productos[0] = new Productos("Pezcado", true);
        productos[1] = new Productos("Carne", true);
        productos[2] = new Productos("Cerdo", true);
        productos[3] = new Productos("Agua", true);
        productos[4] = new Productos("Coca", true);
    }
}
