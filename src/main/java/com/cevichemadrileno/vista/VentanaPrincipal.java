package com.cevichemadrileno.vista;

import javax.swing.*;
import com.cevichemadrileno.controlador.ControladorPrincipal;
import com.cevichemadrileno.modelo.Usuario;
import com.cevichemadrileno.util.Constantes;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Vista principal
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	private ControladorPrincipal controladorPrincipal;
	private JScrollPane scrollPane;

	/**
	 * Constructor de la ventana principal
	 */
	public VentanaPrincipal() {
		super(Constantes.TITULO_APLICACION);
		inicializarComponentes();
	}

	/**
	 * Constructor de la ventana principal
	 */
	private void inicializarComponentes() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(Constantes.ANCHURA_APLICACION, Constantes.ALTURA_APLICACION);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		controladorPrincipal = new ControladorPrincipal(this);

		// Cambiar el icono de la ventana
		String rootFolder = System.getProperty("user.dir");
		Path imagePath = Paths.get(rootFolder, "img", "logo.png");
		ImageIcon originalIcon = new ImageIcon(imagePath.toString());
		setIconImage(originalIcon.getImage());


		scrollPane = new JScrollPane();
        scrollPane.setBounds(-1, 0, Constantes.ANCHURA_APLICACION, Constantes.ALTURA_APLICACION);
        
		getContentPane().add(scrollPane);

		controladorPrincipal.showPanel("login");
	}

	/**
	 * Hace visible la ventana
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * Getters
	 */
	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}
	
	
	
}
