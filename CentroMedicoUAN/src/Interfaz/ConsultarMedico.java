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
import Modelo.Disponibilidades;
import Modelo.Medicos;

public class ConsultarMedico extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JButton btnVerMedico;
	private JButton btnVerDispo;
	private JButton btnCrearEspecialidad;
	private JButton btnCrearDisponibilidad;
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
	private JTextField txtHoraInicio;
	private JTextField txtHoraFin;
	private JComboBox<String> listaEsp;
	private JComboBox<String> listaMedicos;
	private JComboBox<String> listaDispo;
	private Medicos medico = new Medicos();
	private Disponibilidades dispo = new Disponibilidades();
	private CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	public ConsultarMedico(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Medico.jpg")));
		this.setTitle("Consultar Medico");
		this.setSize(460, 350);
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
		this.txtIdentificacionMed.setEditable(false);
		this.txtIdentificacionMed.setBounds(90, 50, 180, 20);
		this.add(txtIdentificacionMed);
		
		this.txtNombreMed=new JTextField();
		this.txtNombreMed.setEditable(false);
		this.txtNombreMed.setBounds(90, 80, 180, 20);
		this.add(txtNombreMed);
		
		this.txtApellidoMed=new JTextField();
		this.txtApellidoMed.setEditable(false);
		this.txtApellidoMed.setBounds(90, 110, 180, 20);
		this.add(txtApellidoMed);
		
		this.txtTelefonoMed=new JTextField();
		this.txtTelefonoMed.setEditable(false);
		this.txtTelefonoMed.setBounds(90, 140, 180, 20);
		this.add(txtTelefonoMed);
		
		this.txtHoraInicio=new JTextField();
		this.txtHoraInicio.setEditable(false);
		this.txtHoraInicio.setBounds(90, 230, 180, 20);
		this.add(txtHoraInicio);
		
		this.txtHoraFin=new JTextField();
		this.txtHoraFin.setEditable(false);
		this.txtHoraFin.setBounds(90, 260, 180, 20);
		this.add(txtHoraFin);
	}
	
	private void crearBotones() {
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(130, 290, 120, 20);
		btnVolver.addActionListener(this);
		this.add(btnVolver);
		
		this.btnCrearEspecialidad=new JButton();
		this.btnCrearEspecialidad.setText("Crear Especialidad");
		this.btnCrearEspecialidad.setBounds(290, 140, 150, 20);
		btnCrearEspecialidad.addActionListener(this);
		this.add(btnCrearEspecialidad);
		
		this.btnCrearDisponibilidad=new JButton();
		this.btnCrearDisponibilidad.setText("Crear Disponibilidad");
		this.btnCrearDisponibilidad.setBounds(290, 170, 150, 20);
		btnCrearDisponibilidad.addActionListener(this);
		this.add(btnCrearDisponibilidad);
		
		this.btnVerMedico=new JButton();
		this.btnVerMedico.setText("Visualizar Medico");
		this.btnVerMedico.setBounds(200, 20, 140, 20);
		btnVerMedico.addActionListener(this);
		this.add(btnVerMedico);
		
		this.btnVerDispo=new JButton();
		this.btnVerDispo.setText("Ver");
		this.btnVerDispo.setBounds(290, 200, 70, 20);
		btnVerDispo.addActionListener(this);
		this.add(btnVerDispo);
		
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
		if(e.getSource()==btnVolver){
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==btnVerMedico){
			llenarMedico();
		}
		
		if(e.getSource()==btnVerDispo){
			llenarDisponibilidad();
		}
		
		if(e.getSource()==btnCrearEspecialidad){
			CrearEspecialidad ventana = new CrearEspecialidad(medico);
			ventana.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==btnCrearDisponibilidad){
			CrearDisponibilidad ventana = new CrearDisponibilidad(medico);
			ventana.setVisible(true);
			setVisible(false);
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
	
	private void llenarDisponibilidad(){
		String fecha = (String) listaDispo.getSelectedItem();
		dispo = medico.buscarDisponibilidad(dispo, fecha);
		txtHoraInicio.setText(dispo.getHora_inicio());
		txtHoraFin.setText(dispo.getHora_fin());
	}
}
