package com.cevichemadrileno.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.cevichemadrileno.controlador.ControladorDashboard;
import com.cevichemadrileno.controlador.ControladorMisActividades;
import com.cevichemadrileno.modelo.*;
import com.cevichemadrileno.util.Constantes;

/**
 * Panel de Mis actividades
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class PanelMisActividades extends JPanel {
	private JLabel tituloLabel;
	private JLabel actividadesInscritasLabel;
	private JLabel actividadesCreadasLabel;
	private JScrollPane actividadesInscritasScrollPane;
	private JScrollPane actividadesCreadasScrollPane;
	private JTable actividadesInscritasTable;
	private JTable actividadesCreadasTable;
	private ControladorDashboard controladorDashboard;
	private ControladorMisActividades controladorMisActividades;

	public PanelMisActividades(ControladorDashboard controladorDashboard) {
		this.controladorDashboard = controladorDashboard;
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBackground(Constantes.GRIS);
		setSize(Constantes.ANCHURA_DASHBOARD, Constantes.ALTURA_APLICACION);
		setLayout(null);
		
		controladorMisActividades = new ControladorMisActividades(this);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Mis actividades");
		tituloLabel.setBounds(237,41,246,62);
		tituloLabel.setFont(Constantes.SANS_SERIF_34);
		tituloLabel.setForeground(Constantes.NEGRO_CLARO);
		add(tituloLabel);
		
		actividadesInscritasLabel = new JLabel();
		actividadesInscritasLabel.setText("Actividades inscritas");
		actividadesInscritasLabel.setBounds(35,95,195,40);
		actividadesInscritasLabel.setFont(Constantes.SANS_SERIF_16);
		actividadesInscritasLabel.setForeground(Constantes.NEGRO_CLARO);
		add(actividadesInscritasLabel);
		
		actividadesCreadasLabel = new JLabel();
		actividadesCreadasLabel.setText("Actividades creadas");
		actividadesCreadasLabel.setBounds(35,322,195,40);
		actividadesCreadasLabel.setFont(Constantes.SANS_SERIF_16);
		actividadesCreadasLabel.setForeground(Constantes.NEGRO_CLARO);
		add(actividadesCreadasLabel);

		// Crear tabla de actividades inscritas
		actividadesInscritasTable = new JTable(null);
		actividadesInscritasTable.setTableHeader(null);
		actividadesInscritasTable.setFont(Constantes.SANS_SERIF_18);
		actividadesInscritasTable.setRowHeight(Constantes.ALTURA_FILAS_TABLA);

		// Crear escuchador de click en los botones de accion
		actividadesInscritasTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = actividadesInscritasTable.rowAtPoint(e.getPoint());
				int column = actividadesInscritasTable.columnAtPoint(e.getPoint());
				if (column == 4) {
					Integer idActividad = (Integer) actividadesInscritasTable.getValueAt(row, 5);
					System.out.println("Desinscribirse de actividad: "+ idActividad);
					controladorMisActividades.desinscribirseDeActividad(idActividad);
					controladorMisActividades.cargarActividadesInscritas();
				}
			}
		});

		actividadesInscritasScrollPane = new JScrollPane(actividadesInscritasTable);
        actividadesInscritasScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        actividadesInscritasScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        actividadesInscritasScrollPane.setBackground(Constantes.GRIS);
        actividadesInscritasScrollPane.setForeground(Constantes.GRIS);
        actividadesInscritasScrollPane.setBorder(null);
        actividadesInscritasScrollPane.setBounds(45,145,620,140);
        
        add(actividadesInscritasScrollPane);


		// Crear tabla de actividades creadas
		actividadesCreadasTable = new JTable(null);
		actividadesCreadasTable.setTableHeader(null);
		actividadesCreadasTable.setFont(Constantes.SANS_SERIF_18);
		actividadesCreadasTable.setRowHeight(Constantes.ALTURA_FILAS_TABLA);
		// Crear escuchador de click en los botones de accion
		actividadesCreadasTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = actividadesCreadasTable.rowAtPoint(e.getPoint());
				int column = actividadesCreadasTable.columnAtPoint(e.getPoint());
				if (column == 4) {
					Integer idActividad = (Integer) actividadesCreadasTable.getValueAt(row, 6);
					System.out.println("Editar actividad con id: "+ idActividad);
					controladorDashboard.showPanel("editarActividad", idActividad);
				} else if (column == 5) {
					Integer idActividad = (Integer) actividadesCreadasTable.getValueAt(row, 6);
					System.out.println("Eliminar actividad con id: "+ idActividad);
					controladorMisActividades.eliminarActividad(idActividad);
					controladorMisActividades.cargarActividadesCreadas();
				}
			}
		});

		actividadesCreadasScrollPane = new JScrollPane(actividadesCreadasTable);
		actividadesCreadasScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		actividadesCreadasScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		actividadesCreadasScrollPane.setBackground(Constantes.GRIS);
		actividadesCreadasScrollPane.setForeground(Constantes.GRIS);
		actividadesCreadasScrollPane.setBorder(null);
		actividadesCreadasScrollPane.setBounds(45,366,620,140);

		add(actividadesInscritasScrollPane);
		add(actividadesCreadasScrollPane);
		
	}
	
	public static String obtenerDiaSemana(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE", new Locale("es", "ES"));
        return sdf.format(date);
    }
	
	public static String obtenerHora(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:", new Locale("es", "ES"));
        String dateStr = sdf.format(date) + "00 - " + sdf.format(date) + "00";
        return dateStr;
    }

	/**
	 * Getters
	 */
	public JLabel getTituloLabel() {
		return tituloLabel;
	}

	public JLabel getActividadesInscritasLabel() {
		return actividadesInscritasLabel;
	}

	public JLabel getActividadesCreadasLabel() {
		return actividadesCreadasLabel;
	}

	public JScrollPane getActividadesInscritasScrollPane() {
		return actividadesInscritasScrollPane;
	}

	public JScrollPane getActividadesCreadasScrollPane() {
		return actividadesCreadasScrollPane;
	}

	public JTable getActividadesInscritasTable() {
		return actividadesInscritasTable;
	}

	public JTable getActividadesCreadasTable() {
		return actividadesCreadasTable;
	}

	public ControladorDashboard getControladorDashboard() {
		return controladorDashboard;
	}

	public ControladorMisActividades getControladorMisActividades() {
		return controladorMisActividades;
	}

	public void actualizarTablaActividadesInscritas(ArrayList<Inscripcion> actividadesInscritas) {
		String[] columnas = {"Nombre", "Dia", "Hora", "Lugar", "Desinscribirse", "idActividad oculta"};
		DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0){
			// Esto es para que la tabla no sea editable
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Inscripcion inscripcion : actividadesInscritas) {
			Object[] row = {
					inscripcion.getActividad().getNombre(),
					obtenerDiaSemana(inscripcion.getActividad().getFecha()),
					obtenerHora(inscripcion.getActividad().getFecha()),
					inscripcion.getActividad().getSala().getTipoSala(),
					"🗑️",
					inscripcion.getIdActividad()
			};
			modeloTabla.addRow(row);
		}

		actividadesInscritasTable.setModel(modeloTabla);
		// Ocultar la columna de idActividad
		actividadesInscritasTable.getColumnModel().getColumn(5).setMinWidth(0);
		actividadesInscritasTable.getColumnModel().getColumn(5).setMaxWidth(0);
		actividadesInscritasTable.getColumnModel().getColumn(5).setWidth(0);

		actividadesInscritasScrollPane.setViewportView(actividadesInscritasTable);
		revalidate();
		repaint();
	}

	public void actualizarTablaActividadesCreadas(ArrayList<Actividad> actividadesCreadas){
		String[] columnas = {"Nombre", "Dia", "Horario", "Lugar", "Editar", "Eliminar", "idActividad oculta"};
		DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0){
			// Esto es para que la tabla no sea editable
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Actividad actividad : actividadesCreadas) {
			Object[] row = {
					actividad.getNombre(),
					obtenerDiaSemana(actividad.getFecha()),
					obtenerHora(actividad.getFecha()),
					actividad.getSala().getCodigoSala(),
					"✏️",
					"🗑️",
					actividad.getId()
			};
			modeloTabla.addRow(row);
		}

		actividadesCreadasTable.setModel(modeloTabla);
		// Ocultar la columna de idActividad
		actividadesCreadasTable.getColumnModel().getColumn(6).setMinWidth(0);
		actividadesCreadasTable.getColumnModel().getColumn(6).setMaxWidth(0);
		actividadesCreadasTable.getColumnModel().getColumn(6).setWidth(0);

		actividadesCreadasScrollPane.setViewportView(actividadesCreadasTable);
		revalidate();
		repaint();
	}
}
