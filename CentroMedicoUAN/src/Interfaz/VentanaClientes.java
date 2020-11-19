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

public class VentanaClientes extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JMenuBar menuClientes;
	private JMenu inicio;
	private JMenu empleados;
	private JMenu nuestroCentro;
	private JMenu contactos;
	private JMenuItem consultar;
	private JMenuItem apartar;
	private JMenuItem iniciarSesion;
	private JMenuItem historia;
	private JMenuItem misionVision;
	private JMenuItem politica;
	private JMenuItem telefono;
	private JMenuItem ubicacion;
	private JLabel label;
	private CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	public VentanaClientes(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Hospital.jpg")));
		this.setTitle("Centro Medico UAN (Pagina Principal)");
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
		label.setBounds(-422, 0, 916, 528);
		this.add(label);
	}

	private void crearMenu() {
		menuClientes = new JMenuBar();
		setJMenuBar(menuClientes);
		
		inicio = new JMenu("Inicio");
		menuClientes.add(inicio);
		
		empleados = new JMenu("Empleados");
		menuClientes.add(empleados);
		
		nuestroCentro = new JMenu("Nuestro Centro");
		menuClientes.add(nuestroCentro);
		
		contactos = new JMenu("Contactos");
		menuClientes.add(contactos);
		
		consultar = new JMenuItem("Servicios");
		consultar.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
		consultar.addActionListener(this);
		inicio.add(consultar);
		
		apartar = new JMenuItem("Apartar Cita");
		apartar.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Cita.png"))));
		apartar.addActionListener(this);
		inicio.add(apartar);
		
		iniciarSesion = new JMenuItem("IniciarSesion");
		iniciarSesion.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/LoginEmpleado.jpg"))));
		iniciarSesion.addActionListener(this);
		empleados.add(iniciarSesion);
		
		historia = new JMenuItem("Historia");
		historia.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Historia.png"))));
		historia.addActionListener(this);
		nuestroCentro.add(historia);
		
		misionVision = new JMenuItem("Mision y Vision");
		misionVision.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Mision.jpg"))));
		misionVision.addActionListener(this);
		nuestroCentro.add(misionVision);
		
		politica = new JMenuItem("Politica de Calidad");
		politica.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Politica.jpg"))));
		politica.addActionListener(this);
		nuestroCentro.add(politica);
		
		telefono = new JMenuItem("Telefonos");
		telefono.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Telefono.jpg"))));
		telefono.addActionListener(this);
		contactos.add(telefono);
		
		ubicacion = new JMenuItem("Ubicacion");
		ubicacion.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/Ubicacion.png"))));
		ubicacion.addActionListener(this);
		contactos.add(ubicacion);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==consultar){
			
			if(a.getLstServicios().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Servicios Registrados");
			}else{
				ServiciosCliente v = new ServiciosCliente();
				v.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==apartar){
			if(a.getLstServicios().isEmpty()){
				JOptionPane.showMessageDialog(null, "No Hay Servicios Registrados");
			}else{
				ApartarCita v = new ApartarCita();
				v.setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource()==iniciarSesion){
			IniciarSesion login = new IniciarSesion();
			login.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==historia){
			Historia v = new Historia();
			v.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==misionVision){
			MisionVision v = new MisionVision();
			v.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==politica){
			Politica v = new Politica();
			v.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==telefono){
			Telefono v = new Telefono();
			v.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource()==ubicacion){
			Ubicacion v = new Ubicacion();
			v.setVisible(true);
			setVisible(false);
		}
	}
}
