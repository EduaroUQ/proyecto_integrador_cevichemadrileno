package com.cevichemadrileno.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * Constantes globales de la aplicación
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class Constantes {
	public static int ANCHURA_APLICACION = 840;
	public static int ALTURA_APLICACION = 620;
	public static int ANCHURA_SIDEBAR = 120;
	public static int ANCHURA_DASHBOARD = 720;
	public static String TITULO_APLICACION = "Ceviche Madrileño";
	public static Color AZUL_OSCURO = new Color(2,48,71);
	public static Color AZUL_OSCURO_CLARO = new Color(4,86,128);
	public static Color CELESTE_OSCURO = new Color(75,129,199);
	public static Color NEGRO_CLARO = new Color(30,30,30);
	public static Color BLANCO = new Color(255,255,255);
	public static Color GRIS = new Color(237,234,233);
	public static Font SANS_SERIF_34 = new Font("SansSerif", Font.PLAIN, 34);
	public static Font SANS_SERIF_18 = new Font("SansSerif", Font.PLAIN, 18);
	public static Font SANS_SERIF_18_NEGRITA = new Font("SansSerif", Font.BOLD, 18);
	public static Font SANS_SERIF_16 = new Font("SansSerif", Font.PLAIN, 16);
	public static Font SANS_SERIF_14 = new Font("SansSerif", Font.PLAIN, 14);
	public static Font SANS_SERIF_12 = new Font("SansSerif", Font.PLAIN, 12);
	public static final Border BORDE_INPUT_ESTILO_1 = BorderFactory.createCompoundBorder(
	    new RoundedBorder(15, 3, new Color(60,103,184)),
	    BorderFactory.createEmptyBorder(0, 10, 0, 10)
	);
	public static final Border BORDER_INPUT_ESTILO_2 = BorderFactory.createCompoundBorder(
			new RoundedBorder(15, 0, null),
		    BorderFactory.createEmptyBorder(0, 10, 0, 10)
		);
	public static final String[] CICLOS = { "DAW", "DAM", "ASIR", "A3D","TAFD","EI","CI" };


}
