package modelo;

public class MesaOcupadaException extends Throwable {
    private String why;

    public MesaOcupadaException(String why) {
        this.why = why;
    }

    public String getWhy() {
        return why;
    }
}
