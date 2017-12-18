package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import modelo.Articulo;
import modelo.Autor;
import modelo.Revista;

public class GestionA {
	
	private List<Articulo> articulos;
	private List<Autor> autores;
	private Revista revista;
	
	
	public GestionA() {
		articulos = new ArrayList<Articulo>();
		autores = new ArrayList<Autor>();
		addRevista();

	}
	
	public void addArticulo(String titulo, String resumen, String pInicio, String pFinal,
			String nombre, String apellido, String cedula, String nacionalidad, String seudonimo) {
		
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
			
			
	}
	
	public void addRevista() {
	
		revista = new Revista();
		revista.setNombre("Nature");
		revista.setnEdicion("204");
		revista.setIdioma("Inglés");
		revista.setArticulos(articulos);
		
	}
	
	public Revista getRevista() {
		return revista;
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
	
	public boolean listAutores(List<Autor> autores) throws Exception {
        boolean retorno=true;
        File directorio=new File("C:/Autor");
        System.out.print((directorio.getPath()));
        if(!directorio.exists()) {
            directorio.mkdir();
        }
        for(Autor autor:autores) {
            try {
               FileOutputStream fo=new   FileOutputStream("C:/Autor/AutoresDescripcion.dat",true);
               DataOutputStream escritura= new DataOutputStream (fo);
               escritura.writeUTF(autor.getNombre());
               escritura.writeUTF(autor.getApellido());
               escritura.writeUTF(autor.getNacionalidad());
               escritura.writeUTF(autor.getSeudonimo());
               escritura.writeUTF(autor.getCedula());
               escritura.close();
               retorno=true;
            }catch(EOFException e1) {
                retorno=false;
            }
        }
        
        return retorno;
    }
	
	public List<Autor> leeAutores() throws Exception{
        List<Autor> autor = new ArrayList<Autor>();
        try {
            FileInputStream fs=new   FileInputStream("C:/Autor/AutoresDescripcion.dat");
            DataInputStream autores= new DataInputStream (fs);
            
            while(true) {
            	
            	String nombre =  autores.readUTF();
            	String apellido = autores.readUTF();
            	String nacionalidad = autores.readUTF();
            	String pseudonimo = autores.readUTF();
            	String cedula = autores.readUTF();
                
                Autor autores1 = new Autor (nombre,apellido,nacionalidad,pseudonimo,cedula);	
                autor.add(autores1);  
            }
           
        }catch(EOFException e1){
           e1.printStackTrace();
        }
        return autor;
    }
	
	public boolean listArticulos(List<Articulo> articulos) throws Exception {
        boolean retorno=true;
        File directorio=new File("C:/Articulo");
        System.out.print((directorio.getPath()));
        if(!directorio.exists()) {
            directorio.mkdir();
        }
        for(Articulo articulo:articulos) {
            try {
               FileOutputStream fo=new   FileOutputStream("C:/Articulo/ArticulosDescripcion.dat",true);
               DataOutputStream escritura= new DataOutputStream (fo);
               escritura.writeUTF(articulo.getTitulo());
               escritura.writeUTF(articulo.getResumen());
               escritura.writeUTF(articulo.getpInicio());
               escritura.writeUTF(articulo.getpFinal());
               escritura.writeUTF(articulo.getAutor().getNombre());
               escritura.close();
               retorno=true;
            }catch(EOFException e1) {
                retorno=false;
            }
        }
        
        return retorno;
    }
	
	 public List<Articulo> leeArticulo() throws Exception{
	        List<Articulo> articulo = new ArrayList<Articulo>();
	        try {
	            FileInputStream fs=new   FileInputStream("C:/Articulo/ArticulosDescripcion.dat");
	            DataInputStream articulodes= new DataInputStream (fs);
	            
	            while(true) {
	            	String titulo = articulodes.readUTF();
	                String resumen = articulodes.readUTF();
	                String inicio = articulodes.readUTF();
	                String final1 = articulodes.readUTF();
	                //String nombre = articulodes.readUTF();
	                
	                Articulo articuloa = new Articulo (titulo,resumen,inicio,final1,null);	             
	                articulo.add(articuloa);  
	            }
	           
	        }catch(EOFException e1){
	           e1.printStackTrace();
	        }
	        return articulo;
	    }
	
}
