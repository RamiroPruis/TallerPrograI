package modelo;

public class Materia {
    private String estado;
    private int nota;

    public Materia(String estado) {
        this.estado = estado;
    }

    public Materia(String estado, int nota) {
        this.estado = estado;
        if (this.estado.equalsIgnoreCase("Aprobada"))
            this.nota = nota;
    }

    public String getEstado() {
        return estado;
    }

    public int getNota() {
        return nota;
    }
}
