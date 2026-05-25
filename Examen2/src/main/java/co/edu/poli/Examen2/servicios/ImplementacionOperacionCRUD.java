package co.edu.poli.Examen2.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.poli.Examen2.model.Examenesmedicos;

public class ImplementacionOperacionCRUD implements OperacionCrud, OperacionARCHIVO {

    private Examenesmedicos[] examenesmedicos = new Examenesmedicos[10];
    private ArrayList<Examenesmedicos> almacen = new ArrayList<Examenesmedicos>();

    // ===================== CRUD =====================

    @Override
    public String crear(Examenesmedicos e) {
        for (int i = 0; i < examenesmedicos.length; i++) {
            if (examenesmedicos[i] == null) {
                examenesmedicos[i] = e;
                almacen.add(e);
                return "Examen creado en la posición: " + i;
            }
        }
        return "No hay espacio disponible en el arreglo.";
    }

    @Override
    public Examenesmedicos consultar(int id) {
        if (id >= 0 && id < examenesmedicos.length) {
            return examenesmedicos[id];
        }
        return null;
    }

    @Override
    public void modificar(int id, int n, Examenesmedicos e) {
        if (id >= 0 && id < examenesmedicos.length) {
            examenesmedicos[id] = e;
            if (n >= 0 && n < almacen.size()) {
                almacen.set(n, e);
            }
        }
    }

    @Override
    public String eliminar(int id, int n) {
        if (id >= 0 && id < examenesmedicos.length && examenesmedicos[id] != null) {
            examenesmedicos[id] = null;
            if (n >= 0 && n < almacen.size()) {
                almacen.remove(n);
            }
            return "Examen eliminado en posición: " + id;
        }
        return "No se encontró el examen en la posición: " + id;
    }

    @Override
    public String listar() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Lista de Exámenes ===\n");
        for (int i = 0; i < examenesmedicos.length; i++) {
            if (examenesmedicos[i] != null) {
                sb.append("[").append(i).append("] ").append(examenesmedicos[i].describir()).append("\n");
            }
        }
        return sb.toString();
    }

    // ===================== ARCHIVO =====================

    @Override
    public String serializar(Examenesmedicos[] examenesmedicos, String path, String name) {
        try {
            FileOutputStream fos = new FileOutputStream(path + "/" + name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(examenesmedicos);
            oos.close();
            fos.close();
            return "Serialización exitosa en: " + path + "/" + name;
        } catch (Exception e) {
            return "Error al serializar: " + e.getMessage();
        }
    }

    @Override
    public Examenesmedicos[] deserealizar(String path, String name) {
        try {
            FileInputStream fis = new FileInputStream(path + "/" + name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Examenesmedicos[] resultado = (Examenesmedicos[]) ois.readObject();
            ois.close();
            fis.close();
            return resultado;
        } catch (Exception e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            return null;
        }
    }

    // ===================== GETTERS / SETTERS =====================

    public Examenesmedicos[] getExamenesmedicos() { return examenesmedicos; }
    public void setExamenesmedicos(Examenesmedicos[] examenesmedicos) { this.examenesmedicos = examenesmedicos; }

    public ArrayList<Examenesmedicos> getAlmacen() { return almacen; }
    public void setAlmacen(ArrayList<Examenesmedicos> almacen) { this.almacen = almacen; }
}
