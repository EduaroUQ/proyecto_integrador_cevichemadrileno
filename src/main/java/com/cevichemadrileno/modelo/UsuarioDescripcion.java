package com.cevichemadrileno.modelo;

/**
 * @author Hugo R.
 */
public class UsuarioDescripcion {
	private String codigoMatricula;
	private String nombreApellidos;
	private String ciclo;
	
	
	/**
	 * Constructor de la clase
	 * @param codigoMatricula
	 * @param nombreApellidos
	 * @param ciclo
	 * @return instancia de UsuarioDescripcion
	 */
	public UsuarioDescripcion(String codigoMatricula, String nombreApellidos, String ciclo) {
		this.codigoMatricula = codigoMatricula;
		this.nombreApellidos = nombreApellidos;
		this.ciclo = ciclo;
	}
	
	/**
	 * Constructor vacio de la clase
	 */
	public UsuarioDescripcion() {}
	
	/**
	 * Getters y Setters
	 */
	public String getCodigoMatricula() {
		return codigoMatricula;
	}
	public void setCodigoMatricula(String codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}
	public String getNombreApellidos() {
		return nombreApellidos;
	}
	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	
	
}
