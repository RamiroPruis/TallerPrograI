package modelo;

import exceptions.EstadoInvalidoException;
import exceptions.NumeroInvalidoException;

/**
 * Clase encargada de la logica, solo habrá una instancia de esta.
 * Contiene la informacion necesaria para saber si el jugador gana o no
 */
public class Juego {
    private static Juego instance = null;
    private int cantIntentos;
    private int numeroAleatorio;
    private String estado = null;
    private final int min = 1, max = 100, topeIntentos = 10; //Constantes

    /**
     * Constructor privado vacio
     */
    private Juego() {
    }

    /**
     * Metodo getInstance usado para instanciar solo una vez la clase Juego
     *
     * @return
     */
    public static Juego getInstance() {
        if (instance == null)
            instance = new Juego();
        return instance;
    }

    /**
     * post: Genera un numero aleatorio entre min y max (constantes de la clase) y pone en 0 el numero de intentos
     */
    public void iniciarJuego() {
        this.numeroAleatorio = min + (int) (Math.random() * ((max - min) + 1));
        this.cantIntentos = 0;
        this.estado = "";
    }

    /**
     * pre: El numero por parametro debe ser entero positivo entre min y max <br>
     * El estado del juego no puede ser "perdio" o "acerto" <br>
     * <p>
     * post: Incrementa en uno la cantidad de intentos<br>
     * establece el estado de la prueba :<br>
     * • ‘bajo’ si el número ingresado es menor que el generado<br>
     * • ‘alto’ si el número ingresado es mayor que el generado<br>
     * • ‘acertó’ si el número ingresado es igual al generado<br>
     * • ‘perdió’ si la cantidad de intentos es igual a 10 y el número ingresado no es igual al generado<br>
     *
     * @param numero
     * @throws NumeroInvalidoException
     * @throws EstadoInvalidoException
     */
    public void probar(double numero) throws NumeroInvalidoException, EstadoInvalidoException {
        int aux;

        // Estas exceptions puede que sean reemplazadas por el assert? --> no porque el enunciado dice que VALIDA
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

    /**
     * Retorna el estado del juego
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Retorna la cantidad de intentos
     *
     * @return
     */
    public int getCantIntentos() {
        return cantIntentos;
    }


}
