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
import Modelo.Clientes;
import Modelo.Disponibilidades;
import Modelo.Especialidades;
import Modelo.Medicos;
import Modelo.Servicios;

public class ApartarCita extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel nombresCliente;
	private JLabel apellidosCliente;
	private JLabel identificacionCliente;
	private JLabel edadCliente;
	private JLabel telefonoCliente;
	private JLabel medicosDisponibles;
	private JLabel selectMedico;
	private JLabel especialidadMedico;
	private JLabel selectEspecialidad;
	private JLabel disponibilidadMedico;
	private JLabel selectFecha;
	private JLabel selectHoraInicio;
	private JLabel selectHoraFin;
	private JLabel precioCita;
	private JTextField txtNombreCliente;
	private JTextField txtApellidosCliente;
	private JTextField txtIdentificacionCliente;
	private JTextField txtEdadCliente;
	private JTextField txtTelefonoCliente;
	private JTextField txtSelectMedico;
	private JTextField txtSelectServicio;
	private JTextField txtSelectFecha;
	private JTextField txtSelectHoraInicio;
	private JTextField txtSelectHoraFin;
	private JTextField txtPrecioCita;
	private JButton btnCrearCliente;
	private JButton btnVolverCliente;
	private JButton btnSeleccionarMedico;
	private JButton btnSeleccionarServicio;
	private JButton btnSeleccionarFecha;
	private JComboBox<String> listaEsp;
	private JComboBox<String> listaMedicos;
	private JComboBox<String> listaDispo;
	private Medicos medico = new Medicos();
	private Disponibilidades dispo = new Disponibilidades();
	private Especialidades espe= new Especialidades();
	private Clientes cliente = new Clientes();
	private Servicios servicio = new Servicios();
	private CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	public ApartarCita(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Servicio.jpg")));
		this.setTitle("Apartar Cita");
		this.setSize(400, 530);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngreseDatos();
		this.crearBotones();
	}
	
	private void crearEtiquetas() {
		this.nombresCliente=new JLabel();
		this.nombresCliente.setText("Nombres");
		this.nombresCliente.setBounds(10, 5, 200, 80);
		this.add(nombresCliente);
		
		this.apellidosCliente=new JLabel();
		this.apellidosCliente.setText("Apellidos");
		this.apellidosCliente.setBounds(10, 35, 200, 80);
		this.add(apellidosCliente);
		
		this.identificacionCliente=new JLabel();
		this.identificacionCliente.setText("Identificacion");
		this.identificacionCliente.setBounds(10, 65, 200, 80);
		this.add(identificacionCliente);
		
		this.edadCliente=new JLabel();
		this.edadCliente.setText("Edad");
		this.edadCliente.setBounds(10, 95, 200, 80);
		this.add(edadCliente);
		
		this.telefonoCliente=new JLabel();
		this.telefonoCliente.setText("Telefono");
		this.telefonoCliente.setBounds(10, 125, 200, 80);
		this.add(telefonoCliente);
		
		this.medicosDisponibles=new JLabel();
		this.medicosDisponibles.setText("Medicos");
		this.medicosDisponibles.setBounds(10, 155, 200, 80);
		this.add(medicosDisponibles);
		
		this.selectMedico=new JLabel();
		this.selectMedico.setText("Cita Medico");
		this.selectMedico.setBounds(10, 185, 200, 80);
		this.add(selectMedico);
		
		this.especialidadMedico=new JLabel();
		this.especialidadMedico.setText("Servicio");
		this.especialidadMedico.setBounds(10, 215, 200, 80);
		this.add(especialidadMedico);
		
		this.selectEspecialidad=new JLabel();
		this.selectEspecialidad.setText("Cita Servicio");
		this.selectEspecialidad.setBounds(10, 245, 200, 80);
		this.add(selectEspecialidad);
		
		this.disponibilidadMedico=new JLabel();
		this.disponibilidadMedico.setText("Horario");
		this.disponibilidadMedico.setBounds(10, 275, 200, 80);
		this.add(disponibilidadMedico);
		
		this.selectFecha=new JLabel();
		this.selectFecha.setText("Fecha");
		this.selectFecha.setBounds(10, 305, 200, 80);
		this.add(selectFecha);
		
		this.selectHoraInicio=new JLabel();
		this.selectHoraInicio.setText("Hora Inicio");
		this.selectHoraInicio.setBounds(10, 335, 200, 80);
		this.add(selectHoraInicio);
		
		this.selectHoraFin=new JLabel();
		this.selectHoraFin.setText("Hora Fin");
		this.selectHoraFin.setBounds(10, 365, 200, 80);
		this.add(selectHoraFin);
		
		this.precioCita=new JLabel();
		this.precioCita.setText("Precio");
		this.precioCita.setBounds(10, 395, 200, 80);
		this.add(precioCita);
	}
	
	private void crearIngreseDatos() {
		this.txtNombreCliente=new JTextField();
		this.txtNombreCliente.setBounds(90, 35, 180, 20);
		this.add(txtNombreCliente);
		
		this.txtApellidosCliente=new JTextField();
		this.txtApellidosCliente.setBounds(90, 65, 180, 20);
		this.add(txtApellidosCliente);
		
		this.txtIdentificacionCliente=new JTextField();
		this.txtIdentificacionCliente.setBounds(90, 95, 180, 20);
		this.add(txtIdentificacionCliente);
		
		this.txtEdadCliente=new JTextField();
		this.txtEdadCliente.setBounds(90, 125, 180, 20);
		this.add(txtEdadCliente);
		
		this.txtTelefonoCliente=new JTextField();
		this.txtTelefonoCliente.setBounds(90, 155, 180, 20);
		this.add(txtTelefonoCliente);
		
		this.txtSelectMedico=new JTextField();
		this.txtSelectMedico.setEditable(false);
		this.txtSelectMedico.setBounds(90, 215, 180, 20);
		this.add(txtSelectMedico);
		
		this.txtSelectServicio=new JTextField();
		this.txtSelectServicio.setEditable(false);
		this.txtSelectServicio.setBounds(90, 275, 180, 20);
		this.add(txtSelectServicio);
		
		this.txtSelectFecha=new JTextField();
		this.txtSelectFecha.setEditable(false);
		this.txtSelectFecha.setBounds(90, 335, 180, 20);
		this.add(txtSelectFecha);
		
		this.txtSelectHoraInicio=new JTextField();
		this.txtSelectHoraInicio.setEditable(false);
		this.txtSelectHoraInicio.setBounds(90, 365, 180, 20);
		this.add(txtSelectHoraInicio);
		
		this.txtSelectHoraFin=new JTextField();
		this.txtSelectHoraFin.setEditable(false);
		this.txtSelectHoraFin.setBounds(90, 395, 180, 20);
		this.add(txtSelectHoraFin);
		
		this.txtPrecioCita=new JTextField();
		this.txtPrecioCita.setEditable(false);
		this.txtPrecioCita.setBounds(90, 425, 180, 20);
		this.add(txtPrecioCita);
	}
	
	private void crearBotones() {
		this.btnCrearCliente=new JButton();
		this.btnCrearCliente.setText("Crear");
		this.btnCrearCliente.setBounds(40, 470, 120, 20);
		btnCrearCliente.addActionListener(this);
		this.add(btnCrearCliente);
		
		this.btnVolverCliente=new JButton();
		this.btnVolverCliente.setText("Volver");
		this.btnVolverCliente.setBounds(180, 470, 120, 20);
		btnVolverCliente.addActionListener(this);
		this.add(btnVolverCliente);
		
		this.btnSeleccionarMedico=new JButton();
		this.btnSeleccionarMedico.setText("Seleccionar");
		this.btnSeleccionarMedico.setBounds(280, 185, 110, 20);
		btnSeleccionarMedico.addActionListener(this);
		this.add(btnSeleccionarMedico);
		
		this.btnSeleccionarServicio=new JButton();
		this.btnSeleccionarServicio.setText("Seleccionar");
		this.btnSeleccionarServicio.setBounds(280, 245, 110, 20);
		btnSeleccionarServicio.addActionListener(this);
		this.add(btnSeleccionarServicio);
		
		this.btnSeleccionarFecha=new JButton();
		this.btnSeleccionarFecha.setText("Seleccionar");
		this.btnSeleccionarFecha.setBounds(280, 305, 110, 20);
		btnSeleccionarFecha.addActionListener(this);
		this.add(btnSeleccionarFecha);
		
		this.listaMedicos = new JComboBox<String>();
		this.listaMedicos.setBounds(90, 185, 180, 20);
		this.add(listaMedicos);
		this.leerMedicos();
		
		this.listaEsp = new JComboBox<String>();
		this.listaEsp.setBounds(90, 245, 180, 20);
		this.add(listaEsp);
		
		this.listaDispo = new JComboBox<String>();
		this.listaDispo.setBounds(90, 305, 180, 20);
		this.add(listaDispo);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCrearCliente) {
			for(int i=0; i<a.getLstCliente().size();i++){
				if(a.getLstCliente().get(i).getFechaCita().equals(txtSelectFecha.getText())
				 && a.getLstCliente().get(i).getCitaMedico().equals(txtSelectMedico.getText())
				 && a.getLstCliente().get(i).getHoraInicioCita().equals(txtSelectHoraInicio.getText())
				 && a.getLstCliente().get(i).getHoraFinCita().equals(txtSelectHoraFin.getText())
				 && a.getLstCliente().get(i).getCitaServicio().equals(txtSelectServicio.getText())){
					JOptionPane.showMessageDialog(null, "Esta Cita Ya Esta Apartada.\n"
					+ "Seleccione Otra Cita");
					return;
				}
			}
			cliente = new Clientes();
			cliente.setNombreCliente(txtNombreCliente.getText());
			cliente.setApellidoCliente(txtApellidosCliente.getText());
			cliente.setIdentificacionCliente(txtIdentificacionCliente.getText());
			cliente.setEdadCliente(txtEdadCliente.getText());
			cliente.setTelefonoCliente(txtTelefonoCliente.getText());
			cliente.setCitaMedico(txtSelectMedico.getText());
			cliente.setCitaServicio(txtSelectServicio.getText());
			cliente.setFechaCita(txtSelectFecha.getText());
			cliente.setHoraInicioCita(txtSelectHoraInicio.getText());
			cliente.setHoraFinCita(txtSelectHoraFin.getText());
			cliente.setPrecioCita(txtPrecioCita.getText());
			a.crearCliente(cliente);
			JOptionPane.showMessageDialog(null, "Cita Apartada Exitosamente");
			VentanaClientes v = new VentanaClientes();
			v.setVisible(true);
			setVisible(false);
		}

		if(e.getSource()==btnVolverCliente){
			VentanaClientes v = new VentanaClientes();
			v.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==btnSeleccionarMedico){
			llenarMedico();
		}
		
		if(e.getSource()==btnSeleccionarServicio){
			llenarEspecialidad();
			llenarPrecio();
		}
		
		if(e.getSource()==btnSeleccionarFecha){
			llenarDisponibilidad();
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
		txtSelectMedico.setText(medico.getNombreMedico());
		leerEspec();
		leerDispo();
	}
	
	private void llenarEspecialidad(){
		String nombre = (String) listaEsp.getSelectedItem();
		espe = medico.buscarEspecialidad(espe, nombre);
		txtSelectServicio.setText(espe.getNombreEspecialidad());
	}
	
	private void llenarDisponibilidad(){
		String fecha = (String) listaDispo.getSelectedItem();
		dispo = medico.buscarDisponibilidad(dispo, fecha);
		txtSelectFecha.setText(dispo.getFecha());
		txtSelectHoraInicio.setText(dispo.getHora_inicio());
		txtSelectHoraFin.setText(dispo.getHora_fin());
	}
	
	private void llenarPrecio(){
		String nombre = (String) listaEsp.getSelectedItem();
		servicio = a.buscarServicio(servicio, nombre);
		String precioCM = (servicio.getCostoServicio());
		int precio = Integer.parseInt(precioCM);
		int precioGanancia = (int) ((precio * 0.25)+(precio * 0.15) + precio);
		String precioFinalCentroMedico = Integer.toString(precioGanancia);
		txtPrecioCita.setText(precioFinalCentroMedico);
	}
}