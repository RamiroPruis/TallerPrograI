package vistas;

import exceptions.NoExisteException;
import usuarios.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Set;

public class Ventana extends JFrame implements IVista {

    private JPanel contentPane;
    private JList<Paciente> listPacientes;
    private JList<Medico> listMedicos;
    private JLabel lblPacientes;
    private JLabel lblMedicos;
    private JButton btnConsulta;
    private JButton btnInternacion;
    private JTextField textField;
    private JLabel lblCantDias;
    private JButton btnDarAlta;
    private DefaultListModel<Paciente> modeloPaciente = new DefaultListModel<Paciente>();
    private DefaultListModel<Medico> modeloMedico = new DefaultListModel<Medico>();



    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 735, 474);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        this.listPacientes = new JList<Paciente>();
        this.listPacientes.setModel(this.modeloPaciente);
        this.listPacientes.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        this.listPacientes.setBounds(232, 47, 193, 337);
        this.contentPane.add(this.listPacientes);

        this.listMedicos = new JList<Medico>();
        this.listMedicos.setModel(this.modeloMedico);
        this.listMedicos.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
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
        this.setVisible(true);
    }



    @Override
    public void addActionListener(ActionListener controller) {

        this.btnDarAlta.addActionListener(controller);
        this.btnInternacion.addActionListener(controller);
        this.btnConsulta.addActionListener(controller);

    }

    @Override
    public Paciente getPacienteSelcted() {
        return this.listPacientes.getSelectedValue();
    }

    @Override
    public Medico getMedicoSelected() {
        return this.listMedicos.getSelectedValue();
    }

    @Override
    public void actualizaListaPacientes(Set<Paciente> pacientes) {
        Iterator<Paciente> it = pacientes.iterator();
        Paciente asociado;

        while (it.hasNext()) {
            asociado = it.next();
            if (!this.modeloPaciente.contains(asociado)) {
                this.modeloPaciente.addElement(asociado);
                this.setTextField();
            } else {
                this.modeloPaciente.remove(this.modeloPaciente.indexOf(asociado));
//                if (this.modeloPaciente.isEmpty())
////                    this.btnComenzar.setEnabled(false);
            }
            listPacientes.clearSelection();
        }
    }

    private void setTextField(){
        this.textField.setText("");
    }



    @Override
    public void actualizaListaMedicos(Set<Medico> medicos) {
        Iterator<Medico> it = medicos.iterator();
        Medico medico;

        while (it.hasNext()) {
            medico = it.next();
            if (!this.modeloMedico.contains(medico)) {
                this.modeloMedico.addElement(medico);
                this.setTextField();
            } else {
                this.modeloMedico.remove(this.modeloMedico.indexOf(medico));
//                if (this.modeloPaciente.isEmpty())
////                    this.btnComenzar.setEnabled(false);
            }
            listMedicos.clearSelection();
        }
    }
}