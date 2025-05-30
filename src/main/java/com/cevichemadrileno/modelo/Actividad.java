package com.cevichemadrileno.modelo;


import java.sql.Timestamp;

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
	private String descripcion;
	private Integer nroMaximoInscritos;
	private Timestamp fecha;

	private Sala sala;
	private Usuario monitor;
	private Integer nroPlazasDisponibles;

	/**
	 * Constructor de la clase
	 * @param id
	 * @param idMonitor
	 * @param idSala
	 * @param nombre
	 * @param descripcion
	 * @param nroMaximoInscritos
	 * @param fecha
	 */
	public Actividad(Integer id, Integer idMonitor, Integer idSala, String nombre, String descripcion, Integer nroMaximoInscritos, Timestamp fecha, Sala sala) {
		this.id = id;
		this.idMonitor = idMonitor;
		this.idSala = idSala;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nroMaximoInscritos = nroMaximoInscritos;
		this.fecha = fecha;
		this.sala = sala;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdMonitor() {
		return idMonitor;
	}

	public void setIdMonitor(Integer idMonitor) {
		this.idMonitor = idMonitor;
	}

	public Integer getIdSala() {
		return idSala;
	}

	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}

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

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Usuario getMonitor() {
		return monitor;
	}

	public void setMonitor(Usuario monitor) {
		this.monitor = monitor;
	}

	public Integer getNroPlazasDisponibles() {
		return nroPlazasDisponibles;
	}

	public void setNroPlazasDisponibles(Integer nroPlazasDisponibles) {
		this.nroPlazasDisponibles = nroPlazasDisponibles;
	}
}
