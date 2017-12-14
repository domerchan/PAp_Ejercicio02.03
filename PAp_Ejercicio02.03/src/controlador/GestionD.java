package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Atleta;
import modelo.Competencia;
import modelo.Resultado;

public class GestionD {

	private List<Competencia> competencias;
	private List<Atleta> atletasA;
	private List<Atleta> atletasB;
	private String pathD = "src/archivos/D.txt";

	public GestionD() {
		competencias = new ArrayList<Competencia>();
		atletasA = new ArrayList<Atleta>();
		atletasB = new ArrayList<Atleta>();

		addCompetencia();
	}

	public void addResultado(String tInicial, String tFinal) {
		try {
			Resultado resultado = new Resultado();
			resultado.settInicial(tInicial);
			resultado.settFinal(tFinal);

			FileWriter file = new FileWriter(pathD, true);
			BufferedWriter out = new BufferedWriter(file);
			String registro = resultado.gettInicial() + " , " + resultado.gettFinal();
			out.append(registro + "\n");
			out.close();
			file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}

	public void addAtleta(String nombre, String apellido, String cedula, String codigo, String inicio, String fin,
			String competencia) {
		try {
			Atleta atleta = new Atleta();
			atleta.setNombre(nombre);
			atleta.setApellido(apellido);
			atleta.setCedula(cedula);
			atleta.setCodigo(codigo);
			Resultado resultado = new Resultado();
			resultado.settInicial(inicio);
			resultado.settFinal(fin);
			atleta.setResultado(resultado);
			if (competencias.get(0).getNombre().equals(competencia))
				atletasA.add(atleta);
			else if (competencias.get(1).getNombre().equals(competencia))
				atletasB.add(atleta);
			FileWriter file = new FileWriter(pathD, true);
			BufferedWriter out = new BufferedWriter(file);
			String registro = atleta.getNombre() + " , " + atleta.getApellido() + " , " + atleta.getCedula() + " , "
					+ atleta.getCodigo() + " , " + atleta.getResultado();
			out.append(registro + "\n");
			out.close();
			file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}

	public void saveCompetencia(Competencia competencia) throws IOException {
		FileWriter file = new FileWriter(pathD, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = competencia.getNombre() + " , " + competencia.getCategoria() + " , "
				+ competencia.getAtletas();
		out.append(registro + "\n");
		out.close();
		file.close();
	}

	public void addCompetencia() {
		try {
			Competencia competencia = new Competencia();
			competencia.setNombre("Atletismo");
			competencia.setCategoria("Velocidad");
			competencia.setAtletas(atletasA);
			competencias.add(competencia);

			saveCompetencia(competencia);

			competencia = new Competencia();
			competencia.setNombre("Baloncesto");
			competencia.setCategoria("Juvenil");
			competencia.setAtletas(atletasB);
			competencias.add(competencia);

			saveCompetencia(competencia);

		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}

	public List<Atleta> listAtletas(String competencia) {
		if (competencias.get(0).getNombre().equals(competencia))
			return atletasA;
		else if (competencias.get(1).getNombre().equals(competencia))
			return atletasB;
		return null;
	}

	public String[] getCompetencias() {
		String[] lista = new String[competencias.size()];
		for (int i = 0; i < competencias.size(); i++)
			lista[i] = competencias.get(i).getNombre();
		return lista;
	}

	public boolean isCedulaValida(String cedula) throws Exception {
		try {
			int a = Integer.parseInt(cedula);
		} catch (NumberFormatException e) {
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if (cedula.length() != 10)
			throw new Exception("Debe ser de 10 dígitos");

		return true;
	}

	public boolean duplicadosCompetencias(String nombre, String categoria) {
		for (int i = 0; i < competencias.size(); i++) {
			if (competencias.get(i).getNombre().equals(nombre)
					&& competencias.get(i).getCategoria().equals(categoria)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * public boolean duplicadosAtletas(String nombre, String codigo) { for (int
	 * i = 0; i < atletas.size(); i++) { if
	 * (atletas.get(i).getNombre().equals(nombre) &&
	 * atletas.get(i).getCodigo().equals(codigo)) { return true; } } return
	 * false; }
	 */
}
