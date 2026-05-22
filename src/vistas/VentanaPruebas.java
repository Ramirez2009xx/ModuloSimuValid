/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class VentanaPruebas extends JFrame implements ActionListener {

    JButton btnRegresar, btnEjemplo, btnAgregarCaso, btnGrafica;
    JComboBox<String> comboPruebas;
    JTable tablaValores;
    DefaultTableModel modelo;
    String tipoVentana;

    JPanel panelGrafica;
    String pruebaSeleccionada = "";

    public VentanaPruebas(String tipo) {

        tipoVentana = tipo;

        setTitle("Pruebas " + tipo);
        setSize(930, 670);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        // TITULO
        JLabel titulo = new JLabel(tipo);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titulo.setBounds(350, 20, 350, 40);
        add(titulo);

        // BOTONES
        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(30, 80, 190, 40);
        add(btnRegresar);

        comboPruebas = new JComboBox<>();

        if (tipo.equals("Paramétricas")) {
            comboPruebas.addItem("Prueba t de Student");
            comboPruebas.addItem("Análisis de Varianza (ANOVA)");
            comboPruebas.addItem("Prueba Z");
        } else {
            comboPruebas.addItem("Prueba U de Mann-Whitney");
            comboPruebas.addItem("Prueba de Wilcoxon");
            comboPruebas.addItem("Prueba Chi-Cuadrada");
        }

        comboPruebas.setBounds(30, 140, 190, 40);
        add(comboPruebas);

        btnEjemplo = new JButton("Ejemplo");
        btnEjemplo.setBounds(30, 200, 190, 40);
        add(btnEjemplo);

        btnAgregarCaso = new JButton("Añadir caso");
        btnAgregarCaso.setBounds(30, 260, 190, 40);
        add(btnAgregarCaso);

        btnGrafica = new JButton("Gráfica");
        btnGrafica.setBounds(30, 320, 190, 40);
        add(btnGrafica);

        // PANEL TABLA (más compacto)
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(null);
        panelTabla.setBounds(250, 80, 640, 330);
        panelTabla.setBorder(BorderFactory.createTitledBorder("Tabla de valores críticos"));
        add(panelTabla);

        modelo = new DefaultTableModel();
        tablaValores = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tablaValores);
        scroll.setBounds(20, 30, 590, 270);
        panelTabla.add(scroll);

        // PANEL GRAFICA (más grande)
        panelGrafica = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarGrafica(g);
            }
        };

        panelGrafica.setBounds(250, 430, 640, 190);
        panelGrafica.setBorder(BorderFactory.createTitledBorder("Gráfica"));
        panelGrafica.setBackground(Color.WHITE);
        add(panelGrafica);

        cargarTabla();

       btnRegresar.addActionListener(this);
       comboPruebas.addActionListener(this);
       btnGrafica.addActionListener(this);
       btnEjemplo.addActionListener(this);
       btnAgregarCaso.addActionListener(this);

        setVisible(true);
    }

    private void cargarTabla() {

        String seleccion = comboPruebas.getSelectedItem().toString();

        modelo.setRowCount(0);
        modelo.setColumnCount(0);

        if (seleccion.equals("Prueba t de Student")) {
            modelo.addColumn("gl");
            modelo.addColumn("α=0.10");
            modelo.addColumn("α=0.05");
            modelo.addColumn("α=0.025");
            modelo.addColumn("α=0.01");
            modelo.addColumn("α=0.005");

            modelo.addRow(new Object[]{"1", "3.078", "6.314", "12.706", "31.821", "63.657"});
            modelo.addRow(new Object[]{"2", "1.886", "2.920", "4.303", "6.965", "9.925"});
            modelo.addRow(new Object[]{"3", "1.638", "2.353", "3.182", "4.541", "5.841"});
            modelo.addRow(new Object[]{"4", "1.533", "2.132", "2.776", "3.747", "4.604"});
            modelo.addRow(new Object[]{"5", "1.476", "2.015", "2.571", "3.365", "4.032"});
            modelo.addRow(new Object[]{"6", "1.440", "1.943", "2.447", "3.143", "3.707"});
            modelo.addRow(new Object[]{"7", "1.415", "1.895", "2.365", "2.998", "3.499"});
            modelo.addRow(new Object[]{"8", "1.397", "1.860", "2.306", "2.896", "3.355"});
            modelo.addRow(new Object[]{"9", "1.383", "1.833", "2.262", "2.821", "3.250"});
            modelo.addRow(new Object[]{"10", "1.372", "1.812", "2.228", "2.764", "3.169"});
        }

        else if (seleccion.equals("Análisis de Varianza (ANOVA)")) {
            modelo.addColumn("gl1");
            modelo.addColumn("gl2");
            modelo.addColumn("α=0.10");
            modelo.addColumn("α=0.05");
            modelo.addColumn("α=0.01");

            modelo.addRow(new Object[]{"1", "5", "4.06", "6.61", "16.26"});
            modelo.addRow(new Object[]{"1", "10", "3.29", "4.96", "10.04"});
            modelo.addRow(new Object[]{"2", "5", "3.78", "5.79", "13.27"});
            modelo.addRow(new Object[]{"2", "10", "2.92", "4.10", "7.56"});
            modelo.addRow(new Object[]{"3", "10", "2.73", "3.71", "6.55"});
            modelo.addRow(new Object[]{"4", "10", "2.61", "3.48", "5.99"});
            modelo.addRow(new Object[]{"5", "10", "2.52", "3.33", "5.64"});
            modelo.addRow(new Object[]{"6", "10", "2.46", "3.22", "5.39"});
        }

        else if (seleccion.equals("Prueba Z")) {
            modelo.addColumn("Confianza");
            modelo.addColumn("α");
            modelo.addColumn("Valor crítico");

            modelo.addRow(new Object[]{"80%", "0.20", "1.282"});
            modelo.addRow(new Object[]{"85%", "0.15", "1.440"});
            modelo.addRow(new Object[]{"90%", "0.10", "1.645"});
            modelo.addRow(new Object[]{"95%", "0.05", "1.960"});
            modelo.addRow(new Object[]{"97%", "0.03", "2.170"});
            modelo.addRow(new Object[]{"98%", "0.02", "2.326"});
            modelo.addRow(new Object[]{"99%", "0.01", "2.576"});
            modelo.addRow(new Object[]{"99.9%", "0.001", "3.291"});
        }

        else if (seleccion.equals("Prueba U de Mann-Whitney")) {
            modelo.addColumn("n1");
            modelo.addColumn("n2");
            modelo.addColumn("α=0.10");
            modelo.addColumn("α=0.05");

            modelo.addRow(new Object[]{"3", "3", "1", "0"});
            modelo.addRow(new Object[]{"4", "4", "3", "2"});
            modelo.addRow(new Object[]{"5", "5", "6", "4"});
            modelo.addRow(new Object[]{"6", "6", "9", "7"});
            modelo.addRow(new Object[]{"7", "7", "13", "10"});
            modelo.addRow(new Object[]{"8", "8", "17", "13"});
            modelo.addRow(new Object[]{"9", "9", "21", "17"});
            modelo.addRow(new Object[]{"10", "10", "27", "23"});
        }

        else if (seleccion.equals("Prueba de Wilcoxon")) {
            modelo.addColumn("n");
            modelo.addColumn("α=0.10");
            modelo.addColumn("α=0.05");
            modelo.addColumn("α=0.01");

            modelo.addRow(new Object[]{"5", "1", "0", "0"});
            modelo.addRow(new Object[]{"6", "3", "2", "0"});
            modelo.addRow(new Object[]{"7", "5", "3", "2"});
            modelo.addRow(new Object[]{"8", "8", "5", "3"});
            modelo.addRow(new Object[]{"9", "10", "8", "5"});
            modelo.addRow(new Object[]{"10", "13", "10", "8"});
            modelo.addRow(new Object[]{"11", "17", "13", "10"});
            modelo.addRow(new Object[]{"12", "21", "17", "14"});
        }

        else if (seleccion.equals("Prueba Chi-Cuadrada")) {
            modelo.addColumn("gl");
            modelo.addColumn("α=0.10");
            modelo.addColumn("α=0.05");
            modelo.addColumn("α=0.01");

            modelo.addRow(new Object[]{"1", "2.71", "3.84", "6.63"});
            modelo.addRow(new Object[]{"2", "4.61", "5.99", "9.21"});
            modelo.addRow(new Object[]{"3", "6.25", "7.81", "11.34"});
            modelo.addRow(new Object[]{"4", "7.78", "9.49", "13.28"});
            modelo.addRow(new Object[]{"5", "9.24", "11.07", "15.09"});
            modelo.addRow(new Object[]{"6", "10.64", "12.59", "16.81"});
            modelo.addRow(new Object[]{"7", "12.02", "14.07", "18.48"});
            modelo.addRow(new Object[]{"8", "13.36", "15.51", "20.09"});
            modelo.addRow(new Object[]{"9", "14.68", "16.92", "21.67"});
            modelo.addRow(new Object[]{"10", "15.99", "18.31", "23.21"});
        }
    }

    private void dibujarGrafica(Graphics g) {

    if (pruebaSeleccionada.equals("")) return;

    Graphics2D g2 = (Graphics2D) g;

    g2.setStroke(new BasicStroke(2));

    int ancho = panelGrafica.getWidth();
    int alto = panelGrafica.getHeight();

    // FONDO
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, ancho, alto);

    // EJES
    g.setColor(Color.BLACK);

    g.drawLine(50, alto - 40, ancho - 30, alto - 40); // eje X
    g.drawLine(50, 20, 50, alto - 40); // eje Y

    // MARCAS
    for (int i = 50; i < ancho - 30; i += 50) {
        g.drawLine(i, alto - 45, i, alto - 35);
    }

    // ================= T STUDENT Y Z =================
    if (pruebaSeleccionada.contains("Student")
            || pruebaSeleccionada.contains("Z")) {

        g.setColor(Color.BLUE);

        int prevX = 50;
        int prevY = alto - 40;

        for (double x = -4; x <= 4; x += 0.05) {

            double y = Math.exp(-(x * x) / 2);

            int px = (int) (50 + ((x + 4) * 65));

            int py = (int) ((alto - 40) - (y * 130));

            g.fillOval(px, py, 2, 2);

            g.drawLine(prevX, prevY, px, py);

            prevX = px;
            prevY = py;
        }

        // LINEA CRITICA
        g.setColor(Color.RED);

        g.drawLine(430, 20, 430, alto - 40);

        g.drawString("Valor crítico", 440, 30);
    }

    // ================= ANOVA =================
    else if (pruebaSeleccionada.contains("ANOVA")) {

        g.setColor(Color.RED);

        int[] barras = {70, 120, 90, 150, 110, 80};

        for (int i = 0; i < barras.length; i++) {

            int x = 90 + (i * 75);

            int y = alto - 40 - barras[i];

            g.fillRect(x, y, 45, barras[i]);

            g.setColor(Color.BLACK);

            g.drawRect(x, y, 45, barras[i]);

            g.drawString("G" + (i + 1), x + 10, alto - 20);

            g.setColor(Color.RED);
        }
    }

    // ================= CHI CUADRADA =================
    else if (pruebaSeleccionada.contains("Chi")) {

        g.setColor(Color.MAGENTA);

        int prevX = 50;
        int prevY = alto - 40;

        for (double x = 0.1; x <= 10; x += 0.05) {

            double y = (1 / Math.pow(2, 1.5))
                    * Math.pow(x, 0.5)
                    * Math.exp(-x / 2);

            int px = (int) (50 + (x * 50));

            int py = (int) ((alto - 40) - (y * 180));

            g.fillOval(px, py, 2, 2);

            g.drawLine(prevX, prevY, px, py);

            prevX = px;
            prevY = py;
        }

        g.setColor(Color.RED);

        g.drawLine(350, 20, 350, alto - 40);

        g.drawString("χ² crítico", 360, 30);
    }

    // ================= MANN WHITNEY Y WILCOXON =================
    else {

        g.setColor(new Color(0, 150, 0));

        int[] puntos = {40, 70, 55, 90, 65, 110, 85, 125, 100};

        int prevX = 0;
        int prevY = 0;

        for (int i = 0; i < puntos.length; i++) {

            int x = 80 + (i * 55);

            int y = alto - 40 - puntos[i];

            g.fillOval(x, y, 10, 10);

            if (i > 0) {

                g.drawLine(prevX, prevY, x, y);
            }

            prevX = x;
            prevY = y;
        }

        g.setColor(Color.BLACK);

        g.drawString("Rangos", 80, 25);
    }

    // TITULO
    g.setColor(Color.BLACK);

    g.setFont(new Font("Segoe UI", Font.BOLD, 14));

    g.drawString(pruebaSeleccionada, 240, 20);
}

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegresar) {
            new ProyectoSimuValid();
            dispose();
        }

        if (e.getSource() == comboPruebas) {
            cargarTabla();
        }

        if (e.getSource() == btnGrafica) {
            pruebaSeleccionada = comboPruebas.getSelectedItem().toString();
            panelGrafica.repaint();
        }
        if (e.getSource() == btnEjemplo) {
        String prueba = comboPruebas.getSelectedItem().toString();
        new VentanaEjemplo(prueba, tipoVentana);
        dispose();
        }
        if (e.getSource() == btnAgregarCaso) {
        new VentanaAgregarCaso(tipoVentana);
        dispose();
        }
    }
}