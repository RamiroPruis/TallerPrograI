package testing.cajaBlanca;

import infraestructura.Factura;
import modelo.Clinica;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import testing.escenarios.ClinicaCargadaEscenario;

import java.util.ArrayList;

public class CajaBlancaPrevio {


    @Before
    public void setUp(){
        //Cargamos la clinica
        ClinicaCargadaEscenario clinicaCargada = new ClinicaCargadaEscenario();


//        Clinica.getInstance().calculoImporteAdicionales(factura.getNroFactura(), factura.getFecha(),insumos);
    }

    @Test
    public void calculoImporteAdicional(){

        //Obtenemos una factura y creamos insumos
        Factura factura = Clinica.getInstance().getFacturas().first();
        ArrayList<Double> insumos = new ArrayList<Double>();
        insumos.add(20.0);
        insumos.add(24.0);
        System.out.println(Clinica.getInstance().calculoImporteAdicionales(factura.getNroFactura(), factura.getFecha(),insumos));
    }
}
