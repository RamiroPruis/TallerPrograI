package modelo;

import excepciones.CombustibleInsuficienteException;

public class Surtidor {
    private float cantidad_combustible, acumuladoManguera1, acumuladoManguera2, ultimaventaManguera1, ultimaventaManguera2;
    private boolean descarga=false;


    public void InicializarSurtidor(float carga){
        this.cantidad_combustible = carga;
        this.acumuladoManguera1 = 0;
        this.acumuladoManguera2 = 0;
        this.ultimaventaManguera1 = 0;
        this.ultimaventaManguera2 = 0;
    }

    public void cargarSurtidor(float carga){
        this.cantidad_combustible += carga;
    }

    public void activaManguera1() throws CombustibleInsuficienteException {
        if (this.cantidad_combustible>0){
            while(cantidad_combustible!=0 && this.descarga){
                cantidad_combustible--;
                try {
                    this.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else
            throw new CombustibleInsuficienteException();

    }

}
