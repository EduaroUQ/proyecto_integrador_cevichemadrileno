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
	private PanelEditarActividad panelEditarActividad;
	private PanelDetalleActividad panelDetalleActividad;

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
		panelEditarActividad = new PanelEditarActividad(this);
		panelDetalleActividad = new PanelDetalleActividad(this);
	}

	/**
	 *  Recibe los eventos de los botones
	 *  @param e: evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getMiPerfilBtn()) {
			showPanel("miPerfil", null);
		}
		if (e.getSource() == vista.getMisActividadesBtn()) {
			showPanel("misActividades",null);
		}
		if (e.getSource() == vista.getActividadesBtn()) {
			showPanel("actividades",null);
		}
		if (e.getSource() == vista.getCrearActividadBtn()) {
			showPanel("crearActividad",null);
		}
		if (e.getSource() == vista.getCerrarSesionBtn()) {
			/**
			 * Cerrar JFrame contenedor del panel
			 */
			// Obtener el JFrame padre del panel y cerrarlo
			Window window = SwingUtilities.getWindowAncestor(vista);
			window.dispose();
			// Reiniciar la aplicación
			VentanaPrincipal ventanaLogin = new VentanaPrincipal();
			ventanaLogin.hacerVisible();
		}
	}

	/**
	 * Cambia el panel que se muestra en el dashboard
	 * @param nombre nombre del panel a mostrar
	 */
	public void showPanel(String nombre, Integer idActividad_ParametroOpcional) {
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
			panelCrearActividad.limpiarMensajeError();
			vista.getMainContentScrollPanel().setViewportView(panelCrearActividad);
		}
		if (nombre.equals("editarActividad")) {
			System.out.println("Cambio de panel a editarActividad");
			panelEditarActividad.refrescarLugares();
			panelEditarActividad.limpiarMensajeError();
			vista.getMainContentScrollPanel().setViewportView(panelEditarActividad);
			panelEditarActividad.getControladorEditarActividad().cargarDatosActividad(idActividad_ParametroOpcional);
		}
		if (nombre.equals("detalleActividad")){
			System.out.println("Cambio de panel a detalleActividad");
			vista.getMainContentScrollPanel().setViewportView(panelDetalleActividad);
			panelDetalleActividad.getControladorDetalleActividad().cargarDetalleActividad(idActividad_ParametroOpcional);
		}
	}
}
