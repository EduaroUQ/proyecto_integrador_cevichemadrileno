package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.PanelLogin;

/**
 * Controlador del panel de login
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorLogin implements ActionListener {
	private PanelLogin vista;
	
	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorLogin(PanelLogin vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getRegistroLinkBtn()) {
			vista.getControladorPrincipal().showPanel("registro");
		}
		if (e.getSource() == vista.getLoginBtn()) {
			System.out.println("Iniciando sesión");
			boolean inicioSesionExitoso = true;
			if (inicioSesionExitoso) {
				
			}
			vista.getControladorPrincipal().showPanel("dashboard");
		}
	}

}
