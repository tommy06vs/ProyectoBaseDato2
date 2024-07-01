package edu.nur.edd.dao;

import java.sql.*;

public class ConexionPostgreSQL {
    private static String URL_CONEXION =
            "jdbc:postgresql://localhost:5432/proye";
    private static String USER = "postgres";
    private static String PASSWORD = "root";
    private Connection conexion;

    private static ConexionPostgreSQL instancia;

    public static ConexionPostgreSQL getOrCreate() throws SQLException {
        if (instancia == null)
            instancia = new ConexionPostgreSQL();
        System.out.println("Conexion PostgreSQL - exitosa");

        return instancia;
    }

    private ConexionPostgreSQL() throws SQLException {
        conexion =
                DriverManager.getConnection(
                        URL_CONEXION, USER, PASSWORD);
    }

    public Connection getConnection(){
        return conexion;
    }

    public ResultSet ejecutarConsulta(String sql) throws SQLException {
        PreparedStatement ps =
                conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet ejecutarInsert(String sql) throws SQLException {
        PreparedStatement ps =
                conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps.getGeneratedKeys();
    }

    public void ejecutarUpdate(String sql) throws SQLException {
        PreparedStatement ps =
                conexion.prepareStatement(sql);
        ps.executeUpdate();
    }

    public void ejecutarDelete(String sql) throws SQLException{
        PreparedStatement ps =
                conexion.prepareStatement(sql);
        ps.executeUpdate();
    }
}
