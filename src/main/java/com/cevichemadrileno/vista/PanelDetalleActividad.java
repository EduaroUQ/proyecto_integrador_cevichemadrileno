package com.cevichemadrileno.vista;

import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.util.Constantes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import static com.cevichemadrileno.vista.PanelMisActividades.obtenerDiaSemana;
import static com.cevichemadrileno.vista.PanelMisActividades.obtenerHora;

/**
 * Panel de detalle de actividad
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class PanelDetalleActividad extends JPanel {
	private JLabel nombreActividadLabel;

	public PanelDetalleActividad() {
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBackground(Constantes.GRIS);
		setSize(Constantes.ANCHURA_DASHBOARD, Constantes.ALTURA_APLICACION);
		setLayout(null);
		
		nombreActividadLabel = new JLabel();
		nombreActividadLabel.setText("");
		nombreActividadLabel.setBounds(173,41,374,62);
		nombreActividadLabel.setFont(Constantes.SANS_SERIF_34);
		nombreActividadLabel.setForeground(Constantes.NEGRO_CLARO);
		nombreActividadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(nombreActividadLabel);

	}

	/**
	 * Getters
	 */
	
	

	
	
	
}
