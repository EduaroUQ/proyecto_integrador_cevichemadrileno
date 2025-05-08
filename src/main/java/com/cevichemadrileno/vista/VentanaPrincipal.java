package com.cevichemadrileno.vista;

import javax.swing.*;
import com.cevichemadrileno.controlador.ControladorPrincipal;
import com.cevichemadrileno.modelo.Usuario;
import com.cevichemadrileno.util.Constantes;

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

		scrollPane = new JScrollPane();
        scrollPane.setBounds(-1, 0, Constantes.ANCHURA_APLICACION, Constantes.ALTURA_APLICACION);
        
		getContentPane().add(scrollPane);
		
		// TODO: cambiar por "login" para prueba funcional
		controladorPrincipal.showPanel("login");
	}

	/**
	 * Hace visible la ventana
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * Cambia el panel del scrollPane
	 * @param panel
	 */
	public void cambiarPanel(JPanel panel) {
		scrollPane.setViewportView(panel);
	}
	
	
	
}
