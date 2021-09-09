package modelo;

import excepciones.NoExisteLegajoException;
import excepciones.NoExisteMateriaException;

import java.util.Iterator;

/**
 * @author Grupo2
 * Clase que representa el certificado de notas de un alumno.
 */
public class Certificado {
    private int legajo;
    private String nombre;
    private String apellido;
    private Alumno alumno;

    public Certificado(){
    }

    /**
     * <b>Pre:</b> El legajo debe ser un numero entero positivo. <br>
     * <b>Post: </b> En caso de que exista el legajo, se actualizan las variables internas, si no se lanza una excepcion.
     * @param Legajo
     * @throws NoExisteLegajoException
     */
    public void pedirCertificado(int Legajo) throws NoExisteLegajoException {
        assert Legajo>0 : "El legajo debe ser un numero positivo";
        Alumno alumno = Facultad.getInstance().getAlumno(Legajo);
        if (alumno != null){
            this.legajo=Legajo;
            this.alumno=alumno;
            this.nombre=alumno.getNombre();
            this.apellido=alumno.getApellido();
        }
        else
            throw new NoExisteLegajoException("El legajo no coincide");
    }

    /**
     * <b>Pre: </b> <br/>
     * <b>Post: </b>  En caso de que no haya legajo, lanza una excepcion. <br/>
     * @return Se devuelve el apellido y el nombre del alumno asociado al certificado.
     */
    public String traerApellidoyNombre() throws NoExisteLegajoException{
        verificaLegajo();
        return this.apellido + "," + this.nombre;
    }



    /**
     * <b>Pre:</b> La materia debe ser una de las cuatro posibles. El legajo debe existir.
     * <b>Post:</b> Si no hay legajo, lanza una excepcion. Si la materia no existe, tambien.
     * @param Materia
     * @return El estado de la materia solicitada.
     */
    public String traerEstado(String Materia) throws NoExisteLegajoException, NoExisteMateriaException {
        verificaLegajo();
        if (alumno.getMaterias().containsKey(Materia))
            return alumno.getMateria(Materia).getEstado();
        else
            throw new NoExisteMateriaException("La materia ingresada no existe o el alumno no la cursa");
    }

    /**
     * <b>Pre: </b> Debe haber un legajo asociado al certificado. <br>
     * @param Materia
     * @return La nota de la materia solicitada.
     * @throws NoExisteLegajoException
     */
    public String traerNota(String Materia) throws NoExisteLegajoException, NoExisteMateriaException {
        verificaLegajo();
        if (alumno.getMaterias().containsKey(Materia))
            return String.valueOf(alumno.getMateria(Materia).getNota());
        else
            throw new NoExisteMateriaException("La materia ingresada no existe o el alumno no la cursa");
    }

    /**
     * <b>Pre:</b> Debe haber un legajo asociado al certificado. <br/>
     * @return String sobre la condicion del alumno.
     * @throws NoExisteLegajoException
     */
    public String traerCondicion() throws NoExisteLegajoException {
        verificaLegajo();
        Iterator<String> it = alumno.getMaterias().keySet().iterator();
        int contador=0;
        do {
            String matActual = it.next();
            if (alumno.getMateria(matActual).getEstado().equalsIgnoreCase("A cursar"));
                contador++;
        }while  (it.hasNext() && contador!=2);
        if (contador>=2)
            return "Regular";
        else
            return "Irregular";
    }

    /**
     * Metodo que verifica que haya un legajo asociado al certificado. Verifica la Invariante del programa. <br>
     * @throws NoExisteLegajoException
     */
    private void verificaLegajo() throws NoExisteLegajoException{
        if (this.legajo==0)
            throw new NoExisteLegajoException("No hay legajo asociado al certificado");
    }

    public int getLegajo() {
        return legajo;
    }
}
