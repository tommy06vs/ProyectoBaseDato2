package edu.nur.edd.lista;

import edu.nur.edd.dao.Estudiante;
import edu.nur.edd.dao.Persona;

import java.sql.SQLException;
import java.util.Iterator;

public class RegistroManager {
    private ListaDoble<Persona> listaPersonas;
    private ListaDoble<Estudiante> listaEstudiantes;
    private Consulta registroDAO;

    public RegistroManager() {
        listaPersonas = new ListaDoble<>();
        listaEstudiantes = new ListaDoble<>();
        registroDAO = new Consulta();
    }

    public void agregarRegistro(Persona persona, Estudiante estudiante) {
        listaPersonas.agregar(persona);
        listaEstudiantes.agregar(estudiante);
    }

    public void procesarRegistros() {
        Iterator<Persona> personaIterator = listaPersonas.iterator();
        Iterator<Estudiante> estudianteIterator = listaEstudiantes.iterator();

        while (personaIterator.hasNext() && estudianteIterator.hasNext()) {
            Persona persona = personaIterator.next();
            Estudiante estudiante = estudianteIterator.next();

            try {
                registroDAO.registrarPersonaYEstudiante(persona, estudiante);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error al registrar la persona con ID: " + persona.getCodigoId());
            }
        }
    }
}
