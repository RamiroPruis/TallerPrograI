package exceptions;


/**
 * Excepcion lanzada cuando el numero ingresado no es valido
 */
public class NumeroInvalidoException extends Throwable {
    public NumeroInvalidoException(String message) {
        super(message);
    }
}
