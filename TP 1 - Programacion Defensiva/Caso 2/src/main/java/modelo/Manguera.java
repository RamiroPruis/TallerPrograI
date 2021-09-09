package modelo;

import excepciones.CombustibleInsuficienteException;

public class Manguera implements Runnable{
    private double acumulado;
    private double ult_venta;
    private boolean activado;
    private Surtidor surtidor;

    public Manguera(Surtidor surtidor){
        this.acumulado = 0;
        this.ult_venta = 0;
        this.surtidor = surtidor;
        this.activado= false;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public double getAcumulado() {
        return acumulado;
    }

    public double getUlt_venta() {
        return ult_venta;
    }

    @Override
    public void run(){
        try {
            this.surtidor.activaDescarga(this);
        } catch (CombustibleInsuficienteException e) {
            e.printStackTrace();
        }
    }



}
