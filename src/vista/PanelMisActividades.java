package vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorMisActividades;
import modelo.Actividad;
import modelo.ActividadDescripcion;
import modelo.Inscripcion;
import modelo.Sala;
import modelo.SalaEspacio;
import modelo.Usuario;
import modelo.UsuarioDescripcion;
import util.Constantes;

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
	private JTable actividadesInscritasTable;
	private ControladorMisActividades controladorMisActividades;
	private ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
	
	public PanelMisActividades() {
		// datos de prueba
		Usuario usuario = new Usuario(1, "ZZZZ", true, new UsuarioDescripcion("ZZZZ", "Hugo",  "DAW"));
		Actividad actividad = new Actividad(1, 1, 1, "Baile", new Date(), new ActividadDescripcion("Baile", "bailar", 10));
		Sala sala = new Sala(1, "B312", new SalaEspacio("B312", 10, "Salon de clase"));
		Inscripcion inscripcion = new Inscripcion(1, 1, usuario, actividad);
		inscripciones.add(inscripcion);
		
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBackground(Constantes.GRAY_COLOR);
		setSize(Constantes.DASHBOARD_WIDTH, Constantes.APPLICATION_HEIGHT);
		setLayout(null);
		
		controladorMisActividades = new ControladorMisActividades(this);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Mis actividades");
		tituloLabel.setBounds(237,41,246,62);
		tituloLabel.setFont(Constantes.TEXT_FONT_34);
		tituloLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(tituloLabel);
		
		actividadesInscritasLabel = new JLabel();
		actividadesInscritasLabel.setText("Actividades inscritas");
		actividadesInscritasLabel.setBounds(35,95,195,40);
		actividadesInscritasLabel.setFont(Constantes.TEXT_FONT_16);
		actividadesInscritasLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(actividadesInscritasLabel);
		
		actividadesCreadasLabel = new JLabel();
		actividadesCreadasLabel.setText("Actividades creadas");
		actividadesCreadasLabel.setBounds(35,319,195,40);
		actividadesCreadasLabel.setFont(Constantes.TEXT_FONT_16);
		actividadesCreadasLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(actividadesCreadasLabel);
		
		actividadesInscritasTable = new JTable(null);
		String[] columnas = {"Nombre", "Curso", "Fecha"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        for (Inscripcion ins : inscripciones) {
            Object[] row = {ins.getActividad().getNombre(), obtenerDiaSemana(ins.getActividad().getFecha()), obtenerHora(ins.getActividad().getFecha()) };
            modeloTabla.addRow(row);
        }

        JTable table = new JTable(modeloTabla);
        table.setTableHeader(null); 
		actividadesInscritasScrollPanel = new JScrollPane(table);
        actividadesInscritasScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        actividadesInscritasScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        actividadesInscritasScrollPanel.setBackground(Constantes.GRAY_COLOR);
        actividadesInscritasScrollPanel.setForeground(Constantes.GRAY_COLOR);
        actividadesInscritasScrollPanel.setBorder(null);
        actividadesInscritasScrollPanel.setBounds(45,145,620,160);
        
        add(actividadesInscritasScrollPanel);
        
		
		
	}
	
	public static String obtenerDiaSemana(Date date) {
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE", new Locale("es", "ES"));
        return sdf.format(date);
    }
	
	public static String obtenerHora(Date date) {
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:", new Locale("es", "ES"));
        String dateStr = sdf.format(date) + "00 - " + sdf.format(date) + "00";
        return dateStr;
    }

	/**
	 * Getters
	 */
	

	
	
	
}
