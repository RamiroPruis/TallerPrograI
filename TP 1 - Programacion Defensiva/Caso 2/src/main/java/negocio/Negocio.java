package negocio;

import excepciones.CombustibleInsuficienteException;
import excepciones.ImposibleCargarException;
import modelo.Surtidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Negocio implements ActionListener {
    private Surtidor surtidor;


    public void inicializaSurtidor(double carga) throws ImposibleCargarException {
        this.surtidor = new Surtidor();
        this.surtidor.InicializarSurtidor(carga);
    }

    /**
     * Envia la cantidad a cargar al metodo cargaSurtidor del surtidor. <br>
     * <b>Pre:</b> El surtidor fue inicializado (!= <i>null</i>)
     * @param carga
     * @throws ImposibleCargarException
     */
    public void cargaSurtidor (double carga) throws ImposibleCargarException{
        this.surtidor.cargarSurtidor(carga);
    }

    private void activaManguera1() throws CombustibleInsuficienteException {
        this.surtidor.activaManguera1();
    }

    private void activaManguera2() throws CombustibleInsuficienteException {
        this.surtidor.activaManguera2();
    }

    private void desactivaManguera1(){
        this.surtidor.desactivaManguera1();
    }
    private void desactivaManguera2(){
        this.surtidor.desactivaManguera2();
    }

    public double getExistenciaDeposito(){
        return this.surtidor.getCantidad_combustible();
    }

    public double getAcumuladoManguera1(){
        return this.surtidor.getAcumuladoManguera1();
    }

    public double getAcumuladoManguera2(){
        return this.surtidor.getAcumuladoManguera2();
    }

    public double getUltimaVentaMG1(){
        return this.surtidor.getUltimaVentaMG1();
    }

    public double getUltimaVentaMG2(){
        return this.surtidor.getUltimaVentaMG2();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
