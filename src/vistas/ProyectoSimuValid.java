/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProyectoSimuValid extends JFrame implements ActionListener {

    JButton btnParametricas, btnNoParametricas;
    JButton btnInfoParametricas, btnInfoNoParametricas;

    JPanel infoPanelP, infoPanelNP;

    public ProyectoSimuValid() {

        // VENTANA
        setTitle("SimuValid");
        setSize(1050, 620);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 242, 245));

        // TITULO
        JLabel titulo = new JLabel("SIMUVALID");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titulo.setBounds(420, 10, 300, 40);
        add(titulo);

        JLabel subtitulo = new JLabel("Pruebas de Validación");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        subtitulo.setBounds(400, 50, 400, 30);
        add(subtitulo);

        // PANEL PARAMETRICAS
        JPanel panelP = new JPanel();
        panelP.setLayout(null);
        panelP.setBackground(Color.WHITE);
        panelP.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        panelP.setBounds(70, 110, 420, 420);
        add(panelP);

        JLabel lblP = new JLabel("Pruebas Paramétricas");
        lblP.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblP.setBounds(75, 20, 300, 35);
        panelP.add(lblP);

        btnParametricas = new JButton("Entrar");
        btnParametricas.setBounds(150, 95, 140, 45);
        btnParametricas.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnParametricas.setBackground(new Color(52, 152, 219));
        btnParametricas.setForeground(Color.WHITE);
        btnParametricas.setFocusPainted(false);
        btnParametricas.addActionListener(this);
        panelP.add(btnParametricas);

        btnInfoParametricas = new JButton("?");
        btnInfoParametricas.setBounds(90, 95, 45, 45);
        btnInfoParametricas.setBackground(new Color(52, 152, 219));
        btnInfoParametricas.setForeground(Color.WHITE);
        btnInfoParametricas.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnInfoParametricas.setFocusPainted(false);
        btnInfoParametricas.addActionListener(this);
        panelP.add(btnInfoParametricas);

        // INFO PARAMETRICAS
        infoPanelP = new JPanel();
        infoPanelP.setLayout(null);
        infoPanelP.setBounds(40, 160, 340, 230);
        infoPanelP.setBackground(Color.WHITE);
        infoPanelP.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        infoPanelP.setVisible(false);
        panelP.add(infoPanelP);

        JTextArea txtP = new JTextArea(
                "Las pruebas paramétricas se usan cuando los datos siguen una distribución normal.\n\n"
                + "Se enfocan en comparar medias y variaciones entre grupos.\n\n"
                + "Requieren datos continuos y una muestra suficiente.\n\n"
                + "Pruebas más comunes:\n"
                + "• Prueba T de Student\n"
                + "• ANOVA\n"
                + "• Prueba Z"
        );
        txtP.setBounds(10, 10, 320, 210);
        txtP.setWrapStyleWord(true);
        txtP.setLineWrap(true);
        txtP.setEditable(false);
        panelP.add(txtP);
        infoPanelP.add(txtP);

        // PANEL NO PARAMETRICAS
        JPanel panelNP = new JPanel();
        panelNP.setLayout(null);
        panelNP.setBackground(Color.WHITE);
        panelNP.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        panelNP.setBounds(550, 110, 420, 420);
        add(panelNP);

        JLabel lblNP = new JLabel("Pruebas No Paramétricas");
        lblNP.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblNP.setBounds(60, 20, 350, 35);
        panelNP.add(lblNP);

        btnNoParametricas = new JButton("Entrar");
        btnNoParametricas.setBounds(150, 95, 140, 45);
        btnNoParametricas.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnNoParametricas.setBackground(new Color(46, 204, 113));
        btnNoParametricas.setForeground(Color.WHITE);
        btnNoParametricas.setFocusPainted(false);
        btnNoParametricas.addActionListener(this);
        panelNP.add(btnNoParametricas);

        btnInfoNoParametricas = new JButton("?");
        btnInfoNoParametricas.setBounds(90, 95, 45, 45);
        btnInfoNoParametricas.setBackground(new Color(46, 204, 113));
        btnInfoNoParametricas.setForeground(Color.WHITE);
        btnInfoNoParametricas.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnInfoNoParametricas.setFocusPainted(false);
        btnInfoNoParametricas.addActionListener(this);
        panelNP.add(btnInfoNoParametricas);

        // INFO NO PARAMETRICAS
        infoPanelNP = new JPanel();
        infoPanelNP.setLayout(null);
        infoPanelNP.setBounds(40, 160, 340, 230);
        infoPanelNP.setBackground(Color.WHITE);
        infoPanelNP.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        infoPanelNP.setVisible(false);
        panelNP.add(infoPanelNP);

        JTextArea txtNP = new JTextArea(
                "Las pruebas no paramétricas se usan cuando los datos no siguen distribución normal.\n\n"
                + "Son útiles cuando hay pocos datos o escalas ordinales.\n\n"
                + "Pruebas más comunes:\n"
                + "• Mann-Whitney\n"
                + "• Wilcoxon\n"
                + "• Chi-Cuadrada"
        );
        txtNP.setBounds(10, 10, 320, 210);
        txtNP.setWrapStyleWord(true);
        txtNP.setLineWrap(true);
        txtNP.setEditable(false);
        infoPanelNP.add(txtNP);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnInfoParametricas) {
            infoPanelP.setVisible(!infoPanelP.isVisible());
        }

        if (e.getSource() == btnInfoNoParametricas) {
            infoPanelNP.setVisible(!infoPanelNP.isVisible());
        }

        if (e.getSource() == btnParametricas) {
            new VentanaPruebas("Paramétricas");
            dispose();
        }

        if (e.getSource() == btnNoParametricas) {
            new VentanaPruebas("No Paramétricas");
            dispose();
        }
    }

    public static void main(String[] args) {
        new ProyectoSimuValid();
    }
}