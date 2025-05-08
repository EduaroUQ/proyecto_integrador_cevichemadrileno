package com.cevichemadrileno.vista;

import javax.swing.*;

import com.cevichemadrileno.controlador.ControladorPrincipal;
import com.cevichemadrileno.controlador.ControladorRegistro;
import com.cevichemadrileno.util.Constantes;
import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Panel de registro
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class PanelRegistro extends JPanel {
	private JLabel tituloLabel;
	private JLabel nombreApellidosLabel;
	private JLabel matriculaLabel;
	private JLabel cicloLabel;
	private JLabel claveLabel;
	private JLabel confirmarClaveLabel;
	private JLabel errorLabel;
	private JButton volverLinkBtn;
	private JTextField nombreApellidosTextField;
	private JTextField matriculaTextField;
	private JComboBox<String> cicloComboBox;
	private JPasswordField claveTextField;
	private JPasswordField confirmarClaveTextField;
	private JButton registroBtn;
	private JPanel sidebarPanel;
	private ControladorRegistro controladorRegistro;
	private ControladorPrincipal controladorPrincipal;
	
	public PanelRegistro(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBackground(Constantes.GRIS);
		setSize(Constantes.ANCHURA_APLICACION, Constantes.ALTURA_APLICACION);
		setLayout(null);
		
		controladorRegistro = new ControladorRegistro(this);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Crear Cuenta");
		tituloLabel.setBounds(358,41,214,62);
		tituloLabel.setFont(Constantes.SANS_SERIF_34);
		tituloLabel.setForeground(Constantes.NEGRO_CLARO);
		add(tituloLabel);
		
		
		nombreApellidosLabel = new JLabel();
		nombreApellidosLabel.setText("Nombre y apellidos");
		nombreApellidosLabel.setBounds(235,133,158,40);
		nombreApellidosLabel.setFont(Constantes.SANS_SERIF_18);
		nombreApellidosLabel.setForeground(Constantes.NEGRO_CLARO);
		add(nombreApellidosLabel);
		
		matriculaLabel = new JLabel();
		matriculaLabel.setText("Matricula");
		matriculaLabel.setBounds(235,183,74,40);
		matriculaLabel.setFont(Constantes.SANS_SERIF_18);
		matriculaLabel.setForeground(Constantes.NEGRO_CLARO);
		add(matriculaLabel);
		
		cicloLabel = new JLabel();
		cicloLabel.setText("Ciclo");
		cicloLabel.setBounds(235,229,74,40);
		cicloLabel.setFont(Constantes.SANS_SERIF_18);
		cicloLabel.setForeground(Constantes.NEGRO_CLARO);
		add(cicloLabel);
		
		claveLabel = new JLabel();
		claveLabel.setText("Contraseña");
		claveLabel.setBounds(235,270,108,40);
		claveLabel.setFont(Constantes.SANS_SERIF_18);
		claveLabel.setForeground(Constantes.NEGRO_CLARO);
		add(claveLabel);
		
		confirmarClaveLabel = new JLabel();
		confirmarClaveLabel.setText("Confirmar contraseña");
		confirmarClaveLabel.setBounds(235,320,191,40);
		confirmarClaveLabel.setFont(Constantes.SANS_SERIF_18);
		confirmarClaveLabel.setForeground(Constantes.NEGRO_CLARO);
		add(confirmarClaveLabel);

		errorLabel = new JLabel();
		errorLabel.setText("");
		errorLabel.setBounds(245, 370, 395, 40);
		errorLabel.setFont(Constantes.SANS_SERIF_18);
		errorLabel.setForeground(Constantes.ROJO);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(errorLabel);
		
		volverLinkBtn = new JButton();
		volverLinkBtn.setText("Volver");
		volverLinkBtn.setBounds(119,10,101,40);
		volverLinkBtn.setFont(Constantes.SANS_SERIF_18);
		volverLinkBtn.setForeground(Constantes.CELESTE_OSCURO);
		volverLinkBtn.setBackground(null);
		volverLinkBtn.setContentAreaFilled(false);
		volverLinkBtn.setBorderPainted(false);
		volverLinkBtn.setFocusPainted(false);
		volverLinkBtn.setOpaque(false);
		volverLinkBtn.addActionListener(controladorRegistro);
		add(volverLinkBtn);
		
		nombreApellidosTextField = new JTextField();
		nombreApellidosTextField.setBounds(431, 145, 185, 25);
		nombreApellidosTextField.setBackground(Constantes.GRIS);
		nombreApellidosTextField.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
		nombreApellidosTextField.setForeground(Constantes.NEGRO_CLARO);
		nombreApellidosTextField.setFont(Constantes.SANS_SERIF_16);
		add(nombreApellidosTextField);
		
		matriculaTextField = new JTextField();
		matriculaTextField.setBounds(431, 195, 185, 25);
		matriculaTextField.setBackground(Constantes.GRIS);
		matriculaTextField.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
		matriculaTextField.setForeground(Constantes.NEGRO_CLARO);
		matriculaTextField.setFont(Constantes.SANS_SERIF_16);
		add(matriculaTextField);
		

		cicloComboBox = new JComboBox<String>(Constantes.CICLOS);
		cicloComboBox.setBackground(Constantes.GRIS);
		cicloComboBox.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
		cicloComboBox.setFont(Constantes.SANS_SERIF_14);
		cicloComboBox.setForeground(Constantes.NEGRO_CLARO);
		cicloComboBox.setBounds(431, 240, 185, 25);
		cicloComboBox.setOpaque(false);
		add(cicloComboBox);
		
		claveTextField = new JPasswordField();
		claveTextField.setBounds(431, 282, 185, 25);
		claveTextField.setBackground(Constantes.GRIS);
		claveTextField.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
		claveTextField.setForeground(Constantes.NEGRO_CLARO);
		claveTextField.setFont(Constantes.SANS_SERIF_16);
		add(claveTextField);
		
		confirmarClaveTextField = new JPasswordField();
		confirmarClaveTextField.setBounds(431, 332, 185, 25);
		confirmarClaveTextField.setBackground(Constantes.GRIS);
		confirmarClaveTextField.setBorder(Constantes.BORDE_INPUT_ESTILO_1);
		confirmarClaveTextField.setForeground(Constantes.NEGRO_CLARO);
		confirmarClaveTextField.setFont(Constantes.SANS_SERIF_16);
		add(confirmarClaveTextField);
		
		
		registroBtn = new JButton();
		registroBtn.setBorderPainted(false);
		registroBtn.setFocusPainted(false);
		registroBtn.setBackground(Constantes.AZUL_OSCURO_CLARO);
		registroBtn.setForeground(Constantes.BLANCO);
		registroBtn.addActionListener(controladorRegistro);
		registroBtn.setFont(Constantes.SANS_SERIF_18);
		registroBtn.setText("Crear");
		registroBtn.setBounds(388,427,120,40);
		add(registroBtn);
		
		String rootFolder = System.getProperty("user.dir");
		Path imagePath = Paths.get(rootFolder, "img", "logo.png");
		ImageIcon originalIcon = new ImageIcon(imagePath.toString());
		Image scaledImage = originalIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		JLabel imageLabel = new JLabel(scaledIcon);
		imageLabel.setBounds(0,0,120, 120);
		add(imageLabel);
		
		sidebarPanel = new JPanel();
		sidebarPanel.setBackground(Constantes.AZUL_OSCURO);
		sidebarPanel.setBounds(0, 0, 120, 620);
		add(sidebarPanel);
		
	}

	/**
	 * Getters
	 */
	public JButton getVolverLinkBtn() {
		return volverLinkBtn;
	}
	public JButton getRegistroBtn() {
		return registroBtn;
	}
	public ControladorPrincipal getControladorPrincipal() {
		return controladorPrincipal;
	}

	public JTextField getNombreApellidosTextField() {
		return nombreApellidosTextField;
	}
	public JTextField getMatriculaTextField() {
		return matriculaTextField;
	}
	public JComboBox<String> getCicloComboBox() {
		return cicloComboBox;
	}
	public JPasswordField getClaveTextField() {
		return claveTextField;
	}
	public JPasswordField getConfirmarClaveTextField() {
		return confirmarClaveTextField;
	}
	public JLabel getErrorLabel() {
		return errorLabel;
	}

	
	
	
}
