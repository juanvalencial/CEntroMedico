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
import Modelo.Clientes;

public class CitasMedicas extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JButton btnVerCliente;
	private JLabel nombreCliente;
	private JLabel apellidoCliente;
	private JLabel idCliente;
	private JLabel edadCliente;
	private JLabel TelefonoCliente;
	private JLabel citaMedico;
	private JLabel citaServicio;
	private JLabel fechaCita;
	private JLabel horaInicioCita;
	private JLabel horaFinCita;
	private JLabel precioCliente;
	private JTextField txtNombreCliente;
	private JTextField txtApellidoCliente;
	private JTextField txtIdCliente;
	private JTextField txtEdadCliente;
	private JTextField txtTelefonoCliente;
	private JTextField txtCitaMedico;
	private JTextField txtCitaServicio;
	private JTextField txtFechaCita;
	private JTextField txtHoraInicioCita;
	private JTextField txtHoraFinCita;
	private JTextField txtPrecioCliente;
	private JComboBox<String> listaCliente;
	private Clientes cliente = new Clientes();
	private CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	public CitasMedicas(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Clientes.png")));
		this.setTitle("Citas Apartadas");
		this.setSize(400, 470);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngresoDatos();
		this.crearBotones();
	}
	
	private void crearEtiquetas() {
		this.idCliente=new JLabel();
		this.idCliente.setText("Identificacion");
		this.idCliente.setBounds(10, 30, 200, 80);
		this.add(idCliente);
		
		this.nombreCliente=new JLabel();
		this.nombreCliente.setText("Nombres");
		this.nombreCliente.setBounds(10, 60, 200, 80);
		this.add(nombreCliente);
		
		this.apellidoCliente=new JLabel();
		this.apellidoCliente.setText("Apellidos");
		this.apellidoCliente.setBounds(10, 90, 200, 80);
		this.add(apellidoCliente);
		
		this.edadCliente=new JLabel();
		this.edadCliente.setText("Edad");
		this.edadCliente.setBounds(10, 120, 200, 80);
		this.add(edadCliente);
		
		this.TelefonoCliente=new JLabel();
		this.TelefonoCliente.setText("Telefono");
		this.TelefonoCliente.setBounds(10, 150, 200, 80);
		this.add(TelefonoCliente);
		
		this.citaMedico=new JLabel();
		this.citaMedico.setText("Medico");
		this.citaMedico.setBounds(10, 180, 200, 80);
		this.add(citaMedico);
		
		this.citaServicio=new JLabel();
		this.citaServicio.setText("Servicio");
		this.citaServicio.setBounds(10, 210, 200, 80);
		this.add(citaServicio);
		
		this.fechaCita=new JLabel();
		this.fechaCita.setText("Fecha");
		this.fechaCita.setBounds(10, 240, 200, 80);
		this.add(fechaCita);
		
		this.horaInicioCita=new JLabel();
		this.horaInicioCita.setText("Hora Inicio");
		this.horaInicioCita.setBounds(10, 270, 200, 80);
		this.add(horaInicioCita);
		
		this.horaFinCita=new JLabel();
		this.horaFinCita.setText("Hora Fin");
		this.horaFinCita.setBounds(10, 300, 200, 80);
		this.add(horaFinCita);
		
		this.precioCliente=new JLabel();
		this.precioCliente.setText("Precio");
		this.precioCliente.setBounds(10, 330, 200, 80);
		this.add(precioCliente);
	}
	
	private void crearIngresoDatos() {
		this.txtIdCliente=new JTextField();
		this.txtIdCliente.setEditable(false);
		this.txtIdCliente.setBounds(90, 60, 180, 20);
		this.add(txtIdCliente);
		
		this.txtNombreCliente=new JTextField();
		this.txtNombreCliente.setEditable(false);
		this.txtNombreCliente.setBounds(90, 90, 180, 20);
		this.add(txtNombreCliente);
		
		this.txtApellidoCliente=new JTextField();
		this.txtApellidoCliente.setEditable(false);
		this.txtApellidoCliente.setBounds(90, 120, 180, 20);
		this.add(txtApellidoCliente);
		
		this.txtEdadCliente=new JTextField();
		this.txtEdadCliente.setEditable(false);
		this.txtEdadCliente.setBounds(90, 150, 180, 20);
		this.add(txtEdadCliente);
		
		this.txtTelefonoCliente=new JTextField();
		this.txtTelefonoCliente.setEditable(false);
		this.txtTelefonoCliente.setBounds(90, 180, 180, 20);
		this.add(txtTelefonoCliente);
		
		this.txtCitaMedico=new JTextField();
		this.txtCitaMedico.setEditable(false);
		this.txtCitaMedico.setBounds(90, 210, 180, 20);
		this.add(txtCitaMedico);
		
		this.txtCitaServicio=new JTextField();
		this.txtCitaServicio.setEditable(false);
		this.txtCitaServicio.setBounds(90, 240, 180, 20);
		this.add(txtCitaServicio);
		
		this.txtFechaCita=new JTextField();
		this.txtFechaCita.setEditable(false);
		this.txtFechaCita.setBounds(90, 270, 180, 20);
		this.add(txtFechaCita);
		
		this.txtHoraInicioCita=new JTextField();
		this.txtHoraInicioCita.setEditable(false);
		this.txtHoraInicioCita.setBounds(90, 300, 180, 20);
		this.add(txtHoraInicioCita);
		
		this.txtHoraFinCita=new JTextField();
		this.txtHoraFinCita.setEditable(false);
		this.txtHoraFinCita.setBounds(90, 330, 180, 20);
		this.add(txtHoraFinCita);
		
		this.txtPrecioCliente=new JTextField();
		this.txtPrecioCliente.setEditable(false);
		this.txtPrecioCliente.setBounds(90, 360, 180, 20);
		this.add(txtPrecioCliente);
		
	}
	
	private void crearBotones() {
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(130, 400, 120, 20);
		btnVolver.addActionListener(this);
		this.add(btnVolver);
		
		this.btnVerCliente=new JButton();
		this.btnVerCliente.setText("Visualizar Cita");
		this.btnVerCliente.setBounds(200, 20, 140, 20);
		btnVerCliente.addActionListener(this);
		this.add(btnVerCliente);
		
		this.listaCliente = new JComboBox<String>();
		this.listaCliente.setBounds(10, 20, 149, 20);
		this.add(listaCliente);
		this.leerCliente();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver){
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==btnVerCliente){
			llenarCliente();
		}
	}

	private void leerCliente() {
		DefaultComboBoxModel<String> mlista = new DefaultComboBoxModel<String>();
		
		for (int i = 0; i < a.getLstCliente().size(); i++) {
			mlista.addElement(a.getLstCliente().get(i).getIdentificacionCliente());
		}
		listaCliente.setModel(mlista);
		getContentPane().add(listaCliente);
	}
	
	private void llenarCliente() {
		String identificacion = (String) listaCliente.getSelectedItem();
		cliente = a.buscarCliente(cliente, identificacion);
		txtIdCliente.setText(cliente.getIdentificacionCliente());
		txtNombreCliente.setText(cliente.getNombreCliente());
		txtApellidoCliente.setText(cliente.getApellidoCliente());
		txtEdadCliente.setText(cliente.getEdadCliente());
		txtTelefonoCliente.setText(cliente.getTelefonoCliente());
		txtCitaMedico.setText(cliente.getCitaMedico());
		txtCitaServicio.setText(cliente.getCitaServicio());
		txtFechaCita.setText(cliente.getFechaCita());
		txtHoraInicioCita.setText(cliente.getHoraInicioCita());
		txtHoraFinCita.setText(cliente.getHoraFinCita());
		txtPrecioCliente.setText(cliente.getPrecioCita());
	}
}
