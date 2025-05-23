package com.cevichemadrileno.modelo;

/**
 * @author Hugo R.
 */
public class Sala {
	private Integer id;
	private String codigoSala;
	private Integer capacidad;
	private String tipoSala;

	/**
	 * Constructor de la clase
	 * @param id
	 * @param capacidad
	 * @param codigoSala
	 * @param tipoSala
	 */
	public Sala( Integer id, String codigoSala, Integer capacidad,String tipoSala) {
		this.id = id;
		this.capacidad = capacidad;
		this.codigoSala = codigoSala;
		this.tipoSala = tipoSala;
	}

	/**
	 * Constructor vacio de la clase
	 */
	public Sala() {}


	/**
	 * Getters y Setters
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigoSala() {
		return codigoSala;
	}
	public void setCodigoSala(String codigoSala) {
		this.codigoSala = codigoSala;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public String getTipoSala() {
		return tipoSala;
	}
	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}
}
