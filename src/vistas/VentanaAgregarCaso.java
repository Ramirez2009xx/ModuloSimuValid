/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaAgregarCaso extends JFrame implements ActionListener {

    JLabel lblTitulo, lblPrueba, lblContexto, lblVariables, lblH0, lblH1, lblDatos;

    JComboBox<String> comboPruebas;

    JTextField txtVariables;
    JTextField txtH0;
    JTextField txtH1;

    JTextArea areaContexto;
    JTextArea areaDatos;
    JTextArea areaVista;

    JScrollPane scrollContexto;
    JScrollPane scrollDatos;
    JScrollPane scrollVista;

    JButton btnInicio;
    JButton btnAgregar;
    JButton btnRegresar;

    String tipoVentana;

    public VentanaAgregarCaso(String tipo) {

        tipoVentana = tipo;

        setTitle("Añadir nuevo caso");
        setSize(1100, 700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        // ================= TITULO =================

        lblTitulo = new JLabel("Agregar nuevo caso");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitulo.setBounds(380, 15, 400, 40);
        add(lblTitulo);

        // ================= PANEL IZQUIERDO =================

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(null);
        panelIzquierdo.setBounds(20, 70, 330, 560);
        panelIzquierdo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        panelIzquierdo.setBackground(new Color(245, 245, 245));
        add(panelIzquierdo);

        // ================= TIPO DE PRUEBA =================

        lblPrueba = new JLabel("Tipo de prueba");
        lblPrueba.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblPrueba.setBounds(20, 15, 150, 30);
        panelIzquierdo.add(lblPrueba);

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

        comboPruebas.setBounds(20, 45, 270, 35);
        panelIzquierdo.add(comboPruebas);

        // ================= CONTEXTO =================

        lblContexto = new JLabel("Contexto del caso");
        lblContexto.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblContexto.setBounds(20, 90, 180, 30);
        panelIzquierdo.add(lblContexto);

        areaContexto = new JTextArea();
        areaContexto.setLineWrap(true);
        areaContexto.setWrapStyleWord(true);
        areaContexto.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        scrollContexto = new JScrollPane(areaContexto);
        scrollContexto.setBounds(20, 120, 280, 80);
        panelIzquierdo.add(scrollContexto);

        // ================= VARIABLES =================

        lblVariables = new JLabel("Variables analizadas");
        lblVariables.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblVariables.setBounds(20, 210, 180, 30);
        panelIzquierdo.add(lblVariables);

        txtVariables = new JTextField();
        txtVariables.setBounds(20, 240, 280, 35);
        panelIzquierdo.add(txtVariables);

        // ================= H0 =================

        lblH0 = new JLabel("Hipótesis nula (H0)");
        lblH0.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblH0.setBounds(20, 285, 200, 30);
        panelIzquierdo.add(lblH0);

        txtH0 = new JTextField();
        txtH0.setBounds(20, 315, 280, 35);
        panelIzquierdo.add(txtH0);

        // ================= H1 =================

        lblH1 = new JLabel("Hipótesis alternativa (H1)");
        lblH1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblH1.setBounds(20, 360, 240, 30);
        panelIzquierdo.add(lblH1);

        txtH1 = new JTextField();
        txtH1.setBounds(20, 390, 280, 35);
        panelIzquierdo.add(txtH1);

        // ================= DATOS =================

        lblDatos = new JLabel("Muestras o datos");
        lblDatos.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblDatos.setBounds(20, 435, 180, 30);
        panelIzquierdo.add(lblDatos);

        areaDatos = new JTextArea();
        areaDatos.setLineWrap(true);
        areaDatos.setWrapStyleWord(true);
        areaDatos.setFont(new Font("Consolas", Font.PLAIN, 13));

        scrollDatos = new JScrollPane(areaDatos);
        scrollDatos.setBounds(20, 465, 280, 50);
        panelIzquierdo.add(scrollDatos);

        // ================= BOTONES =================

        btnInicio = new JButton("Resolver");
        btnInicio.setBounds(20, 525, 80, 30);
        panelIzquierdo.add(btnInicio);

        btnAgregar = new JButton("Vista");
        btnAgregar.setBounds(110, 525, 90, 30);
        panelIzquierdo.add(btnAgregar);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(210, 525, 100, 30);
        panelIzquierdo.add(btnRegresar);

        // ================= PANEL DERECHO =================

        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(null);
        panelDerecho.setBounds(370, 70, 690, 560);
        panelDerecho.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        panelDerecho.setBackground(Color.WHITE);
        add(panelDerecho);

        JLabel lblVista = new JLabel("Vista previa del caso");
        lblVista.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblVista.setBounds(20, 10, 300, 30);
        panelDerecho.add(lblVista);

        areaVista = new JTextArea();
        areaVista.setEditable(false);
        areaVista.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaVista.setLineWrap(true);
        areaVista.setWrapStyleWord(true);

        scrollVista = new JScrollPane(areaVista);
        scrollVista.setBounds(20, 50, 650, 480);
        panelDerecho.add(scrollVista);

        mostrarEjemplo();

        // ================= EVENTOS =================

        btnRegresar.addActionListener(this);
        btnAgregar.addActionListener(this);
        btnInicio.addActionListener(this);
        comboPruebas.addActionListener(this);

        setVisible(true);
    }

    // ================= EJEMPLOS =================

    private void mostrarEjemplo() {

        String prueba = comboPruebas.getSelectedItem().toString();

        String ejemplo = "";

        if (prueba.equals("Prueba t de Student")) {

            ejemplo =
            "════════ EJEMPLO DE REDACCIÓN ════════\n\n" +

            "CONTEXTO:\n" +
            "El banco de Hopelchén desea comparar los tiempos\n" +
            "de espera antes y después de implementar un sistema.\n\n" +

            "VARIABLES:\n" +
            "Tiempo de espera antes y después.\n\n" +

            "HIPÓTESIS:\n" +
            "H0: No existe diferencia significativa.\n" +
            "H1: Sí existe diferencia significativa.\n\n" +

            "DATOS:\n" +
            "15,18,20,16,17\n" +
            "12,14,13,11,15";
        }

        else if (prueba.equals("Análisis de Varianza (ANOVA)")) {

            ejemplo =
            "════════ EJEMPLO DE REDACCIÓN ════════\n\n" +

            "DATOS:\n" +
            "12,14,13\n" +
            "18,20,17\n" +
            "10,11,9";
        }

        else if (prueba.equals("Prueba Z")) {

            ejemplo =
            "════════ EJEMPLO DE REDACCIÓN ════════\n\n" +

            "DATOS:\n" +
            "5400,5000,1000,40";
        }

        else if (prueba.equals("Prueba U de Mann-Whitney")) {

            ejemplo =
            "════════ EJEMPLO DE REDACCIÓN ════════\n\n" +

            "DATOS:\n" +
            "5,6,7,8\n" +
            "3,4,5,6";
        }

        else if (prueba.equals("Prueba de Wilcoxon")) {

            ejemplo =
            "════════ EJEMPLO DE REDACCIÓN ════════\n\n" +

            "DATOS:\n" +
            "120,130,125,140\n" +
            "150,145,155,160";
        }

        else if (prueba.equals("Prueba Chi-Cuadrada")) {

            ejemplo =
            "════════ EJEMPLO DE REDACCIÓN ════════\n\n" +

            "DATOS:\n" +
            "20,10\n" +
            "15,25";
        }

        areaVista.setText(ejemplo);
    }

    // ================= VISTA PREVIA =================

    private void generarVistaPrevia() {

        String texto =

        "════════ CASO GENERADO ════════\n\n" +

        "TIPO DE PRUEBA:\n" +
        comboPruebas.getSelectedItem().toString() + "\n\n" +

        "CONTEXTO:\n" +
        areaContexto.getText() + "\n\n" +

        "VARIABLES ANALIZADAS:\n" +
        txtVariables.getText() + "\n\n" +

        "HIPÓTESIS NULA (H0):\n" +
        txtH0.getText() + "\n\n" +

        "HIPÓTESIS ALTERNATIVA (H1):\n" +
        txtH1.getText() + "\n\n" +

        "MUESTRAS O DATOS:\n" +
        areaDatos.getText();

        areaVista.setText(texto);
    }

    // ================= EVENTOS =================

    @Override
    public void actionPerformed(ActionEvent e) {

        // REGRESAR

        if (e.getSource() == btnRegresar) {

            new VentanaPruebas(tipoVentana);
            dispose();
        }

        // VISTA PREVIA

        if (e.getSource() == btnAgregar) {

            generarVistaPrevia();
        }

        // CAMBIAR EJEMPLO

        if (e.getSource() == comboPruebas) {

            mostrarEjemplo();
        }

        // RESOLVER

        if (e.getSource() == btnInicio) {

            String pruebaSeleccionada =
                    comboPruebas.getSelectedItem().toString();

            String contexto =
                    areaContexto.getText();

            String variables =
                    txtVariables.getText();

            String h0 =
                    txtH0.getText();

            String h1 =
                    txtH1.getText();

            String datos =
                    areaDatos.getText();

            new VentanaResultado(

                    pruebaSeleccionada,
                    contexto,
                    variables,
                    h0,
                    h1,
                    datos,
                    tipoVentana
            );

            dispose();
        }
    }
}