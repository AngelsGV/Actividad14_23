package FINAL;


import java.sql.*;

public class OficinaDAO {

    private static Connection conectar() {
        Connection con = null;
        String url = "jdbc:mysql://localhost/Empresa";
        try {
            con = DriverManager.getConnection(url, "Pepe", "12345");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }

    public Oficina selectOficina(int noOficina) {
        Oficina oficina = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_OFICINA_BY_ID);) {
            preparedStatement.setInt(1, noOficina);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String ciudad = rs.getString("ciudad");
                double superficie = rs.getDouble("superficie");
                double ventas = rs.getDouble("ventas");
                oficina = new Oficina(noOficina, ciudad, superficie, ventas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oficina;
    }

    public boolean updateOficina(Oficina oficina) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_OFICINA);) {
            statement.setString(1, oficina.getCiudad());
            statement.setDouble(2, oficina.getVentas());
            statement.setInt(3, oficina.getNoOficina());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}