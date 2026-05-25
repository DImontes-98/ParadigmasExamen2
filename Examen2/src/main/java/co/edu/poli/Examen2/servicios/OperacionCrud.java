package co.edu.poli.Examen2.servicios;

import co.edu.poli.Examen2.model.Examenesmedicos;

public interface OperacionCrud {

    String crear(Examenesmedicos e);

    Examenesmedicos consultar(int id);

    void modificar(int id, int n, Examenesmedicos e);

    String eliminar(int id, int n);

    String listar();
}
