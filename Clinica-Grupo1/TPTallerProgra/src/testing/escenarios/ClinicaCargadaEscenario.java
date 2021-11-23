package testing.escenarios;

import excepciones.NoExisteRangoEtarioException;
import modelo.Clinica;
import modelo.PacienteFactory;

public class ClinicaCargadaEscenario {
    private Clinica clinica = Clinica.getInstance();

    public ClinicaCargadaEscenario(){
        try {
            clinica.ingresoPaciente(PacienteFactory.getPaciente("123456","Mariano","Garcia","Mar del Plata","2234534434","Lopez 1234","Mayor"));
            clinica.ingresoPaciente(PacienteFactory.getPaciente("123456","Joaquin","Fioriti","Mar del Plata","2234534434","Lopez 1234","Nino"));
            clinica.ingresoPaciente(PacienteFactory.getPaciente("123456","Ramiro","Pruis","Mar del Plata","2234534434","Lopez 1234","Joven"));
            clinica.ingresoPaciente(PacienteFactory.getPaciente("123456","Camila","Ezama","Mar del Plata","2234534434","Lopez 1234","Mayor"));
        } catch (NoExisteRangoEtarioException e) {
        }
    }

    public Clinica getClinica() {
        return clinica;
    }
}
