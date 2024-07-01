package edu.nur.edd.lista;

import edu.nur.edd.dao.Estudiante;
import edu.nur.edd.dao.Persona;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Main2 {
    public static void main(String[] args) {
        // Crear objetos de Persona y Estudiante
        Persona persona1 = new Persona("P001", "Jua", "Pere", "Gome", "1999-01-01",
                "Calle 123", "5551234", "juan@example.com");
        Estudiante estudiante1 = new Estudiante("2024-1", "0001",0);

        Persona persona2 = new Persona("P002", "Marí", "Lópe", "Garcí", "1999-03-15",
                "Avenida 456", "5555678", "maria@example.com");
        Estudiante estudiante2 = new Estudiante("P002", "2023-2", "0001", 60);

        // Llamar al método para registrar persona y estudiante
        try {
            Consulta consulta = new Consulta();
            consulta.registrarPersonaYEstudiante(persona1, estudiante1);
            //consulta.registrarPersonaYEstudiante(persona2, estudiante2);
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar el error según sea necesario
        }
    }
}
