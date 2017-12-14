package modelo;

public class Resultado {

	private String tInicial;
	private String tFinal;
	
	public Resultado() {
		
	}

	public Resultado(String tInicial, String tFinal) {
		super();
		this.tInicial = tInicial;
		this.tFinal = tFinal;
	}

	public String gettInicial() {
		return tInicial;
	}

	public void settInicial(String tInicial) {
		this.tInicial = tInicial;
	}

	public String gettFinal() {
		return tFinal;
	}

	public void settFinal(String tFinal) {
		this.tFinal = tFinal;
	}
	
}
