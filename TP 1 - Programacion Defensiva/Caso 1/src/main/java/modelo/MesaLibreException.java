package modelo;

public class MesaLibreException extends Throwable {
    private String why;

    public MesaLibreException(String s) {
        this.why = s;
    }

    public String getWhy() {
        return why;
    }
}
