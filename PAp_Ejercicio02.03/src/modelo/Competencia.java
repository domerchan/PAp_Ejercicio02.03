package modelo;

import java.util.List;

public class Competencia {

	private String nombre;
	private String categoria;
	private List<Atleta> atletas;
	
	public Competencia() {
		
	}

	public Competencia(String nombre, String categoria, List<Atleta> atletas) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.atletas = atletas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}

}
