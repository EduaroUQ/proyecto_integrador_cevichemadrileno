package com.cevichemadrileno.vista;


import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;

import com.cevichemadrileno.controlador.ControladorCrearActividad;
import com.cevichemadrileno.modelo.Sala;
import com.cevichemadrileno.modelo.SalaEspacio;
import com.cevichemadrileno.util.Constantes;

/**
 * Panel de crear actividad
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class PanelCrearActividad extends JPanel {
	private JLabel tituloLabel;
	
	private JLabel nombreLabel;
	private JLabel fechaLabel;
	private JLabel horaLabel;
	private JLabel lugarLabel;
	private JLabel nroMaximoInscritosLabel;
	private JLabel descripcionLabel;
	
	private JTextField nombreTextField;
	private JComboBox<String> dayCombo;
	private JComboBox<String> monthCombo;
	private JComboBox<Integer> yearCombo;
	private JComboBox<String> hourCombo;
	private JComboBox<String> minuteCombo;
	
	private JComboBox<String> lugarCombo;
	private JComboBox<Integer> nroMaximoInscritosCombo;
	private JScrollPane descripcionScrollPane;
	private JTextArea descripcionTextArea;
	
	private ArrayList<Sala> salas = new ArrayList<Sala>();

	private JButton crearBtn;
	private ControladorCrearActividad controladorCrearActividad;
	
	public PanelCrearActividad() {
		salas.add(new Sala(1, "D101", new SalaEspacio("D101", 10, "sala de maquinas")));
		salas.add(new Sala(2, "E302", new SalaEspacio("E302", 10, "sala de maquinas")));
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBackground(Constantes.GRIS);
		setSize(Constantes.ANCHURA_DASHBOARD, Constantes.ALTURA_APLICACION);
		setLayout(null);
		
		controladorCrearActividad = new ControladorCrearActividad(this);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Crear Actividad");
		tituloLabel.setBounds(229,41,262,62);
		tituloLabel.setFont(Constantes.SANS_SERIF_34);
		tituloLabel.setForeground(Constantes.NEGRO_CLARO);
		add(tituloLabel);
		
		nombreLabel = new JLabel();
		nombreLabel.setText("Nombre");
		nombreLabel.setBounds(152,105,71,40);
		nombreLabel.setFont(Constantes.SANS_SERIF_18);
		nombreLabel.setForeground(Constantes.NEGRO_CLARO);
		add(nombreLabel);
		
		nombreTextField = new JTextField();
		nombreTextField.setBounds(259, 119, 247, 32);
		nombreTextField.setBackground(Constantes.GRIS);
		nombreTextField.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
		nombreTextField.setForeground(Constantes.NEGRO_CLARO);
		nombreTextField.setFont(Constantes.SANS_SERIF_16);
		add(nombreTextField);
		
		fechaLabel = new JLabel();
		fechaLabel.setText("Fecha");
		fechaLabel.setBounds(156,156,71,40);
		fechaLabel.setFont(Constantes.SANS_SERIF_18);
		fechaLabel.setForeground(Constantes.NEGRO_CLARO);
		add(fechaLabel);
		
		horaLabel = new JLabel();
		horaLabel.setText("Hora");
		horaLabel.setBounds(172,208,50,40);
		horaLabel.setFont(Constantes.SANS_SERIF_18);
		horaLabel.setForeground(Constantes.NEGRO_CLARO);
		add(horaLabel);
		
		Calendar now = Calendar.getInstance();

        dayCombo = new JComboBox<>();
        dayCombo.setBounds(259, 173, 69, 26);
        dayCombo.setBackground(Constantes.GRIS);
        dayCombo.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
        dayCombo.setFont(Constantes.SANS_SERIF_14);
        dayCombo.setForeground(Constantes.NEGRO_CLARO);
        dayCombo.setOpaque(false);
        for (int i = 1; i <= 31; i++) {
            dayCombo.addItem(String.format("%02d", i));
        }
        dayCombo.setSelectedItem(String.format("%02d", now.get(Calendar.DAY_OF_MONTH)));
        
        monthCombo = new JComboBox<>();
        monthCombo.setBounds(338, 173, 69, 26);
        monthCombo.setBackground(Constantes.GRIS);
        monthCombo.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
        monthCombo.setFont(Constantes.SANS_SERIF_14);
        monthCombo.setForeground(Constantes.NEGRO_CLARO);
        for (int i = 1; i <= 12; i++) {
            monthCombo.addItem(String.format("%02d", i));
        }
        monthCombo.setSelectedItem(String.format("%02d", now.get(Calendar.MONTH) + 1));
        
        yearCombo = new JComboBox<>();
        yearCombo.setBounds(417, 173, 89, 26);
        yearCombo.setBackground(Constantes.GRIS);
        yearCombo.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
        yearCombo.setFont(Constantes.SANS_SERIF_14);
        yearCombo.setForeground(Constantes.NEGRO_CLARO);
        for (int i = 2025; i <= 2026; i++) yearCombo.addItem(i);
        yearCombo.setSelectedItem(now.get(Calendar.YEAR));

        hourCombo = new JComboBox<>();
        hourCombo.setBounds(259, 216, 148, 26);
        hourCombo.setBackground(Constantes.GRIS);
        hourCombo.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
        hourCombo.setFont(Constantes.SANS_SERIF_14);
        hourCombo.setForeground(Constantes.NEGRO_CLARO);
        for (int i = 9; i <= 20; i++) hourCombo.addItem(String.format("%02d", i) + ":00 - " + String.format("%02d", i+1) + ":00");
        hourCombo.setSelectedItem(now.get(Calendar.HOUR_OF_DAY));


        add(dayCombo);
        add(monthCombo);
        add(yearCombo);
        add(hourCombo);
        
		
		lugarLabel = new JLabel();
		lugarLabel.setText("Lugar");
		lugarLabel.setBounds(165,262,62,40);
		lugarLabel.setFont(Constantes.SANS_SERIF_18);
		lugarLabel.setForeground(Constantes.NEGRO_CLARO);
		add(lugarLabel);
        
        lugarCombo = new JComboBox<>();
        lugarCombo.setBounds(259, 270, 247, 26);
        lugarCombo.setBackground(Constantes.GRIS);
        lugarCombo.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
        lugarCombo.setFont(Constantes.SANS_SERIF_14);
        lugarCombo.setForeground(Constantes.NEGRO_CLARO);
        for (Sala sala : salas) {
            lugarCombo.addItem(sala.getCodigoSala());
		}
        lugarCombo.setSelectedIndex(0);
        add(lugarCombo);
        
        
        nroMaximoInscritosLabel = new JLabel();
        nroMaximoInscritosLabel.setText("Máximo de inscritos");
        nroMaximoInscritosLabel.setBounds(62,312,161,40);
        nroMaximoInscritosLabel.setFont(Constantes.SANS_SERIF_18);
        nroMaximoInscritosLabel.setForeground(Constantes.NEGRO_CLARO);
        add(nroMaximoInscritosLabel);
        
        nroMaximoInscritosCombo = new JComboBox<Integer>();
        nroMaximoInscritosCombo.setBounds(259, 320, 69, 26);
        nroMaximoInscritosCombo.setBackground(Constantes.GRIS);
        nroMaximoInscritosCombo.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
        nroMaximoInscritosCombo.setFont(Constantes.SANS_SERIF_14);
        nroMaximoInscritosCombo.setForeground(Constantes.NEGRO_CLARO);
        for (int i = 1; i <= 10; i++) nroMaximoInscritosCombo.addItem(i);
        add(nroMaximoInscritosCombo);
		

        descripcionLabel = new JLabel();
        descripcionLabel.setText("Descripción");
        descripcionLabel.setBounds(122,358,106,40);
        descripcionLabel.setFont(Constantes.SANS_SERIF_18);
        descripcionLabel.setForeground(Constantes.NEGRO_CLARO);
        add(descripcionLabel);
        
        descripcionTextArea = new JTextArea();
        descripcionTextArea.setBounds(129,402,403,76);
        descripcionTextArea.setBackground(Constantes.GRIS);
        descripcionTextArea.setBorder(null);
		descripcionTextArea.setForeground(Constantes.NEGRO_CLARO);
		descripcionTextArea.setFont(Constantes.SANS_SERIF_16);
		descripcionTextArea.setWrapStyleWord(true);
		descripcionTextArea.setLineWrap(true);

        descripcionScrollPane = new JScrollPane(descripcionTextArea);
        descripcionScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        descripcionScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        descripcionScrollPane.setBackground(Constantes.GRIS);
        descripcionScrollPane.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
        descripcionScrollPane.setForeground(Constantes.NEGRO_CLARO);
        descripcionScrollPane.setBounds(129,402,403,76);
        add(descripcionScrollPane);
        
		crearBtn = new JButton();
		crearBtn.setBorderPainted(false);
		crearBtn.setFocusPainted(false);
		crearBtn.setBackground(Constantes.AZUL_OSCURO_CLARO);
		crearBtn.setForeground(Constantes.BLANCO);
		crearBtn.addActionListener(controladorCrearActividad);
		crearBtn.setFont(Constantes.SANS_SERIF_18);
		crearBtn.setText("Crear");
		crearBtn.setBounds(300,515,120,32);
		add(crearBtn);
	}



	/**
	 * Getters
	 */
	public JButton getCrearBtn() {
		return crearBtn;
	}
	

	
	
	
}
