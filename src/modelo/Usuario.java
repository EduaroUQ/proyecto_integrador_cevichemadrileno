package modelo;

/**
 * @author Hugo R.
 */
public class Usuario {
	private Integer id;
	private String codigoMatricula;
	private Boolean esMonitor;
	
	private UsuarioDescripcion usuarioDescripcion;

	/**
	 * Constructor de la clase
	 * @param id
	 * @param codigoMatricula
	 * @param esMonitor
	 * @param usuarioDescripcion
	 * @return instancia de Usuario
	 */
	public Usuario(Integer id, String codigoMatricula, Boolean esMonitor, UsuarioDescripcion usuarioDescripcion) {
		this.id = id;
		this.codigoMatricula = codigoMatricula;
		this.esMonitor = esMonitor;
		this.usuarioDescripcion = usuarioDescripcion;
	}

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
	public Boolean getEsMonitor() {
		return esMonitor;
	}
	public void setEsMonitor(Boolean esMonitor) {
		this.esMonitor = esMonitor;
	}
	public UsuarioDescripcion getUsuarioDescripcion() {
		return usuarioDescripcion;
	}
	public void setUsuarioDescripcion(UsuarioDescripcion usuarioDescripcion) {
		this.usuarioDescripcion = usuarioDescripcion;
	}
	
	
	
}
