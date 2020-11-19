package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.Fachada;
import Modelo.CentroMedico;
import Modelo.Eps;

public class DatosEps extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JButton btnVerEps;
	private JLabel nombreEps;
	private JLabel municipioEps;
	private JLabel direccionEps;
	private JLabel telefonoEps;
	private JTextField txtNombreEps;
	private JTextField txtMunicipioEps;
	private JTextField txtDireccionEps;
	private JTextField txtTelefonoEps;
	private JComboBox<String> listaEps;
	private Eps eps = new Eps();
	private CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	public DatosEps(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/PrecioServicio.png")));
		this.setTitle("Contratos EPS's");
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngresoDatos();
		this.crearBotones();
	}
	
	private void crearEtiquetas() {
		this.nombreEps=new JLabel();
		this.nombreEps.setText("Nombre");
		this.nombreEps.setBounds(10, 30, 200, 80);
		this.add(nombreEps);
		
		this.municipioEps=new JLabel();
		this.municipioEps.setText("Municipio");
		this.municipioEps.setBounds(10, 60, 200, 80);
		this.add(municipioEps);
		
		this.direccionEps=new JLabel();
		this.direccionEps.setText("Direccion");
		this.direccionEps.setBounds(10, 90, 200, 80);
		this.add(direccionEps);
		
		this.telefonoEps=new JLabel();
		this.telefonoEps.setText("Telefono");
		this.telefonoEps.setBounds(10, 120, 200, 80);
		this.add(telefonoEps);
	}
	
	private void crearIngresoDatos() {
		this.txtNombreEps=new JTextField();
		this.txtNombreEps.setEditable(false);
		this.txtNombreEps.setBounds(90, 60, 180, 20);
		this.add(txtNombreEps);
		
		this.txtMunicipioEps=new JTextField();
		this.txtMunicipioEps.setEditable(false);
		this.txtMunicipioEps.setBounds(90, 90, 180, 20);
		this.add(txtMunicipioEps);
		
		this.txtDireccionEps=new JTextField();
		this.txtDireccionEps.setEditable(false);
		this.txtDireccionEps.setBounds(90, 120, 180, 20);
		this.add(txtDireccionEps);
		
		this.txtTelefonoEps=new JTextField();
		this.txtTelefonoEps.setEditable(false);
		this.txtTelefonoEps.setBounds(90, 150, 180, 20);
		this.add(txtTelefonoEps);
	}
	
	private void crearBotones() {
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(130, 180, 120, 20);
		btnVolver.addActionListener(this);
		this.add(btnVolver);
		
		this.btnVerEps=new JButton();
		this.btnVerEps.setText("Visualizar EPS");
		this.btnVerEps.setBounds(200, 20, 140, 20);
		btnVerEps.addActionListener(this);
		this.add(btnVerEps);
		
		this.listaEps = new JComboBox<String>();
		this.listaEps.setBounds(10, 20, 149, 20);
		this.add(listaEps);
		this.leerEps();
	}

	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==btnVolver){
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==btnVerEps){
			llenarEps();
		}
	}
	
	private void leerEps() {
		DefaultComboBoxModel<String> mlista = new DefaultComboBoxModel<String>();
		
		for (int i = 0; i < a.getLstEps().size(); i++) {
			mlista.addElement(a.getLstEps().get(i).getNombreEps());
		}
		listaEps.setModel(mlista);
		getContentPane().add(listaEps);
	}
	
	private void llenarEps() {
		String nombre = (String) listaEps.getSelectedItem();
		eps = a.buscarEps(eps, nombre);
		txtNombreEps.setText(eps.getNombreEps());
		txtMunicipioEps.setText(eps.getMunicipioEps());
		txtDireccionEps.setText(eps.getDireccionEps());
		txtTelefonoEps.setText(eps.getTelefonoEps());
	}
}