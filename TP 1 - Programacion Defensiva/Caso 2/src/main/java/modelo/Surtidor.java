package modelo;

import excepciones.CombustibleInsuficienteException;
import excepciones.ImposibleCargarException;

public class Surtidor {
    private double cantidad_combustible;
    private Manguera manguera1, manguera2;
    private boolean activado;

    /**
     * Setea el surtidor e instancia sus mangueras. Capacidad maxima del surtidor: 2000l<br>
     * <b>Pre: </b> La carga inicial tiene que ser >= 1 <br>
     * <b>Pos:  </b> Se inicializa la cantidad de combustible y se inicializa en 0 el acumulado de ventas y ultima venta de cada manguera.
     *
     * @param carga Cantidad de combustible inicial del surtidor (>=1)
     */
    public void InicializarSurtidor(double carga) throws ImposibleCargarException{
        if (carga>2000)
            throw new ImposibleCargarException();
        this.cantidad_combustible = carga;
        manguera1 = new Manguera(this);
        manguera2 = new Manguera(this);
    }

    /**
     * Carga el combustible en el surtidor. <br>
     * <b>Pre: </b> La carga tiene que ser >=1
     *
     * @param carga
     */
    public void cargarSurtidor(double carga) throws ImposibleCargarException{
        if (!(this.cantidad_combustible+carga > 2000))
            this.cantidad_combustible += carga;
        else
            throw new ImposibleCargarException();
    }

    /**
     * Descarga combustible de la manguera hasta que se detenga la descarga o no haya mas combustible
     * @param manguera Es la manguera activada que realiza la descarga
     * @throws CombustibleInsuficienteException Cuando no hay mas combustible en el surtidor y no se desactiva la manguera
     */
    protected synchronized void activaDescarga(Manguera manguera) throws CombustibleInsuficienteException{
        manguera.setActivado(true);
        do{
            cantidad_combustible--;
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(this.cantidad_combustible>0 && manguera.isActivado());
        notifyAll();
        if (cantidad_combustible == 0){
            throw new CombustibleInsuficienteException();
        }
    }

    /**
     * Activa la manguera 1
     * @throws CombustibleInsuficienteException Si no hay combustible suficiente
     */
    public void activaManguera1() throws CombustibleInsuficienteException {
        if (this.cantidad_combustible>0)
            new Thread(this.manguera1).start();
        else
            throw new CombustibleInsuficienteException();
    }

    /**
     * Desactiva la manguera
     */
    public void desactivaManguera1(){
        assert !this.manguera1.isActivado() : "la manguera no estaba activada";

        this.manguera1.setActivado(false);
    }

    public void activaManguera2() throws CombustibleInsuficienteException{
       if (this.cantidad_combustible>0)
            new Thread(this.manguera2).start();
       else
           throw new CombustibleInsuficienteException();
    }

    public void desactivaManguera2(){
        assert !this.manguera2.isActivado() : "la manguera no estaba activada";

        this.manguera2.setActivado(false);
    }

    public double getAcumuladoManguera1(){
        return this.manguera1.getAcumulado();
    }

    public double getAcumuladoManguera2(){
        return this.manguera2.getAcumulado();
    }

    public double getUltimaVentaMG1(){
        return this.manguera1.getUlt_venta();
    }

    public double getUltimaVentaMG2(){
        return this.manguera2.getUlt_venta();
    }
    public double getCantidad_combustible() {
        return cantidad_combustible;
    }
}
