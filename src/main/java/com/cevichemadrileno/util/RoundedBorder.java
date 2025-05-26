package com.cevichemadrileno.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.AbstractBorder;

/**
 * Borde personalizado con esquinas redondeadas para componentes Swing
 * Permite definir el radio de redondeo, el grosor del borde y su color
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class RoundedBorder extends AbstractBorder {
    private final int radio;
    private final int grosor;
    private final Color color;

    /**
     * Constructor
     *
     * @param radio  el radio de redondeo de las esquinas
     * @param grosor el grosor del borde
     * @param color  el color del borde
     */
    public RoundedBorder(int radio, int grosor, Color color) {
        this.radio = radio;
        this.grosor = grosor;
        this.color = color;
    }

    /**
     * Pinta el borde redondeado alrededor del componente especificado.
     *
     * @param c       el componente para el cual se está pintando el borde
     * @param g       el contexto gráfico utilizado para pintar
     * @param x       la posición X del borde
     * @param y       la posición Y del borde
     * @param width   el ancho del borde
     * @param height  la altura del borde
     */
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        // Asegurarse de que el contexto gráfico sea Graphics2D para mejores resultados
        Graphics2D g2 = (Graphics2D) g.create();
        // Configurar las propiedades de renderizado para suavizar los bordes
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Configurar el color y el grosor del borde
        g2.setColor(color);
        // Establecer el grosor del borde
        g2.setStroke(new BasicStroke(grosor));
        // Dibujar el borde redondeado
        // Usar drawRoundRect para dibujar un rectángulo con esquinas redondeadas
        // Ajustar las coordenadas para que el borde se dibuje correctamente
        // dentro del componente, teniendo en cuenta el grosor
        // y el radio de las esquinas redondeadas
        g2.drawRoundRect(x + grosor / 2, y + grosor / 2,width - grosor, height - grosor, radio, radio);
        // Liberar el contexto gráfico
        g2.dispose();
    }

    /**
     * Devuelve los márgenes (insets) del borde.
     *
     * @param c el componente al que se aplica el borde
     * @return los insets del borde
     */
    @Override
    public Insets getBorderInsets(Component c) {
        // Crear un nuevo objeto Insets con el grosor especificado
        return new Insets(grosor, grosor, grosor, grosor);
    }

    /**
     * Establece los márgenes (insets) del borde en el objeto proporcionado.
     *
     * @param c      el componente al que se aplica el borde
     * @param insets el objeto Insets a modificar
     * @return el objeto Insets modificado
     */
    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        // Establecer los insets con el grosor especificado
        insets.set(grosor, grosor, grosor, grosor);
        return insets;
    }
}