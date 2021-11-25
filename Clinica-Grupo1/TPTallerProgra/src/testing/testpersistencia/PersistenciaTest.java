package testing.testpersistencia;

import modelo.Clinica;
import org.junit.Before;
import org.junit.Test;
import persistencia.ClinicaDTO;
import persistencia.Persistencia;
import util.Util;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PersistenciaTest {


    @Before
    public void setUp() {
        //Creamos una clinica desde cero (vacia)
        Clinica.setInstance(null);
        Clinica.getInstance();

        //Aca estamos checkeando que si habia un archivo que lo elimine
        File file = new File("clinicaPersistida.bin");
        if (file.exists())
            file.delete();
    }


    @Test
    public void testCrearArchivo() {
        Persistencia persistencia = new Persistencia();
        ClinicaDTO clinicaDTO = Util.clinicaDTOFromCLinica();

        try {
            //Creamos el archivo y persistimos
            persistencia.abrirOutput("clinicaPersistida.bin");
            persistencia.escribir(clinicaDTO);
            persistencia.cerrarOutput();
            File file = new File("clinicaPersistida.bin");
            assertTrue("Deberia existir el archivo clinicaPersistida.bin", file.exists());

        } catch (IOException e) {
            fail("No deberia entrar aca");
        }
    }

    @Test
    public void testClinicaVacia() {
        Persistencia persistencia = new Persistencia();
        ClinicaDTO clinicaDTO = Util.clinicaDTOFromCLinica();


        try {
            //Creamos el archivo y persistimos
            persistencia.abrirOutput("clinicaPersistida.bin");
            persistencia.escribir(clinicaDTO);
            persistencia.cerrarOutput();
            //Despersistimos

            try {
                ClinicaDTO clinicaDespersistida;
                persistencia.abrirInput("clinicaPersistida.bin");
                clinicaDespersistida = (ClinicaDTO) persistencia.leer();
                persistencia.cerrarInput();
                assertTrue("Las clinicas deben ser iguales", clinicaDespersistida.equals(clinicaDTO));

            } catch (ClassNotFoundException e) {
                fail("No deberia entrar aca");
            }

        } catch (IOException e) {
            fail("No deberia entrar aca");
        }
    }

}
