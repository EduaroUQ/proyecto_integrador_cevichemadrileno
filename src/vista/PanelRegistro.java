package vista;

import javax.swing.*;

import controlador.ControladorPrincipal;
import controlador.ControladorRegistro;
import util.Constantes;
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
		setBackground(Constantes.GRAY_COLOR);
		setSize(Constantes.APPLICATION_WIDTH, Constantes.APPLICATION_HEIGHT);
		setLayout(null);
		
		controladorRegistro = new ControladorRegistro(this);
		
		tituloLabel = new JLabel();
		tituloLabel.setText("Crear Cuenta");
		tituloLabel.setBounds(358,41,214,62);
		tituloLabel.setFont(Constantes.TEXT_FONT_34);
		tituloLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(tituloLabel);
		
		
		nombreApellidosLabel = new JLabel();
		nombreApellidosLabel.setText("Nombre y apellidos");
		nombreApellidosLabel.setBounds(235,133,158,40);
		nombreApellidosLabel.setFont(Constantes.TEXT_FONT_18);
		nombreApellidosLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(nombreApellidosLabel);
		
		matriculaLabel = new JLabel();
		matriculaLabel.setText("Matricula");
		matriculaLabel.setBounds(235,183,74,40);
		matriculaLabel.setFont(Constantes.TEXT_FONT_18);
		matriculaLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(matriculaLabel);
		
		cicloLabel = new JLabel();
		cicloLabel.setText("Ciclo");
		cicloLabel.setBounds(235,229,74,40);
		cicloLabel.setFont(Constantes.TEXT_FONT_18);
		cicloLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(cicloLabel);
		
		claveLabel = new JLabel();
		claveLabel.setText("Contraseña");
		claveLabel.setBounds(235,270,108,40);
		claveLabel.setFont(Constantes.TEXT_FONT_18);
		claveLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(claveLabel);
		
		confirmarClaveLabel = new JLabel();
		confirmarClaveLabel.setText("Confirmar contraseña");
		confirmarClaveLabel.setBounds(235,320,191,40);
		confirmarClaveLabel.setFont(Constantes.TEXT_FONT_18);
		confirmarClaveLabel.setForeground(Constantes.MAIN_TEXT_COLOR);
		add(confirmarClaveLabel);
		
		volverLinkBtn = new JButton();
		volverLinkBtn.setText("Volver");
		volverLinkBtn.setBounds(119,10,101,40);
		volverLinkBtn.setFont(Constantes.TEXT_FONT_18);
		volverLinkBtn.setForeground(Constantes.TERTIARY_COLOR);
		volverLinkBtn.setBackground(null);
		volverLinkBtn.setContentAreaFilled(false);
		volverLinkBtn.setBorderPainted(false);
		volverLinkBtn.setFocusPainted(false);
		volverLinkBtn.setOpaque(false);
		volverLinkBtn.addActionListener(controladorRegistro);
		add(volverLinkBtn);
		
		nombreApellidosTextField = new JTextField();
		nombreApellidosTextField.setBounds(431, 145, 185, 25);
		nombreApellidosTextField.setBackground(Constantes.GRAY_COLOR);
		nombreApellidosTextField.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
		nombreApellidosTextField.setForeground(Constantes.MAIN_TEXT_COLOR);
		nombreApellidosTextField.setFont(Constantes.TEXT_FONT_16);
		add(nombreApellidosTextField);
		
		matriculaTextField = new JTextField();
		matriculaTextField.setBounds(431, 195, 185, 25);
		matriculaTextField.setBackground(Constantes.GRAY_COLOR);
		matriculaTextField.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
		matriculaTextField.setForeground(Constantes.MAIN_TEXT_COLOR);
		matriculaTextField.setFont(Constantes.TEXT_FONT_16);
		add(matriculaTextField);
		

		cicloComboBox = new JComboBox<String>(Constantes.CICLOS);
		cicloComboBox.setBackground(Constantes.GRAY_COLOR);
		cicloComboBox.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
		cicloComboBox.setFont(Constantes.TEXT_FONT_14);
		cicloComboBox.setForeground(Constantes.MAIN_TEXT_COLOR);
		cicloComboBox.setBounds(431, 240, 185, 25);
		cicloComboBox.setOpaque(false);
		add(cicloComboBox);
		
		claveTextField = new JPasswordField();
		claveTextField.setBounds(431, 282, 185, 25);
		claveTextField.setBackground(Constantes.GRAY_COLOR);
		claveTextField.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
		claveTextField.setForeground(Constantes.MAIN_TEXT_COLOR);
		claveTextField.setFont(Constantes.TEXT_FONT_16);
		add(claveTextField);
		
		confirmarClaveTextField = new JPasswordField();
		confirmarClaveTextField.setBounds(431, 332, 185, 25);
		confirmarClaveTextField.setBackground(Constantes.GRAY_COLOR);
		confirmarClaveTextField.setBorder(Constantes.INPUT_FIELD_DEFAULT_BORDER);
		confirmarClaveTextField.setForeground(Constantes.MAIN_TEXT_COLOR);
		confirmarClaveTextField.setFont(Constantes.TEXT_FONT_16);
		add(confirmarClaveTextField);
		
		
		registroBtn = new JButton();
		registroBtn.setBorderPainted(false);
		registroBtn.setFocusPainted(false);
		registroBtn.setBackground(Constantes.SECONDARY_COLOR);
		registroBtn.setForeground(Constantes.WHITE_COLOR);
		registroBtn.addActionListener(controladorRegistro);
		registroBtn.setFont(Constantes.TEXT_FONT_18);
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
		sidebarPanel.setBackground(Constantes.MAIN_COLOR);
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

	
	
	
}
