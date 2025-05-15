package com.cevichemadrileno.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cevichemadrileno.modelo.Usuario;
import com.cevichemadrileno.vista.PanelRegistro;

/**
 * Controlador del panel de registro
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ControladorRegistro implements ActionListener {
	private PanelRegistro vista;
	private AccesoBD accesoBD;
	
	/**
	 * Constructor
	 * @param vista
	 */
	public ControladorRegistro(PanelRegistro vista) {
		this.vista = vista;
		this.accesoBD = new AccesoBD();
	}

	/**
	 * Recibe los eventos de los botones
	 * @param e: evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getRegistroBtn()) {
			// Validar campos
			String nombreApellidos = vista.getNombreApellidosTextField().getText();
			String matricula = vista.getMatriculaTextField().getText();
			String ciclo = (String) vista.getCicloComboBox().getSelectedItem();
			String clave = new String(vista.getClaveTextField().getPassword());
			String confirmarClave = new String(vista.getConfirmarClaveTextField().getPassword());
			if (nombreApellidos.isEmpty()){
				vista.getErrorLabel().setText("Escribe tu nombre y apellidos");
				return;
			}
			if (matricula.isEmpty()){
				vista.getErrorLabel().setText("Escribe tu codigo de matricula");
				return;
			}
			if (clave.isEmpty()){
				vista.getErrorLabel().setText("Escribe tu contraseña");
				return;
			}
			if (confirmarClave.isEmpty()){
				vista.getErrorLabel().setText("Escribe tu contraseña de nuevo");
				return;
			}
			if (!clave.equals(confirmarClave)){
				vista.getErrorLabel().setText("Las contraseñas no coinciden");
				return;
			}
			if (accesoBD.existeUsuario(matricula)){
				vista.getErrorLabel().setText("Ya existe un usuario con esa matricula");
				return;
			}
			// Crear usuario
			Usuario nuevoUsuario = new Usuario();
			nuevoUsuario.setNombreApellidos(nombreApellidos);
			nuevoUsuario.setCiclo(ciclo);
			nuevoUsuario.setClave(clave);
			nuevoUsuario.setCodigoMatricula(matricula);
			nuevoUsuario.setEsMonitor(false);
			accesoBD.registrarUsuario(nuevoUsuario);

			vista.getControladorPrincipal().showPanel("login");
		}
		if (e.getSource() == vista.getVolverLinkBtn()) {
			vista.getControladorPrincipal().showPanel("login");
		}
	}

}
