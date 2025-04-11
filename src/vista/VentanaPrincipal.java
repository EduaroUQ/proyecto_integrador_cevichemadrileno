package vista;

import javax.swing.*;
import controlador.ControladorPrincipal;
import util.Constantes;

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
	
	public VentanaPrincipal() {
		super(Constantes.APPLICATION_TITLE);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(Constantes.APPLICATION_WIDTH, Constantes.APPLICATION_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		controladorPrincipal = new ControladorPrincipal(this);

		scrollPane = new JScrollPane();
        scrollPane.setBounds(-1, 0, Constantes.APPLICATION_WIDTH, Constantes.APPLICATION_HEIGHT);
        
		getContentPane().add(scrollPane);
		
		// TODO: cambiar por "login" para prueba funcional
		controladorPrincipal.showPanel("login");
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	public void cambiarPanel(JPanel panel) {
		scrollPane.setViewportView(panel);
	}
	
	
	
}
