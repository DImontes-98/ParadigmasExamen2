package co.edu.poli.Examen2.model;

import java.io.Serializable;

public abstract class Examenesmedicos implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombrepaciente;
    private String fechadeexamen;
    private String ididentificacion;
    private double costoprocedimiento;
    private String tipoMoneda;

    // Constructor vacío
    public Examenesmedicos() {}

    // Constructor con parámetros
    public Examenesmedicos(String nombrepaciente, String fechadeexamen,
                           String ididentificacion, double costoprocedimiento,
                           String tipoMoneda) {
        this.nombrepaciente = nombrepaciente;
        this.fechadeexamen = fechadeexamen;
        this.ididentificacion = ididentificacion;
        this.costoprocedimiento = costoprocedimiento;
        this.tipoMoneda = tipoMoneda;
    }

    // Getters y Setters
    public String getNombrepaciente() { return nombrepaciente; }
    public void setNombrepaciente(String nombrepaciente) { this.nombrepaciente = nombrepaciente; }

    public String getFechadeexamen() { return fechadeexamen; }
    public void setFechadeexamen(String fechadeexamen) { this.fechadeexamen = fechadeexamen; }

    public String getIdidentificacion() { return ididentificacion; }
    public void setIdidentificacion(String ididentificacion) { this.ididentificacion = ididentificacion; }

    public double getCostoprocedimiento() { return costoprocedimiento; }
    public void setCostoprocedimiento(double costoprocedimiento) { this.costoprocedimiento = costoprocedimiento; }

    public String getTipoMoneda() { return tipoMoneda; }
    public void setTipoMoneda(String tipoMoneda) { this.tipoMoneda = tipoMoneda; }

    // Métodos concretos
    public double calcularcosto(double procedimiento) {
        return this.costoprocedimiento + procedimiento;
    }

    public String actualizarEstado(String nuevoEstado) {
        return "Estado actualizado a: " + nuevoEstado;
    }

    // Método abstracto
    public abstract String describir();

    @Override
    public String toString() {
        return "Examenesmedicos [nombrepaciente=" + nombrepaciente +
               ", fechadeexamen=" + fechadeexamen +
               ", ididentificacion=" + ididentificacion +
               ", costoprocedimiento=" + costoprocedimiento +
               ", tipoMoneda=" + tipoMoneda + "]";
    }
}
