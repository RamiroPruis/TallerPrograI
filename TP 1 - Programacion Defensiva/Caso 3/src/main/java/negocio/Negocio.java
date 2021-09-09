package negocio;

import UI.IVista;
import excepciones.NoExisteLegajoException;
import excepciones.NoExisteMateriaException;
import modelo.Certificado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Negocio implements ActionListener {
    private static Negocio _instance;
    public Certificado certificado;
    private IVista vista;

    public Negocio() {
        this.certificado=new Certificado();
    }

    public static Negocio getInstance(){
        if (_instance==null)
            _instance=new Negocio();
        return _instance;
    }
    public void setVista(IVista vista){
        this.vista=vista;
        this.vista.addActionListener(this);
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
            vista.mostrarEstado(e.getLocalizedMessage());
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
            this.vista.mostrarEstado(e.getLocalizedMessage());
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
            this.vista.mostrarEstado(e.getLocalizedMessage());
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
            this.vista.mostrarEstado(e.getLocalizedMessage());
        }
        return condicion;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        if (accion.equalsIgnoreCase("MostrarNota")){
            vista.mostrarMensaje(this.traerNota(vista.getTextMateria()));
        }
        else if (accion.equalsIgnoreCase("MostrarEstado")){
            vista.mostrarMensaje(this.traerEstado(vista.getTextMateria()));
        }
        else if (accion.equalsIgnoreCase("MostrarCertificado")){
            vista.mostrarCertificado();
        }
        else if (accion.equalsIgnoreCase("Solicitar")){
            vista.pedirCertificado(vista.getTextLegajo());
        }
    }

    public Certificado getCertificado(){
        return this.certificado;
    }
}
