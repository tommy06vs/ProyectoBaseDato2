package edu.nur.edd.lista;

import edu.nur.edd.dao.ConexionPostgreSQL;
import edu.nur.edd.dao.Estudiante;
import edu.nur.edd.dao.Persona;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Date;

import java.sql.*;

public class Consulta {
    private ConexionPostgreSQL conexion;
    private ListaDoble<Persona> listaPersonas = new ListaDoble<>();
    private ListaDoble<Estudiante> listaEstudiantes = new ListaDoble<>();

    public Consulta() {
        try {
            conexion = ConexionPostgreSQL.getOrCreate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registrarPersonaYEstudiante(Persona persona, Estudiante estudiante) throws SQLException {
        String procedimientoSQL = "CALL usp_ins_estudiante(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {/*Connection conn = conexion.getConnection();
             CallableStatement cs = conn.prepareCall(procedimientoSQL)*/

            ConexionPostgreSQL con = ConexionPostgreSQL.getOrCreate();
            PreparedStatement ps = con.getConnection().prepareStatement(procedimientoSQL);
            // Setear los parámetros del procedimiento
            ps.setString(1, persona.getCodigoId());
            ps.setString(2, persona.getSnombre());
            ps.setString(3, persona.getAppaterno());
            ps.setString(4, persona.getApmaterno());
            ps.setDate(5, Date.valueOf(persona.getDtnacimiento())); // Convertir String a java.sql.Date
            ps.setString(6, persona.getDireccion());
            ps.setString(7, persona.getTelefono());
            ps.setString(8, persona.getEmail());
            ps.setString(9, estudiante.getSemIngreso());
            ps.setString(10, estudiante.getCarreraId());
            ps.setObject(11, estudiante.getIhoraservicio()); // Usar setObject para manejar null

            // Ejecutar el procedimiento almacenado
            ps.executeUpdate();
            //cs.execute();
            System.out.println("Registro de persona y estudiante completado exitosamente para " + persona.getCodigoId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al registrar persona y estudiante para " + persona.getCodigoId());
        }
    }



    public void insertarEstudiante(Persona persona, Estudiante estudiante) {
        if (persona.getCodigoId().equals(estudiante.getCodigoId())) {
            listaPersonas.agregar(persona);
            listaEstudiantes.agregar(estudiante);
            String sql = "{CALL usp_ins_estudiante(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            try (Connection conn = ConexionPostgreSQL.getOrCreate().getConnection();
                 CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, persona.getCodigoId());
                stmt.setString(2, persona.getSnombre());
                stmt.setString(3, persona.getAppaterno());
                stmt.setString(4, persona.getApmaterno());
                stmt.setDate(5, Date.valueOf(persona.getDtnacimiento())); // Asegúrate de convertir la fecha adecuadamente
                stmt.setString(6, persona.getDireccion());
                stmt.setString(7, persona.getTelefono());
                stmt.setString(8, persona.getEmail());
                stmt.setString(9, estudiante.getSemIngreso());
                stmt.setString(10, estudiante.getCarreraId());

                if (estudiante.getIhoraservicio() != 0) {
                    stmt.setInt(11, estudiante.getIhoraservicio());
                } else {
                    stmt.setNull(11, java.sql.Types.INTEGER);
                }

                stmt.executeUpdate();  // Ejecutar la actualización, ya que INSERT es una operación de modificación

                System.out.println("Inserción de persona y estudiante exitosa.");
            } catch (SQLException e) {
                System.out.println("Error al ejecutar procedimiento almacenado: " + e.getMessage());
            }
        } else {
            System.out.println("El código ID de la persona y el estudiante no coinciden.");
        }
    }



    /*public void insertarPersona(String codigo_id, String snombre, String appaterno, String apmaterno, Date dtnacimiento, String direccion, String telefono, String email, Timestamp fecha_ingreso) {
        String sql = "INSERT INTO personas(codigo_id, snombre, appaterno, apmaterno, dtnacimiento, direccion, telefono, email, fecha_ingreso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigo_id);
            pstmt.setString(2, snombre);
            pstmt.setString(3, appaterno);
            pstmt.setString(4, apmaterno);
            pstmt.setDate(5, dtnacimiento);
            pstmt.setString(6, direccion);
            pstmt.setString(7, telefono);
            pstmt.setString(8, email);
            pstmt.setTimestamp(9, fecha_ingreso);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

    public void seleccionarPersonas() {
        String sql = "SELECT * FROM personas";

        try (Connection conn = ConexionPostgreSQL.getOrCreate().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //Connection conn = ConexionPostgreSQL.getOrCreate().getConnection();
            //CallableStatement stmt = conn.prepareCall(sql)

            while (rs.next()) {
                System.out.println(rs.getString("codigo_id") + "\t" +
                        rs.getString("snombre") + "\t" +
                        rs.getString("appaterno") + "\t" +
                        rs.getString("apmaterno") + "\t" +
                        rs.getDate("dtnacimiento") + "\t" +
                        rs.getString("direccion") + "\t" +
                        rs.getString("telefono") + "\t" +
                        rs.getString("email") + "\t" +
                        rs.getTimestamp("fecha_ingreso"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public void eliminarPersona(String codigo_id) {
        String sql = "DELETE FROM personas WHERE codigo_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigo_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
}
