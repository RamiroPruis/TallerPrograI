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

        //Creamos una clinica VACIA
        Clinica.setInstance(null);
        Clinica.getInstance();

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


    @Test
    public void testClinicaConDatos(){

        Persistencia persistencia = new Persistencia();
        ClinicaCargada.cargaClinica(); //Carga la clinica con cosas (hardcode)
        ClinicaDTO clinicaDTO = Util.clinicaDTOFromCLinica();

        try {
            //Creamos el archivo y persistimos
            persistencia.abrirOutput("clinicaPersistida.bin");
            persistencia.escribir(clinicaDTO);
            persistencia.cerrarOutput();


            try {
                //Abrimos el archivo y despersistimos
                persistencia.abrirInput("clinicaPersistida.bin");
                ClinicaDTO clinicaDespersistida = (ClinicaDTO) persistencia.leer();
                persistencia.cerrarOutput();
                assertTrue("Las clinicas deben ser iguales", clinicaDespersistida.equals(clinicaDTO));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Despersistimos

    }

}
