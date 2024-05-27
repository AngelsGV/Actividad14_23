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

    public Oficina selectOficina(int nOficina) {
        Oficina oficina = null;
        Connection connection = conectar();
        String sql = "SELECT * FROM Oficinas WHERE oficina = ?";
        try{
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setInt(1, nOficina);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                String ciudad = rs.getString("ciudad");
                int superficie = rs.getInt("superficie");
                int ventas = rs.getInt("ventas");
                oficina = new Oficina(nOficina, ciudad, superficie, ventas);
            }
            rs.close();
            sentencia.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oficina;
    }

    public boolean updateOficina(Oficina oficina) {
        boolean rowUpdated = false;
        Connection connection = conectar();
        String sql = "UPDATE Oficinas SET ciudad = ?, ventas = ? WHERE no_oficina = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, oficina.getCiudad());
            statement.setDouble(2, oficina.getVentas());
            statement.setInt(3, oficina.getOficina());
            rowUpdated = statement.executeUpdate() > 0;

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}