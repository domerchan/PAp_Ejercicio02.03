package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.Articulo;

public class ModelArticulo extends AbstractTableModel {

	private Locale localizacion = Ventana.localizacion;
	private ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
	private List<Articulo> datos;
	private String articulo;
	public String[] columnas = {lang.getString("Titulo"), lang.getString("Autor"), lang.getString("Inicio"), lang.getString("Final") };
	public Class[] columnasTipos = {String.class, String.class, String.class, String.class};
	
	public ModelArticulo() {
		super();
		datos = new ArrayList<Articulo>();
		Locale localizacion = Ventana.localizacion;
		lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
	}
	
	public ModelArticulo(List<Articulo> datos) {
		super();
		if (datos == null)
			this.datos = new ArrayList<Articulo>();
		else
			this.datos = datos;
		this.articulo = articulo;
	}
	
	public int getColumnCount() {
		return columnas.length;
	}

	public int getRowCount() {
		return datos.size();
	}
	
	public String getColumnName(int col) {
		return columnas[col];
	}
	
	public Class getColumnClass(int col) {
		return columnasTipos[col];
	}

	public Object getValueAt(int row, int col) {
		
		Articulo dato = (Articulo) (datos.get(row));
		
		switch(col) {
		case 0:
			return row + 1;
		case 1:
			return articulo;	
		case 2:
			return dato.getTitulo();
		case 3:
			return dato.getAutor().getSeudonimo();
		case 4:
			return dato.getpInicio();
		case 5: 
			return dato.getpFinal();
		default:
			break;
		}
		return new String();
	}
}