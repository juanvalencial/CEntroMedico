package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Modelo.Especialidades;
import Modelo.Medicos;

public class CrearEspecialidad extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel especialidadl;
	private JTextField txtEspecialidad;
	private JButton btnVolver;
	private JButton btnCrearEspecialidad;
	private Medicos medico;
	private Especialidades especialidad;
	
	public CrearEspecialidad(Medicos medico){
		super();
		this.medico=medico;
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Medico.jpg")));
		this.setTitle("Crear Especialidad");
		this.setSize(400, 150);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearIngreseDatos();
		this.crearBotones();
	}

	private void crearEtiquetas() {
		this.especialidadl=new JLabel();
		this.especialidadl.setText("Especialidad");
		this.especialidadl.setBounds(10, 5, 200, 80);
		this.add(especialidadl);
	}

	private void crearIngreseDatos() {
		this.txtEspecialidad=new JTextField();
		this.txtEspecialidad.setBounds(90, 35, 180, 20);
		this.add(txtEspecialidad);
	}

	private void crearBotones() {
		this.btnCrearEspecialidad=new JButton();
		this.btnCrearEspecialidad.setText("Crear Especialidad");
		this.btnCrearEspecialidad.setBounds(40, 70, 150, 20);
		btnCrearEspecialidad.addActionListener(this);
		this.add(btnCrearEspecialidad);
		
		this.btnVolver=new JButton();
		this.btnVolver.setText("Volver");
		this.btnVolver.setBounds(200, 70, 120, 20);
		btnVolver.addActionListener(this);
		this.add(btnVolver);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCrearEspecialidad){
			if (txtEspecialidad.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Completa el formulario");
			} else {
				especialidad = new Especialidades();
				especialidad.setNombreEspecialidad(txtEspecialidad.getText());
				medico.crearEspecialidad(especialidad);
				JOptionPane.showMessageDialog(null, "Especialidad Creada Exitosamente");
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
		txtEspecialidad.setText("");
	}
}
