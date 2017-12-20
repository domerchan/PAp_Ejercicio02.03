package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import modelo.Atleta;
import modelo.Competencia;
import modelo.Resultado;

public class GestionD {
	
	//DOMENICA

	private List<Competencia> competencias;
	private List<Atleta> atletasAJ;
	private List<Atleta> atletasAS;
	private List<Atleta> atletasBJ;
	private List<Atleta> atletasBS;
	private String pathD = "src/archivos/D.txt";
	private RandomAccessFile file;

	public GestionD() throws IOException {
		competencias = new ArrayList<Competencia>();
		atletasAJ = new ArrayList<Atleta>();
		atletasBJ = new ArrayList<Atleta>();
		atletasAS = new ArrayList<Atleta>();
		atletasBS = new ArrayList<Atleta>();

		addCompetencia();
	}
	
	public void newRegistro(String nombre, String apellido, String cedula, String codigo, String tinicial,
			String tfinal, String cnombre, String categoria) throws IOException {
		try {
			Atleta atleta = new Atleta();
			Resultado resultado = new Resultado();
			Competencia competencia = searchCompetencia(cnombre, categoria);
			competencias.add(competencia);

			resultado.settInicial(tinicial);
			resultado.settFinal(tfinal);
			
			atleta.setNombre(nombre);
			atleta.setApellido(apellido);
			atleta.setCedula(cedula);
			atleta.setCodigo(codigo);
			atleta.setResultado(resultado);
			
			if (competencias.get(0).getNombre().equals(competencia))
				if (competencias.get(0).getCategoria().equals("Juvenil"))
					atletasAJ.add(atleta);
				else
					atletasAS.add(atleta);
			else if (competencias.get(1).getNombre().equals(competencia))
				if (competencias.get(1).getCategoria().equals("Juvenil"))
					atletasBJ.add(atleta);
				else
					atletasBS.add(atleta);
			
			file = new RandomAccessFile(pathD, "rw");
			file.writeUTF(nombre);
			file.writeUTF(apellido);
			file.writeUTF(cedula);
			file.writeUTF(codigo);
			file.writeUTF(tinicial);
			file.writeUTF(tfinal);
			file.writeUTF(cnombre);
			file.writeUTF(categoria);
			
			
		} catch (IOException evento) {
			evento.printStackTrace();
		} finally {
			file.close();
		}
	}
	
	public RandomAccessFile getFile() {
		return file;
	}

/*	public void addResultado(String tInicial, String tFinal) throws IOException {
		try {
			Resultado resultado = new Resultado();
			resultado.settInicial(tInicial);
			resultado.settFinal(tFinal);
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}
*/
	
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
				atletasAJ.add(atleta);
			else if (competencias.get(1).getNombre().equals(competencia))
				atletasBJ.add(atleta);
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
			competencia.setCategoria("Senior");
			competencia.setAtletas(atletasAS);
			competencias.add(competencia);

			saveCompetencia(competencia);
			
			competencia = new Competencia();
			competencia.setNombre("Atletismo");
			competencia.setCategoria("Juvenil");
			competencia.setAtletas(atletasAJ);
			competencias.add(competencia);

			saveCompetencia(competencia);

			competencia = new Competencia();
			competencia.setNombre("Baloncesto");
			competencia.setCategoria("Juvenil");
			competencia.setAtletas(atletasBJ);
			competencias.add(competencia);

			saveCompetencia(competencia);
			
			competencia = new Competencia();
			competencia.setNombre("Baloncesto");
			competencia.setCategoria("Senior");
			competencia.setAtletas(atletasBS);
			competencias.add(competencia);

			saveCompetencia(competencia);

		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}

	public List<Atleta> listAtletas(String competencia) {
		if (competencias.get(0).getNombre().equals(competencia))
			return atletasAJ;
		else if (competencias.get(1).getNombre().equals(competencia))
			return atletasBJ;
		return null;
	}

	public String[] getCompetencias() {
		String[] lista = new String[competencias.size()];
		System.out.println(competencias.size());
		for (int i = 0; i < competencias.size(); i++)
			lista[i] = competencias.get(i).getNombre();
		return lista;
	}

	public boolean validarCedula(String cedula) throws Exception {
		try {
			int a = Integer.parseInt(cedula);
		} catch (NumberFormatException e) {
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if (cedula.length() != 10)
			throw new Exception("Debe ser de 10 dígitos");
		return true;
	}

	public boolean validarCodigo(String codigo) throws Exception {
		if (codigo.length() != 5)
			throw new Exception("Código inválido");
		return true;
	}
	
	public boolean validarTiempo(String tiempo) throws Exception {
		if (tiempo.length() != 5)
			throw new Exception("Tiempo inválido");
		return true;
	}
	
	public String complete(String dato) {
		for (int i = dato.length() + 1; i < 11; i++)
			dato = dato + " ";
		return dato;
	}
	
	public Competencia searchCompetencia(String nombre, String categoria) {
		for (int i = 0; i < competencias.size(); i++) {
			Competencia c = competencias.get(i);
			if (c.getNombre().equals(nombre) && c.getCategoria().equals(categoria))
				return c;
		}
		return null;
	}

	/*
	 * public boolean duplicadosAtletas(String nombre, String codigo) { for (int
	 * i = 0; i < atletas.size(); i++) { if
	 * (atletas.get(i).getNombre().equals(nombre) &&
	 * atletas.get(i).getCodigo().equals(codigo)) { return true; } } return
	 * false; }
	 */
}
