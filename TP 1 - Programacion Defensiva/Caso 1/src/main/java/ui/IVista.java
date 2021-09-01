package ui;

import negocio.Negocio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class IVista extends JFrame {

    private JPanel contentPane;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JTextField textField;
    private JButton btnAbrirLocal;
    private JTextField textFieldOcuparMesa;
    private JButton btnOcuparMesa;
    private JTextField textFieldCerrarMesa;
    private JButton btnCerrarMesa;

    /**
     * Create the frame.
     */
    public IVista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(this.contentPane);

        this.panel = new JPanel();
        this.contentPane.add(this.panel, BorderLayout.CENTER);
        this.panel.setLayout(new GridLayout(3, 1, 0, 0));

        this.panel_2 = new JPanel();
        this.panel.add(this.panel_2);

        this.textField = new JTextField();
        this.panel_2.add(this.textField);
        this.textField.setColumns(10);

        this.btnAbrirLocal = new JButton("Abrir Local");
        this.btnAbrirLocal.setActionCommand("AbrirLocal");
        this.btnAbrirLocal.addActionListener(Negocio.getInstance());
        this.panel_2.add(this.btnAbrirLocal);

        this.panel_3 = new JPanel();
        this.panel.add(this.panel_3);

        this.textFieldOcuparMesa = new JTextField();
        this.textFieldOcuparMesa.setColumns(10);
        this.panel_3.add(this.textFieldOcuparMesa);

        this.btnOcuparMesa = new JButton("Ocupar Mesa");
        this.btnOcuparMesa.addActionListener(Negocio.getInstance());
        this.btnOcuparMesa.setActionCommand("OcuparMesa");
        this.panel_3.add(this.btnOcuparMesa);

        this.panel_1 = new JPanel();
        this.panel.add(this.panel_1);

        this.textFieldCerrarMesa = new JTextField();
        this.textFieldCerrarMesa.setColumns(10);
        this.panel_1.add(this.textFieldCerrarMesa);

        this.btnCerrarMesa = new JButton("Cerrar Mesa");
        this.btnCerrarMesa.addActionListener(Negocio.getInstance());
        this.btnCerrarMesa.setActionCommand("CerrarMesa");
        this.panel_1.add(this.btnCerrarMesa);
        this.setVisible(true);
    }

//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    IVista frame = new IVista();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    public int abrirLocal() {
        return Integer.parseInt(this.textField.getText());
    }

    public int ocuparMesa() {
        return Integer.parseInt(this.textFieldOcuparMesa.getText());
    }

    public int cerrarMesa() {
        return Integer.parseInt(this.textFieldCerrarMesa.getText());
    }


}
