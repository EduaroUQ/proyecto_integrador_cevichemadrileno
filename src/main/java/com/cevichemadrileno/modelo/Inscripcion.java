package com.cevichemadrileno.modelo;

/**
 * @author Hugo R.
 */
public class Inscripcion {
	private Integer idUsuario;
	private Integer idActividad;
	
	private Usuario usuario;
	private Actividad actividad;
	
	
	/**
	 * Constructor de la clase
	 * @param idUsuario
	 * @param idActividad
	 * @param usuario
	 * @param actividad
	 * @return instancia de Inscripcion
	 */
	public Inscripcion(Integer idUsuario, Integer idActividad, Usuario usuario, Actividad actividad) {
		this.idUsuario = idUsuario;
		this.idActividad = idActividad;
		this.usuario = usuario;
		this.actividad = actividad;
	}

	/**
	 * Constructor vacio de la clase
	 */
	public Inscripcion() {}
	

	/**
	 * Getters y Setters
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public Integer getIdActividad() {
		return idActividad;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Actividad getActividad() {
		return actividad;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	
	
}
