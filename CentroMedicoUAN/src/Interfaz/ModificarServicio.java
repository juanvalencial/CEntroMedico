package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.Fachada;
import Modelo.CentroMedico;
import Modelo.Servicios;

public class ModificarServicio extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JButton btnVerServicio;
	private JButton btnModificarServicio;
	private JLabel nomServicio;
	private JLabel desServicio;
	private JLabel comServicio;
	private JLabel durServicio;
	private JLabel cosServicio;
	private JTextField txtNomServicio;
	private JTextField txtDesServicio;
	private JTextField txtComServicio;
	private JTextField txtDurServicio;
	private JTextField txtCosServicio;
	private JComboBox<String> listaServicios;
	private Servicios servicio = new Servicios();
	private CentroMedico a = Fachada.getInstance().getCentroMedico();
	public ModificarServicio(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Servicio.jpg")));
		this.setTitle("Modificar Servicio");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngresoDatos();
		this.crearBotones();
	}
	
	private void crearEtiquetas() {
		this.nomServicio=new JLabel();
		this.nomServicio.setText("Nombre");
		this.nomServicio.setBounds(10, 30, 200, 80);
		this.add(nomServicio);
		
		this.desServicio=new JLabel();
		this.desServicio.setText("Descripcion");
		this.desServicio.setBounds(10, 60, 200, 80);
		this.add(desServicio);
		
		this.comServicio=new JLabel();
		this.comServicio.setText("Complejidad");
		this.comServicio.setBounds(10, 90, 200, 80);
		this.add(comServicio);
		
		this.durServicio=new JLabel();
		this.durServicio.setText("Duracion");
		this.durServicio.setBounds(10, 120, 200, 80);
		this.add(durServicio);
		
		this.cosServicio=new JLabel();
		this.cosServicio.setText("Costo");
		this.cosServicio.setBounds(10, 150, 200, 80);
		this.add(cosServicio);
	}
	
	private void crearIngresoDatos() {
		this.txtNomServicio=new JTextField();
		this.txtNomServicio.setBounds(90, 60, 180, 20);
		this.add(txtNomServicio);
		
		this.txtDesServicio=new JTextField();
		this.txtDesServicio.setBounds(90, 90, 180, 20);
		this.add(txtDesServicio);
		
		this.txtComServicio=new JTextField();
		this.txtComServicio.setBounds(90, 120, 180, 20);
		this.add(txtComServicio);
		
		this.txtDurServicio=new JTextField();
		this.txtDurServicio.setBounds(90, 150, 180, 20);
		this.add(txtDurServicio);
		
		this.txtCosServicio=new JTextField();
		this.txtCosServicio.setBounds(90, 180, 180, 20);
		this.add(txtCosServicio);
	}
	
	private void crearBotones() {
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(200, 210, 120, 20);
		btnVolver.addActionListener(this);
		this.add(btnVolver);
		
		this.btnVerServicio=new JButton();
		this.btnVerServicio.setText("Visualizar Servicio");
		this.btnVerServicio.setBounds(200, 20, 140, 20);
		btnVerServicio.addActionListener(this);
		this.add(btnVerServicio);
		
		this.btnModificarServicio=new JButton();
		this.btnModificarServicio.setText("Modificar Servicio");
		this.btnModificarServicio.setBounds(20, 210, 140, 20);
		btnModificarServicio.addActionListener(this);
		this.add(btnModificarServicio);
		
		this.listaServicios = new JComboBox<String>();
		this.listaServicios.setBounds(10, 20, 149, 20);
		this.add(listaServicios);
		this.leerServicios();
		
		this.llenarServicios();
	}
	public void actionPerformed(ActionEvent e) {	
		String nombreServicio = (String) listaServicios.getSelectedItem();
		servicio = a.buscarServicio(servicio, nombreServicio);
		
		if(e.getSource()==btnVolver){
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==btnVerServicio){
			llenarServicios();
		}
		
		if(e.getSource()==btnModificarServicio){
			servicio.setNombreServicio(txtNomServicio.getText());
			servicio.setDescripcionServicio(txtDesServicio.getText());
			servicio.setComplejidadServicio(txtComServicio.getText());
			servicio.setDuracionServicio(txtDurServicio.getText());
			ModificarServicio eli= new ModificarServicio();
			this.setVisible(false);
			eli.setVisible(true);
			JOptionPane.showMessageDialog(null, "Servicio Modificado");
		}
	}
	
	private void leerServicios() {
		DefaultComboBoxModel<String> slista = new DefaultComboBoxModel<String>();
		for (int i = 0; i < a.getLstServicios().size(); i++) {
			slista.addElement(a.getLstServicios().get(i).getNombreServicio());
		}
		listaServicios.setModel(slista);
		getContentPane().add(listaServicios);
	}
	
	private void llenarServicios() {
		String identificacion = (String) listaServicios.getSelectedItem();
		servicio = a.buscarServicio(servicio, identificacion);
		txtNomServicio.setText(servicio.getNombreServicio());
		txtDesServicio.setText(servicio.getDescripcionServicio());
		txtComServicio.setText(servicio.getComplejidadServicio());
		txtDurServicio.setText(servicio.getDuracionServicio());
		txtCosServicio.setText(servicio.getCostoServicio());
	}
}