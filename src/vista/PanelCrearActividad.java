package vista;


import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;

import controlador.ControladorCrearActividad;
import modelo.Sala;
import modelo.SalaEspacio;
import util.Constantes;

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
		setBackground(Constantes.GRAY_COLOR);
		setSize(Constantes.DASHBOARD_WIDTH, Constantes.APPLICATION_HEIGHT);
		setLayout(null);
		
		controladorCrearActividad = new ControladorCrearActividad(this);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Crear Actividad");
		tituloLabel.setBounds(229,41,262,62);
		tituloLabel.setFont(Constantes.TEXT_FONT_34);
		tituloLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(tituloLabel);
		
		nombreLabel = new JLabel();
		nombreLabel.setText("Nombre");
		nombreLabel.setBounds(152,105,71,40);
		nombreLabel.setFont(Constantes.TEXT_FONT_18);
		nombreLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(nombreLabel);
		
		nombreTextField = new JTextField();
		nombreTextField.setBounds(259, 119, 247, 32);
		nombreTextField.setBackground(Constantes.GRAY_COLOR);
		nombreTextField.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
		nombreTextField.setForeground(Constantes.MAIN_TEXT_COLOR);
		nombreTextField.setFont(Constantes.TEXT_FONT_16);
		add(nombreTextField);
		
		fechaLabel = new JLabel();
		fechaLabel.setText("Fecha");
		fechaLabel.setBounds(156,156,71,40);
		fechaLabel.setFont(Constantes.TEXT_FONT_18);
		fechaLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(fechaLabel);
		
		horaLabel = new JLabel();
		horaLabel.setText("Hora");
		horaLabel.setBounds(172,208,50,40);
		horaLabel.setFont(Constantes.TEXT_FONT_18);
		horaLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(horaLabel);
		
		Calendar now = Calendar.getInstance();

        dayCombo = new JComboBox<>();
        dayCombo.setBounds(259, 173, 69, 26);
        dayCombo.setBackground(Constantes.GRAY_COLOR);
        dayCombo.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
        dayCombo.setFont(Constantes.TEXT_FONT_14);
        dayCombo.setForeground(Constantes.MAIN_TEXT_COLOR);
        dayCombo.setOpaque(false);
        for (int i = 1; i <= 31; i++) {
            dayCombo.addItem(String.format("%02d", i));
        }
        dayCombo.setSelectedItem(String.format("%02d", now.get(Calendar.DAY_OF_MONTH)));
        
        monthCombo = new JComboBox<>();
        monthCombo.setBounds(338, 173, 69, 26);
        monthCombo.setBackground(Constantes.GRAY_COLOR);
        monthCombo.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
        monthCombo.setFont(Constantes.TEXT_FONT_14);
        monthCombo.setForeground(Constantes.MAIN_TEXT_COLOR);
        for (int i = 1; i <= 12; i++) {
            monthCombo.addItem(String.format("%02d", i));
        }
        monthCombo.setSelectedItem(String.format("%02d", now.get(Calendar.MONTH) + 1));
        
        yearCombo = new JComboBox<>();
        yearCombo.setBounds(417, 173, 89, 26);
        yearCombo.setBackground(Constantes.GRAY_COLOR);
        yearCombo.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
        yearCombo.setFont(Constantes.TEXT_FONT_14);
        yearCombo.setForeground(Constantes.MAIN_TEXT_COLOR);
        for (int i = 2025; i <= 2026; i++) yearCombo.addItem(i);
        yearCombo.setSelectedItem(now.get(Calendar.YEAR));

        hourCombo = new JComboBox<>();
        hourCombo.setBounds(259, 216, 148, 26);
        hourCombo.setBackground(Constantes.GRAY_COLOR);
        hourCombo.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
        hourCombo.setFont(Constantes.TEXT_FONT_14);
        hourCombo.setForeground(Constantes.MAIN_TEXT_COLOR);
        for (int i = 9; i <= 20; i++) hourCombo.addItem(String.format("%02d", i) + ":00 - " + String.format("%02d", i+1) + ":00");
        hourCombo.setSelectedItem(now.get(Calendar.HOUR_OF_DAY));


        add(dayCombo);
        add(monthCombo);
        add(yearCombo);
        add(hourCombo);
        
		
		lugarLabel = new JLabel();
		lugarLabel.setText("Lugar");
		lugarLabel.setBounds(165,262,62,40);
		lugarLabel.setFont(Constantes.TEXT_FONT_18);
		lugarLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(lugarLabel);
        
        lugarCombo = new JComboBox<>();
        lugarCombo.setBounds(259, 270, 247, 26);
        lugarCombo.setBackground(Constantes.GRAY_COLOR);
        lugarCombo.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
        lugarCombo.setFont(Constantes.TEXT_FONT_14);
        lugarCombo.setForeground(Constantes.MAIN_TEXT_COLOR);
        for (Sala sala : salas) {
            lugarCombo.addItem(sala.getCodigoSala());
		}
        lugarCombo.setSelectedIndex(0);
        add(lugarCombo);
        
        
        nroMaximoInscritosLabel = new JLabel();
        nroMaximoInscritosLabel.setText("Máximo de inscritos");
        nroMaximoInscritosLabel.setBounds(62,312,161,40);
        nroMaximoInscritosLabel.setFont(Constantes.TEXT_FONT_18);
        nroMaximoInscritosLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
        add(nroMaximoInscritosLabel);
        
        nroMaximoInscritosCombo = new JComboBox<Integer>();
        nroMaximoInscritosCombo.setBounds(259, 320, 69, 26);
        nroMaximoInscritosCombo.setBackground(Constantes.GRAY_COLOR);
        nroMaximoInscritosCombo.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
        nroMaximoInscritosCombo.setFont(Constantes.TEXT_FONT_14);
        nroMaximoInscritosCombo.setForeground(Constantes.MAIN_TEXT_COLOR);
        for (int i = 1; i <= 10; i++) nroMaximoInscritosCombo.addItem(i);
        add(nroMaximoInscritosCombo);
		

        descripcionLabel = new JLabel();
        descripcionLabel.setText("Descripción");
        descripcionLabel.setBounds(122,358,106,40);
        descripcionLabel.setFont(Constantes.TEXT_FONT_18);
        descripcionLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
        add(descripcionLabel);
        
        descripcionTextArea = new JTextArea();
        descripcionTextArea.setBounds(129,402,403,76);
        descripcionTextArea.setBackground(Constantes.GRAY_COLOR);
        descripcionTextArea.setBorder(null);
		descripcionTextArea.setForeground(Constantes.MAIN_TEXT_COLOR);
		descripcionTextArea.setFont(Constantes.TEXT_FONT_16);
		descripcionTextArea.setWrapStyleWord(true);
		descripcionTextArea.setLineWrap(true);

        descripcionScrollPane = new JScrollPane(descripcionTextArea);
        descripcionScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        descripcionScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        descripcionScrollPane.setBackground(Constantes.GRAY_COLOR);
        descripcionScrollPane.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
        descripcionScrollPane.setForeground(Constantes.MAIN_TEXT_COLOR);
        descripcionScrollPane.setBounds(129,402,403,76);
        add(descripcionScrollPane);
        
		crearBtn = new JButton();
		crearBtn.setBorderPainted(false);
		crearBtn.setFocusPainted(false);
		crearBtn.setBackground(Constantes.SECONDARY_COLOR);
		crearBtn.setForeground(Constantes.WHITE_COLOR);
		crearBtn.addActionListener(controladorCrearActividad);
		crearBtn.setFont(Constantes.TEXT_FONT_18);
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
