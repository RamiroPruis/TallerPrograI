package exceptions;

/**
 * Una Excepcion que surge tras intentar jugar cuando el estado del juego es "perdio" o "gano"
 */
public class EstadoInvalidoException extends Exception {

    public EstadoInvalidoException(String message) {
        super(message);
    }
}
