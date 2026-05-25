package co.edu.poli.Examen2.model;

public class examensangre extends Examenesmedicos {

    private String rh;
    private String gruposanguineo;

    // Constructor vacío
    public examensangre() {}

    // Constructor con parámetros
    public examensangre(String nombrepaciente, String fechadeexamen,
                        String ididentificacion, double costoprocedimiento,
                        String tipoMoneda, String rh, String gruposanguineo) {
        super(nombrepaciente, fechadeexamen, ididentificacion, costoprocedimiento, tipoMoneda);
        this.rh = rh;
        this.gruposanguineo = gruposanguineo;
    }

    // Getters y Setters
    public String getRh() { return rh; }
    public void setRh(String rh) { this.rh = rh; }

    public String getGruposanguineo() { return gruposanguineo; }
    public void setGruposanguineo(String gruposanguineo) { this.gruposanguineo = gruposanguineo; }

    // Método propio
    public boolean esCompatible(String diferenteGrupo) {
        return this.gruposanguineo.equalsIgnoreCase(diferenteGrupo);
    }

    // Implementación del método abstracto
    @Override
    public String describir() {
        return "Examen de Sangre - Paciente: " + getNombrepaciente() +
               " | RH: " + rh + " | Grupo: " + gruposanguineo;
    }

    @Override
    public String toString() {
        return super.toString() + " [rh=" + rh + ", gruposanguineo=" + gruposanguineo + "]";
    }
}
