package com.cevichemadrileno.vista;

import com.cevichemadrileno.controlador.ControladorDashboard;
import com.cevichemadrileno.controlador.ControladorMisActividades;
import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.modelo.Inscripcion;
import com.cevichemadrileno.util.Constantes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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

	/**
	 * Constructor
	 * @param controladorDashboard
	 */
	public PanelMisActividades(ControladorDashboard controladorDashboard) {
		this.controladorDashboard = controladorDashboard;
		inicializarComponentes();
	}

	/**
	 * Inicializa los componentes del panel
	 */
	private void inicializarComponentes() {
		setBackground(Constantes.GRIS);
		setSize(Constantes.ANCHURA_PANEL_DERECHO_DASHBOARD, Constantes.ALTURA_APLICACION);
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

		if (Constantes.usuarioAutenticado.getEsMonitor()){
			add(actividadesCreadasLabel);
		}

		// Crear tabla de actividades inscritas
		actividadesInscritasTable = new JTable(null);
		actividadesInscritasTable.setTableHeader(null);
		actividadesInscritasTable.setFont(Constantes.SANS_SERIF_12);
		actividadesInscritasTable.setRowHeight(Constantes.ALTURA_FILAS_TABLA);
		actividadesInscritasTable.setShowGrid(false);
		actividadesInscritasTable.setBorder(null);

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

		// Crear scroll pane para la tabla de actividades inscritas
		actividadesInscritasScrollPane = new JScrollPane(actividadesInscritasTable);
        actividadesInscritasScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        actividadesInscritasScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        actividadesInscritasScrollPane.setBackground(Constantes.GRIS);
        actividadesInscritasScrollPane.setForeground(Constantes.GRIS);
		actividadesInscritasScrollPane.setBorder(BorderFactory.createEmptyBorder());
		if (Constantes.usuarioAutenticado.getEsMonitor()){
			actividadesInscritasScrollPane.setBounds(45,145,620,140);
		} else{
			actividadesInscritasScrollPane.setBounds(45,145,620,340);
		}

        add(actividadesInscritasScrollPane);


		// Crear tabla de actividades creadas
		actividadesCreadasTable = new JTable(null);
		actividadesCreadasTable.setTableHeader(null);
		actividadesCreadasTable.setFont(Constantes.SANS_SERIF_12);
		actividadesCreadasTable.setRowHeight(Constantes.ALTURA_FILAS_TABLA);
		actividadesCreadasTable.setShowGrid(false);
		actividadesCreadasTable.setBorder(null);

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

		// Crear scroll pane para la tabla de actividades creadas
		actividadesCreadasScrollPane = new JScrollPane(actividadesCreadasTable);
		actividadesCreadasScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		actividadesCreadasScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		actividadesCreadasScrollPane.setBackground(Constantes.GRIS);
		actividadesCreadasScrollPane.setForeground(Constantes.GRIS);
		actividadesCreadasScrollPane.setBorder(BorderFactory.createEmptyBorder());
		actividadesCreadasScrollPane.setBounds(45,366,620,140);


		if (Constantes.usuarioAutenticado.getEsMonitor()){
			add(actividadesCreadasScrollPane);
		}
		
	}

	/**
	 * Obtiene el dia de la semana a partir de una fecha
	 *
	 * @param date
	 * @return string con el dia de la semana en uppercase y en español
	 */
	public static String obtenerDiaSemana(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE", new Locale("es", "ES"));
		String dia = sdf.format(date);
		return dia.substring(0, 1).toUpperCase() + dia.substring(1);
	}


	/**
	 * Obtiene la hora a partir de una fecha
	 *
	 * @param date
	 * @return string con la hora formateada en formato HH:MM - HH:MM
	 */
	public static String obtenerHora(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", new Locale("es", "ES"));
		int hora = Integer.parseInt(simpleDateFormat.format(date));
		return String.format("%02d:00", hora) + " - " + String.format("%02d:00", hora + 1);
	}



	/**
	 * Getters
	 */
	public ControladorMisActividades getControladorMisActividades() {
		return controladorMisActividades;
	}

	/**
	 * Actualiza el contenido de la tabla de actividades inscritas
	 *
	 * @param actividadesInscritas
	 */
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

	/**
	 * Actualiza el contenido de la tabla de actividades creadas
	 *
	 * @param actividadesCreadas
	 */
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
					actividad.getSala().getTipoSala(),
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
