/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class VentanaResultado extends JFrame {

    JTextArea areaDescripcion, areaProcedimiento, areaConclusion;

    JTable tablaResultados, tablaCriticos;

    DefaultTableModel modeloResultados, modeloCriticos;

    String tipoPrueba, contexto, variables, h0, h1, datos, tipoVentana;

    double estadistico = 0;
    double critico = 1.96;

    int n = 0;

    public VentanaResultado(String tipoPrueba, String contexto,
                            String variables, String h0,
                            String h1, String datos,
                            String tipoVentana) {

        this.tipoPrueba = tipoPrueba;
        this.contexto = contexto;
        this.variables = variables;
        this.h0 = h0;
        this.h1 = h1;
        this.datos = datos;
        this.tipoVentana = tipoVentana;

        setTitle("Resultados estadísticos");

        setSize(1220, 760);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        getContentPane().setBackground(Color.WHITE);

        // ================= PANEL DESCRIPCION =================
        JPanel p1 = new JPanel(null);

        p1.setBounds(20, 50, 360, 190);

        p1.setBorder(
                BorderFactory.createTitledBorder(
                        "Descripción del problema"
                )
        );

        p1.setBackground(Color.WHITE);

        add(p1);

        areaDescripcion = new JTextArea();

        areaDescripcion.setEditable(false);

        areaDescripcion.setLineWrap(true);

        areaDescripcion.setWrapStyleWord(true);

        areaDescripcion.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        JScrollPane sp1 = new JScrollPane(areaDescripcion);

        sp1.setBounds(10, 25, 335, 145);

        p1.add(sp1);

        // ================= PANEL RESULTADOS =================
        JPanel p2 = new JPanel(null);

        p2.setBounds(20, 260, 360, 160);

        p2.setBorder(
                BorderFactory.createTitledBorder(
                        "Tabla de resultados"
                )
        );

        p2.setBackground(Color.WHITE);

        add(p2);

        modeloResultados = new DefaultTableModel();

        tablaResultados = new JTable(modeloResultados);

        JScrollPane sp2 = new JScrollPane(tablaResultados);

        sp2.setBounds(10, 25, 335, 120);

        p2.add(sp2);

        // ================= PANEL CRITICOS =================
        JPanel p3 = new JPanel(null);

        p3.setBounds(20, 440, 360, 210);

        p3.setBorder(
                BorderFactory.createTitledBorder(
                        "Valores críticos"
                )
        );

        p3.setBackground(Color.WHITE);

        add(p3);

        modeloCriticos = new DefaultTableModel();

        tablaCriticos = new JTable(modeloCriticos);

        JScrollPane sp3 = new JScrollPane(tablaCriticos);

        sp3.setBounds(10, 25, 335, 160);

        p3.add(sp3);

        // ================= PANEL PROCEDIMIENTO =================
        JPanel p4 = new JPanel(null);

        p4.setBounds(410, 50, 770, 470);

        p4.setBorder(
                BorderFactory.createTitledBorder(
                        "Procedimiento paso a paso"
                )
        );

        p4.setBackground(Color.WHITE);

        add(p4);

        areaProcedimiento = new JTextArea();

        areaProcedimiento.setEditable(false);

        areaProcedimiento.setLineWrap(true);

        areaProcedimiento.setWrapStyleWord(true);

        areaProcedimiento.setFont(
                new Font("Monospaced", Font.PLAIN, 14)
        );

        JScrollPane sp4 = new JScrollPane(areaProcedimiento);

        sp4.setBounds(10, 25, 745, 425);

        p4.add(sp4);

        // ================= PANEL CONCLUSION =================
        JPanel p5 = new JPanel(null);

        p5.setBounds(410, 540, 770, 130);

        p5.setBorder(
                BorderFactory.createTitledBorder(
                        "Conclusión"
                )
        );

        p5.setBackground(Color.WHITE);

        add(p5);

        areaConclusion = new JTextArea();

        areaConclusion.setEditable(false);

        areaConclusion.setLineWrap(true);

        areaConclusion.setWrapStyleWord(true);

        areaConclusion.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        areaConclusion.setBounds(15, 25, 560, 85);

        p5.add(areaConclusion);

        JButton btn = new JButton("Regresar");

        btn.setBounds(610, 42, 130, 42);

        btn.addActionListener(e -> {

            dispose();

            new VentanaPruebas(tipoVentana)
                    .setVisible(true);
        });

        p5.add(btn);

        // ================= DESCRIPCION =================
        areaDescripcion.setText(

                "TIPO DE PRUEBA:\n"
                + tipoPrueba

                + "\n\nCONTEXTO:\n"
                + contexto

                + "\n\nVARIABLES:\n"
                + variables

                + "\n\nH0:\n"
                + h0

                + "\n\nH1:\n"
                + h1
        );

        // ================= CALCULOS =================
        switch (tipoPrueba) {

            case "Prueba t de Student" ->
                calcularT();

            case "Prueba Z" ->
                calcularZ();

            case "Análisis de Varianza (ANOVA)" ->
                calcularANOVA();

            case "Prueba U de Mann-Whitney" ->
                calcularMannWhitney();

            case "Prueba de Wilcoxon" ->
                calcularWilcoxon();

            case "Prueba Chi-Cuadrada" ->
                calcularChiCuadrada();
        }

        cargarTablas();

        cargarProcedimiento();

        cargarConclusion();

        setVisible(true);
    }

    // ================= T STUDENT =================
    private void calcularT() {

        String[] l = datos.split("\n");

        double[] g1 = convertir(l[0]);

        double[] g2 = convertir(l[1]);

        double m1 = media(g1);

        double m2 = media(g2);

        double var1 = varianza(g1, m1);

        double var2 = varianza(g2, m2);

        double sp = Math.sqrt(
                (((g1.length - 1) * var1)
                + ((g2.length - 1) * var2))
                /
                (g1.length + g2.length - 2)
        );

        estadistico = (m1 - m2)
                /
                (sp * Math.sqrt(
                        (1.0 / g1.length)
                        +
                        (1.0 / g2.length)
                ));

        n = g1.length + g2.length;

        critico = 2.101;
    }

    // ================= Z =================
    private void calcularZ() {

        String[] v = datos.split(",");

        double xm = Double.parseDouble(v[0]);

        double mu = Double.parseDouble(v[1]);

        double s = Double.parseDouble(v[2]);

        n = Integer.parseInt(v[3]);

        estadistico = (xm - mu)
                /
                (s / Math.sqrt(n));

        critico = 1.96;
    }

    // ================= ANOVA =================
    private void calcularANOVA() {

        String[] grupos = datos.split("\n");

        double[][] datosGrupos =
                new double[grupos.length][];

        int totalDatos = 0;

        double sumaTotal = 0;

        for (int i = 0; i < grupos.length; i++) {

            datosGrupos[i] = convertir(grupos[i]);

            for (double x : datosGrupos[i]) {

                sumaTotal += x;

                totalDatos++;
            }
        }

        double mediaGeneral =
                sumaTotal / totalDatos;

        double SCE = 0;

        double SCI = 0;

        for (double[] grupo : datosGrupos) {

            double mediaGrupo = media(grupo);

            SCE += grupo.length
                    *
                    Math.pow(
                            mediaGrupo - mediaGeneral,
                            2
                    );

            for (double x : grupo) {

                SCI += Math.pow(
                        x - mediaGrupo,
                        2
                );
            }
        }

        int gl1 = grupos.length - 1;

        int gl2 = totalDatos - grupos.length;

        double CME = SCE / gl1;

        double CMI = SCI / gl2;

        estadistico = CME / CMI;

        n = totalDatos;

        critico = 3.89;
    }

    // ================= MANN WHITNEY =================
    private void calcularMannWhitney() {

        String[] l = datos.split("\n");

        double[] g1 = convertir(l[0]);

        double[] g2 = convertir(l[1]);

        ArrayList<Double> todos = new ArrayList<>();

        for (double x : g1) todos.add(x);

        for (double x : g2) todos.add(x);

        Collections.sort(todos);

        double r1 = 0;

        for (double x : g1) {

            r1 += todos.indexOf(x) + 1;
        }

        double u1 =
                (g1.length * g2.length)
                +
                ((g1.length * (g1.length + 1)) / 2.0)
                -
                r1;

        double r2 = 0;

        for (double x : g2) {

            r2 += todos.indexOf(x) + 1;
        }

        double u2 =
                (g1.length * g2.length)
                +
                ((g2.length * (g2.length + 1)) / 2.0)
                -
                r2;

        estadistico = Math.min(u1, u2);

        n = g1.length + g2.length;

        critico = 2;
    }

    // ================= WILCOXON =================
    private void calcularWilcoxon() {

        String[] l = datos.split("\n");

        double[] antes = convertir(l[0]);

        double[] despues = convertir(l[1]);

        double sumaPositivos = 0;

        double sumaNegativos = 0;

        for (int i = 0; i < antes.length; i++) {

            double d = despues[i] - antes[i];

            if (d > 0) {

                sumaPositivos += Math.abs(d);
            }

            else {

                sumaNegativos += Math.abs(d);
            }
        }

        estadistico =
                Math.min(
                        sumaPositivos,
                        sumaNegativos
                );

        n = antes.length;

        critico = 3;
    }

    // ================= CHI CUADRADA =================
    private void calcularChiCuadrada() {

        String[] l = datos.split("\n");

        double[] observados = convertir(l[0]);

        double[] esperados = convertir(l[1]);

        double chi = 0;

        for (int i = 0; i < observados.length; i++) {

            chi += Math.pow(
                    observados[i]
                    -
                    esperados[i],
                    2
            )
                    /
                    esperados[i];
        }

        estadistico = chi;

        n = observados.length;

        critico = 5.99;
    }

    // ================= TABLAS =================
    private void cargarTablas() {

        modeloResultados.setRowCount(0);

        modeloCriticos.setRowCount(0);

        modeloResultados.setColumnIdentifiers(
                new String[]{
                    "Concepto",
                    "Valor"
                }
        );

        modeloResultados.addRow(
                new Object[]{
                    "Estadístico calculado",
                    String.format("%.4f",
                            estadistico)
                }
        );

        modeloCriticos.setColumnIdentifiers(
                new String[]{
                    "Elemento",
                    "Valor"
                }
        );

        modeloCriticos.addRow(
                new Object[]{
                    "Prueba",
                    tipoPrueba
                }
        );

        modeloCriticos.addRow(
                new Object[]{
                    "Nivel α",
                    "0.05"
                }
        );

        modeloCriticos.addRow(
                new Object[]{
                    "Datos usados",
                    n
                }
        );

        modeloCriticos.addRow(
                new Object[]{
                    "Valor crítico",
                    critico
                }
        );
    }

    // ================= PROCEDIMIENTO =================
    private void cargarProcedimiento() {

        areaProcedimiento.setText(

                "1. PLANTEAMIENTO\n\n"

                + "H0:\n"
                + h0

                + "\n\nH1:\n"
                + h1

                + "\n\n2. DATOS\n\n"
                + datos

                + "\n\n3. RESULTADO\n\n"

                + "Estadístico calculado = "
                + String.format("%.4f",
                        estadistico)

                + "\n\nValor crítico = "
                + String.format("%.4f",
                        critico)

                + "\n\n4. COMPARACIÓN\n\n"

                + "|"
                + String.format("%.4f",
                        estadistico)

                + "| vs "
                + String.format("%.4f",
                        critico)
        );
    }

    // ================= CONCLUSION =================
    private void cargarConclusion() {

        String decision;

        if (Math.abs(estadistico)
                > critico) {

            decision = "SE RECHAZA H0";
        }

        else {

            decision = "NO SE RECHAZA H0";
        }

        areaConclusion.setText(

                "Resultado final:\n"

                + decision

                + "\n\nEstadístico calculado = "

                + String.format("%.4f",
                        estadistico)

                + "\nValor crítico = "

                + String.format("%.4f",
                        critico)
        );
    }

    // ================= UTILIDADES =================
    private double[] convertir(String t) {

        String[] p = t.split(",");

        double[] d = new double[p.length];

        for (int i = 0; i < p.length; i++) {

            d[i] =
                    Double.parseDouble(
                            p[i].trim()
                    );
        }

        return d;
    }

    private double media(double[] v) {

        double s = 0;

        for (double x : v) {

            s += x;
        }

        return s / v.length;
    }

    private double varianza(
            double[] v,
            double media
    ) {

        double suma = 0;

        for (double x : v) {

            suma += Math.pow(
                    x - media,
                    2
            );
        }

        return suma / (v.length - 1);
    }
}