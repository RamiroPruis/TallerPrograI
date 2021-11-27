package testing;


import modelo.MedicoFactory;
import modelo.PacienteFactory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testing.cajaBlanca.CajaBlancaEscenario1Test;
import testing.cajaBlanca.CajaBlancaEscenario2Test;
import testing.cajaBlanca.CajaBlancaPrevioTest;
import testing.testCajaNegra.*;
import testing.testGUI.GUITestDatos;
import testing.testIntegracion.IntegracionDescendenteTest;
import testing.testpersistencia.PersistenciaTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({GUITestDatos.class, PacienteFactoryTest.class, MedicoFactoryTest.class,FacturaTest.class, ClinicaVaciaTest.class, ClinicaCargadaTest.class, AgregarInstalacion.class, AgregarPracticaTest.class,BuscarPacienteTest.class,AltaDePacienteTest.class, PersistenciaTest.class, CajaBlancaPrevioTest.class, CajaBlancaEscenario1Test.class, CajaBlancaEscenario2Test.class, IntegracionDescendenteTest.class,PacienteTest.class})
public class AllTests {
}
