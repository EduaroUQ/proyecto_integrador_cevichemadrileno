package com.cevichemadrileno.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.cevichemadrileno.vista.PanelLogin;

/**
 * Controlador del panel de login
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorLogin implements ActionListener {
	private PanelLogin vista;
	private AccesoBD accesoBD;
	
	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorLogin(PanelLogin vista) {
		this.vista = vista;
		this.accesoBD = new AccesoBD();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getRegistroLinkBtn()) {
			vista.getControladorPrincipal().showPanel("registro");
		}
		if (e.getSource() == vista.getLoginBtn()) {
			String usuario = vista.getUsuarioTextField().getText();
			String clave = vista.getClaveTextField().getText();
			if (!accesoBD.existeUsuario(usuario)) {
				vista.getErrorLabel().setText("El usuario no existe");
				return;
			}
			if (accesoBD.login(usuario, clave)) {
				accesoBD.cargarSalas();
				vista.getControladorPrincipal().showPanel("dashboard");
			} else {
				vista.getErrorLabel().setText("Usuario o contraseña incorrectos");
			}
		}
	}

}
