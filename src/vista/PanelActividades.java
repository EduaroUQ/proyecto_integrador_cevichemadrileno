package vista;

import javax.swing.*;

import util.Constantes;

/**
 * Panel de actividades
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class PanelActividades extends JPanel {
	private JLabel tituloLabel;
	
	public PanelActividades() {
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBackground(Constantes.GRAY_COLOR);
		setSize(Constantes.DASHBOARD_WIDTH, Constantes.APPLICATION_HEIGHT);
		setLayout(null);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Actividades disponibles");
		tituloLabel.setBounds(173,41,374,62);
		tituloLabel.setFont(Constantes.TEXT_FONT_34);
		tituloLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(tituloLabel);
		
		
	}

	/**
	 * Getters
	 */
	

	
	
	
}
