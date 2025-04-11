package modelo;

/**
 * @author Hugo R.
 */
public class SalaEspacio {
	private String codigoSala;
	private Integer capacidad;
	private String tipoSala;
	

	/**
	 * Constructor de la clase
	 * @param codigoSala
	 * @param capacidad
	 * @param tipoSala
	 * @return instancia de SalaEspacio
	 */
	public SalaEspacio(String codigoSala, Integer capacidad, String tipoSala) {
		this.codigoSala = codigoSala;
		this.capacidad = capacidad;
		this.tipoSala = tipoSala;
	}

	/**
	 * Constructor vacio de la clase
	 */
	public SalaEspacio() {}


	/**
	 * Getters y Setters
	 */
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
