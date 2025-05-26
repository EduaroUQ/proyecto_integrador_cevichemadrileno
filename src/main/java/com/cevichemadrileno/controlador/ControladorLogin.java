package com.cevichemadrileno.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.cevichemadrileno.modelo.AccesoBD;
import com.cevichemadrileno.util.Constantes;
import com.cevichemadrileno.vista.PanelLogin;

/**
 * Controlador del panel de login
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorLogin implements ActionListener, KeyListener {
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
			login();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (
			(e.getSource() == vista.getClaveTextField() || e.getSource() == vista.getMatriculaTextField()) &&
			e.getKeyCode() == KeyEvent.VK_ENTER
		) {
			login();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	private void login(){
		String usuario = vista.getMatriculaTextField().getText();
		String clave = vista.getClaveTextField().getText();
		if (!accesoBD.existeUsuario(usuario)) {
			vista.getErrorLabel().setText("El usuario no existe");
			return;
		}
		Constantes.usuarioAutenticado = accesoBD.login(usuario, clave);
		if (Constantes.usuarioAutenticado != null) {
			accesoBD.cargarSalas();
			vista.getControladorPrincipal().showPanel("dashboard");
		} else {
			vista.getErrorLabel().setText("Contraseña incorrecta");
		}
	}
}
