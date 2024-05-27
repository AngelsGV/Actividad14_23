package FINAL;

//Modificar ciudad e incrementar ventas.
// No hace falta ni eliminar ni historias, solo poder acceder a los datos y modificar.
import java.sql.*;

public class OficinaDAO {
    //Conexión normal. Igual que ejercicio anterior
    private static Connection conectar() {
        Connection con = null;
        String url = "jdbc:mysql://localhost/Empresa";
        try {
            con =DriverManager.getConnection(url, "Pepe", "12345");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }

    public static Oficina selectOficina(int nOficina) {//Resuela 14.11

        Oficina oficina = null;
        String sql = "SELECT * FROM Oficinas WHERE oficina = ?";
        try{
            Connection conexion = conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, nOficina);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                String ciudad = rs.getString("ciudad");
                int superficie = rs.getInt("superficie");
                int ventas = rs.getInt("ventas");
                oficina = new Oficina(nOficina, ciudad, superficie, ventas);
                conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return oficina;
    }

    public static void update(Oficina oficina) {
        if (oficina != null) {
            String sql = "UPDATE Oficinas SET ciudad = ?, ventas = ? WHERE oficina = ?";
            try {
                Connection conexion = conectar();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, oficina.getCiudad());
                sentencia.setDouble(2, oficina.getVentas());
                sentencia.setInt(3, oficina.getOficina());
                sentencia.executeUpdate();
                conexion.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
}