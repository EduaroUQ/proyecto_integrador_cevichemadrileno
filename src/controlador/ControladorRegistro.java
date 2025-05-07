package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.PanelRegistro;

/**
 * Controlador del panel de registro
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorRegistro implements ActionListener {
	private PanelRegistro vista;
	
	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorRegistro(PanelRegistro vista) {
		this.vista = vista;
	}

	/**
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getRegistroBtn()) {
			// registrar al usuario
		}
		if (e.getSource() == vista.getVolverLinkBtn()) {
			vista.getControladorPrincipal().showPanel("login");
		}
	}

}
