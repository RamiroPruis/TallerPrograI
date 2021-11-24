package testing.escenarios;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Habitacion;
import infraestructura.HabitacionCompartida;
import infraestructura.HabitacionPrivada;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;
import personas.Paciente;

public class ClinicaCargadaEscenario {
    private Clinica clinica = Clinica.getInstance();
    Paciente paciente1=null,paciente2=null,paciente3=null,paciente4=null;
    IMedico medico1=null,medico2=null,medico3=null;
    Habitacion h1=null,h2=null;


    public ClinicaCargadaEscenario(){
        try {
            paciente1 = PacienteFactory.getPaciente("123420","Mariano","Garcia","Mar del Plata","2234534434","Lopez 1234","Mayor");
            paciente2 = PacienteFactory.getPaciente("123453","Joaquin","Fioriti","Balcarce","2234534434","Lopez 1234","Nino");
            paciente3 = PacienteFactory.getPaciente("123456","Ramiro","Pruis","Mar del Plata","2234534434","Lopez 1234","Joven");
            paciente4 = PacienteFactory.getPaciente("123457","Camila","Ezama","Mar del Plata","2234534434","Lopez 1234","Mayor");

            clinica.ingresoPaciente(paciente1);
            clinica.ingresoPaciente(paciente2);
            clinica.ingresoPaciente(paciente3);
            clinica.ingresoPaciente(paciente4);

            clinica.atenderPaciente(paciente1);
            clinica.atenderPaciente(paciente2);
            clinica.atenderPaciente(paciente3);
            clinica.atenderPaciente(paciente4);

            h1 = new HabitacionPrivada(1,1000);
            h2 = new HabitacionCompartida(2,500);
            clinica.asignarHabitacion(h1);

            medico1 =MedicoFactory.getMedico("1234","Adolf","Spinelli","Mar del Plata","231412413","Lopez 1234","2394","Cirujia","Permanente","Magister");
            medico2 =MedicoFactory.getMedico("1234","Leonel","Guccione","Mar del Plata","231412413","Lopez 1234","2384","Cirujia","Permanente","Doctor");
            medico3 =MedicoFactory.getMedico("1234","Leonel","Guccione","Mar del Plata","231412413","Lopez 1234","2374","Cirujia","Residente","Doctor");
            clinica.agregarMedico(medico1);
            clinica.agregarMedico(medico2);
            clinica.agregarMedico(medico3);
        } catch (NoExisteRangoEtarioException e) {
        } catch (NoExisteEspecialidadException e) {
            e.printStackTrace();
        } catch (NoExisteContratacionException e) {
            e.printStackTrace();
        } catch (NoExistePosgradoException e) {
            e.printStackTrace();
        }
    }

    public Clinica getClinica() {
        return clinica;
    }

    public Paciente getPaciente(){
        return this.paciente1;
    }

    public IMedico getMedico() {
        return medico1;
    }
}
