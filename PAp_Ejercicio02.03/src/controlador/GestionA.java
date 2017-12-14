package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Articulo;
import modelo.Autor;
import modelo.Revista;

public class GestionA {
	
	private List<Articulo> articulos;
	private List<Autor> autores;
	private Revista revista;
	private String pathA = "src/archivos/A.txt";
	
	public GestionA() {
		articulos = new ArrayList<Articulo>();
		autores = new ArrayList<Autor>();
		addRevista();

	}
	
	public void addArticulo(String titulo, String resumen, String pInicio, String pFinal,
			String nombre, String apellido, String cedula, String nacionalidad, String seudonimo) {
		try {
			Autor autor1 = new Autor();
			autor1.setNombre(nombre);
			autor1.setApellido(apellido);
			autor1.setCedula(cedula);
			autor1.setNacionalidad(nacionalidad);
			autor1.setSeudonimo(seudonimo);
			autores.add(autor1);
			Articulo articulo = new Articulo();
			articulo.setAutor(autor1);
			articulo.setTitulo(titulo);
			articulo.setResumen(resumen);
			articulo.setpInicio(pInicio);
			articulo.setpFinal(pFinal);
			articulos.add(articulo);

			FileWriter file = new FileWriter(pathA, true);
			BufferedWriter out = new BufferedWriter(file);
			String registro = articulo.getTitulo() + " , " + articulo.getAutor() + " ; " + articulo.getResumen() + " , "
					+ articulo.getpInicio() + " ; " + articulo.getpFinal();
			out.append(registro + "\n");
			out.close();
			file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}
	
	public void addRevista() {
		try {
		revista = new Revista();
		revista.setNombre("Nature");
		revista.setnEdicion("204");
		revista.setIdioma("Inglés");
		revista.setArticulos(articulos);
		
		FileWriter file = new FileWriter(pathA, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = revista.getNombre()+" , "+revista.getnEdicion()+" , "+revista.getIdioma()+" , "+revista.getArticulos();
		out.append(registro + "\n");
		out.close();
		file.close();
		}catch (IOException evento){
			evento.printStackTrace();
		}
	}
	
	public Revista getRevista() {
		return revista;
	}
	
	public List<Articulo> getArticulos() {
		return articulos;
	}
	
	public boolean isCedulaValida(String cedula) throws Exception{
		try {
			int a = Integer.parseInt(cedula);
		}catch(NumberFormatException e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(cedula.length()!=10)
			throw new Exception("Debe ser de 10 dígitos");
		
		return true;
	}

	public boolean duplicadosArticulos(String titulo,String autor){
		for(int i=0; i<articulos.size();i++) {
			if(articulos.get(i).getTitulo().equals(titulo) && articulos.get(i).getAutor().equals(autor)){
				return true;
			}
		}
		return false;
	}
	
	public boolean duplicadosAutores(String nombre,String Seudonimo){
		for(int i=0; i<autores.size();i++) {
			if(autores.get(i).getNombre().equals(nombre) && autores.get(i).getSeudonimo().equals(Seudonimo)){
				return true;
			}
		}
		return false;
	}
	
}
