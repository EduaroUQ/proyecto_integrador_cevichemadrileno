package vista;

import javax.swing.*;

import controlador.ControladorLogin;
import controlador.ControladorPrincipal;
import util.Constantes;
import java.awt.Color;
import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Panel de inicio de sesión
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class PanelLogin extends JPanel {
	private JLabel tituloLabel;
	private JLabel matriculaLabel;
	private JLabel claveLabel;
	private JLabel registroInfoLabel;
	private JButton registroLinkBtn;
	private JTextField usuarioTextField;
	private JPasswordField claveTextField;
	private JButton loginBtn;
	private ControladorLogin controladorLogin;
	private ControladorPrincipal controladorPrincipal;
	
	public PanelLogin(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBackground(Constantes.MAIN_COLOR);
		setSize(Constantes.APPLICATION_WIDTH, Constantes.APPLICATION_HEIGHT);
		setLayout(null);
		
		controladorLogin = new ControladorLogin(this);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Inicio Sesión");
		tituloLabel.setBounds(314,83,198,62);
		tituloLabel.setFont(Constantes.TEXT_FONT_34);
		tituloLabel.setForeground(Constantes.WHITE_COLOR);
		add(tituloLabel);
		
		matriculaLabel = new JLabel();
		matriculaLabel.setText("Matricula");
		matriculaLabel.setBounds(247,162,74,40);
		matriculaLabel.setFont(Constantes.TEXT_FONT_18);
		matriculaLabel.setForeground(Constantes.WHITE_COLOR);
		add(matriculaLabel);
		
		claveLabel = new JLabel();
		claveLabel.setText("Contraseña");
		claveLabel.setBounds(247,269,108,40);
		claveLabel.setFont(Constantes.TEXT_FONT_18);
		claveLabel.setForeground(Constantes.WHITE_COLOR);
		add(claveLabel);
		
		registroInfoLabel = new JLabel();
		registroInfoLabel.setText("¿No tienes una cuenta?");
		registroInfoLabel.setBounds(247,364,198,40);
		registroInfoLabel.setFont(Constantes.TEXT_FONT_18);
		registroInfoLabel.setForeground(Constantes.WHITE_COLOR);
		add(registroInfoLabel);
		
		registroLinkBtn = new JButton();
		registroLinkBtn.setText("Registrate aquí");
		registroLinkBtn.setBounds(431,364,158,40);
		registroLinkBtn.setFont(Constantes.TEXT_FONT_18);
		registroLinkBtn.setForeground(Constantes.TERTIARY_COLOR);
		registroLinkBtn.setBackground(null);
		registroLinkBtn.setContentAreaFilled(false);
		registroLinkBtn.setBorderPainted(false);
		registroLinkBtn.setFocusPainted(false);
		registroLinkBtn.setOpaque(false);
		registroLinkBtn.addActionListener(controladorLogin);
		add(registroLinkBtn);
		
		usuarioTextField = new JTextField();
		usuarioTextField.setBounds(282, 205, 262, 25);
		usuarioTextField.setBackground(Constantes.SECONDARY_COLOR);
		usuarioTextField.setBorder(Constantes.LOGIN_INPUT_FIELD_BORDER);
		usuarioTextField.setFont(Constantes.TEXT_FONT_16);
		usuarioTextField.setForeground(Constantes.WHITE_COLOR);
		add(usuarioTextField);
	
		claveTextField = new JPasswordField();
		claveTextField.setBounds(282, 311, 262, 25);
		claveTextField.setBackground(Constantes.SECONDARY_COLOR);
		claveTextField.setBorder(Constantes.LOGIN_INPUT_FIELD_BORDER);
		claveTextField.setFont(Constantes.TEXT_FONT_16);
		claveTextField.setForeground(Constantes.WHITE_COLOR);
		add(claveTextField);
		
		loginBtn = new JButton();
		loginBtn.setBackground(Color.WHITE);
		loginBtn.setBorderPainted(false);
		loginBtn.setFocusPainted(false);
		loginBtn.addActionListener(controladorLogin);
		loginBtn.setFont(Constantes.TEXT_FONT_18);
		loginBtn.setText("Entrar");
		loginBtn.setBounds(334,426,158,40);
		add(loginBtn);
		
		
		String rootFolder = System.getProperty("user.dir");
		Path imagePath = Paths.get(rootFolder, "img", "logo.png");
		ImageIcon originalIcon = new ImageIcon(imagePath.toString());
		Image scaledImage = originalIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		JLabel imageLabel = new JLabel(scaledIcon);
		imageLabel.setBounds(0,0,120, 120);
		
		add(imageLabel);
	}

	public JButton getRegistroLinkBtn() {
		return registroLinkBtn;
	}
	public JButton getLoginBtn() {
		return loginBtn;
	}
	public ControladorPrincipal getControladorPrincipal() {
		return controladorPrincipal;
	}
	public JTextField getUsuarioTextField() {
		return usuarioTextField;
	}
	public JPasswordField getClaveTextField() {
		return claveTextField;
	}
	

	
	
	
}
