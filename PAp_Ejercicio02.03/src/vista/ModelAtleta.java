package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.Atleta;

public class ModelAtleta extends AbstractTableModel {
	private Locale localizacion = Ventana.localizacion;
	private ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
	private List<Atleta> datos;
	private String competencia;
	public String[] columnas = { lang.getString("Inscripcion"), lang.getString("Competencia"), lang.getString("Nombre"), lang.getString("Apellido"),
			lang.getString("Cedula"), lang.getString("Codigo"), lang.getString("Inicial"), lang.getString("Fin") };
	public Class[] columnasTipos = { int.class, String.class, String.class, String.class, String.class, String.class, String.class,
			String.class };

	public ModelAtleta() {
		super();
		datos = new ArrayList<Atleta>();
		Locale localizacion = Ventana.localizacion;
		lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
	}

	public ModelAtleta(List<Atleta> datos, String competencia) {
		super();
		if (datos == null)
			this.datos = new ArrayList<Atleta>();
		else
			this.datos = datos;
		this.competencia = competencia;
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

		Atleta dato = (Atleta) (datos.get(row));

		switch (col) {
		case 0:
			return row + 1;
		case 1:
			return competencia;
		case 2:
			return dato.getNombre();
		case 3:
			return dato.getApellido();
		case 4:
			return dato.getCodigo();
		case 5:
			return dato.getResultado().gettInicial();
		case 6:
			return dato.getResultado().gettFinal();
		default:
			break;
		}
		return new String();
	}
}
