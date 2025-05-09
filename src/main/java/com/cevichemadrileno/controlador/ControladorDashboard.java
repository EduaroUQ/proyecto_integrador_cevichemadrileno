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
		}
		if (e.getSource() == vista.getActividadesBtn()) {
			showPanel("actividades");
		}
		if (e.getSource() == vista.getCrearActividadBtn()) {
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
			System.out.println("Cambio de panel a miPerfil");
			vista.getMainContentScrollPanel().setViewportView(panelMiPerfil);
		}
		if (nombre.equals("misActividades")) {
			System.out.println("Cambio de panel a misActividades");
			vista.getMainContentScrollPanel().setViewportView(panelMisActividades);
			panelMisActividades.getControladorMisActividades().cargarActividadesInscritas();
			if (Constantes.usuarioAutenticado.getEsMonitor()){
				panelMisActividades.getControladorMisActividades().cargarActividadesCreadas();
			}
		}
		if (nombre.equals("actividades")) {
			System.out.println("Cambio de panel a actividades");
			vista.getMainContentScrollPanel().setViewportView(panelActividades);
			panelActividades.getControladorActividades().cargarActividades();
		}
		if (nombre.equals("crearActividad")) {
			System.out.println("Cambio de panel a crearActividad");
			panelCrearActividad.refrescarLugares();
			vista.getMainContentScrollPanel().setViewportView(panelCrearActividad);
		}
	}
	

}
