package modelo;

/**
 * Clase tipo exception utilizada para cuando se quiere liberar una mesa que ya esta libre
 */
public class MesaLibreException extends Throwable {
    private String why;

    public MesaLibreException(String s) {
        this.why = s;
    }

    public String getWhy() {
        return why;
    }
}
