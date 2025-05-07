package com.cevichemadrileno.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cevichemadrileno.vista.PanelActividades;

/**
 * Controlador del panel de actividades
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorActividades implements ActionListener {
	private PanelActividades vista;
	
	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorActividades(PanelActividades vista) {
		this.vista = vista;
	}

	/**
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == vista.getVolverLinkBtn()) {
//			vista.getControladorPrincipal().showPanel("login");
//		}
	}

}
