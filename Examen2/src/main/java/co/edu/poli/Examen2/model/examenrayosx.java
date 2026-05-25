package co.edu.poli.Examen2.model;

public class examenrayosx extends Examenesmedicos {

    private String zonadelcuerpo;
    private double nivelradiacion;

    // Constructor vacío
    public examenrayosx() {}

    // Constructor con parámetros
    public examenrayosx(String nombrepaciente, String fechadeexamen,
                        String ididentificacion, double costoprocedimiento,
                        String tipoMoneda, String zonadelcuerpo, double nivelradiacion) {
        super(nombrepaciente, fechadeexamen, ididentificacion, costoprocedimiento, tipoMoneda);
        this.zonadelcuerpo = zonadelcuerpo;
        this.nivelradiacion = nivelradiacion;
    }

    // Getters y Setters
    public String getZonadelcuerpo() { return zonadelcuerpo; }
    public void setZonadelcuerpo(String zonadelcuerpo) { this.zonadelcuerpo = zonadelcuerpo; }

    public double getNivelradiacion() { return nivelradiacion; }
    public void setNivelradiacion(double nivelradiacion) { this.nivelradiacion = nivelradiacion; }

    // Método propio
    public String clasificarRiesgo(double nivelRadiacion) {
        if (nivelRadiacion < 1.0) return "Riesgo bajo: " + nivelRadiacion + " mSv";
        else if (nivelRadiacion <= 10.0) return "Riesgo moderado: " + nivelRadiacion + " mSv";
        else return "Riesgo alto: " + nivelRadiacion + " mSv";
    }

    // Implementación del método abstracto
    @Override
    public String describir() {
        return "Examen de Rayos X - Paciente: " + getNombrepaciente() +
               " | Zona: " + zonadelcuerpo + " | Radiación: " + nivelradiacion + " mSv";
    }

    @Override
    public String toString() {
        return super.toString() + " [zonadelcuerpo=" + zonadelcuerpo +
               ", nivelradiacion=" + nivelradiacion + "]";
    }
}
