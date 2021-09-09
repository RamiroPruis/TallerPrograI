package modelo;

/**
 * Clase mesa que representa el estado de la mesa, que puede ser activa(si/no), habilitada (si/no), y la cuenta.
 */
public class Mesa {
    private boolean activa;
    private boolean habilitada;
    private double cuenta = 0;

    public Mesa(boolean activa) {
        this.activa = activa;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    private void pedido(double costo) {
        this.cuenta += costo;
    }

    public double getCuenta() {
        return cuenta;
    }

    public void setCuenta(double cuenta) {
        this.cuenta = cuenta;
    }
}
