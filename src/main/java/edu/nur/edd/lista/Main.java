package edu.nur.edd.lista;

import edu.nur.edd.dao.Estudiante;
import edu.nur.edd.dao.Persona;

import java.sql.Date;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        Consulta consulta = new Consulta();

        // Crear una nueva persona
        Persona persona = new Persona("882446", "Lola", "Landa", "Lala", "2000-01-02",
                "Calle Falsa 123", "74899633", "lolall77@gmail.com", new Timestamp(System.currentTimeMillis()));

        // Crear un nuevo estudiante
        Estudiante estudiante = new Estudiante("882446", "2024-2", 0, "0001");

        // Insertar persona y estudiante en la base de datos
        consulta.insertarEstudiante(persona, estudiante);
        // Seleccionar todas las personas
        consulta.seleccionarPersonas();

        // Eliminar una persona
        //consulta.eliminarPersona("123456");
    }
}
