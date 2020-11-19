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
import Modelo.Medicos;

public class EliminarMedico extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JButton btnVerMedico;
	private JButton btnEliminarMedico;
	private JLabel identificacionMed;
	private JLabel nombreMed;
	private JLabel apellidoMed;
	private JLabel telefonoMed;
	private JLabel especialidadMed;
	private JLabel dispoMed;
	private JTextField txtIdentificacionMed;
	private JTextField txtNombreMed;
	private JTextField txtApellidoMed;
	private JTextField txtTelefonoMed;
	private JComboBox<String> listaEsp;
	private JComboBox<String> listaMedicos;
	private JComboBox<String> listaDispo;
	private String nombre,fecha;
	private Medicos medico = new Medicos();
	private CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	public EliminarMedico(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Medico.jpg")));
		this.setTitle("Eliminar Medico");
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
		this.identificacionMed=new JLabel();
		this.identificacionMed.setText("Identificacion");
		this.identificacionMed.setBounds(10, 20, 200, 80);
		this.add(identificacionMed);
		
		this.nombreMed=new JLabel();
		this.nombreMed.setText("Nombres");
		this.nombreMed.setBounds(10, 50, 200, 80);
		this.add(nombreMed);
		
		this.apellidoMed=new JLabel();
		this.apellidoMed.setText("Apellidos");
		this.apellidoMed.setBounds(10, 80, 200, 80);
		this.add(apellidoMed);
		
		this.telefonoMed=new JLabel();
		this.telefonoMed.setText("Telefono");
		this.telefonoMed.setBounds(10, 110, 200, 80);
		this.add(telefonoMed);
		
		this.especialidadMed=new JLabel();
		this.especialidadMed.setText("Especialidad");
		this.especialidadMed.setBounds(10, 140, 200, 80);
		this.add(especialidadMed);
		
		this.dispoMed=new JLabel();
		this.dispoMed.setText("Disponibilidad");
		this.dispoMed.setBounds(10, 170, 200, 80);
		this.add(dispoMed);
	}
	
	private void crearIngresoDatos() {
		this.txtIdentificacionMed=new JTextField();
		this.txtIdentificacionMed.setEditable(false);
		this.txtIdentificacionMed.setBounds(95, 50, 180, 20);
		this.add(txtIdentificacionMed);
		
		this.txtNombreMed=new JTextField();
		this.txtNombreMed.setEditable(false);
		this.txtNombreMed.setBounds(95, 80, 180, 20);
		this.add(txtNombreMed);
		
		this.txtApellidoMed=new JTextField();
		this.txtApellidoMed.setEditable(false);
		this.txtApellidoMed.setBounds(95, 110, 180, 20);
		this.add(txtApellidoMed);
		
		this.txtTelefonoMed=new JTextField();
		this.txtTelefonoMed.setEditable(false);
		this.txtTelefonoMed.setBounds(95, 140, 180, 20);
		this.add(txtTelefonoMed);
	}
	
	private void crearBotones() {
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(210, 240, 120, 20);
		btnVolver.addActionListener(this);
		this.add(btnVolver);
		
		this.btnVerMedico=new JButton();
		this.btnVerMedico.setText("Visualizar Medico");
		this.btnVerMedico.setBounds(200, 20, 140, 20);
		btnVerMedico.addActionListener(this);
		this.add(btnVerMedico);
		
		this.btnEliminarMedico=new JButton();
		this.btnEliminarMedico.setText("Eliminar Medico");
		this.btnEliminarMedico.setBounds(20, 240, 130, 20);
		btnEliminarMedico.addActionListener(this);
		this.add(btnEliminarMedico);
		
		this.listaMedicos = new JComboBox<String>();
		this.listaMedicos.setBounds(15, 20, 149, 20);
		this.add(listaMedicos);
		this.leerMedicos();
		
		this.listaEsp = new JComboBox<String>();
		this.listaEsp.setBounds(95, 170, 180, 20);
		this.add(listaEsp);
		
		this.listaDispo = new JComboBox<String>();
		this.listaDispo.setBounds(95, 200, 180, 20);
		this.add(listaDispo);
		
		this.llenarMedico();
	}
	public void actionPerformed(ActionEvent e) {	
		
		String identificacion = (String) listaMedicos.getSelectedItem();
		
		if(e.getSource()==btnVolver){
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==btnEliminarMedico){
			medico.eliminarEspecialidad(nombre);
			medico.eliminarDisponibilidad(fecha);
			a.eliminarMedico(identificacion);
			EliminarMedico eli= new EliminarMedico();
			this.setVisible(false);
			eli.setVisible(true);
			JOptionPane.showMessageDialog(null, "Medico Eliminado");
		}
		
		if(e.getSource()==btnVerMedico){
			llenarMedico();
		}
	}
	
	private void leerMedicos() {
		DefaultComboBoxModel<String> mlista = new DefaultComboBoxModel<String>();
		
		for (int i = 0; i < a.getLstMedicos().size(); i++) {
			mlista.addElement(a.getLstMedicos().get(i).getIdentificacion());
		}
		listaMedicos.setModel(mlista);
	}
	
	private void leerEspec(){
		DefaultComboBoxModel<String> eLista = new DefaultComboBoxModel<String>();
		
		for (int i = 0; i < medico.getLstEspecialidades().size(); i++) {
			eLista.addElement(medico.getLstEspecialidades().get(i).getNombreEspecialidad());
		}
		listaEsp.setModel(eLista);
	}
	
	private void leerDispo(){
		DefaultComboBoxModel<String> dLista = new DefaultComboBoxModel<String>();
		
		for (int i = 0; i < medico.getLstDisponibilidades().size(); i++) {
			dLista.addElement(medico.getLstDisponibilidades().get(i).getFecha());
		}
		listaDispo.setModel(dLista);
	}
	
	private void llenarMedico() {
		String identificacion = (String) listaMedicos.getSelectedItem();
		medico = a.buscarMedico(medico, identificacion);
		txtIdentificacionMed.setText(medico.getIdentificacion());
		txtNombreMed.setText(medico.getNombreMedico());
		txtApellidoMed.setText(medico.getApellidoMedico());
		txtTelefonoMed.setText(medico.getTelefonoMedico());
		leerEspec();
		leerDispo();
	}
}
