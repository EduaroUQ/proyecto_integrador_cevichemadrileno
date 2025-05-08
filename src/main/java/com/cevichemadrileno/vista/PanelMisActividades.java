package com.cevichemadrileno.vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
	private JScrollPane actividadesInscritasScrollPanel;
	private JScrollPane actividadesCreadasScrollPanel;
	private JTable actividadesInscritasTable;
	private JTable actividadesCreadasTable;
	private ControladorMisActividades controladorMisActividades;
	private ArrayList<Inscripcion> actividadesInscritas = new ArrayList<Inscripcion>();
	private ArrayList<Actividad> actividadesCreadas = new ArrayList<Actividad>();

	public PanelMisActividades() {
		// datos de prueba
		Actividad actividad = new Actividad(1, 1, 1, "Baile", "bailar", 10, new Date());
		Sala sala = new Sala(1, "B312", 10, "Salon de clase");
		actividad.setSala(sala);
		Inscripcion inscripcion = new Inscripcion(1, 1, Constantes.usuarioAutenticado, actividad);

		actividadesCreadas.add(actividad);
		actividadesInscritas.add(inscripcion);
		
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
		String[] columnas = {"Nombre", "Curso", "Fecha"};
        DefaultTableModel modeloTabla1 = new DefaultTableModel(columnas, 0);

        for (Inscripcion ins : actividadesInscritas) {
            Object[] row = {ins.getActividad().getNombre(), obtenerDiaSemana(ins.getActividad().getFecha()), obtenerHora(ins.getActividad().getFecha()) };
			modeloTabla1.addRow(row);
        }

		actividadesInscritasTable = new JTable(modeloTabla1);
		actividadesInscritasTable.setTableHeader(null);
		actividadesInscritasScrollPanel = new JScrollPane(actividadesInscritasTable);
        actividadesInscritasScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        actividadesInscritasScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        actividadesInscritasScrollPanel.setBackground(Constantes.GRIS);
        actividadesInscritasScrollPanel.setForeground(Constantes.GRIS);
        actividadesInscritasScrollPanel.setBorder(null);
        actividadesInscritasScrollPanel.setBounds(45,145,620,140);
        
        add(actividadesInscritasScrollPanel);


		// Crear tabla de actividades creadas
		actividadesCreadasTable = new JTable(null);
		String[] columnas2 = {"Nombre", "Dia", "Hora", "Lugar", "Accion"};
		DefaultTableModel modeloTabla2 = new DefaultTableModel(columnas2, 0);

		for (Actividad actividad : actividadesCreadas) {
			Object[] row = {actividad.getNombre(), obtenerDiaSemana(actividad.getFecha()), obtenerHora(actividad.getFecha()), actividad.getSala().getCodigoSala(), "Eliminar" };
			modeloTabla2.addRow(row);
		}

		actividadesCreadasTable = new JTable(modeloTabla2);
		actividadesCreadasTable.setTableHeader(null);
		actividadesCreadasScrollPanel = new JScrollPane(actividadesCreadasTable);
		actividadesCreadasScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		actividadesCreadasScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		actividadesCreadasScrollPanel.setBackground(Constantes.GRIS);
		actividadesCreadasScrollPanel.setForeground(Constantes.GRIS);
		actividadesCreadasScrollPanel.setBorder(null);
		actividadesCreadasScrollPanel.setBounds(45,366,620,140);

		add(actividadesInscritasScrollPanel);
		add(actividadesCreadasScrollPanel);
		
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
	

	
	
	
}
