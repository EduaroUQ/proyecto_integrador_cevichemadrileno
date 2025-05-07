package com.cevichemadrileno.modelo;

import java.util.Date;

/**
 * Entidad Actividad
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class Actividad {
	private Integer id;
	private Integer idMonitor;
	private Integer idSala;
	private String nombre;
	private Date fecha;
	
	private ActividadDescripcion actividadDescripcion;

	/**
	 * 	 * Constructor de la clase
	 * @param id
	 * @param idMonitor
	 * @param idSala
	 * @param nombre
	 * @param fecha
	 * @param actividadDescripcion
	 * @return instancia de Actividad
	 */
	public Actividad(Integer id, Integer idMonitor, Integer idSala, String nombre, Date fecha,
			ActividadDescripcion actividadDescripcion) {
		this.id = id;
		this.idMonitor = idMonitor;
		this.idSala = idSala;
		this.nombre = nombre;
		this.fecha = fecha;
		this.actividadDescripcion = actividadDescripcion;
	}
	
	/**
	 * Constructor vacio de la clase
	 */
	public Actividad() {}


	/**
	 * Getters y Setters
	 */
	public Integer getId() {
		return id;
	}
	public Integer getIdMonitor() {
		return idMonitor;
	}
	public Integer getIdSala() {
		return idSala;
	}
	public String getNombre() {
		return nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public ActividadDescripcion getActividadDescripcion() {
		return actividadDescripcion;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIdMonitor(Integer idMonitor) {
		this.idMonitor = idMonitor;
	}
	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setActividadDescripcion(ActividadDescripcion actividadDescripcion) {
		this.actividadDescripcion = actividadDescripcion;
	}

	

	
	
	
}
