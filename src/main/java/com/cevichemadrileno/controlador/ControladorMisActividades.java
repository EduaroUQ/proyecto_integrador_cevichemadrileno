package com.cevichemadrileno.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

import com.cevichemadrileno.modelo.AccesoBD;
import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.modelo.Inscripcion;
import com.cevichemadrileno.util.Constantes;
import com.cevichemadrileno.vista.PanelMisActividades;

import javax.swing.*;

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

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	/**
	 * Carga las actividades inscritas del usuario
	 */
	public void cargarActividadesInscritas() {
		ArrayList<Inscripcion> actividades = accesoBD.obtenerActividadesInscritas(Constantes.usuarioAutenticado.getId());
		vista.actualizarTablaActividadesInscritas(actividades);
	}

	/**
	 * Carga las actividades creadas por el usuario
	 */
	public void cargarActividadesCreadas() {
		ArrayList<Actividad> actividades = accesoBD.obtenerActividadesCreadas(Constantes.usuarioAutenticado.getId());
		vista.actualizarTablaActividadesCreadas(actividades);
	}

	/**
	 * Desinscribe al usuario de una actividad
	 * @param idActividad: id de la actividad
	 */
	public void desinscribirseDeActividad(Integer idActividad) {
		accesoBD.desinscribirseDeActividad(idActividad, Constantes.usuarioAutenticado.getId());
	}

	/**
	 * Elimina una actividad creada por el usuario
	 * @param idActividad
	 */
	public void eliminarActividad(Integer idActividad) {
		int resultado = JOptionPane.showConfirmDialog(
				vista,
				"¿Está seguro que desea eliminar la actividad?",
				"Advertencia",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE
		);

		if (resultado == JOptionPane.YES_OPTION) {
			accesoBD.eliminarActividad(idActividad);
		}
	}
}
