package testing.escenarios;

import modelo.Clinica;

public class ClinicaVaciaEscenario {
    private Clinica clinica = Clinica.getInstance();

    public Clinica getClinica() {
        return clinica;
    }
}
