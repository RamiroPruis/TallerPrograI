package testing.testGUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import controlador.Controlador;
import infraestructura.Habitacion;
import modelo.Clinica;
import modelo.IMedico;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testing.escenarios.ClinicaCargadaEscenario;
import testing.testGUI.TestUtils;
import vista.Ventana;

import javax.imageio.ImageIO;
import javax.swing.*;
import static org.junit.Assert.*;


public class GUITestDatos {
    public static final int DELAY = 50;
    private Robot robot;
    private Controlador controlador;
    public GUITestDatos() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception{
        robot.delay(DELAY);
        Clinica.setInstance(null);
        Ventana ventana = new Ventana();
        ClinicaCargadaEscenario escenario = new ClinicaCargadaEscenario();
        controlador = new Controlador(ventana,ventana,ventana,ventana);

    }

    @After
    public void tearDown() throws Exception
    {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(DELAY);
        Ventana ventana = (Ventana) controlador.getVistaPaciente();
        ventana.setVisible(false);
        Clinica.setInstance(null);
    }

    @Test
    public void cargaMedico (){
        JButton button = (JButton) TestUtils.getComponentForName((Component) controlador.getVistaPaciente(),"btn_Cargar");
        JList list_pacientes = (JList) TestUtils.getComponentForName((Component) controlador.getVistaPaciente(),"list_pacientes");
        TestUtils.clickComponent(button,robot);
        robot.delay(DELAY);
        TestUtils.clickComponent(list_pacientes,robot);
        JTabbedPane tabbedPane = (JTabbedPane) TestUtils.getComponentForName((Component) controlador.getVistaHabitacion(),"tabbedPane");

        robot.delay(DELAY);

        robot.keyPress(KeyEvent.VK_SHIFT);
        for (int i = 0; i < 3 ;i++) {
           aprieta(KeyEvent.VK_TAB,robot);
           robot.delay(DELAY);
        }
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.delay(DELAY);
        aprieta(KeyEvent.VK_RIGHT,robot);

        robot.delay(DELAY);
        //cambio de ventana

        JList list_medicos= (JList) TestUtils.getComponentForName((Component) controlador.getVistaMedico(),"list_medicos");
        TestUtils.clickComponent(list_medicos,robot);
        IMedico medicoAct = (IMedico) list_medicos.getSelectedValue();
        robot.keyPress(KeyEvent.VK_SHIFT);
        for (int i = 0; i < 3 ;i++) {
            aprieta(KeyEvent.VK_TAB,robot);
            robot.delay(DELAY);
        }
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.delay(DELAY);
        aprieta(KeyEvent.VK_LEFT,robot);
        robot.delay(DELAY);

        JButton btn_prestacionMedica = (JButton) TestUtils.getComponentForName((Component) controlador.getVistaPaciente(),"btn_PrestacionMedica");
        TestUtils.clickComponent(btn_prestacionMedica,robot);
        String esperado = "Se agrego la prestacion medica: "+ medicoAct.getNombre() +" " + medicoAct.getMatricula() + " al paciente";

        assertEquals("El mensaje mostrado es incorrecto",esperado,TestUtils.msgDialog);
    }

    @Test
    public void cargaHabitacion(){
        JButton button = (JButton) TestUtils.getComponentForName((Component) controlador.getVistaPaciente(),"btn_Cargar");
        JList list_pacientes = (JList) TestUtils.getComponentForName((Component) controlador.getVistaPaciente(),"list_pacientes");
        TestUtils.clickComponent(button,robot);
        robot.delay(DELAY);
        TestUtils.clickComponent(list_pacientes,robot);
        JTabbedPane tabbedPane = (JTabbedPane) TestUtils.getComponentForName((Component) controlador.getVistaHabitacion(),"tabbedPane");

        robot.delay(DELAY);

        robot.keyPress(KeyEvent.VK_SHIFT);
        for (int i = 0; i < 3 ;i++) {
            aprieta(KeyEvent.VK_TAB,robot);
            robot.delay(DELAY);
        }
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.delay(DELAY);
        aprieta(KeyEvent.VK_RIGHT,robot);
        robot.delay(DELAY);
        aprieta(KeyEvent.VK_RIGHT,robot);
        robot.delay(DELAY);

        JTextField textField_cantDias = (JTextField) TestUtils.getComponentForName((Component) controlador.getVistaHabitacion(),"textField_cantDias");
        TestUtils.clickComponent(textField_cantDias,robot);
        TestUtils.tipeaTexto("10",robot);

        JList list_habitaciones = (JList) TestUtils.getComponentForName((Component) controlador.getVistaPaciente(),"list_habitaciones");
        TestUtils.clickComponent(list_habitaciones,robot);
        Habitacion habitacionAct = (Habitacion) list_habitaciones.getSelectedValue();

        robot.delay(DELAY);
        robot.keyPress(KeyEvent.VK_SHIFT);
        for (int i = 0; i < 1 ;i++) {
            aprieta(KeyEvent.VK_TAB,robot);
            robot.delay(DELAY);
        }
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.delay(DELAY);
        aprieta(KeyEvent.VK_LEFT,robot);
        aprieta(KeyEvent.VK_LEFT,robot);
        robot.delay(DELAY);
        JButton btn_prestacionHabitacion = (JButton) TestUtils.getComponentForName((Component) controlador.getVistaPaciente(),"btn_PrestacionHabitacion");
        TestUtils.clickComponent(btn_prestacionHabitacion,robot);

        String esperado = "Se agrego la habitacion: "+ habitacionAct.toString()+ " al paciente";

        assertEquals("El mensaje mostrado es incorrecto",esperado,TestUtils.msgDialog);

    }

    @Test
    public void intentaAtenderSinCargar(){
        JButton btn_atender = (JButton) TestUtils.getComponentForName((Component) controlador.getVistaPaciente(),"btn_atender");
        assertFalse("El boton deberia estar deshabilitado",btn_atender.isEnabled());
    }

    @Test
    public void todosAtendidos(){
        JButton button = (JButton) TestUtils.getComponentForName((Component) controlador.getVistaPaciente(),"btn_Cargar");
        TestUtils.clickComponent(button,robot);
        robot.delay(DELAY);

        JButton btn_atender = (JButton) TestUtils.getComponentForName((Component) controlador.getVistaPaciente(),"btn_atender");
        TestUtils.clickComponent(btn_atender,robot);

        assertEquals("El mensaje esperado no es correcto","No hay mas pacientes en la lista de espera",TestUtils.msgDialog);
    }

    public void aprieta(int key,Robot robot){
        robot.keyPress(key);
        robot.keyRelease(key);
    }


}



