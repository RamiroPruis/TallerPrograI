package modelo;

import exceptions.EstadoInvalidoException;
import exceptions.NumeroInvalidoException;

public class Juego {
    private static Juego instance = null;
    private int cantIntentos;
    private int numeroAleatorio;
    private String estado = null;
    private final int min = 1, max = 100, topeIntentos = 10; //Constantes

    private Juego() {
    }

    public static Juego getInstance() {
        if (instance == null)
            instance = new Juego();
        return instance;
    }

    public void iniciarJuego() {
        this.numeroAleatorio = min + (int) (Math.random() * ((max - min) + 1));
        this.cantIntentos = 0;
        this.estado = "";
    }

    public void probar(double numero) throws NumeroInvalidoException, EstadoInvalidoException {
        int aux;
        if ((numero % 1) != 0)
            throw new NumeroInvalidoException("Debe ser entero");
        if (!(numero >= min && numero <= max))
            throw new NumeroInvalidoException("El numero tiene que cumplir: min <= x <= max");
        if (this.estado.equalsIgnoreCase("perdio") || this.estado.equalsIgnoreCase("acerto"))
            throw new EstadoInvalidoException("El estado no puede ser perdio o acerto");
        this.cantIntentos++;

        aux = (int) numero;

        if (aux == this.numeroAleatorio)
            this.estado = "acerto";
        else if (this.cantIntentos == this.topeIntentos)
            this.estado = "perdio";
        else if (aux < this.numeroAleatorio)
            this.estado = "bajo";
        else
            this.estado = "alto";


    }

    public String getEstado() {
        return estado;
    }

    public int getCantIntentos() {
        return cantIntentos;
    }


}
