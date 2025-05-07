package com.cevichemadrileno.vista;

import javax.swing.*;

import com.cevichemadrileno.util.Constantes;

/**
 * Panel de actividades
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class PanelActividades extends JPanel {
	private JLabel tituloLabel;
	
	public PanelActividades() {
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBackground(Constantes.GRIS);
		setSize(Constantes.ANCHURA_DASHBOARD, Constantes.ALTURA_APLICACION);
		setLayout(null);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Actividades disponibles");
		tituloLabel.setBounds(173,41,374,62);
		tituloLabel.setFont(Constantes.SANS_SERIF_34);
		tituloLabel.setForeground(Constantes.NEGRO_CLARO);
		add(tituloLabel);
		
		
	}

	/**
	 * Getters
	 */
	
	

	
	
	
}
