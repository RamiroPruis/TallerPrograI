package testing.escenarios;

import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import modelo.PacienteFactory;

import java.util.GregorianCalendar;

public class FacturaSinPrestacionesEscenario {
    Factura factura;


    public FacturaSinPrestacionesEscenario() {
        try {
            factura = new Factura(1, new GregorianCalendar(), PacienteFactory.getPaciente("123", "nombre", "apellido", "ciudad", "123", "domicilio", "Joven"));
        } catch (NoExisteRangoEtarioException e) {
            e.printStackTrace();
        }

    }

    public Factura getFactura() {
        return factura;
    }

}
