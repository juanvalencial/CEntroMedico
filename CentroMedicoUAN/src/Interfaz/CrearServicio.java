package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.Fachada;
import Modelo.CentroMedico;
import Modelo.Servicios;

public class CrearServicio extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel nombreServ;
	private JLabel descripcionServ;
	private JLabel complejidadServ;
	private JLabel duracionServ;
	private JLabel costoServ;
	private JTextField txtNombreServ;
	private JTextField txtDescripcionServ;
	private JTextField txtComplejidadServ;
	private JTextField txtDuracionServ;
	private JTextField txtCostoServ;
	private JButton btnCrearServ;
	private JButton btnVolverServ;
	private Servicios servicio;
	private CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	public CrearServicio(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Servicio.jpg")));
		this.setTitle("Crear Servicio");
		this.setSize(400, 280);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngreseDatos();
		this.crearBotones();
	}
	
	private void crearEtiquetas() {
		this.nombreServ=new JLabel();
		this.nombreServ.setText("Nombre");
		this.nombreServ.setBounds(10, 5, 200, 80);
		this.add(nombreServ);
		
		this.descripcionServ=new JLabel();
		this.descripcionServ.setText("Descripcion");
		this.descripcionServ.setBounds(10, 35, 200, 80);
		this.add(descripcionServ);
		
		this.complejidadServ=new JLabel();
		this.complejidadServ.setText("Complejidad");
		this.complejidadServ.setBounds(10, 65, 200, 80);
		this.add(complejidadServ);
		
		this.duracionServ=new JLabel();
		this.duracionServ.setText("Duracion");
		this.duracionServ.setBounds(10, 95, 200, 80);
		this.add(duracionServ);
		
		this.costoServ=new JLabel();
		this.costoServ.setText("Costo");
		this.costoServ.setBounds(10, 125, 200, 80);
		this.add(costoServ);
	}
	
	private void crearIngreseDatos() {
		this.txtNombreServ=new JTextField();
		this.txtNombreServ.setBounds(90, 35, 180, 20);
		this.add(txtNombreServ);
		
		this.txtDescripcionServ=new JTextField();
		this.txtDescripcionServ.setBounds(90, 65, 180, 20);
		this.add(txtDescripcionServ);
		
		this.txtComplejidadServ=new JTextField();
		this.txtComplejidadServ.setBounds(90, 95, 180, 20);
		this.add(txtComplejidadServ);
		
		this.txtDuracionServ=new JTextField();
		this.txtDuracionServ.setBounds(90, 125, 180, 20);
		this.add(txtDuracionServ);
		
		this.txtCostoServ=new JTextField();
		this.txtCostoServ.setBounds(90, 155, 180, 20);
		this.add(txtCostoServ);
	}
	
	private void crearBotones() {
		this.btnCrearServ=new JButton();
		this.btnCrearServ.setText("Crear");
		this.btnCrearServ.setBounds(40, 200, 120, 20);
		btnCrearServ.addActionListener(this);
		this.add(btnCrearServ);
		
		this.btnVolverServ=new JButton();
		this.btnVolverServ.setText("Volver");
		this.btnVolverServ.setBounds(180, 200, 120, 20);
		btnVolverServ.addActionListener(this);
		this.add(btnVolverServ);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCrearServ) {
			if (txtNombreServ.getText().equals("") || txtDescripcionServ.getText().equals("")
					|| txtComplejidadServ.getText().equals("") || txtDuracionServ.getText().equals("")
					|| txtCostoServ.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Completa el formulario");
			} else {
				servicio = new Servicios();
				servicio.setNombreServicio(txtNombreServ.getText());
				servicio.setDescripcionServicio(txtDescripcionServ.getText());
				servicio.setComplejidadServicio(txtComplejidadServ.getText());
				servicio.setDuracionServicio(txtDuracionServ.getText());
				servicio.setCostoServicio(txtCostoServ.getText());
				a.crearServicio(servicio);
				JOptionPane.showMessageDialog(null, "Servicio Creado Exitosamente");
				limpiarFormulario();
			}
		}
		
		if(e.getSource()==btnVolverServ){
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
			setVisible(false);
		}
	}
	
	private void limpiarFormulario() {
		txtNombreServ.setText("");
		txtDescripcionServ.setText("");
		txtComplejidadServ.setText("");
		txtDuracionServ.setText("");
		txtCostoServ.setText("");
	}
}
