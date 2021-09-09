package negocio;

import UI.IVista;
import excepciones.NoExisteLegajoException;
import excepciones.NoExisteMateriaException;
import modelo.Certificado;

public class Negocio {

    private static Negocio _instance=null;
    public Certificado certificado;
    private IVista vista;

    public Negocio() {
        this.certificado=new Certificado();
    }


    public static Negocio getInstance(){
        if (_instance == null)
            _instance = new Negocio();
        return _instance;
    }


    public void setVista(IVista vista){
        this.vista=vista;
    }

    /**
     * Solicita un certificado en base a un legajo. El mismo no se valida en esta ocasion.
     * <b>Post:</b> Se crea un certificado con el legajo saociado, o se lanza una excepcion.
     * @param legajo
     * @throws NoExisteLegajoException
     */
    public void pedirCertificado(Integer legajo) throws NoExisteLegajoException {
        this.certificado.pedirCertificado(legajo);
    }

    /**
     * Retorna el apellido y el nombre del certificado creado. Si no es posible, imprime la excepcion<br>
     * @return
     */
    public String traerApellidoyNombre(){
        String apenom=null;
        try {
            apenom = this.certificado.traerApellidoyNombre();
        } catch (NoExisteLegajoException e) {
            e.printStackTrace();
        }
        return apenom;
    }

    /**
     * Metodo que retorna el estado de una cierta materia.  <br>
     * @param Materia
     * @return
     */
    public String traerEstado(String Materia){
        String estado=null;
        try {
            estado=this.certificado.traerEstado(Materia);
        } catch (NoExisteLegajoException | NoExisteMateriaException e) {
            e.printStackTrace();
        }
        return estado;
    }

    /**
     * Metodo que delga al certificado la obtencion de la nota de una cierta materia. <br/>
     * @param Materia
     * @return
     */
    public String traerNota(String Materia){
        String Nota=null;
        try {
            Nota=this.certificado.traerNota(Materia);
        } catch (NoExisteLegajoException | NoExisteMateriaException e) {
            e.printStackTrace();
        }
        return Nota;
    }

    /**
     * Metodo que delga al certificado la obtencion de la condicion del estudiante.
     *
     * @return
     */
    public String traerCondicion(){
        String condicion=null;
        try {
            condicion=this.certificado.traerCondicion();
        } catch (NoExisteLegajoException e) {
            e.printStackTrace();
        }
        return condicion;
    }


}
