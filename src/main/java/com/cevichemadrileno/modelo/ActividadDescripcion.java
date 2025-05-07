package com.cevichemadrileno.modelo;

/**
 * Entidad ActividadDescripcion
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class ActividadDescripcion {
	private String nombre;
	private String descripcion;
	private Integer nroMaximoInscritos;
	
	
	/**
	 * Constructor de la clase
	 * @param nombre
	 * @param descripcion
	 * @param nroMaximoInscritos
	 * @return instancia de ActividadDescripcion
	 */
	public ActividadDescripcion(String nombre, String descripcion, Integer nroMaximoInscritos) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nroMaximoInscritos = nroMaximoInscritos;
	}
	
	/**
	 * Constructor vacio de la clase
	 */
	public ActividadDescripcion() {}
	
	/**
	 * Getters y Setters
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getNroMaximoInscritos() {
		return nroMaximoInscritos;
	}
	public void setNroMaximoInscritos(Integer nroMaximoInscritos) {
		this.nroMaximoInscritos = nroMaximoInscritos;
	}
	
	
}
