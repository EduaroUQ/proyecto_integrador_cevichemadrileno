package com.cevichemadrileno.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.cevichemadrileno.controlador.ControladorActividades;
import com.cevichemadrileno.controlador.ControladorDashboard;
import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.util.Constantes;
import com.cevichemadrileno.util.DateUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

	/**
	 * Constructor
	 * @param controladorDashboard
	 */
	public PanelActividades(ControladorDashboard controladorDashboard) {
		inicializarComponentes();
		this.controladorDashboard = controladorDashboard;
	}

	/**
	 * Inicializa los componentes del panel
	 */
	private void inicializarComponentes() {
		setBackground(Constantes.GRIS);
		setSize(Constantes.ANCHURA_PANEL_DERECHO_DASHBOARD, Constantes.ALTURA_APLICACION);
		setLayout(null);

		controladorActividades = new ControladorActividades(this);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Actividades disponibles");
		tituloLabel.setBounds(173,41,374,62);
		tituloLabel.setFont(Constantes.SANS_SERIF_34);
		tituloLabel.setForeground(Constantes.NEGRO_CLARO);
		add(tituloLabel);


		actividadesTable = new JTable();
		actividadesTable.setTableHeader(null);
		actividadesTable.setFont(Constantes.SANS_SERIF_12);
		actividadesTable.setRowHeight(Constantes.ALTURA_FILAS_TABLA);
		actividadesTable.setShowGrid(false);
		actividadesTable.setBorder(null);

		// Crear escuchador de click en los botones de accion
		actividadesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = actividadesTable.rowAtPoint(e.getPoint());
				int column = actividadesTable.columnAtPoint(e.getPoint());
				if (column == 4) {
					Integer idActividad = (Integer) actividadesTable.getValueAt(row, 5);
					System.out.println("Ver más detalle de actividad con id: "+ idActividad);
					controladorDashboard.showPanel("detalleActividad", idActividad);
				}
			}
		});

		actividadesScrollPane = new JScrollPane(actividadesTable);
		actividadesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		actividadesScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		actividadesScrollPane.setBackground(Constantes.GRIS);
		actividadesScrollPane.setForeground(Constantes.GRIS);
		actividadesScrollPane.setBorder(BorderFactory.createEmptyBorder());
		actividadesScrollPane.setBounds(45,145,620,340);

		add(actividadesScrollPane);
	}


	/**
	 * Getters
	 */
	public ControladorActividades getControladorActividades() {
		return controladorActividades;
	}

	/**
	 * Actualiza las actividades de la tabla
	 * @param actividades
	 */
	public void actualizarTablaActividades(ArrayList<Actividad> actividades) {
		String[] columnas = {"Nombre", "Dia", "Horario", "Lugar", "Accion", "idActividad"};
		DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0){
			// Esto es para que la tabla no sea editable
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		}; 


		for (Actividad actividad : actividades) {
			if (actividad.getIdMonitor()!=Constantes.usuarioAutenticado.getId()) {
				Object[] row = {
						actividad.getNombre(),
						DateUtils.formatearFecha(actividad.getFecha()),
						DateUtils.obtenerHora(actividad.getFecha()),
						actividad.getSala().getTipoSala(),
						"Ver más",
						actividad.getId()
				};
				modeloTabla.addRow(row);
			}
		}

		actividadesTable.setModel(modeloTabla);
		// Ocultar la columna de idActividad
		actividadesTable.getColumnModel().getColumn(5).setMinWidth(0);
		actividadesTable.getColumnModel().getColumn(5).setMaxWidth(0);
		actividadesTable.getColumnModel().getColumn(5).setWidth(0);
		//Modificar ancho de la columna ver más
		actividadesTable.getColumnModel().getColumn(4).setPreferredWidth(10);
		actividadesScrollPane.setViewportView(actividadesTable);
		revalidate();
		repaint();
	}
}
