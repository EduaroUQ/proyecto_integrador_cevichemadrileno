package com.cevichemadrileno.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.cevichemadrileno.vista.*;

/**
 * Controlador de la vista principal
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorPrincipal implements ActionListener {
	private VentanaPrincipal vista;
	private PanelLogin panelLogin;
	private PanelRegistro panelRegistro;
	private PanelDashboard panelDashboard;

	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorPrincipal(VentanaPrincipal vista) {
		this.vista = vista;
		panelLogin = new PanelLogin(this);
		panelRegistro = new PanelRegistro(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	}

	/**
	 * Cambia el panel de la vista principal
	 * @param nombre nombre del panel a mostrar
	 */
	public void showPanel(String nombre) {
		if (nombre.equals("login")) {
			vista.cambiarPanel(panelLogin);
		}
		if (nombre.equals("registro")) {
			vista.cambiarPanel(panelRegistro);
		}
		if (nombre.equals("dashboard")) {
			panelDashboard = new PanelDashboard();
			vista.cambiarPanel(panelDashboard);
		}
	}

}
