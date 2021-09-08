package vista;

import negocio.Monitor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


/**
 * Clase interfaz grafica, encargada de extraer datos desde la ventana e interactuar directamente con el usuario
 */
public class Ivista extends JFrame {

    private JPanel contentPane;
    private JPanel panelSur;
    private JLabel lblVolverJugar;
    private JButton btnNewButton;
    private JPanel panelCentral;
    private JLabel lblEligeNumero;
    private JTextField textFieldElijeNumero;
    private JButton btnProbar;


    /**
     * Create the frame.
     */
    public Ivista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(this.contentPane);

        this.panelSur = new JPanel();
        this.contentPane.add(this.panelSur, BorderLayout.SOUTH);

        this.lblVolverJugar = new JLabel("Volver a jugar");
        this.panelSur.add(this.lblVolverJugar);

        this.btnNewButton = new JButton("Reset");
        this.btnNewButton.addActionListener(Monitor.getInstance());
        this.btnNewButton.setActionCommand("reset");
        this.panelSur.add(this.btnNewButton);

        this.panelCentral = new JPanel();
        this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
        this.panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        this.lblEligeNumero = new JLabel("Elige un numero");
        this.panelCentral.add(this.lblEligeNumero);

        this.textFieldElijeNumero = new JTextField();
        this.panelCentral.add(this.textFieldElijeNumero);
        this.textFieldElijeNumero.setColumns(10);

        this.btnProbar = new JButton("Probar");
        this.btnProbar.addActionListener(Monitor.getInstance());
        this.btnProbar.setActionCommand("probar");
        this.panelCentral.add(this.btnProbar);
        this.setVisible(true);
    }


    /**
     * @return el numero escrito por el usuario
     */
    public double getNumero() {
        return Double.parseDouble(this.textFieldElijeNumero.getText());
    }
}
