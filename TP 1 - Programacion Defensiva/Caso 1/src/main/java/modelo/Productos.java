package modelo;

public class Productos {
    private String nombre;
    private boolean disponible;


    public Productos(String nombre, boolean disponible) {
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }


    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
