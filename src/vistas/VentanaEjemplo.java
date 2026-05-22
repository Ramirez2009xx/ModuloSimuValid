/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaEjemplo extends JFrame implements ActionListener {

    JTextArea areaTexto;
    JButton btnRegresar;
    String prueba;
    String tipo;

    public VentanaEjemplo(String prueba, String tipo) {

        this.prueba = prueba;
        this.tipo = tipo;

        setTitle("Ejemplo - " + prueba);
        setSize(850, 620);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel titulo = new JLabel("Ejemplo práctico: " + prueba);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setBounds(220, 20, 500, 30);
        add(titulo);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(30, 20, 120, 35);
        btnRegresar.addActionListener(this);
        add(btnRegresar);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setBounds(30, 80, 770, 470);
        add(scroll);

        cargarEjemplo();

        setVisible(true);
    }

private void cargarEjemplo() {

    String texto = "";

    if (prueba.equals("Prueba t de Student")) {
        texto =
        "════════ PRUEBA T DE STUDENT ════════\n\n" +
        "CONTEXTO:\n" +
        "El banco de Hopelchén implementó un nuevo sistema de turnos electrónicos.\n" +
        "Se desea comprobar si el tiempo promedio de espera disminuyó.\n\n" +

        "HIPÓTESIS:\n" +
        "H0: μ1 = μ2  (No hay diferencia)\n" +
        "H1: μ1 ≠ μ2  (Sí hay diferencia)\n\n" +

        "TABLA DE DATOS:\n" +
        "Antes   Después\n" +
        "15      12\n" +
        "18      14\n" +
        "20      13\n" +
        "16      11\n" +
        "17      15\n\n" +

        "PASO 1: MEDIA\n" +
        "X̄1=(15+18+20+16+17)/5 = 17.2\n" +
        "X̄2=(12+14+13+11+15)/5 = 13.0\n\n" +

        "PASO 2: VARIANZA\n" +
        "S1² = 3.7\n" +
        "S2² = 2.5\n\n" +

        "PASO 3: FORMULA\n" +
        "t=(X̄1-X̄2)/√[(S1²/n1)+(S2²/n2)]\n\n" +

        "PASO 4: SUSTITUCIÓN\n" +
        "t=(17.2-13.0)/√[(3.7/5)+(2.5/5)]\n" +
        "t=4.2/1.74\n" +
        "t=2.41\n\n" +

        "PASO 5: VALOR CRÍTICO\n" +
        "gl = n1+n2-2 = 8\n" +
        "t crítica = 2.306\n\n" +

        "DECISIÓN:\n" +
        "2.41 > 2.306 → Se rechaza H0\n\n" +

        "CONCLUSIÓN:\n" +
        "El nuevo sistema sí redujo el tiempo de espera.";
    }

    else if (prueba.equals("Análisis de Varianza (ANOVA)")) {
        texto =
        "════════ ANÁLISIS DE VARIANZA (ANOVA) ════════\n\n" +
        "CONTEXTO:\n" +
        "El banco de Hopelchén analiza tres cajas para comparar tiempos de atención.\n\n" +

        "HIPÓTESIS:\n" +
        "H0: μ1 = μ2 = μ3\n" +
        "H1: Al menos una media es diferente\n\n" +

        "TABLA DE DATOS:\n" +
        "Caja1  Caja2  Caja3\n" +
        "12     18     10\n" +
        "14     20     11\n" +
        "13     17      9\n\n" +

        "PASO 1: MEDIAS\n" +
        "Caja1 = 13.0\n" +
        "Caja2 = 18.3\n" +
        "Caja3 = 10.0\n" +
        "Media general = 13.77\n\n" +

        "PASO 2: SUMA ENTRE GRUPOS\n" +
        "SCE = Σn(X̄i-X̄)^2\n" +
        "SCE = 106.8\n\n" +

        "PASO 3: SUMA DENTRO GRUPOS\n" +
        "SCD = Σ(X-X̄i)^2\n" +
        "SCD = 18.6\n\n" +

        "PASO 4: CUADRADOS MEDIOS\n" +
        "CME = 53.4\n" +
        "CMD = 3.1\n\n" +

        "PASO 5: FORMULA\n" +
        "F = CME/CMD\n" +
        "F = 53.4 / 3.1 = 17.22\n\n" +

        "PASO 6: VALOR CRÍTICO\n" +
        "F crítica = 4.26\n\n" +

        "DECISIÓN:\n" +
        "17.22 > 4.26 → Se rechaza H0\n\n" +

        "CONCLUSIÓN:\n" +
        "Existe diferencia significativa entre cajas.";
    }

    else if (prueba.equals("Prueba Z")) {
        texto =
        "════════ PRUEBA Z ════════\n\n" +
        "CONTEXTO:\n" +
        "El banco desea saber si el retiro promedio diario supera $5000.\n\n" +

        "HIPÓTESIS:\n" +
        "H0: μ = 5000\n" +
        "H1: μ > 5000\n\n" +

        "DATOS:\n" +
        "n = 40\n" +
        "X̄ = 5400\n" +
        "σ = 1000\n\n" +

        "PASO 1: FORMULA\n" +
        "Z = (X̄ - μ)/(σ/√n)\n\n" +

        "PASO 2: SUSTITUCIÓN\n" +
        "Z=(5400-5000)/(1000/√40)\n" +
        "Z=400/158.11\n" +
        "Z=2.53\n\n" +

        "PASO 3: VALOR CRÍTICO\n" +
        "Z crítica = 1.96\n\n" +

        "DECISIÓN:\n" +
        "2.53 > 1.96 → Se rechaza H0\n\n" +

        "CONCLUSIÓN:\n" +
        "El retiro promedio supera $5000.";
    }

    else if (prueba.equals("Prueba U de Mann-Whitney")) {
        texto =
        "════════ U DE MANN-WHITNEY ════════\n\n" +
        "CONTEXTO:\n" +
        "En  se comparan tiempos de cobro entre dos cajeras.\n\n" +

        "HIPÓTESIS:\n" +
        "H0: No hay diferencia entre cajeras\n" +
        "H1: Sí hay diferencia\n\n" +

        "TABLA:\n" +
        "Caja A  Caja B\n" +
        "5       3\n6       4\n7       5\n8       6\n\n" +

        "PASO 1: ORDENAR DATOS\n" +
        "3 4 5 5 6 6 7 8\n\n" +

        "PASO 2: ASIGNAR RANGOS\n" +
        "1 2 3 4 5 6 7 8\n\n" +

        "PASO 3: SUMA DE RANGOS\n" +
        "R1 = 22\n" +
        "R2 = 14\n\n" +

        "PASO 4: FORMULA\n" +
        "U = n1*n2 + n1(n1+1)/2 - R1\n\n" +

        "PASO 5: SUSTITUCIÓN\n" +
        "U = 4*4 + 10 - 22\n" +
        "U = 4\n\n" +

        "VALOR CRÍTICO:\n" +
        "U crítica = 4\n\n" +

        "CONCLUSIÓN:\n" +
        "No se rechaza H0.";
    }

    else if (prueba.equals("Prueba de Wilcoxon")) {
        texto =
        "════════ PRUEBA DE WILCOXON ════════\n\n" +
        "CONTEXTO:\n" +
        "En  se analizaron ventas antes y después de una promoción.\n\n" +

        "HIPÓTESIS:\n" +
        "H0: No hubo cambio\n" +
        "H1: Sí hubo cambio\n\n" +

        "TABLA:\n" +
        "Antes  Después\n" +
        "120    150\n130    145\n125    155\n140    160\n\n" +

        "PASO 1: DIFERENCIAS\n" +
        "30, 15, 30, 20\n\n" +

        "PASO 2: ORDENAR\n" +
        "15, 20, 30, 30\n\n" +

        "PASO 3: RANGOS\n" +
        "1, 2, 3.5, 3.5\n\n" +

        "PASO 4: SUMA MENOR\n" +
        "W = 0\n\n" +

        "VALOR CRÍTICO:\n" +
        "W crítica = 2\n\n" +

        "CONCLUSIÓN:\n" +
        "0 < 2 → Se rechaza H0.";
    }

    else if (prueba.equals("Prueba Chi-Cuadrada")) {
        texto =
        "════════ PRUEBA CHI-CUADRADA ════════\n\n" +
        "CONTEXTO:\n" +
        "En  se analiza si existe relación entre género y método de pago.\n\n" +

        "HIPÓTESIS:\n" +
        "H0: No existe relación\n" +
        "H1: Sí existe relación\n\n" +

        "TABLA OBSERVADA:\n" +
        "          Efectivo Tarjeta\n" +
        "Hombres      20      10\n" +
        "Mujeres      15      25\n\n" +

        "PASO 1: TOTALES\n" +
        "Filas: 30 y 40\n" +
        "Columnas: 35 y 35\n" +
        "Total = 70\n\n" +

        "PASO 2: ESPERADOS\n" +
        "E=(fila*columna)/total\n" +
        "E=(30*35)/70 = 15\n\n" +

        "PASO 3: FORMULA\n" +
        "χ² = Σ((O-E)^2/E)\n\n" +

        "PASO 4: RESULTADO\n" +
        "χ² = 6.12\n\n" +

        "VALOR CRÍTICO:\n" +
        "χ² crítica = 3.84\n\n" +

        "CONCLUSIÓN:\n" +
        "6.12 > 3.84 → Se rechaza H0.";
    }

    areaTexto.setText(texto);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegresar) {
            new VentanaPruebas(tipo);
            dispose();
        }
    }
}