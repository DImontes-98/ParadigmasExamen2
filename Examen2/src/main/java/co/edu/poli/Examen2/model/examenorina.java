package co.edu.poli.Examen2.model;

public class examenorina extends Examenesmedicos {

    private boolean glucosa;
    private double ph;

    // Constructor vacío
    public examenorina() {}

    // Constructor con parámetros
    public examenorina(String nombrepaciente, String fechadeexamen,
                       String ididentificacion, double costoprocedimiento,
                       String tipoMoneda, boolean glucosa, double ph) {
        super(nombrepaciente, fechadeexamen, ididentificacion, costoprocedimiento, tipoMoneda);
        this.glucosa = glucosa;
        this.ph = ph;
    }

    // Getters y Setters
    public boolean isGlucosa() { return glucosa; }
    public void setGlucosa(boolean glucosa) { this.glucosa = glucosa; }

    public double getPh() { return ph; }
    public void setPh(double ph) { this.ph = ph; }

    // Método propio
    public String analizarPH(double ph) {
        if (ph < 6.0) return "pH ácido: " + ph;
        else if (ph <= 7.5) return "pH normal: " + ph;
        else return "pH básico: " + ph;
    }

    // Implementación del método abstracto
    @Override
    public String describir() {
        return "Examen de Orina - Paciente: " + getNombrepaciente() +
               " | Glucosa: " + glucosa + " | pH: " + ph;
    }

    @Override
    public String toString() {
        return super.toString() + " [glucosa=" + glucosa + ", ph=" + ph + "]";
    }
}
