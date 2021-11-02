package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame implements IVista {

    private JPanel contentPane;
    private JList listPacientes;
    private JList listMedicos;
    private JLabel lblPacientes;
    private JLabel lblMedicos;
    private JButton btnConsulta;
    private JButton btnInternacion;
    private JTextField textField;
    private JLabel lblCantDias;
    private JButton btnDarAlta;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana frame = new Ventana();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 735, 474);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        this.listPacientes = new JList();
        this.listPacientes.setBounds(232, 47, 193, 337);
        this.contentPane.add(this.listPacientes);

        this.listMedicos = new JList();
        this.listMedicos.setBounds(10, 50, 193, 337);
        this.contentPane.add(this.listMedicos);

        this.lblPacientes = new JLabel("Lista de Pacientes");
        this.lblPacientes.setBounds(29, 11, 139, 27);
        this.contentPane.add(this.lblPacientes);

        this.lblMedicos = new JLabel("Lista de Medicos");
        this.lblMedicos.setBounds(242, 11, 139, 27);
        this.contentPane.add(this.lblMedicos);

        this.btnConsulta = new JButton("Generar Consulta");
        this.btnConsulta.setActionCommand("GenerarConsulta");
        this.btnConsulta.setBounds(483, 51, 145, 23);
        this.contentPane.add(this.btnConsulta);

        this.btnInternacion = new JButton("Generar Internacion");
        this.btnInternacion.setActionCommand("GenerarInternacion");
        this.btnInternacion.setBounds(483, 194, 139, 23);
        this.contentPane.add(this.btnInternacion);

        this.textField = new JTextField();
        this.textField.setColumns(10);
        this.textField.setBounds(507, 163, 96, 20);
        this.contentPane.add(this.textField);

        this.lblCantDias = new JLabel("Cantidad de dias");
        this.lblCantDias.setBounds(507, 138, 102, 14);
        this.contentPane.add(this.lblCantDias);

        this.btnDarAlta = new JButton("Dar de alta");
        this.btnDarAlta.setActionCommand("DardeAlta");
        this.btnDarAlta.setBounds(483, 294, 139, 23);
        this.contentPane.add(this.btnDarAlta);
    }

    @Override
    public void addActionListener(ActionListener controller) {

        this.btnDarAlta.addActionListener(controller);
        this.btnInternacion.addActionListener(controller);
        this.btnConsulta.addActionListener(controller);

    }
}