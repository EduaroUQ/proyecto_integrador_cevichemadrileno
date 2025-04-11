package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Actividad;
import vista.PanelCrearActividad;

/**
 * Controlador del panel de actividades
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorCrearActividad implements ActionListener {
	private PanelCrearActividad vista;
	private Actividad actividad;
	
	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorCrearActividad(PanelCrearActividad vista) {
		this.vista = vista;
	}

	/**
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.getCrearBtn()) {
			 JOptionPane.showMessageDialog(vista, "Actividad creada con exito", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
