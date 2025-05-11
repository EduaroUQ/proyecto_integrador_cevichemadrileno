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
	 * Recibe los eventos de los botones
	 * @param e: evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getVolverLinkBtn()) {
			vista.getControladorDashboard().showPanel("actividades", null);
		}
		if (e.getSource() == vista.getInscribirseBtn()) {
			System.out.println("Inscribirse en actividad");
			if (actividad.getIdMonitor() == Constantes.usuarioAutenticado.getId()) {
				JOptionPane.showMessageDialog(
					vista,
					"No puedes inscribirte en tu propia actividad",
					"Error",
					JOptionPane.ERROR_MESSAGE
				);
				return;
			}
			if (actividad.getNroPlazasDisponibles() <= 0) {
				JOptionPane.showMessageDialog(
					vista,
					"No hay plazas disponibles",
					"Error",
					JOptionPane.ERROR_MESSAGE
				);
				return;
			}
			if (accesoBD.usuarioYaInscritoEnActividad(actividad.getId())) {
				JOptionPane.showMessageDialog(
					vista,
					"Ya estás inscrito en esta actividad",
					"Error",
					JOptionPane.ERROR_MESSAGE
				);
				return;
			}
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

	/**
	 * Carga los detalles de la actividad
	 * @param idActividad: numero entero con el id de la actividad
	 */
	public void cargarDetalleActividad(Integer idActividad) {
		actividad = accesoBD.obtenerDetalleActividadPorId(idActividad);
		vista.getNombreActividadLabel().setText(actividad.getNombre());
		vista.getPlazasDisponiblesLabel().setText(actividad.getNroPlazasDisponibles() + " de "+actividad.getNroMaximoInscritos());
		vista.getUbicacionLabel().setText(actividad.getSala().getTipoSala());
		vista.getDescripcionLabel().setText(actividad.getDescripcion());
		vista.getInstructorLabel().setText(actividad.getMonitor().getNombreApellidos());
	}
}
