package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Ubicacion extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel ubicacion;
	private JLabel imagen;
	private JTextArea telefonoTi;
	private String textoHistoria="";
	private JButton volver;
	
	public Ubicacion(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Hospital.jpg")));
		this.setTitle("Ubicacion");
		this.setSize(500, 560);
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
		this.titulo.setBounds(160, 5, 200, 80);
		titulo.setFont(new java.awt.Font("Verdana", 1, 15));
		this.add(titulo);
		
		this.ubicacion=new JLabel();
		this.ubicacion.setText("Ubicacion");
		this.ubicacion.setBounds(10, 60, 100, 80);
		this.add(ubicacion);
		
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(
		(ClassLoader.getSystemResource("Imagenes/UbicacionCM.png"))));
		imagen.setBounds(80, 90, 300, 250);
		this.add(imagen);
	}

	private void crearTexto() {
		textoHistoria = "Direccion: Carrera 44 # 22a - 68 \n\n"
		+ "Horario de atencion: Lunes a Viernes 6:00am - 8:00pm \n"
		+ "                                      Sabados 8:00am - 5:00pm \n" ;
				
		this.telefonoTi = new JTextArea();
		this.telefonoTi.setEditable(false);
		this.telefonoTi.setBounds(40, 370, 350, 80);
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
		this.volver.setBounds(190, 480, 120, 20);
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
