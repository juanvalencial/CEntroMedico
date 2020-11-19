package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Modelo.Disponibilidades;
import Modelo.Medicos;

public class CrearDisponibilidad extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	public JLabel fechaDispo;
	public JLabel horaInicio;
	public JLabel horaFin;
	public JTextField txtFechaDispo;
	public JTextField txtHoraInicio;
	public JTextField txtHoraFin;
	private JButton btnVolver;
	private JButton btnCrearDisponibilidad;
	private Medicos medico;
	private Disponibilidades dispo;
	
	public CrearDisponibilidad(Medicos medico){
		super();
		this.medico=medico;
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Medico.jpg")));
		this.setTitle("Crear Disponibilidad");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngreseDatos();
		this.crearBotones();
	}
	
	private void crearEtiquetas() {
		this.fechaDispo=new JLabel();
		this.fechaDispo.setText("Fecha");
		this.fechaDispo.setBounds(10, 5, 200, 80);
		this.add(fechaDispo);
		
		this.horaInicio=new JLabel();
		this.horaInicio.setText("Hora Inicio");
		this.horaInicio.setBounds(10, 35, 200, 80);
		this.add(horaInicio);
		
		this.horaFin=new JLabel();
		this.horaFin.setText("Hora Fin");
		this.horaFin.setBounds(10, 65, 200, 80);
		this.add(horaFin);
	}
	
	private void crearIngreseDatos() {
		this.txtFechaDispo=new JTextField();
		this.txtFechaDispo.setBounds(90, 35, 180, 20);
		this.add(txtFechaDispo);
		
		this.txtHoraInicio=new JTextField();
		this.txtHoraInicio.setBounds(90, 65, 180, 20);
		this.add(txtHoraInicio);
		
		this.txtHoraFin=new JTextField();
		this.txtHoraFin.setBounds(90, 95, 180, 20);
		this.add(txtHoraFin);

	}
	
	private void crearBotones() {
		this.btnCrearDisponibilidad=new JButton();
		this.btnCrearDisponibilidad.setText("Crear Disponibilidad");
		this.btnCrearDisponibilidad.setBounds(40, 130, 150, 20);
		btnCrearDisponibilidad.addActionListener(this);
		this.add(btnCrearDisponibilidad);
		
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(200, 130, 120, 20);
		btnVolver.addActionListener(this);
		this.add(btnVolver);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCrearDisponibilidad){
			if (txtFechaDispo.getText().equals("") || txtHoraInicio.getText().equals("")
					|| txtHoraFin.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Completa el formulario");
			} else {
				dispo = new Disponibilidades();
				dispo.setFecha(txtFechaDispo.getText());
				dispo.setHora_inicio(txtHoraInicio.getText());
				dispo.setHora_fin(txtHoraFin.getText());
				medico.crearDisponibilidad(dispo);
				JOptionPane.showMessageDialog(null, "Disponibilidad Creada Exitosamente");
				limpiarFormulario();
			}
		}
		if(e.getSource()==btnVolver){
			ConsultarMedico ventana = new ConsultarMedico();
			ventana.setVisible(true);
			setVisible(false);
		}
	}

	private void limpiarFormulario() {
		txtFechaDispo.setText("");
		txtHoraInicio.setText("");
		txtHoraFin.setText("");
	}
}
