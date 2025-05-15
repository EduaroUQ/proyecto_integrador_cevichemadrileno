package com.cevichemadrileno.vista;

import javax.swing.*;

import com.cevichemadrileno.controlador.ControladorDashboard;
import com.cevichemadrileno.util.Constantes;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Panel del dashboard principal después de autenticarse
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class PanelDashboard extends JPanel {
	private JButton miPerfilBtn;
	private JButton misActividadesBtn;
	private JButton actividadesBtn;
	private JButton crearActividadBtn;
	private JButton cerrarSesionBtn;
	private JPanel sidebarPanelBackground;
	private JScrollPane mainContentScrollPanel;
	private ControladorDashboard controladorDashboard;

	/**
	 * Constructor
	 */
	public PanelDashboard() {
		inicializarComponentes();
	}

	/**
	 * Inicializa los componentes del panel
	 */
	private void inicializarComponentes() {
		setBackground(Constantes.GRIS);
		setSize(Constantes.ANCHURA_APLICACION, Constantes.ALTURA_APLICACION);
		setLayout(null);
		
		controladorDashboard = new ControladorDashboard(this);
		
		sidebarPanelBackground = new JPanel();
		sidebarPanelBackground.setBackground(Constantes.AZUL_OSCURO);
		sidebarPanelBackground.setBounds(0, 0, 120, 620);
		
		String rootFolder = System.getProperty("user.dir");
		Path imagePath = Paths.get(rootFolder, "img", "logo.png");
		ImageIcon originalIcon = new ImageIcon(imagePath.toString());
		Image scaledImage = originalIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		JLabel imageLabel = new JLabel(scaledIcon);
		imageLabel.setBounds(0,0,120, 120);
		add(imageLabel);
		
		miPerfilBtn = new JButton();
		miPerfilBtn.setText("Mi perfil");
		miPerfilBtn.setFont(Constantes.SANS_SERIF_12);
		miPerfilBtn.setForeground(Constantes.BLANCO);
		miPerfilBtn.setBackground(null);
		miPerfilBtn.setContentAreaFilled(false);
		miPerfilBtn.setBorderPainted(false);
		miPerfilBtn.setFocusPainted(false);
		miPerfilBtn.setHorizontalAlignment(SwingConstants.LEFT);
		miPerfilBtn.setOpaque(false);
		miPerfilBtn.addActionListener(controladorDashboard);
		miPerfilBtn.setBounds(0, 120, 120, 40);
		add(miPerfilBtn);
		

		misActividadesBtn = new JButton();
		misActividadesBtn.setText("Mis actividades");
		misActividadesBtn.setFont(Constantes.SANS_SERIF_12);
		misActividadesBtn.setForeground(Constantes.BLANCO);
		misActividadesBtn.setBackground(null);
		misActividadesBtn.setContentAreaFilled(false);
		misActividadesBtn.setBorderPainted(false);
		misActividadesBtn.setFocusPainted(false);
		misActividadesBtn.setHorizontalAlignment(SwingConstants.LEFT);
		misActividadesBtn.setOpaque(false);
		misActividadesBtn.addActionListener(controladorDashboard);
		misActividadesBtn.setBounds(0, 160, 120, 40);
		add(misActividadesBtn);
		
		actividadesBtn = new JButton();
		actividadesBtn.setText("Actividades");
		actividadesBtn.setFont(Constantes.SANS_SERIF_12);
		actividadesBtn.setForeground(Constantes.BLANCO);
		actividadesBtn.setBackground(null);
		actividadesBtn.setContentAreaFilled(false);
		actividadesBtn.setBorderPainted(false);
		actividadesBtn.setFocusPainted(false);
		actividadesBtn.setHorizontalAlignment(SwingConstants.LEFT);
		actividadesBtn.setOpaque(false);
		actividadesBtn.addActionListener(controladorDashboard);
		actividadesBtn.setBounds(0, 200, 120, 40);
		add(actividadesBtn);

		if (Constantes.usuarioAutenticado.getEsMonitor()) {
			crearActividadBtn = new JButton();
			crearActividadBtn.setText("Crear actividad");
			crearActividadBtn.setFont(Constantes.SANS_SERIF_12);
			crearActividadBtn.setForeground(Constantes.BLANCO);
			crearActividadBtn.setBackground(null);
			crearActividadBtn.setContentAreaFilled(false);
			crearActividadBtn.setBorderPainted(false);
			crearActividadBtn.setFocusPainted(false);
			crearActividadBtn.setHorizontalAlignment(SwingConstants.LEFT);
			crearActividadBtn.setOpaque(false);
			crearActividadBtn.addActionListener(controladorDashboard);
			crearActividadBtn.setBounds(0, 240, 120, 40);
			add(crearActividadBtn);
		}


		cerrarSesionBtn = new JButton();
		cerrarSesionBtn.setText("Cerrar sesión");
		cerrarSesionBtn.setFont(Constantes.SANS_SERIF_12);
		cerrarSesionBtn.setForeground(Constantes.BLANCO);
		cerrarSesionBtn.setBackground(null);
		cerrarSesionBtn.setContentAreaFilled(false);
		cerrarSesionBtn.setBorderPainted(false);
		cerrarSesionBtn.setFocusPainted(false);
		cerrarSesionBtn.setHorizontalAlignment(SwingConstants.LEFT);
		cerrarSesionBtn.setOpaque(false);
		cerrarSesionBtn.addActionListener(controladorDashboard);
		if (Constantes.usuarioAutenticado.getEsMonitor()) {
			cerrarSesionBtn.setBounds(0, 280, 120, 40);
		} else {
			cerrarSesionBtn.setBounds(0, 240, 120, 40);
		}
		add(cerrarSesionBtn);
		
		mainContentScrollPanel = new JScrollPane();
		mainContentScrollPanel.setBounds(119, -1, Constantes.ANCHURA_PANEL_DERECHO_DASHBOARD, Constantes.ALTURA_APLICACION);

		add(mainContentScrollPanel);
		add(sidebarPanelBackground);

		// Define cual es el panel del dashboard que se va a mostrar por defecto
		controladorDashboard.showPanel(Constantes.PANEL_DEL_DASHBOARD_POR_DEFECTO,null);
	}



	/**
	 * Getters
	 */
	public JButton getMiPerfilBtn() {
		return miPerfilBtn;
	}
	public JButton getMisActividadesBtn() {
		return misActividadesBtn;
	}
	public JButton getActividadesBtn() {
		return actividadesBtn;
	}
	public JButton getCrearActividadBtn() {
		return crearActividadBtn;
	}
	public JButton getCerrarSesionBtn() {
		return cerrarSesionBtn;
	}
	public JScrollPane getMainContentScrollPanel() {
		return mainContentScrollPanel;
	}
}
