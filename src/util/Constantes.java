package util;

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
	public static int APPLICATION_WIDTH = 840;
	public static int APPLICATION_HEIGHT = 620;
	public static int SIDEBAR_WIDTH = 120;
	public static int DASHBOARD_WIDTH = 720;
	public static String APPLICATION_TITLE = "Ceviche Madrileño";
	public static Color MAIN_COLOR = new Color(2,48,71);
	public static Color SECONDARY_COLOR = new Color(4,86,128);
	public static Color TERTIARY_COLOR = new Color(75,129,199);
	public static Color MAIN_TEXT_COLOR = new Color(30,30,30);
	public static Color WHITE_COLOR = new Color(255,255,255);
	public static Color GRAY_COLOR = new Color(237,234,233);
	public static Font TEXT_FONT_34 = new Font("SansSerif", Font.PLAIN, 34);
	public static Font TEXT_FONT_18 = new Font("SansSerif", Font.PLAIN, 18);
	public static Font FONT_BOLD_18 = new Font("SansSerif", Font.BOLD, 18);
	public static Font TEXT_FONT_16 = new Font("SansSerif", Font.PLAIN, 16);
	public static Font TEXT_FONT_14 = new Font("SansSerif", Font.PLAIN, 14);
	public static Font TEXT_FONT_12 = new Font("SansSerif", Font.PLAIN, 12);
	public static final Border INPUT_FIELD_DEFAULT_BORDER = BorderFactory.createCompoundBorder(
	    new RoundedBorder(15, 3, new Color(60,103,184)),
	    BorderFactory.createEmptyBorder(0, 10, 0, 10)
	);
	public static final Border LOGIN_INPUT_FIELD_BORDER = BorderFactory.createCompoundBorder(
			new RoundedBorder(15, 0, null),
		    BorderFactory.createEmptyBorder(0, 10, 0, 10)
		);
	public static final String[] CICLOS = { "DAW", "DAM", "ASIR", "A3D","TAFD","EI","CI" };


}
