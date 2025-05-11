package com.cevichemadrileno.vista;

import javax.swing.*;

import com.cevichemadrileno.controlador.ControladorDashboard;
import com.cevichemadrileno.util.Constantes;

/**
 * Panel de Mi Perfil
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class PanelMiPerfil extends JPanel {
	private JLabel tituloLabel;
	private JLabel nombreApellidosLabel;
	private JLabel matriculaLabel;
	private JLabel cicloLabel;
	
	private JLabel nombreApellidosValueLabel;
	private JLabel matriculaValueLabel;
	private JLabel cicloValueLabel;

	private ControladorDashboard controladorDashboard;

	/**
	 * Constructor
	 * @param controladorDashboard
	 */
	public PanelMiPerfil(ControladorDashboard controladorDashboard) {
		inicializarComponentes();
		this.controladorDashboard = controladorDashboard;
	}

	/**
	 * Inicializa los componentes del panel
	 */
	private void inicializarComponentes() {
		setBackground(Constantes.GRIS);
		setSize(Constantes.ANCHURA_DASHBOARD, Constantes.ALTURA_APLICACION);
		setLayout(null);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Mi perfil");
		tituloLabel.setBounds(278,41,163,62);
		tituloLabel.setFont(Constantes.SANS_SERIF_34);
		tituloLabel.setForeground(Constantes.NEGRO_CLARO);
		add(tituloLabel);
		
		nombreApellidosLabel = new JLabel();
		nombreApellidosLabel.setText("Nombre y Apellidos");
		nombreApellidosLabel.setBounds(58,130,188,40);
		nombreApellidosLabel.setFont(Constantes.SANS_SERIF_18_NEGRITA);
		nombreApellidosLabel.setForeground(Constantes.NEGRO_CLARO);
		add(nombreApellidosLabel);
		
		matriculaLabel = new JLabel();
		matriculaLabel.setText("Matrícula");
		matriculaLabel.setBounds(58,217,128,40);
		matriculaLabel.setFont(Constantes.SANS_SERIF_18_NEGRITA);
		matriculaLabel.setForeground(Constantes.NEGRO_CLARO);
		add(matriculaLabel);
		
		cicloLabel = new JLabel();
		cicloLabel.setText("Ciclo");
		cicloLabel.setBounds(58,305,74,40);
		cicloLabel.setFont(Constantes.SANS_SERIF_18_NEGRITA);
		cicloLabel.setForeground(Constantes.NEGRO_CLARO);
		add(cicloLabel);
		
		nombreApellidosValueLabel = new JLabel();
		nombreApellidosValueLabel.setText(Constantes.usuarioAutenticado.getNombreApellidos());
		nombreApellidosValueLabel.setBounds(86,167,188,40);
		nombreApellidosValueLabel.setFont(Constantes.SANS_SERIF_16);
		nombreApellidosValueLabel.setForeground(Constantes.NEGRO_CLARO);
		add(nombreApellidosValueLabel);
	
		matriculaValueLabel = new JLabel();
		matriculaValueLabel.setText(Constantes.usuarioAutenticado.getCodigoMatricula());
		matriculaValueLabel.setBounds(86,255,128,40);
		matriculaValueLabel.setFont(Constantes.SANS_SERIF_16);
		matriculaValueLabel.setForeground(Constantes.NEGRO_CLARO);
		add(matriculaValueLabel);
		
		cicloValueLabel = new JLabel();
		cicloValueLabel.setText(Constantes.usuarioAutenticado.getCiclo());
		cicloValueLabel.setBounds(86,339,74,40);
		cicloValueLabel.setFont(Constantes.SANS_SERIF_16);
		cicloValueLabel.setForeground(Constantes.NEGRO_CLARO);
		add(cicloValueLabel);
	}

}
