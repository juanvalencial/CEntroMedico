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
import Modelo.Disponibilidades;
import Modelo.Especialidades;
import Modelo.Medicos;

public class CrearMedico extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel identificacionMed;
	private JLabel nombreMed;
	private JLabel apellidoMed;
	private JLabel telefonoMed;
	private JTextField txtIdentificacionMed;
	private JTextField txtNombreMed;
	private JTextField txtApellidoMed;
	private JTextField txtTelefonoMed;
	private JButton btnCrearMed;
	private JButton btnVolverMed;
	private Medicos medico;
	private CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	public CrearMedico(Medicos medico, Especialidades especialidad, Disponibilidades dispo){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Medico.jpg")));
		this.setTitle("Crear Medico");
		this.setSize(400, 350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngreseDatos();
		this.crearBotones();
	}
	
	private void crearEtiquetas() {
		this.identificacionMed=new JLabel();
		this.identificacionMed.setText("Identificacion");
		this.identificacionMed.setBounds(10, 5, 200, 80);
		this.add(identificacionMed);
		
		this.nombreMed=new JLabel();
		this.nombreMed.setText("Nombres");
		this.nombreMed.setBounds(10, 35, 200, 80);
		this.add(nombreMed);
		
		this.apellidoMed=new JLabel();
		this.apellidoMed.setText("Apellidos");
		this.apellidoMed.setBounds(10, 65, 200, 80);
		this.add(apellidoMed);
		
		this.telefonoMed=new JLabel();
		this.telefonoMed.setText("Telefono");
		this.telefonoMed.setBounds(10, 95, 200, 80);
		this.add(telefonoMed);
	}
	
	private void crearIngreseDatos() {
		this.txtIdentificacionMed=new JTextField();
		this.txtIdentificacionMed.setBounds(90, 35, 180, 20);
		this.add(txtIdentificacionMed);
		
		this.txtNombreMed=new JTextField();
		this.txtNombreMed.setBounds(90, 65, 180, 20);
		this.add(txtNombreMed);
		
		this.txtApellidoMed=new JTextField();
		this.txtApellidoMed.setBounds(90, 95, 180, 20);
		this.add(txtApellidoMed);
		
		this.txtTelefonoMed=new JTextField();
		this.txtTelefonoMed.setBounds(90, 125, 180, 20);
		this.add(txtTelefonoMed);
	}
	
	private void crearBotones() {
		this.btnCrearMed=new JButton();
		this.btnCrearMed.setText("Crear");
		this.btnCrearMed.setBounds(40, 280, 120, 20);
		btnCrearMed.addActionListener(this);
		this.add(btnCrearMed);
		
		this.btnVolverMed=new JButton();
		this.btnVolverMed.setText("Volver");
		this.btnVolverMed.setBounds(180, 280, 120, 20);
		btnVolverMed.addActionListener(this);
		this.add(btnVolverMed);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCrearMed) {
			if (txtIdentificacionMed.getText().equals("") || txtNombreMed.getText().equals("")
					|| txtApellidoMed.getText().equals("") || txtTelefonoMed.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Completa el formulario");
			} else {
				medico = new Medicos();
				medico.setIdentificacion(txtIdentificacionMed.getText());
				medico.setNombreMedico(txtNombreMed.getText());
				medico.setApellidoMedico(txtApellidoMed.getText());
				medico.setTelefonoMedico(txtTelefonoMed.getText());
				a.crearMedico(medico);
				JOptionPane.showMessageDialog(null, "Medico Creado Exitosamente");
				limpiarFormulario();
			}
		}
		
		if(e.getSource()==btnVolverMed){
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
			setVisible(false);
		}
	}
	
	private void limpiarFormulario() {
		txtIdentificacionMed.setText("");
		txtNombreMed.setText("");
		txtApellidoMed.setText("");
		txtTelefonoMed.setText("");
	}
}
