package com.cevichemadrileno.controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cevichemadrileno.util.Constantes;
import com.cevichemadrileno.vista.*;

import javax.swing.*;

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
		panelActividades = new PanelActividades(this);
		panelMiPerfil = new PanelMiPerfil(this);
		panelMisActividades = new PanelMisActividades(this);
		panelCrearActividad = new PanelCrearActividad(this);
	}

	/**
	 * Inicializa los listeners de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getMiPerfilBtn()) {
			showPanel("miPerfil");
		}
		if (e.getSource() == vista.getMisActividadesBtn()) {
			showPanel("misActividades");
			panelMisActividades.getControladorMisActividades().cargarActividadesInscritas();
			if (Constantes.usuarioAutenticado.getEsMonitor()){
				panelMisActividades.getControladorMisActividades().cargarActividadesCreadas();
			}
		}
		if (e.getSource() == vista.getActividadesBtn()) {
			showPanel("actividades");
			panelActividades.getControladorActividades().cargarActividades();
		}
		if (e.getSource() == vista.getCrearActividadBtn()) {
			panelCrearActividad.refrescarLugares();
			showPanel("crearActividad");
		}
		if (e.getSource() == vista.getCerrarSesionBtn()) {
			// Cerrar JFrame contenedor del panel
			Window window = SwingUtilities.getWindowAncestor(vista);
			window.dispose();
			// Reiniciar la aplicación
			VentanaPrincipal ventanaLogin = new VentanaPrincipal();
			ventanaLogin.hacerVisible();
		}
	}

	/**
	 * Cambia el panel que se muestra en el dashboard
	 * @param nombre Nombre del panel a mostrar
	 */
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
