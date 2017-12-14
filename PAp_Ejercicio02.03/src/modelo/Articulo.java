package modelo;

public class Articulo {

	private String titulo;
	private String resumen;
	private String pInicio;
	private String pFinal;

	private Autor autor;

	
	public Articulo() {
		
	}

	public Articulo(String titulo, String resumen, String pInicio, String pFinal, Autor autor) {
		super();
		this.titulo = titulo;
		this.resumen = resumen;
		this.pInicio = pInicio;
		this.pFinal = pFinal;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getpInicio() {
		return pInicio;
	}

	public void setpInicio(String pInicio) {
		this.pInicio = pInicio;
	}

	public String getpFinal() {
		return pFinal;
	}

	public void setpFinal(String pFinal) {
		this.pFinal = pFinal;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
}
