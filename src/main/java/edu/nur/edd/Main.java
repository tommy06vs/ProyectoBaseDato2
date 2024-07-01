package edu.nur.edd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getRootLogger();
    private static Logger registroLogger = LogManager.getLogger("RegistroLogger");

    public static void main(String[] args) {
        System.out.println("Hello world!!!");
        System.out.println("Hello world!!!");
        System.out.println("Hello world!");
        System.out.println("Hello world");
        logger.error("Este es un mensaje de prueba de error para verificar el SMTP appender.");
        Main a = new Main();
        a.m(true);

        a.registrarUsuario("Juan Pérez");
    }

    private void m(boolean conError) {
        logger.debug("Entrando al metodo m1");

        try {
            int a = 5 + 4;
            if(conError)
                throw new IllegalArgumentException("Error en la conversion de archivos");
            logger.debug("Hizo  la operacion 5+4");
        } catch(Exception q) {
            logger.error("Paso algo raro", q);
        }

        logger.info("Termina metodo m");
    }

    private void registrarUsuario(String nombre) {
        // Lógica para registrar al usuario
        registroLogger.info("Nuevo usuario registrado: " + nombre);
        registroLogger.debug("Nuevo usuario registrado1: " + nombre);//objet
        registroLogger.debug("Nuevo usuario registrado2: " + nombre);//string
        registroLogger.debug("Nuevo usuario registrado3: " + nombre);//mensaj
    }
}