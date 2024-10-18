/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mauri
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Servicio> lstServicio = new ArrayList<>();

    public Servicio traerServicio(String codServicio) {
        for (Servicio s : lstServicio) {
            if (s.codServicio.equals(codServicio)) {
                return s;
            }
        }
        return null;
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.enPromocion == enPromocion) {
                serviciosEnPromocion.add(s);
            }
        }
        return serviciosEnPromocion;
    }

    // Sobrecarga del método traerServicio que filtra servicios en promoción por fecha
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate fecha) {
        List<Servicio> serviciosFiltrados = new ArrayList<>();
        for (Servicio s : lstServicio) {
            // En este caso usamos la fecha para filtrar adicionalmente los servicios
            if (s.enPromocion == enPromocion && s.calcularPrecioFinal(fecha) > 0) {
                serviciosFiltrados.add(s);
            }
        }
        return serviciosFiltrados;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("El servicio con ese codigo ya existe.");
        }
        lstServicio.add(new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc));
        return true;
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("El servicio con ese codigo ya existe.");
        }
        lstServicio.add(new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche));
        return true;
    }

    @Override
    public String toString() {
        return "Sistema{" + "lstServicio=" + lstServicio + '}';
    }
    
    
}
