package vista;

import java.io.IOException;
import java.io.RandomAccessFile;
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
	private RandomAccessFile file;

	public String[] columnas = { lang.getString("Inscripcion"), lang.getString("Nombre"), lang.getString("Apellido"),
			lang.getString("Codigo"), lang.getString("Inicial"), lang.getString("Fin"), lang.getString("Competencia"),
			lang.getString("Categoria") };
	public Class[] columnasTipos = { int.class, String.class, String.class, String.class, String.class, String.class,
			String.class, String.class };

	public ModelAtleta(RandomAccessFile file) {
		super();
		datos = new ArrayList<Atleta>();
		Locale localizacion = Ventana.localizacion;
		lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
		this.file = file;
	}

	public ModelAtleta(List<Atleta> datos) {
		super();
		if (datos == null)
			this.datos = new ArrayList<Atleta>();
		else
			this.datos = datos;
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

		try {
			switch (col) {
			case 0:
				return row + 1;
			case 1:
				return file.readUTF();
			case 2:
				return file.readUTF();
			case 3:
				file.seek((row)*81 + 36);
				return file.readUTF();
			case 4:
				return file.readUTF();
			case 5:
				return file.readUTF();
			case 6:
				return file.readUTF();
			case 7: 
				return file.readUTF();
			default:
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new String();
	}
}
