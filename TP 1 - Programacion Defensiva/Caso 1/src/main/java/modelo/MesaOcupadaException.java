package modelo;

/**
 * Clase tipo exception para cuando la mesa esta ocupada y no es posible ocuparla
 */
public class MesaOcupadaException extends Throwable {
    private String why;

    public MesaOcupadaException(String why) {
        this.why = why;
    }

    public String getWhy() {
        return why;
    }
}
