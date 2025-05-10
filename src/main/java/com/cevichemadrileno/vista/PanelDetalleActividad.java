package com.cevichemadrileno.vista;

import com.cevichemadrileno.controlador.ControladorDashboard;
import com.cevichemadrileno.controlador.ControladorDetalleActividad;
import com.cevichemadrileno.util.Constantes;

import javax.swing.*;

/**
 * Panel de detalle de actividad
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class PanelDetalleActividad extends JPanel {
	// JLabels de texto fijo
	private JButton volverLinkBtn;
	private JLabel textoDetalleActividadLabel;
	private JLabel textoPlazasDisponiblesLabel;
	private JLabel textoUbicacionLabel;
	private JLabel textoDuracionLabel;
	private JLabel textoDescripcionLabel;
	private JLabel textoInstructorLabel;

	// JLabels de texto variable
	private JLabel nombreActividadLabel;
	private JLabel plazasDisponiblesLabel;
	private JLabel ubicacionLabel;
	private JLabel duracionLabel;
	private JLabel descripcionLabel;
	private JLabel instructorLabel;
	private JButton inscribirseBtn;

	private ControladorDashboard controladorDashboard;
	private ControladorDetalleActividad controladorDetalleActividad;

	/**
	 * Constructor
	 * @param controladorDashboard
	 */
	public PanelDetalleActividad(ControladorDashboard controladorDashboard) {
		inicializarComponentes();
		this.controladorDashboard = controladorDashboard;
	}

	private void inicializarComponentes() {
		setBackground(Constantes.GRIS);
		setSize(Constantes.ANCHURA_DASHBOARD, Constantes.ALTURA_APLICACION);
		setLayout(null);

		controladorDetalleActividad = new ControladorDetalleActividad(this);

		volverLinkBtn = new JButton();
		volverLinkBtn.setText("Volver");
		volverLinkBtn.setBounds(1,1,101,40);
		volverLinkBtn.setFont(Constantes.SANS_SERIF_18);
		volverLinkBtn.setForeground(Constantes.CELESTE_OSCURO);
		volverLinkBtn.setBackground(null);
		volverLinkBtn.setContentAreaFilled(false);
		volverLinkBtn.setBorderPainted(false);
		volverLinkBtn.setFocusPainted(false);
		volverLinkBtn.setOpaque(false);
		volverLinkBtn.addActionListener(controladorDetalleActividad);
		add(volverLinkBtn);

		// JLabels de texto fijo
		textoDetalleActividadLabel = new JLabel();
		textoDetalleActividadLabel.setText("Detalles de la actividad");
		textoDetalleActividadLabel.setBounds(47,106,216,40);
		textoDetalleActividadLabel.setFont(Constantes.SANS_SERIF_20);
		textoDetalleActividadLabel.setForeground(Constantes.NEGRO_CLARO);
		add(textoDetalleActividadLabel);

		textoPlazasDisponiblesLabel = new JLabel();
		textoPlazasDisponiblesLabel.setText("Plazas disponibles");
		textoPlazasDisponiblesLabel.setBounds(55,156,168,40);
		textoPlazasDisponiblesLabel.setFont(Constantes.SANS_SERIF_16_NEGRITA);
		textoPlazasDisponiblesLabel.setForeground(Constantes.NEGRO_CLARO);
		add(textoPlazasDisponiblesLabel);

		textoUbicacionLabel = new JLabel();
		textoUbicacionLabel.setText("Ubicación");
		textoUbicacionLabel.setBounds(290,156,101,40);
		textoUbicacionLabel.setFont(Constantes.SANS_SERIF_16_NEGRITA);
		textoUbicacionLabel.setForeground(Constantes.NEGRO_CLARO);
		add(textoUbicacionLabel);

		textoDuracionLabel = new JLabel();
		textoDuracionLabel.setText("Duración");
		textoDuracionLabel.setBounds(522,156,82,40);
		textoDuracionLabel.setFont(Constantes.SANS_SERIF_16_NEGRITA);
		textoDuracionLabel.setForeground(Constantes.NEGRO_CLARO);
		add(textoDuracionLabel);

		textoDescripcionLabel = new JLabel();
		textoDescripcionLabel.setText("Descripción");
		textoDescripcionLabel.setBounds(57,247,116,40);
		textoDescripcionLabel.setFont(Constantes.SANS_SERIF_16_NEGRITA);
		textoDescripcionLabel.setForeground(Constantes.NEGRO_CLARO);
		add(textoDescripcionLabel);

		textoInstructorLabel = new JLabel();
		textoInstructorLabel.setText("Instructor");
		textoInstructorLabel.setBounds(55,356,101,40);
		textoInstructorLabel.setFont(Constantes.SANS_SERIF_16_NEGRITA);
		textoInstructorLabel.setForeground(Constantes.NEGRO_CLARO);
		add(textoInstructorLabel);


		// JLabels de texto variable
		nombreActividadLabel = new JLabel();
		nombreActividadLabel.setText("");
		nombreActividadLabel.setBounds(173,38,374,62);
		nombreActividadLabel.setFont(Constantes.SANS_SERIF_34);
		nombreActividadLabel.setForeground(Constantes.NEGRO_CLARO);
		nombreActividadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(nombreActividadLabel);

		plazasDisponiblesLabel = new JLabel();
		plazasDisponiblesLabel.setText("");
		plazasDisponiblesLabel.setBounds(55,194,188,33);
		plazasDisponiblesLabel.setFont(Constantes.SANS_SERIF_14);
		plazasDisponiblesLabel.setForeground(Constantes.NEGRO_CLARO);
		add(plazasDisponiblesLabel);

		ubicacionLabel = new JLabel();
		ubicacionLabel.setText("");
		ubicacionLabel.setBounds(290,194,207,33);
		ubicacionLabel.setFont(Constantes.SANS_SERIF_14);
		ubicacionLabel.setForeground(Constantes.NEGRO_CLARO);
		add(ubicacionLabel);

		duracionLabel = new JLabel();
		duracionLabel.setText("60 minutos");
		duracionLabel.setBounds(522,194,116,33);
		duracionLabel.setFont(Constantes.SANS_SERIF_14);
		duracionLabel.setForeground(Constantes.NEGRO_CLARO);
		add(duracionLabel);

		descripcionLabel = new JLabel();
		descripcionLabel.setText("");
		descripcionLabel.setBounds(55,284,554,62);
		descripcionLabel.setFont(Constantes.SANS_SERIF_14);
		descripcionLabel.setForeground(Constantes.NEGRO_CLARO);
		descripcionLabel.setVerticalAlignment(SwingConstants.NORTH);
		add(descripcionLabel);

		instructorLabel = new JLabel();
		instructorLabel.setText("");
		instructorLabel.setBounds(55,395,260,33);
		instructorLabel.setFont(Constantes.SANS_SERIF_14);
		instructorLabel.setForeground(Constantes.NEGRO_CLARO);
		add(instructorLabel);

		// Boton
		inscribirseBtn = new JButton();
		inscribirseBtn.setBorderPainted(false);
		inscribirseBtn.setFocusPainted(false);
		inscribirseBtn.setBackground(Constantes.AZUL_OSCURO_CLARO);
		inscribirseBtn.setForeground(Constantes.BLANCO);
		inscribirseBtn.addActionListener(controladorDetalleActividad);
		inscribirseBtn.setFont(Constantes.SANS_SERIF_18);
		inscribirseBtn.setText("Inscribirse ahora");
		inscribirseBtn.setBounds(260,488,207,40);
		add(inscribirseBtn);

	}

	/**
	 * Getters
	 */
	public JButton getVolverLinkBtn() {
		return volverLinkBtn;
	}

	public JLabel getNombreActividadLabel() {
		return nombreActividadLabel;
	}

	public JLabel getPlazasDisponiblesLabel() {
		return plazasDisponiblesLabel;
	}

	public JLabel getUbicacionLabel() {
		return ubicacionLabel;
	}

	public JLabel getDuracionLabel() {
		return duracionLabel;
	}

	public JLabel getDescripcionLabel() {
		return descripcionLabel;
	}

	public JLabel getInstructorLabel() {
		return instructorLabel;
	}

	public JButton getInscribirseBtn() {
		return inscribirseBtn;
	}

	public ControladorDashboard getControladorDashboard() {
		return controladorDashboard;
	}

	public ControladorDetalleActividad getControladorDetalleActividad() {
		return controladorDetalleActividad;
	}
}
