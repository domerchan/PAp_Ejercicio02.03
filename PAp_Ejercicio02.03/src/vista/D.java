package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JTable tblAtleta;
	
	public D(GestionD gd) {

		Locale localizacion = Ventana.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);

		this.gd = gd;
		setSize(750, 300);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel pnlD = new JPanel();
		pnlD.setLayout(new GridLayout(2,1));
		
		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(BorderFactory.createEmptyBorder());
		pnlDatos.setLayout(new GridLayout(4,4));
		pnlDatos.add(new JLabel(lang.getString("Nombre") + ": "));
		txtNombre = new JTextField(20);
		pnlDatos.add(txtNombre);
		pnlDatos.add(new JLabel(lang.getString("Apellido") + ": "));
		txtApellido = new JTextField(20);
		pnlDatos.add(txtApellido);
		pnlDatos.add(new JLabel(lang.getString("Cedula") + ": "));
		txtCedula = new JTextField(20);
		pnlDatos.add(txtCedula);
		pnlDatos.add(new JLabel(lang.getString("Codigo") + ": "));
		txtCodigo = new JTextField(20);
		pnlDatos.add(txtCodigo);
		pnlDatos.add(new JLabel(lang.getString("Inicial") + ": "));
		txtInicio = new JTextField(20);
		pnlDatos.add(txtInicio);
		pnlDatos.add(new JLabel(lang.getString("Fin") + ": "));
		txtFin = new JTextField(20);
		pnlDatos.add(txtFin);
		pnlDatos.add(new JLabel(lang.getString("Competencia") + ": "));
		String[] competencias = gd.getCompetencias();
		cbxCompetencia = new JComboBox(competencias);
		pnlDatos.add(cbxCompetencia);
		
		tblAtleta = new JTable();
		tblAtleta.setModel(new ModelAtleta());
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
	
	public void newAtleta() {
		gd.addAtleta(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtCodigo.getText(), txtInicio.getText(), txtFin.getText(), cbxCompetencia.getSelectedItem().toString());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "Cargar":
			newAtleta();
			tblAtleta.setModel(new ModelAtleta(gd.listAtletas(cbxCompetencia.getSelectedItem().toString()), cbxCompetencia.getSelectedItem().toString()));
			break;
		case "Limpiar":
			limpiar();
			break;
		}
	}

}
