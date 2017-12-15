package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.GestionA;
import controlador.GestionD;
//import controlador.GestionE;




public class Ventana extends JFrame implements ActionListener {
	
	public static Locale localizacion;
	private JDesktopPane escritorio;
	private GestionA ga;
	private GestionD gd;
//	private GestionE ge;
	private JMenu mnuVentanaRegistro, mnuVentanaTablas, idioma;
	private JMenuItem mnuVentanpais, mnuVentanaC, mnuVentanaD, mnuIdiom, mnuVentanaE, mnuVentanaA, mnuVentanaF, mnuSalir, idiomaen,
			idiomaes;

	public Ventana() throws IOException {
		initComponents();
		ga = new GestionA();
		gd = new GestionD();
	//	ge = new GestionE();
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		localizacion = new Locale("es", "EC");
		ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
		setSize(800, 600);
		setTitle(lang.getString("Gestion"));
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();
		getContentPane().add(escritorio, BorderLayout.CENTER);

		JMenuBar barra = new JMenuBar();

		mnuVentanaRegistro = new JMenu(lang.getString("Registros"));
		
		mnuVentanaA = new JMenuItem(lang.getString("A"));
		mnuVentanaA.addActionListener(this);
		mnuVentanaA.setActionCommand("mnuVentanaA");
		mnuVentanaRegistro.add(mnuVentanaA);
		
		mnuVentanaD = new JMenuItem(lang.getString("D"));
		mnuVentanaD.addActionListener(this);
		mnuVentanaD.setActionCommand("mnuVentanaD");
		mnuVentanaRegistro.add(mnuVentanaD);
		
		mnuVentanaE = new JMenuItem(lang.getString("E"));
		mnuVentanaE.addActionListener(this);
		mnuVentanaE.setActionCommand("mnuVentanaE");
		mnuVentanaRegistro.add(mnuVentanaE);

		mnuSalir = new JMenuItem(lang.getString("Salir"));
		mnuSalir.addActionListener(this);
		mnuSalir.setActionCommand("mnuSalir");
		mnuVentanaRegistro.add(mnuSalir);

		idioma = new JMenu(lang.getString("Idiomas"));
		idiomaen = new JMenuItem("EN");
		idiomaen.addActionListener(this);
		idiomaen.setActionCommand("mnuEN");
		idioma.add(idiomaen);

		idiomaes = new JMenuItem("ES");
		idiomaes.addActionListener(this);
		idiomaes.setActionCommand("mnuES");
		idioma.add(idiomaes);

		barra.add(mnuVentanaRegistro);
		barra.add(idioma);

		setJMenuBar(barra);

	}

	@Override

	public void actionPerformed(ActionEvent event) {
		String comando = event.getActionCommand();
		System.out.println("Eventos menu " + comando);

		switch (comando) {
		case "mnuVentanaA":
			llamarVentanaA();
			break;
		case "mnuVentanaD":
			llamarVentanaD();
			break;
		case "mnuVentanaE":
	//		llamarVentanaE();
		case "mnuSalir":
			salir();
			break;
		case "mnuEN":
			llamaridioma("en", "US");
			break;
		case "mnuES":
			llamaridioma("es", "EC");
			break;
		default:
			break;
		}

	}


/*	private void llamarVentanaE() {
		E vnte = new E(ge);
		vnte.setVisible(true);
		escritorio.add(vnte);
		try {
			vnte.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/

	private void llamarVentanaD() {
		D vntd = new D(gd);
		vntd.setVisible(true);
		escritorio.add(vntd);
		try {
			vntd.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void llamarVentanaA() {
		A vnta = new A(ga);
		vnta.setVisible(true);
		escritorio.add(vnta);
		try {
			vnta.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void llamaridioma(String lenguaje, String pais) {
		localizacion = new Locale(lenguaje, pais);
		ResourceBundle lang = ResourceBundle.getBundle("Idioma.mensajes", localizacion);
		setTitle(lang.getString("SistemadeInscripcionUniversitaria"));
		mnuVentanaRegistro.setText(lang.getString("Inscripciones"));
		idioma.setText(lang.getString("Idiomas"));
	}
	
	public void salir() {
		System.exit(0);
	}

}
