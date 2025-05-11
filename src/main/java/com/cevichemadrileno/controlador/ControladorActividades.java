package com.cevichemadrileno.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.cevichemadrileno.modelo.Actividad;
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
	private AccesoBD accesoBD;

	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorActividades(PanelActividades vista) {
		this.vista = vista;
		accesoBD = new AccesoBD();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	/**
	 * Carga las actividades disponibles
	 */
	public void cargarActividades(){
		ArrayList<Actividad> actividades = accesoBD.obtenerActividades();
		vista.actualizarTablaActividades(actividades);
	}

}
