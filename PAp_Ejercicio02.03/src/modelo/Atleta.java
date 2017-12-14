package modelo;

public class Atleta extends Persona {

	private String codigo;
	private Resultado resultado;
	
	public Atleta() {
		
	}

	public Atleta(String codigo, Resultado resultado) {
		super();
		this.codigo = codigo;
		this.resultado = resultado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
}
