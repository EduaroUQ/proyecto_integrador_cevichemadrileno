package com.cevichemadrileno.modelo;

/**
 * @author Hugo R.
 */
public class Usuario {
	private Integer id;
	private String codigoMatricula;
	private String clave;
	private Boolean esMonitor;
	private String nombreApellidos;
	private String ciclo;

	/**
	 * Constructor vacio de la clase
	 */
	public Usuario() {}

	/**
	 * Getters y Setters
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigoMatricula() {
		return codigoMatricula;
	}
	public void setCodigoMatricula(String codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Boolean getEsMonitor() {
		return esMonitor;
	}
	public void setEsMonitor(Boolean esMonitor) {
		this.esMonitor = esMonitor;
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
