package testing.escenarios;

import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import infraestructura.Prestacion;
import modelo.PacienteFactory;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class FacturaConPrestacionesEscenario {
    Factura factura;


    public FacturaConPrestacionesEscenario() {
        try {
            factura = new Factura(1, new GregorianCalendar(), PacienteFactory.getPaciente("123", "nombre", "apellido", "ciudad", "123", "domicilio", "Joven"));
            ArrayList<Prestacion> prestaciones = new ArrayList<Prestacion>();
            Prestacion prestacion1 = new Prestacion("Habitacion1", 356.4, 4);
            Prestacion prestacion2 = new Prestacion("Habitacion2", 100.4, 2);
            Prestacion prestacion3 = new Prestacion("Habitacion3", 300.4, 3);
            prestaciones.add(prestacion1);
            prestaciones.add(prestacion2);
            prestaciones.add(prestacion3);
            factura.setPrestaciones(prestaciones);
        } catch (NoExisteRangoEtarioException e) {
            e.printStackTrace();
        }

    }

    public Factura getFactura() {
        return factura;
    }

}
