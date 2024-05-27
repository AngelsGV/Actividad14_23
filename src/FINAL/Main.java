package FINAL;

// Utilizando la BD Empleados, crea un programa que permita modificar la ciudad
// e incrementar las ventas de distintas oficinas.
// Utiliza una clase DAO para la oficina.
// Muestra los datos antes y después de la
// modificación

public class Main {
    public static void main(String[] args) {
        OficinaDAO oficinaDAO = new OficinaDAO();

        int noOficina = 1;

        // Mostrar datos antes de la modificación
        Oficina oficinaAntes = oficinaDAO.selectOficina(noOficina);
        System.out.println("Antes de la modificación: " + oficinaAntes);

        if (oficinaAntes != null) {
            // Modificar la ciudad y aumentar las ventas
            oficinaAntes.setCiudad("Nueva Ciudad");
            oficinaAntes.setVentas(oficinaAntes.getVentas() + 1000);

            if (oficinaDAO.updateOficina(oficinaAntes)) {
                // Mostrar datos después de la modificación
                Oficina oficinaDespues = oficinaDAO.selectOficina(noOficina);
                System.out.println("Después de la modificación: " + oficinaDespues);
            } else {
                System.out.println("No se pudo actualizar la oficina.");
            }
        } else {
            System.out.println("La oficina con el número " + noOficina + " no existe.");
        }
    }
}
