package com.cevichemadrileno.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.modelo.Sala;
import com.cevichemadrileno.util.Constantes;
import com.cevichemadrileno.vista.PanelCrearActividad;

/**
 * Controlador del panel de actividades
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorCrearActividad implements ActionListener {
	private PanelCrearActividad vista;
	private AccesoBD accesoBD;
	
	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorCrearActividad(PanelCrearActividad vista) {
		this.vista = vista;
		accesoBD = new AccesoBD();
	}

	/**
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getCrearBtn()) {

			String nombreActividad = vista.getNombreTextField().getText();
			String horaStr = vista.getHoraCombo().getSelectedItem().toString();
			String lugar = vista.getLugarCombo().getSelectedItem().toString();
			String descripcion = vista.getDescripcionTextArea().getText();
			Integer numeroMaxInscritos = Integer.parseInt(vista.getNroMaximoInscritosCombo().getSelectedItem().toString());
			String codigoSala = vista.getLugarCombo().getSelectedItem().toString();

			// Obtener fecha y hora de la actividad
			int dia = Integer.parseInt(vista.getDiaCombo().getSelectedItem().toString());
			int mes = Integer.parseInt(vista.getMesCombo().getSelectedItem().toString()) - 1;
			int anio = (Integer) vista.getYearCombo().getSelectedItem();
			int hora = Integer.parseInt(horaStr.split(":")[0]);
			System.out.println("Hora de nueva actividad: " + hora);

			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, anio);
			calendar.set(Calendar.MONTH, mes);
			calendar.set(Calendar.DAY_OF_MONTH, dia);
			calendar.set(Calendar.HOUR_OF_DAY, hora);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);

			Timestamp fecha = new Timestamp(calendar.getTimeInMillis());
			System.out.println("Fecha de actividad: " + fecha);

			// Validar campos
			if (nombreActividad.isEmpty()){
				vista.getErrorLabel().setText("Escribe el nombre de la actividad");
				return;
			}
			if (lugar.isEmpty()){
				vista.getErrorLabel().setText("Escribe el lugar de la actividad");
				return;
			}
			if (descripcion.isEmpty()){
				vista.getErrorLabel().setText("Escribe una descripcion de la actividad");
				return;
			}

			Actividad actividad = new Actividad();
			actividad.setNombre(nombreActividad);
			actividad.setDescripcion(descripcion);
			actividad.setNroMaximoInscritos(numeroMaxInscritos);
			actividad.setFecha(fecha);
			actividad.setIdMonitor(Constantes.usuarioAutenticado.getId());

			// Buscar id de la sala por codigo de la sala y asignar a la actividad
			for (Sala sala: Constantes.salas){
				if (sala.getCodigoSala().equals(codigoSala)){
					actividad.setIdSala(sala.getId());
					break;
				}
			}

			accesoBD.registrarActividad(actividad);

			int resultado = JOptionPane.showConfirmDialog(
					vista,
					"Actividad creada con éxito",
					"Éxito",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE
			);

			if (resultado == JOptionPane.OK_OPTION || resultado == JOptionPane.CLOSED_OPTION) {
				vista.getControladorDashboard().showPanel("misActividades", null);
			}


		}
	}

}
