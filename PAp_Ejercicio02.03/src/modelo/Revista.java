package modelo;

import java.util.List;

public class Revista {

	private String nombre;
	private String nEdicion;
	private String idioma;
	private List<Articulo> articulos;
	
	public Revista() {
		
	}
	
	public Revista(String nombre, String nEdicion, String idioma, List<Articulo> articulos) {
		super();
		this.nombre = nombre;
		this.nEdicion = nEdicion;
		this.idioma = idioma;
		this.articulos = articulos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getnEdicion() {
		return nEdicion;
	}

	public void setnEdicion(String nEdicion) {
		this.nEdicion = nEdicion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

}
