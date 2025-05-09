package com.cevichemadrileno.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.modelo.Inscripcion;
import com.cevichemadrileno.vista.PanelMisActividades;

/**
 * Controlador del panel de Mis Actividades
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorMisActividades implements ActionListener {
	private PanelMisActividades vista;
	private AccesoBD accesoBD;
	
	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorMisActividades(PanelMisActividades vista) {
		this.vista = vista;
		this.accesoBD = new AccesoBD();
	}

	/**
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void cargarActividadesInscritas() {
		ArrayList<Inscripcion> actividades = accesoBD.obtenerActividadesInscritas();
		vista.actualizarTablaActividadesInscritas(actividades);
	}

	public void cargarActividadesCreadas() {
		ArrayList<Actividad> actividades = accesoBD.obtenerActividadesCreadas();
		vista.actualizarTablaActividadesCreadas(actividades);
	}

	public void desinscribirseDeActividad(Integer idActividad) {
		accesoBD.desinscribirseDeActividad(idActividad);
	}

	public void editarActividad(Integer idActividad) {
	}

	public void eliminarActividad(Integer idActividad) {
		accesoBD.eliminarActividad(idActividad);
	}
}
