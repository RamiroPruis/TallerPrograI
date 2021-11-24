package testing.escenarios;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoExisteRangoEtarioException;
import modelo.Clinica;
import modelo.MedicoFactory;
import modelo.PacienteFactory;

public class ClinicaCargadaEscenario {
    private Clinica clinica = Clinica.getInstance();

    public ClinicaCargadaEscenario(){
        try {
            clinica.ingresoPaciente(PacienteFactory.getPaciente("123420","Mariano","Garcia","Mar del Plata","2234534434","Lopez 1234","Mayor"));
            clinica.ingresoPaciente(PacienteFactory.getPaciente("123453","Joaquin","Fioriti","Balcarce","2234534434","Lopez 1234","Nino"));
            clinica.ingresoPaciente(PacienteFactory.getPaciente("123456","Ramiro","Pruis","Mar del Plata","2234534434","Lopez 1234","Joven"));
            clinica.ingresoPaciente(PacienteFactory.getPaciente("123457","Camila","Ezama","Mar del Plata","2234534434","Lopez 1234","Mayor"));

            clinica.agregarMedico(MedicoFactory.getMedico("1234","Adolf","Spinelli","Mar del Plata","231412413","Lopez 1234","2394","Cirujia","Permanente","Magister"));
            clinica.agregarMedico(MedicoFactory.getMedico("1234","Leonel","Guccione","Mar del Plata","231412413","Lopez 1234","2384","Cirujia","Permanente","Doctor"));
            clinica.agregarMedico(MedicoFactory.getMedico("1234","Leonel","Guccione","Mar del Plata","231412413","Lopez 1234","2374","Cirujia","Residente","Doctor"));
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
}
