package excepciones;

public class NoExisteLegajoException extends Exception{


    public NoExisteLegajoException(String no_hay_legajo_existente) {
        super(no_hay_legajo_existente);
    }

}
