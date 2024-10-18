/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.time.LocalDate;
import java.util.List;
import model.Servicio;
import model.Sistema;
/**
 *
 * @author mauri
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sistema sistema = new Sistema();

        // **Pruebas de Creación de Objetos**
        // 1-1) Intentar crear el objeto Gastronomía
        System.out.println("1-1");
        
        try {
            sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        } catch (Exception e) {
            System.out.println("Error al crear servicio: " + e.getMessage());
        }
        // 1-2) Crear el objeto Gastronomía 
        System.out.println("1-2");
        
        try{
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        } catch (Exception e){
            System.out.println("Error al crear servicio: " + e.getMessage());
        }
        // 1-3) Intentar crear el objeto Hospedaje 
        System.out.println("1-3");
 
        
        try {
            sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
        } catch (Exception e) {
            System.out.println("Error al crear servicio: " + e.getMessage());
        }

        // 1-4) Crear el objeto Hospedaje
        System.out.println("1-4");
        
        try {
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
        } catch (Exception e){
            System.out.println("Error al crear servicio: " + e.getMessage());
        }
        // **Pruebas de Cálculo de Precios Finales**
        // 2-1) Calcular e imprimir precio final del servicio Gastronomía
        System.out.println("2-1");
        Servicio gastronomia = sistema.traerServicio("489235");
        
        System.out.println("Precio final de la gastronomia: " + gastronomia.calcularPrecioFinal(LocalDate.of(2020, 10, 28)));
        

        // 2-2) Calcular e imprimir precio final del servicio Hospedaje
        System.out.println("2-2");
        Servicio hospedaje = sistema.traerServicio("287282");
        
        System.out.println("Precio final del hospedaje: " + hospedaje.calcularPrecioFinal(LocalDate.of(2020, 10, 27)));
        

        
        // 3) Agregar los siguientes objetos e imprimir la lista de servicios
        System.out.println("3");
        sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
        sistema.agregarHospedaje("489259", 10.0, true, "Habitacion triple", 2200.0);
        sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
        sistema.agregarHospedaje("758972", 15.0, false, "Habitacion simple", 1000.0);

        List<Servicio> servicios = sistema.traerServicio(true);
        for (Servicio s : servicios) {
            System.out.println("Servicio en promocion: " + s);
        }

        // **Consultas de Servicios**
        // 4-1) Traer todos los objetos Servicios en enPromocion=true
        System.out.println("4-1");
        List<Servicio> serviciosPromocion = sistema.traerServicio(true);
        for (Servicio s : serviciosPromocion) {
            System.out.println("Servicio en promocion: " + s);
        }

        // 4-2) Traer todos los objetos Servicios del día 2020-10-28 y enPromocion=true
        System.out.println("4-2");
        LocalDate fecha = LocalDate.of(2020, 10, 28);
        List<Servicio> serviciosFechaPromocion = sistema.traerServicio(true, fecha);
        for (Servicio s : serviciosFechaPromocion) {
            System.out.println("Servicio en promocion en la fecha: " + s);
        }
    }
}
 
