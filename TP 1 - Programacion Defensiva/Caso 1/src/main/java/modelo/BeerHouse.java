package modelo;

import java.util.ArrayList;


public class BeerHouse {
    private static BeerHouse instance = null;
    private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private int cantMesas;
    private Carta carta;
    private boolean abierto = false;

    private BeerHouse() {

    }

    public static BeerHouse getInstance() {
        BeerHouse respuesta;
        if (instance == null) {
            respuesta = new BeerHouse();
            instance = respuesta;
        } else
            respuesta = instance;
        return respuesta;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    /**
     * Pre: La cantaidad de mesas es >= 1 y menor que 50
     * Post: Actualiza la carta, inicializa las mesas en desocupadas
     *
     * @param cantMesas
     */
    public void abrirLocal(int cantMesas) throws MesasInvalidoException {
        //verificarInvariante(cantMesas);

        if (!(cantMesas >= 1 && cantMesas <= 50))
            throw new MesasInvalidoException();

        this.cantMesas = cantMesas;

        for (int i = 0; i < cantMesas; i++) {
            this.mesas.add(new Mesa(false));
        }

        this.abierto = true;
        this.carta = new Carta();
        this.carta.actualiza();
    }

    private void verificarInvariante(int cantMesas) {
        assert cantMesas >= 1 : "La cantidad de mesas debe ser mayor a 0";
        assert cantMesas <= mesas.size() : "La cantidad de mesas debe ser menor a 50";
    }


    /**
     * Pre: Numero de mesa debe estar dentro de las mesas habilitadas, y la mesa debe estar libre
     * Post: Cambia el estado de la mesa elegida a ocupada
     *
     * @param nroMesa
     * @return Instancia de la mesa seleccionada
     */
    public Mesa ocuparMesa(int nroMesa) throws MesaOcupadaException {
        verificarInvariante(nroMesa);

        if (nroMesa >= this.mesas.size()) throw new MesaOcupadaException("Eliga una mesa valida, comienzan en 0");
        if (this.mesas.get(nroMesa).isActiva()) throw new MesaOcupadaException("La mesa ya esta ocupada");

        mesas.get(nroMesa).setActiva(true);
        System.out.println("La mesa que se ocupo fue la " + nroMesa);
        return mesas.get(nroMesa);
    }

    /**
     * Pre: Numero de mesa debe ser valido. La mesa debe estar en estado ocupada para poder seleccionar esta opcion
     * Post: Retorna el importe de la cuenta, y setea en libre la mesa
     *
     * @param nroMesa
     * @return
     */
    public double cerrarMesa(int nroMesa) throws MesaLibreException {
        verificarInvariante(nroMesa);

        if (nroMesa >= this.mesas.size()) throw new MesaLibreException("Eliga una mesa valida, comienzan en 0");

        if (!mesas.get(nroMesa).isActiva()) throw new MesaLibreException("La mesa no estaba siendo en uso, elija otra");

        double cuenta = mesas.get(nroMesa).getCuenta();
        mesas.get(nroMesa).setActiva(false);
        mesas.get(nroMesa).setCuenta(0);
        return cuenta;
    }

}
