package com.cevichemadrileno.controlador;

import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.modelo.Sala;
import com.cevichemadrileno.util.Constantes;
import com.cevichemadrileno.vista.PanelDetalleActividad;
import com.cevichemadrileno.vista.PanelEditarActividad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Controlador del panel de detalle de actividad
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorDetalleActividad implements ActionListener {
	private PanelDetalleActividad vista;
	private AccesoBD accesoBD;
	private Actividad actividad;

	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorDetalleActividad(PanelDetalleActividad vista) {
		this.vista = vista;
		accesoBD = new AccesoBD();
	}

	/**
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getVolverLinkBtn()) {
			vista.getControladorDashboard().showPanel("actividades", null);
		}
		if (e.getSource() == vista.getInscribirseBtn()) {
			// TODO: validacion de ya estar inscrito en actividad
			// TODO: validacion de monitor no puede inscribirse en sus propias actividades
			accesoBD.inscribirseEnActividad(actividad.getId());

			int resultado = JOptionPane.showConfirmDialog(
				vista,
				"Inscripción exitosa",
				"Éxito",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE
			);

			if (resultado == JOptionPane.OK_OPTION || resultado == JOptionPane.CLOSED_OPTION) {
				vista.getControladorDashboard().showPanel("misActividades", null);
			}

		}
	}

	public void cargarDetalleActividad(Integer idActividad) {
		actividad = accesoBD.obtenerDetalleActividadPorId(idActividad);
		vista.getNombreActividadLabel().setText(actividad.getNombre());
		vista.getPlazasDisponiblesLabel().setText(actividad.getNroPlazasDisponibles() + " de "+actividad.getNroMaximoInscritos());
		vista.getUbicacionLabel().setText(actividad.getSala().getTipoSala());
		vista.getDescripcionLabel().setText(actividad.getDescripcion());
		vista.getInstructorLabel().setText(actividad.getMonitor().getNombreApellidos());
	}
}
