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
import Modelo.Disponibilidades;
import Modelo.Especialidades;
import Modelo.Medicos;

public class ModificarMedico extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JButton btnVerMedico;
	private JButton btnModificarMedico;
	private JButton verEspec;
	private JButton verDispo;
	private JLabel identificacionMed;
	private JLabel nombreMed;
	private JLabel apellidoMed;
	private JLabel telefonoMed;
	private JLabel especialidadMed;
	private JLabel fechaMed;
	private JLabel horaInicio;
	private JLabel horaFin;
	private JTextField txtIdentificacionMed;
	private JTextField txtNombreMed;
	private JTextField txtApellidoMed;
	private JTextField txtTelefonoMed;
	private JTextField txtEspecialidad;
	private JTextField txtFechaMed;
	private JTextField txtHoraInicio;
	private JTextField txtHoraFin;
	private JComboBox<String> listaMedicos;
	private JComboBox<String> listaEsp;
	private JComboBox<String> listaDispo;
	private Medicos medico = new Medicos();
	private Disponibilidades dispo = new Disponibilidades();
	private Especialidades espe= new Especialidades();
	private CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	public ModificarMedico(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Medico.jpg")));
		this.setTitle("Modificar Medico");
		this.setSize(500, 350);
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
		
		this.fechaMed=new JLabel();
		this.fechaMed.setText("Fecha Disp.");
		this.fechaMed.setBounds(10, 170, 200, 80);
		this.add(fechaMed);
		
		this.horaInicio=new JLabel();
		this.horaInicio.setText("Hora Ini. Disp.");
		this.horaInicio.setBounds(10, 200, 200, 80);
		this.add(horaInicio);
		
		this.horaFin=new JLabel();
		this.horaFin.setText("Hora Fin Disp.");
		this.horaFin.setBounds(10, 230, 200, 80);
		this.add(horaFin);
	}
	
	private void crearIngresoDatos() {
		this.txtIdentificacionMed=new JTextField();
		this.txtIdentificacionMed.setBounds(90, 50, 180, 20);
		this.add(txtIdentificacionMed);
		
		this.txtNombreMed=new JTextField();
		this.txtNombreMed.setBounds(90, 80, 180, 20);
		this.add(txtNombreMed);
		
		this.txtApellidoMed=new JTextField();
		this.txtApellidoMed.setBounds(90, 110, 180, 20);
		this.add(txtApellidoMed);
		
		this.txtTelefonoMed=new JTextField();
		this.txtTelefonoMed.setBounds(90, 140, 180, 20);
		this.add(txtTelefonoMed);
		
		this.txtEspecialidad=new JTextField();
		this.txtEspecialidad.setBounds(300, 170, 180, 20);
		this.add(txtEspecialidad);
		
		this.txtFechaMed=new JTextField();
		this.txtFechaMed.setBounds(300, 200, 180, 20);
		this.add(txtFechaMed);
		
		this.txtHoraInicio=new JTextField();
		this.txtHoraInicio.setBounds(90, 230, 180, 20);
		this.add(txtHoraInicio);
		
		this.txtHoraFin=new JTextField();
		this.txtHoraFin.setBounds(90, 260, 180, 20);
		this.add(txtHoraFin);
	}
	
	private void crearBotones() {
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(200, 290, 120, 20);
		btnVolver.addActionListener(this);
		this.add(btnVolver);
		
		this.verEspec=new JButton();
		this.verEspec.setText("Ver Espec");
		this.verEspec.setBounds(310, 100, 120, 20);
		verEspec.addActionListener(this);
		this.add(verEspec);
		
		this.verDispo=new JButton();
		this.verDispo.setText("Ver Dispo");
		this.verDispo.setBounds(310, 140, 120, 20);
		verDispo.addActionListener(this);
		this.add(verDispo);
		
		this.btnModificarMedico=new JButton();
		this.btnModificarMedico.setText("Modificar Medico");
		this.btnModificarMedico.setBounds(20, 290, 150, 20);
		btnModificarMedico.addActionListener(this);
		this.add(btnModificarMedico);
		
		this.btnVerMedico=new JButton();
		this.btnVerMedico.setText("Visualizar Medico");
		this.btnVerMedico.setBounds(200, 20, 140, 20);
		btnVerMedico.addActionListener(this);
		this.add(btnVerMedico);
		
		this.listaMedicos = new JComboBox<String>();
		this.listaMedicos.setBounds(10, 20, 149, 20);
		this.add(listaMedicos);
		this.leerMedicos();
		
		this.listaEsp = new JComboBox<String>();
		this.listaEsp.setBounds(90, 170, 180, 20);
		this.add(listaEsp);
		
		this.listaDispo = new JComboBox<String>();
		this.listaDispo.setBounds(90, 200, 180, 20);
		this.add(listaDispo);
		
		this.llenarMedico();
	}
	public void actionPerformed(ActionEvent e) {
		String nombreMedico = (String) listaMedicos.getSelectedItem();
		medico = a.buscarMedico(medico, nombreMedico);
		if(e.getSource()==btnVolver){
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==btnVerMedico){
			llenarMedico();
		}
		
		if(e.getSource()==btnModificarMedico){
			medico.setNombreMedico(txtNombreMed.getText());
			medico.setApellidoMedico(txtApellidoMed.getText());
			medico.setTelefonoMedico(txtTelefonoMed.getText());
			espe.setNombreEspecialidad(txtEspecialidad.getText());
			dispo.setFecha(txtFechaMed.getText());
			dispo.setHora_inicio(txtHoraInicio.getText());
			dispo.setHora_fin(txtHoraFin.getText());
			ModificarMedico eli= new ModificarMedico();
			this.setVisible(false);
			eli.setVisible(true);
			JOptionPane.showMessageDialog(null, "Medico Modificado");
		}
		
		if(e.getSource()==verDispo){
			llenarDisponibilidad();
		}
		
		if(e.getSource()==verEspec){
			llenarEspecialidad();
		}
	}
	
	private void leerMedicos() {
		DefaultComboBoxModel<String> mlista = new DefaultComboBoxModel<String>();
		
		for (int i = 0; i < a.getLstMedicos().size(); i++) {
			mlista.addElement(a.getLstMedicos().get(i).getIdentificacion());
		}
		listaMedicos.setModel(mlista);
		getContentPane().add(listaMedicos);
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
	
	private void llenarDisponibilidad(){
		String fecha = (String) listaDispo.getSelectedItem();
		dispo = medico.buscarDisponibilidad(dispo, fecha);
		txtFechaMed.setText(dispo.getFecha());
		txtHoraInicio.setText(dispo.getHora_inicio());
		txtHoraFin.setText(dispo.getHora_fin());
	}
	
	private void llenarEspecialidad(){
		String nombre = (String) listaEsp.getSelectedItem();
		espe = medico.buscarEspecialidad(espe, nombre);
		txtEspecialidad.setText(espe.getNombreEspecialidad());
	}
}