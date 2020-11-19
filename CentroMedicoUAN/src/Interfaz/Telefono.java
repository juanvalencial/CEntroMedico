package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Telefono extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel telefono;
	private JTextArea telefonoTi;
	private String textoHistoria="";
	private JButton volver;
	
	public Telefono(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Hospital.jpg")));
		this.setTitle("Telefonos");
		this.setSize(340, 320);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearEtiquetas();
		this.crearTexto();
		this.crearBotones();
	}
	
	private void crearEtiquetas() {
		this.titulo=new JLabel();
		this.titulo.setText("Centro Medico UAN");
		this.titulo.setBounds(80, 5, 200, 80);
		titulo.setFont(new java.awt.Font("Verdana", 1, 15));
		this.add(titulo);
		
		this.telefono=new JLabel();
		this.telefono.setText("Telefonos");
		this.telefono.setBounds(10, 60, 200, 80);
		this.add(telefono);
	}

	private void crearTexto() {
		textoHistoria = "Telefonos:  \n\n"
				+ "Linea Nacional: 01 8000 346789 \n"
				+ "Bogota: 1872341 - 8765897 \n" ;
				
		this.telefonoTi = new JTextArea();
		this.telefonoTi.setEditable(false);
		this.telefonoTi.setBounds(60, 110, 200, 100);
		this.telefonoTi.setLineWrap(true);
		this.telefonoTi.setText(textoHistoria);
		this.telefonoTi.setWrapStyleWord(true);
		this.telefonoTi.setBorder(javax.swing.BorderFactory.createBevelBorder(
		javax.swing.border.BevelBorder.LOWERED, null, null, null,
		new java.awt.Color(0, 0, 0)));
		this.add(telefonoTi);
	}

	private void crearBotones() {
		this.volver=new JButton();
		this.volver.setText("Volver");
		this.volver.setBounds(110, 250, 120, 20);
		volver.addActionListener(this);
		this.add(volver);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==volver){
			VentanaClientes ventana = new VentanaClientes();
			ventana.setVisible(true);
			setVisible(false);
		}
	}
}
