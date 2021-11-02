package vistas;

import usuarios.Medico;
import usuarios.Paciente;

import java.awt.event.ActionListener;
import java.util.Set;

public interface IVista {

    void addActionListener(ActionListener controlador);
    Paciente getPacienteSelcted();
    Medico getMedicoSelected();

    void actualizaListaPacientes(Set<Paciente> pacientes);
    void actualizaListaMedicos(Set<Medico> medicos);
    int getCantidadDias();
}
