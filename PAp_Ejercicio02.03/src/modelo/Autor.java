package modelo;

public class Autor extends Persona {
	private String seudonimo;
	private String nacionalidad;
	
	public Autor() {
		
	}
	
	public Autor(String nombre, String apellido, String cedula, String seudonimo, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.seudonimo = seudonimo;
		this.nacionalidad = nacionalidad;
	}
	
	public String getSeudonimo() {
		return seudonimo;
	}

	public void setSeudonimo(String seudonimo) {
		this.seudonimo = seudonimo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
}
