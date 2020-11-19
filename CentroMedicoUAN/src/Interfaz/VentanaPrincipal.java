package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Controlador.Fachada;
import Modelo.CentroMedico;
import Modelo.Disponibilidades;
import Modelo.Especialidades;
import Modelo.Medicos;
import Parser.ReadJSONFile;
import Parser.ReadXMLFile;

public class VentanaPrincipal extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JMenuBar menu;
	private JMenu medico;
	private JMenu servicio;
	private JMenu cargar;
	private JMenu contratos;
	private JMenu salir;
	private JMenuItem crearMedico;
	private JMenuItem consultarMedico;
	private JMenuItem modificarMedico;
	private JMenuItem eliminarMedico;
	private JMenuItem crearServicio;
	private JMenuItem consultarServicio;
	private JMenuItem modificarServicio;
	private JMenuItem eliminarServicio;
	private JMenuItem cargarXML;
	private JMenuItem cargarJSON;
	private JMenuItem eps;
	private JMenuItem clientes;
	private JMenuItem cerrarSesion;
	private JLabel label;
	private CentroMedico a = Fachada.getInstance().getCentroMedico();
	private String cargaXML;
	private String cargaJSON;
	
	public VentanaPrincipal(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Hospital.jpg")));
		this.setTitle("Centro Medico UAN");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearFondo();
		this.crearMenu();
	}
	
	private void crearFondo() {
		label = new JLabel();
		label.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Medico.jpg"))));
		label.setBounds(-422, -178, 916, 528);
		this.add(label);
	}
	
	private void crearMenu() {
		menu = new JMenuBar();
		setJMenuBar(menu);
		
		medico = new JMenu("Medicos");
		menu.add(medico);
		
		servicio = new JMenu("Servicios");
		menu.add(servicio);
		
		cargar = new JMenu("Cargar");
		menu.add(cargar);
		
		contratos = new JMenu("Contratos");
		menu.add(contratos);
		
		salir = new JMenu("Salir");
		menu.add(salir);
		
		crearMedico = new JMenuItem("Crear");
		crearMedico.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Crear.png"))));
		crearMedico.addActionListener(this);
		medico.add(crearMedico);
		
		consultarMedico = new JMenuItem("Consultar");
		consultarMedico.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
		consultarMedico.addActionListener(this);
		medico.add(consultarMedico);
		
		modificarMedico = new JMenuItem("Modificar");
		modificarMedico.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
		modificarMedico.addActionListener(this);
		medico.add(modificarMedico);
		
		eliminarMedico = new JMenuItem("Eliminar");
		eliminarMedico.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
		eliminarMedico.addActionListener(this);
		medico.add(eliminarMedico);
		
		crearServicio = new JMenuItem("Crear");
		crearServicio.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Crear.png"))));
		crearServicio.addActionListener(this);
		servicio.add(crearServicio);
		
		consultarServicio = new JMenuItem("Consultar");
		consultarServicio.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
		consultarServicio.addActionListener(this);
		servicio.add(consultarServicio);
		
		modificarServicio = new JMenuItem("Modificar");
		modificarServicio.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
		modificarServicio.addActionListener(this);
		servicio.add(modificarServicio);
		
		eliminarServicio = new JMenuItem("Eliminar");
		eliminarServicio.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
		eliminarServicio.addActionListener(this);
		servicio.add(eliminarServicio);
		
		cargarXML = new JMenuItem("XML");
		cargarXML.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/CargarXML.png"))));
		cargarXML.addActionListener(this);
		cargar.add(cargarXML);
		
		cargarJSON = new JMenuItem("JSON");
		cargarJSON.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/CargarJSON.png"))));
		cargarJSON.addActionListener(this);
		cargar.add(cargarJSON);
		
		eps = new JMenuItem("EPS");
		eps.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/PrecioServicio.png"))));
		eps.addActionListener(this);
		contratos.add(eps);
		
		clientes = new JMenuItem("Citas Apartadas");
		clientes.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Clientes.png"))));
		clientes.addActionListener(this);
		contratos.add(clientes);
		
		cerrarSesion = new JMenuItem("Cerrar Sesion");
		cerrarSesion.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Salir.png"))));
		cerrarSesion.addActionListener(this);
		salir.add(cerrarSesion);
	}
	
	public void actionPerformed(ActionEvent e) {
		Medicos medico = new Medicos();
		Especialidades especialidad = new Especialidades();
		Disponibilidades dispo = new Disponibilidades();
		if(e.getSource()==crearMedico){
			CrearMedico ventana = new CrearMedico(medico,especialidad,dispo);
			ventana.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==consultarMedico){
			if(a.getLstMedicos().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ningun Medico Registrado");
			}else{
				ConsultarMedico ventana = new ConsultarMedico();
				ventana.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==modificarMedico){
			if(a.getLstMedicos().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ningun Medico Registrado");
			}else{
				ModificarMedico ventana = new ModificarMedico();
				ventana.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==eliminarMedico){
			if(a.getLstMedicos().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ningun Medico Registrado");
			}else{
				EliminarMedico ventana = new EliminarMedico();
				ventana.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==crearServicio){
			CrearServicio ventana = new CrearServicio();
			ventana.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==consultarServicio){
			if(a.getLstServicios().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ningun Servicio Registrado");
			}else{
				ConsultarServicio ventana = new ConsultarServicio();
				ventana.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==modificarServicio){
			if(a.getLstServicios().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ningun Servicio Registrado");
			}else{
				ModificarServicio ventana = new ModificarServicio();
				ventana.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==eliminarServicio){
			if(a.getLstServicios().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ningun Servicio Registrado");
			}else{
				EliminarServicio ventana = new EliminarServicio();
				ventana.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==cargarXML){
			
			if(cargaXML=="listo"){
				JOptionPane.showMessageDialog(null, "El XML Ya Se Cargo");
			}else{
				ReadXMLFile xml=new ReadXMLFile();
				try {
					xml.cargar_xml();
					JOptionPane.showMessageDialog(null, "XML Cargado Exitosamente");
					cargaXML="listo";
				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==cargarJSON){
			if(cargaJSON=="listo"){
				JOptionPane.showMessageDialog(null, "El JSON Ya Se Cargo");
			}else{
				ReadJSONFile json=new ReadJSONFile();
				try {
					json.CargarJson();
					JOptionPane.showMessageDialog(null, "JSON Cargado Exitosamente");
					cargaJSON="listo";
				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==eps){
			if(a.getLstEps().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ninguna EPS Registrada");
			}else{
				DatosEps ventana = new DatosEps();
				ventana.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==clientes){
			if(a.getLstCliente().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Ninguna Cita Registrada");
			}else{
				CitasMedicas ventana = new CitasMedicas();
				ventana.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==cerrarSesion){
			VentanaClientes ventana = new VentanaClientes();
			ventana.setVisible(true);
			setVisible(false);
		}
	}
}
