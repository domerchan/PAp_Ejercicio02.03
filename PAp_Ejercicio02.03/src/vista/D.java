package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.GestionD;

public class D extends JInternalFrame implements ActionListener {

	private GestionD gd;
	private JButton btnCargar;
	private JButton btnLimpiar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtCodigo;
	private JTextField txtInicio;
	private JTextField txtFin;
	private JComboBox cbxCompetencia;
	private JComboBox cbxCategoria;
	private JTable tblAtleta;

	public D(GestionD gd) {

		Locale localizacion = Ventana.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);

		this.gd = gd;
		setSize(750, 300);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel pnlD = new JPanel();
		pnlD.setLayout(new GridLayout(2, 1));

		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(BorderFactory.createEmptyBorder());
		pnlDatos.setLayout(new GridLayout(4, 4));
		pnlDatos.add(new JLabel(lang.getString("Nombre") + ": "));
		txtNombre = new JTextField(20);
		pnlDatos.add(txtNombre);
		pnlDatos.add(new JLabel(lang.getString("Apellido") + ": "));
		txtApellido = new JTextField(20);
		pnlDatos.add(txtApellido);
		pnlDatos.add(new JLabel(lang.getString("Cedula") + ": "));
		txtCedula = new JTextField(20);
		pnlDatos.add(txtCedula);
		pnlDatos.add(new JLabel(lang.getString("Codigo") + ": ej.(AA-11)"));
		txtCodigo = new JTextField(20);
		pnlDatos.add(txtCodigo);
		pnlDatos.add(new JLabel(lang.getString("Inicial") + ": ej.(00:00)"));
		txtInicio = new JTextField(20);
		pnlDatos.add(txtInicio);
		pnlDatos.add(new JLabel(lang.getString("Fin") + ": ej.(15:27)"));
		txtFin = new JTextField(20);
		pnlDatos.add(txtFin);
		pnlDatos.add(new JLabel(lang.getString("Competencia") + ": "));
		String[] competencias = { "Atletismo", "Baloncesto" };
		cbxCompetencia = new JComboBox(competencias);
		pnlDatos.add(cbxCompetencia);
		pnlDatos.add(new JLabel(lang.getString("Categoria") + ": "));
		String[] categorias = { "Juvenil", "Senior" };
		cbxCategoria = new JComboBox(categorias);
		pnlDatos.add(cbxCategoria);

		tblAtleta = new JTable();
		RandomAccessFile file = gd.getFile();
		tblAtleta.setModel(new ModelAtleta(file));
		JScrollPane sAtleta = new JScrollPane(tblAtleta);

		pnlD.add(pnlDatos);
		pnlD.add(sAtleta);

		JPanel pnlButton = new JPanel();
		btnCargar = new JButton(lang.getString("Cargar"));
		btnCargar.addActionListener(this);
		btnCargar.setActionCommand("Cargar");
		btnLimpiar = new JButton(lang.getString("Limpiar"));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setActionCommand("Limpiar");

		pnlButton.add(btnCargar);
		pnlButton.add(btnLimpiar);

		c.add(pnlD, BorderLayout.CENTER);
		c.add(pnlButton, BorderLayout.SOUTH);

	}

	public void limpiar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtCedula.setText("");
		txtCodigo.setText("");
		txtInicio.setText("");
		txtFin.setText("");
	}

	public void newRegistro() {
		try {
			String nombre = gd.complete(txtNombre.getText().toString());
			String apellido = gd.complete(txtApellido.getText().toString());
			String competencia = gd.complete(cbxCompetencia.getSelectedItem().toString());
			String categoria = gd.complete(cbxCategoria.getSelectedItem().toString());
			gd.validarCedula(txtCedula.getText().toString());
			gd.validarCodigo(txtCodigo.getText().toString());
			gd.validarTiempo(txtInicio.getText().toString());
			gd.validarTiempo(txtFin.getText().toString());
			gd.newRegistro(nombre, apellido, txtCedula.getText().toString(), txtCodigo.getText().toString(),
					txtInicio.getText().toString(), txtFin.getText().toString(), competencia, categoria);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "Cargar":
			newRegistro();
			tblAtleta.setModel(new ModelAtleta(gd.listAtletas(cbxCompetencia.getSelectedItem().toString())));
			break;
		case "Limpiar":
			limpiar();
			break;
		}
	}

}
