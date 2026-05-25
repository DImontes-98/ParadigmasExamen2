package co.edu.poli.Examen2.servicios;

import co.edu.poli.Examen2.model.Examenesmedicos;

public interface OperacionARCHIVO {

    String serializar(Examenesmedicos[] examenesmedicos, String path, String name);

    Examenesmedicos[] deserealizar(String path, String name);
}
