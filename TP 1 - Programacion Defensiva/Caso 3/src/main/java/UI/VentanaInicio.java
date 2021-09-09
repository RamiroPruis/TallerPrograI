package UI;

import excepciones.NoExisteLegajoException;
import negocio.Negocio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaInicio extends JFrame implements IVista,KeyListener, ActionListener {

    private JPanel contentPane;
    private JPanel panel;
    private JPanel panel_1;
    private JLabel lblNewLabel;
    private JTextField textLegajo;
    private JButton btnSolicitar;
    private JButton btnMostrarCertificado;
    private JPanel panel_3;
    private JLabel lblNewLabel_1;
    private JTextField textMateria;
    private JPanel panel_4;
    private JPanel panel_5;
    private JButton btnMostrarEstado;
    private JButton btnMostrarNota;
    private JPanel panel_6;
    private JTextPane textPane;
    private JPanel panel_9;
    private JPanel panel_2;
    private JPanel panel_7;
    private JPanel panel_8;

    /**
     * Create the frame.
     */
    public VentanaInicio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(this.contentPane);

        this.panel = new JPanel();
        this.contentPane.add(this.panel, BorderLayout.NORTH);
        this.panel.setLayout(new BorderLayout(0, 0));

        this.panel_1 = new JPanel();
        this.panel.add(this.panel_1, BorderLayout.WEST);

        this.panel_9 = new JPanel();
        this.panel_1.add(this.panel_9);

        this.lblNewLabel = new JLabel("Legajo");
        this.panel_9.add(this.lblNewLabel);

        this.panel_2 = new JPanel();
        this.panel_9.add(this.panel_2);

        this.textLegajo = new JTextField();
        this.panel_2.add(this.textLegajo);
        this.textLegajo.setColumns(10);

        this.panel_7 = new JPanel();
        this.panel_9.add(this.panel_7);

        this.btnSolicitar = new JButton("Solicitar Certificado");
        this.panel_7.add(this.btnSolicitar);
        this.btnSolicitar.setActionCommand("Solicitar");

        this.btnMostrarCertificado = new JButton("Mostrar Certificado");
        this.panel_7.add(this.btnMostrarCertificado);
        this.btnMostrarCertificado.setActionCommand("MostrarCertificado");

        this.panel_3 = new JPanel();
        this.panel.add(this.panel_3, BorderLayout.SOUTH);
        this.panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        this.panel_8 = new JPanel();
        this.panel_3.add(this.panel_8);

        this.lblNewLabel_1 = new JLabel("Materia");
        this.panel_8.add(this.lblNewLabel_1);
        this.lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);

        this.panel_4 = new JPanel();
        this.panel_8.add(this.panel_4);

        this.textMateria = new JTextField();
        this.panel_4.add(this.textMateria);
        this.textMateria.setHorizontalAlignment(SwingConstants.LEFT);
        this.textMateria.setColumns(10);

        this.panel_5 = new JPanel();
        this.panel_8.add(this.panel_5);

        this.btnMostrarEstado = new JButton("Mostrar Estado");
        this.btnMostrarEstado.setActionCommand("MostrarEstado");
        this.panel_5.add(this.btnMostrarEstado);

        this.btnMostrarNota = new JButton("Mostrar Nota");
        this.btnMostrarNota.setActionCommand("MostrarNota");
        this.panel_5.add(this.btnMostrarNota);

        this.panel_6 = new JPanel();
        this.contentPane.add(this.panel_6, BorderLayout.CENTER);
        this.panel_6.setLayout(new BorderLayout(0, 0));

        this.textPane = new JTextPane();
        this.textPane.setEditable(true);
        this.panel_6.add(this.textPane);
        this.setVisible(true);
    }

    public void addActionListener(ActionListener actionListener) {
        this.btnMostrarNota.addActionListener(actionListener);
        this.btnMostrarEstado.addActionListener(actionListener);
        this.btnSolicitar.addActionListener(actionListener);
        this.btnMostrarCertificado.addActionListener(actionListener);
    }

    @Override
    public String getTextMateria() {
        return textMateria.getText();
    }

    @Override
    public int getTextLegajo() {
        return Integer.parseInt(textLegajo.getText());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        String Materia = "";
        Materia = this.textMateria.getText();
        if (!Materia.isBlank()) {
            this.btnMostrarNota.setEnabled(true);
            this.btnMostrarEstado.setEnabled(true);
        }
    }

    /**
     * Metodo que delega a la capa de negocio la peticion del certificado con un legajo no verificado.
     * <b>Post: De ser posible, genera un certificado en base a un legajo y lo muestra. Si no, lanza una excepcion.</b> <br>
     * @param Legajo
     */
    public void pedirCertificado(Integer Legajo){
        try {
            Negocio.getInstance().pedirCertificado(Legajo);
            this.mostrarCertificado();
        } catch (NoExisteLegajoException e) {
            this.mostrarEstado(e.getLocalizedMessage());
        }
    }

    /**
     * Muestra por una ventana emergente el mensaje recibido por parametro
     * <b>Pre:</b> El mensaje debe ser no nulo, debe existir. <br>
     * @param Mensaje
     */
    public void mostrarEstado(String Mensaje){
        assert Mensaje!=null : "Mensaje invalido";
        assert Mensaje!="" : "No hay mensaje para mostrar";
        JOptionPane.showMessageDialog(this,Mensaje);
    }

    /**
     * Muestra por pantalla los datos del certificado emitido.
     * <b>Pre:</b>  El certificado debe haber sido generado previamente. <br>
     */
    public void mostrarCertificado(){
        if (Negocio.getInstance().getCertificado()!=null)
            this.textPane.setText("Apellido, Nombre:" + Negocio.getInstance().traerApellidoyNombre() + "\n"
                    + "Legajo: " + Negocio.getInstance().getCertificado().getLegajo() );
    }

    /**
     *
     * @param mensaje
     */
    public void mostrarMensaje(String mensaje){
       this.textPane.setText(mensaje);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
