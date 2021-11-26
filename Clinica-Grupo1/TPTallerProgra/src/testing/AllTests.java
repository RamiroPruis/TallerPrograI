package testing;


import modelo.MedicoFactory;
import modelo.PacienteFactory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testing.testCajaNegra.*;
import testing.testGUI.GUITestDatos;
import testing.testpersistencia.PersistenciaTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({GUITestDatos.class, PacienteFactoryTest.class, MedicoFactoryTest.class,FacturaTest.class, ClinicaVaciaTest.class, ClinicaCargadaTest.class, AgregarInstalacion.class, AgregarPracticaTest.class,BuscarPacienteTest.class,AltaDePacienteTest.class, PersistenciaTest.class,})
public class AllTests {
}
