package testing.testCajaNegra;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import infraestructura.Factura;
import infraestructura.HabitacionCompartida;
import infraestructura.Prestacion;
import modelo.IMedico;
import modelo.MedicoFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import testing.escenarios.FacturaConPrestacionesEscenario;
import testing.escenarios.FacturaSinPrestacionesEscenario;
import testing.escenarios.MedicoCorrectoEscenario;


public class FacturaTest {

    FacturaConPrestacionesEscenario facturaConPrestaciones;
    FacturaSinPrestacionesEscenario facturaSinPrestaciones;

    @Before
    public void setUp() {
        facturaConPrestaciones = new FacturaConPrestacionesEscenario();
        facturaSinPrestaciones = new FacturaSinPrestacionesEscenario();

    }

    @After
    public void tearDown() {

    }

    @Test
    public void asignarHabitacionPrestacionesExistentes() {

        Factura factura = facturaConPrestaciones.getFactura();
        int sizeBefore = factura.getPrestaciones().size();
        factura.asignarHabitacion(new HabitacionCompartida(3, 36.5));
        assertEquals(factura.getPrestaciones().size(), sizeBefore+1); //Verificamos que se agregue algo en la lista
        assertNotNull(factura.getPrestaciones().get(sizeBefore)); // Verificamos que no sea null
    }


    @Test
    public void asignarHabitacionPrestacionesInexistentes() {

        Factura factura = facturaSinPrestaciones.getFactura();
        int sizeBefore = factura.getPrestaciones().size();
        factura.asignarHabitacion(new HabitacionCompartida(3, 36.5));
        assertEquals(factura.getPrestaciones().size(), sizeBefore+1); //Verificamos que se agregue algo en la lista
        assertNotNull(factura.getPrestaciones().get(sizeBefore)); // Verificamos que no sea null
    }

    @Test
    public void asignarMedicoConPrestacionesExistentes(){
        MedicoCorrectoEscenario medicoCorrecto = new MedicoCorrectoEscenario();
        Factura factura = facturaConPrestaciones.getFactura();
        int sizeBefore = factura.getPrestaciones().size();
        try {
            IMedico medicoPrueba = MedicoFactory.getMedico(medicoCorrecto.dNI,medicoCorrecto.nombre,medicoCorrecto.apellido,medicoCorrecto.ciudad,medicoCorrecto.telefono,medicoCorrecto.domicilio,medicoCorrecto.matricula,medicoCorrecto.especialidad,medicoCorrecto.contratacion,medicoCorrecto.posgrado);
            factura.asignarMedico(medicoPrueba);
            assertEquals(factura.getPrestaciones().size(), sizeBefore+1); //Verificamos que se agregue algo en la lista
            assertNotNull(factura.getPrestaciones().get(sizeBefore)); // Verificamos que no sea null
        } catch (NoExisteEspecialidadException e) {
            e.printStackTrace();
        } catch (NoExisteContratacionException e) {
            e.printStackTrace();
        } catch (NoExistePosgradoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void asignarMedicoSinPrestacionesExistentes(){
        MedicoCorrectoEscenario medicoCorrecto = new MedicoCorrectoEscenario();
        Factura factura = facturaSinPrestaciones.getFactura();
        int sizeBefore = factura.getPrestaciones().size();
        try {
            IMedico medicoPrueba = MedicoFactory.getMedico(medicoCorrecto.dNI,medicoCorrecto.nombre,medicoCorrecto.apellido,medicoCorrecto.ciudad,medicoCorrecto.telefono,medicoCorrecto.domicilio,medicoCorrecto.matricula,medicoCorrecto.especialidad,medicoCorrecto.contratacion,medicoCorrecto.posgrado);
            factura.asignarMedico(medicoPrueba);
            assertEquals(factura.getPrestaciones().size(), sizeBefore+1); //Verificamos que se agregue algo en la lista
            assertNotNull(factura.getPrestaciones().get(sizeBefore)); // Verificamos que no sea null
        } catch (NoExisteEspecialidadException e) {
            e.printStackTrace();
        } catch (NoExisteContratacionException e) {
            e.printStackTrace();
        } catch (NoExistePosgradoException e) {
            e.printStackTrace();
        }
    }

}
