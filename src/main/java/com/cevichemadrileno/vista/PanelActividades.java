package com.cevichemadrileno.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.cevichemadrileno.controlador.ControladorActividades;
import com.cevichemadrileno.controlador.ControladorCrearActividad;
import com.cevichemadrileno.controlador.ControladorDashboard;
import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.util.Constantes;

import java.util.ArrayList;

import static com.cevichemadrileno.vista.PanelMisActividades.obtenerDiaSemana;
import static com.cevichemadrileno.vista.PanelMisActividades.obtenerHora;

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
	private JScrollPane actividadesScrollPane;
	private JTable actividadesTable;
	private ControladorDashboard controladorDashboard;
	private ControladorActividades controladorActividades;
	
	public PanelActividades(ControladorDashboard controladorDashboard) {
		inicializarComponentes();
		this.controladorDashboard = controladorDashboard;
	}

	private void inicializarComponentes() {
		setBackground(Constantes.GRIS);
		setSize(Constantes.ANCHURA_DASHBOARD, Constantes.ALTURA_APLICACION);
		setLayout(null);

		controladorActividades = new ControladorActividades(this);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Actividades disponibles");
		tituloLabel.setBounds(173,41,374,62);
		tituloLabel.setFont(Constantes.SANS_SERIF_34);
		tituloLabel.setForeground(Constantes.NEGRO_CLARO);
		add(tituloLabel);


		actividadesTable = new JTable();
		actividadesScrollPane = new JScrollPane(actividadesTable);
		actividadesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		actividadesScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		actividadesScrollPane.setBackground(Constantes.GRIS);
		actividadesScrollPane.setForeground(Constantes.GRIS);
		actividadesScrollPane.setBorder(null);
		actividadesScrollPane.setBounds(45,145,620,183);

		add(actividadesScrollPane);
	}


	/**
	 * Getters
	 */
	public JLabel getTituloLabel() {
		return tituloLabel;
	}

	public JScrollPane getActividadesScrollPane() {
		return actividadesScrollPane;
	}

	public JTable getActividadesTable() {
		return actividadesTable;
	}

	public ControladorDashboard getControladorDashboard() {
		return controladorDashboard;
	}

	public ControladorActividades getControladorActividades() {
		return controladorActividades;
	}

	/**
	 * Actualiza las actividades de la tabla
	 * @param actividades
	 */
	public void actualizarTablaActividades(ArrayList<Actividad> actividades) {
		String[] columnas = {"Nombre", "Dia", "Horario", "Lugar", "Accion"};
		DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

		for (Actividad actividad : actividades) {
			Object[] row = {
					actividad.getNombre(),
					obtenerDiaSemana(actividad.getFecha()),
					obtenerHora(actividad.getFecha()),
					actividad.getSala().getCodigoSala(),
					"Ver más"
			};
			modeloTabla.addRow(row);
		}

		actividadesTable.setModel(modeloTabla);
		actividadesScrollPane.setViewportView(actividadesTable);
		revalidate();
		repaint();
	}
}
