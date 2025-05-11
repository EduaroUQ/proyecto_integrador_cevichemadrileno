package com.cevichemadrileno.vista;

import javax.swing.*;

import com.cevichemadrileno.controlador.ControladorLogin;
import com.cevichemadrileno.controlador.ControladorPrincipal;
import com.cevichemadrileno.util.Constantes;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Panel del Login
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
	private JLabel errorLabel;
	private JButton registroLinkBtn;
	private JTextField usuarioTextField;
	private JPasswordField claveTextField;
	private JButton loginBtn;
	private ControladorLogin controladorLogin;
	private ControladorPrincipal controladorPrincipal;

	/**
	 * Constructor
	 * @param controladorPrincipal
	 */
	public PanelLogin(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		inicializarComponentes();
	}

	/**
	 * Inicializa los componentes del panel
	 */
	private void inicializarComponentes() {
		setBackground(Constantes.AZUL_OSCURO);
		setSize(Constantes.ANCHURA_APLICACION, Constantes.ALTURA_APLICACION);
		setLayout(null);
		
		controladorLogin = new ControladorLogin(this);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Inicio Sesión");
		tituloLabel.setBounds(314,83,198,62);
		tituloLabel.setFont(Constantes.SANS_SERIF_34);
		tituloLabel.setForeground(Constantes.BLANCO);
		add(tituloLabel);
		
		matriculaLabel = new JLabel();
		matriculaLabel.setText("Matricula");
		matriculaLabel.setBounds(247,162,74,40);
		matriculaLabel.setFont(Constantes.SANS_SERIF_18);
		matriculaLabel.setForeground(Constantes.BLANCO);
		add(matriculaLabel);
		
		claveLabel = new JLabel();
		claveLabel.setText("Contraseña");
		claveLabel.setBounds(247,253,108,40);
		claveLabel.setFont(Constantes.SANS_SERIF_18);
		claveLabel.setForeground(Constantes.BLANCO);
		add(claveLabel);
		
		registroInfoLabel = new JLabel();
		registroInfoLabel.setText("¿No tienes una cuenta?");
		registroInfoLabel.setBounds(247,349,198,40);
		registroInfoLabel.setFont(Constantes.SANS_SERIF_18);
		registroInfoLabel.setForeground(Constantes.BLANCO);
		add(registroInfoLabel);

		errorLabel = new JLabel();
		errorLabel.setText("");
		errorLabel.setBounds(247,399,344,40);
		errorLabel.setFont(Constantes.SANS_SERIF_18);
		errorLabel.setForeground(Constantes.ROJO);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(errorLabel);

		registroLinkBtn = new JButton();
		registroLinkBtn.setText("Registrate aquí");
		registroLinkBtn.setBounds(431,349,158,40);
		registroLinkBtn.setFont(Constantes.SANS_SERIF_18);
		registroLinkBtn.setForeground(Constantes.CELESTE_OSCURO);
		registroLinkBtn.setBackground(null);
		registroLinkBtn.setContentAreaFilled(false);
		registroLinkBtn.setBorderPainted(false);
		registroLinkBtn.setFocusPainted(false);
		registroLinkBtn.setOpaque(false);
		registroLinkBtn.addActionListener(controladorLogin);
		add(registroLinkBtn);
		
		usuarioTextField = new JTextField();
		usuarioTextField.setBounds(282, 205, 262, 25);
		usuarioTextField.setBackground(Constantes.AZUL_OSCURO_CLARO);
		usuarioTextField.setBorder(Constantes.BORDER_INPUT_ESTILO_2);
		usuarioTextField.setFont(Constantes.SANS_SERIF_16);
		usuarioTextField.setForeground(Constantes.BLANCO);
		usuarioTextField.setText("123");
		add(usuarioTextField);
	
		claveTextField = new JPasswordField();
		claveTextField.setBounds(282, 295, 262, 25);
		claveTextField.setBackground(Constantes.AZUL_OSCURO_CLARO);
		claveTextField.setBorder(Constantes.BORDER_INPUT_ESTILO_2);
		claveTextField.setFont(Constantes.SANS_SERIF_16);
		claveTextField.setForeground(Constantes.BLANCO);
		claveTextField.setText("123");
		add(claveTextField);
		
		loginBtn = new JButton();
		loginBtn.setBackground(Color.WHITE);
		loginBtn.setBorderPainted(false);
		loginBtn.setFocusPainted(false);
		loginBtn.addActionListener(controladorLogin);
		loginBtn.setFont(Constantes.SANS_SERIF_18);
		loginBtn.setText("Entrar");
		loginBtn.setBounds(334,449,158,40);
		add(loginBtn);
		
		// Colocar el logo de la aplicacion
		String rootFolder = System.getProperty("user.dir");
		Path imagePath = Paths.get(rootFolder, "img", "logo.png");
		ImageIcon originalIcon = new ImageIcon(imagePath.toString());
		Image scaledImage = originalIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		JLabel imageLabel = new JLabel(scaledIcon);
		imageLabel.setBounds(0,0,120, 120);
		
		add(imageLabel);
	}

	/**
	 * Getters
	 */
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
	public JLabel getErrorLabel() {return errorLabel;}
}
