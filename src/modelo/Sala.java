package modelo;

/**
 * @author Hugo R.
 */
public class Sala {
	private Integer id;
	private String codigoSala;
	
	private SalaEspacio salaEspacio;

	/**
	 * Constructor de la clase
	 * @param id
	 * @param codigoSala
	 * @param salaEspacio
	 * @return instancia de Sala
	 */
	public Sala(Integer id, String codigoSala, SalaEspacio salaEspacio) {
		this.id = id;
		this.codigoSala = codigoSala;
		this.salaEspacio = salaEspacio;
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
	public SalaEspacio getSalaEspacio() {
		return salaEspacio;
	}
	public void setSalaEspacio(SalaEspacio salaEspacio) {
		this.salaEspacio = salaEspacio;
	}
	
}	
