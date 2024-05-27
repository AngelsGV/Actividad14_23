package FINAL;

// Utilizando la BD Empleados, crea un programa que permita modificar la ciudad
// e incrementar las ventas de distintas oficinas.
// Utiliza una clase DAO para la oficina.
// Muestra los datos antes y después de la
// modificación

public class Main {
    public static void main(String[] args) {

    //Oficina 11. Sevilla. 100 	10000.0
        int nOficina = 11;

        // Datos antes de la modificación
        Oficina oficinaAntes = OficinaDAO.selectOficina(nOficina);
        System.out.println("Antes de la modificación: " + oficinaAntes);

        if (oficinaAntes != null) { // Si la oficina no está vacía

            // Modificar la ciudad y aumentar las ventas
            oficinaAntes.setCiudad("Lleida");
            oficinaAntes.setVentas(oficinaAntes.getVentas() + 1000);

            // Actualizar la oficina en BD
            OficinaDAO.update(oficinaAntes);

            // datos después de la modificación
            Oficina oficinaDespues = OficinaDAO.selectOficina(nOficina);
            System.out.println("Después de la modificación: " + oficinaDespues);
        } else {
            System.out.println("La oficina con el número " + nOficina + " no existe."); // Si está vacía
        }
    }
}