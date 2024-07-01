package edu.nur.edd.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private static Logger logger = LogManager.getRootLogger();

    private JPanel panel_principal = new JPanel();
    public Ventana(){
        setTitle("RUN");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponent();

        repaint();
        setVisible(true);
        logger.info("cargamos el metodos y damos el repaint y lo hacemos visible");
    }

    public void initComponent(){
        logger.debug("entrando al metodo initComponent()");
        panel_principal.setLayout(null);
        panel_principal.setBackground(Color.darkGray);

        this.add(panel_principal);
        logger.info("agregamos el panel principal");
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
