package vista;

import java.io.DataOutputStream;

import javax.swing.*;

import modelo.Usuario;
import modelo.UsuarioDescripcion;
import util.Constantes;

/**
 * Panel de Mi Perfil
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class PanelMiPerfil extends JPanel {
	private JLabel tituloLabel;
	private JLabel nombreApellidosLabel;
	private JLabel matriculaLabel;
	private JLabel cicloLabel;
	
	private JLabel nombreApellidosValueLabel;
	private JLabel matriculaValueLabel;
	private JLabel cicloValueLabel;
	
	private Usuario usuario;
	
	public PanelMiPerfil() {
		this.usuario = new Usuario(1, "123456A", true, new UsuarioDescripcion("123456A", "Hugo Rubio Crespo", "DAW"));
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBackground(Constantes.GRAY_COLOR);
		setSize(Constantes.DASHBOARD_WIDTH, Constantes.APPLICATION_HEIGHT);
		setLayout(null);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Mi perfil");
		tituloLabel.setBounds(278,41,163,62);
		tituloLabel.setFont(Constantes.TEXT_FONT_34);
		tituloLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(tituloLabel);
		
		nombreApellidosLabel = new JLabel();
		nombreApellidosLabel.setText("Nombre y Apellidos");
		nombreApellidosLabel.setBounds(58,130,188,40);
		nombreApellidosLabel.setFont(Constantes.FONT_BOLD_18);
		nombreApellidosLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(nombreApellidosLabel);
		
		matriculaLabel = new JLabel();
		matriculaLabel.setText("Matrícula");
		matriculaLabel.setBounds(58,217,128,40);
		matriculaLabel.setFont(Constantes.FONT_BOLD_18);
		matriculaLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(matriculaLabel);
		
		cicloLabel = new JLabel();
		cicloLabel.setText("Ciclo");
		cicloLabel.setBounds(58,305,74,40);
		cicloLabel.setFont(Constantes.FONT_BOLD_18);
		cicloLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(cicloLabel);
		
		nombreApellidosValueLabel = new JLabel();
		nombreApellidosValueLabel.setText(usuario.getUsuarioDescripcion().getNombreApellidos());
		nombreApellidosValueLabel.setBounds(86,167,188,40);
		nombreApellidosValueLabel.setFont(Constantes.TEXT_FONT_16);
		nombreApellidosValueLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(nombreApellidosValueLabel);
	
		matriculaValueLabel = new JLabel();
		matriculaValueLabel.setText(usuario.getCodigoMatricula());
		matriculaValueLabel.setBounds(86,255,128,40);
		matriculaValueLabel.setFont(Constantes.TEXT_FONT_16);
		matriculaValueLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(matriculaValueLabel);
		
		cicloValueLabel = new JLabel();
		cicloValueLabel.setText(usuario.getUsuarioDescripcion().getCiclo());
		cicloValueLabel.setBounds(86,339,74,40);
		cicloValueLabel.setFont(Constantes.TEXT_FONT_16);
		cicloValueLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(cicloValueLabel);
	}

	/**
	 * Getters
	 */
	

	
	
	
}
