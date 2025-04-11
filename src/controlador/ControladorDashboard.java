package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.PanelActividades;
import vista.PanelCrearActividad;
import vista.PanelDashboard;
import vista.PanelMiPerfil;
import vista.PanelMisActividades;

/**
 * Controlador del panel del dashboard principal después de autenticarse
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorDashboard implements ActionListener {
	private PanelDashboard vista;
	private PanelMiPerfil panelMiPerfil;
	private PanelMisActividades panelMisActividades;
	private PanelActividades panelActividades;
	private PanelCrearActividad panelCrearActividad;
	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorDashboard(PanelDashboard vista) {
		this.vista = vista;
		panelMiPerfil = new PanelMiPerfil();
		panelMisActividades = new PanelMisActividades();
		panelActividades = new PanelActividades();
		panelCrearActividad = new PanelCrearActividad();
	}

	/**
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getMiPerfilBtn()) {
			showPanel("miPerfil");
		}
		if (e.getSource() == vista.getMisActividadesBtn()) {
			showPanel("misActividades");
		}
		if (e.getSource() == vista.getActividadesBtn()) {
			showPanel("actividades");
		}
		if (e.getSource() == vista.getCrearActividadBtn()) {
			showPanel("crearActividad");
		}
	}
	
	public void showPanel(String nombre) {
		if (nombre.equals("miPerfil")) {
			vista.cambiarPanel(panelMiPerfil);
		}
		if (nombre.equals("misActividades")) {
			vista.cambiarPanel(panelMisActividades);
		}
		if (nombre.equals("actividades")) {
			vista.cambiarPanel(panelActividades);
		}
		if (nombre.equals("crearActividad")) {
			vista.cambiarPanel(panelCrearActividad);
		}
	}
	

}
