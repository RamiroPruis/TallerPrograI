package modelo;

public abstract class Materia {
    private String estado;
    private int nota;

    public Materia(String estado, int nota) {
        this.estado = estado;
        if (this.estado.equalsIgnoreCase("Aprobada"))
            this.nota = nota;
    }


}
