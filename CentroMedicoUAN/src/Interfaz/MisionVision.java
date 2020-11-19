package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MisionVision extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel misionTi;
	private JLabel visionTi;
	private JTextArea mision;
	private String textoMision="";
	private JTextArea vision;
	private String textoVision="";
	private JButton volver;
	
	public MisionVision(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Hospital.jpg")));
		this.setTitle("Mision y Vision");
		this.setSize(340, 420);
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
		
		this.misionTi=new JLabel();
		this.misionTi.setText("Mision");
		this.misionTi.setBounds(10, 60, 200, 80);
		this.add(misionTi);
		
		this.visionTi=new JLabel();
		this.visionTi.setText("Vision");
		this.visionTi.setBounds(10, 200, 200, 80);
		this.add(visionTi);
	}

	private void crearTexto() {
		textoMision = "Brindar y mantener la diferencia en servicios de  "
		+ "salud integrales adaptados a las necesidades y exigencias de nuestros "
		+ "pacientes, apoyados en las nuevas tecnologias.";
		
		this.mision = new JTextArea();
		this.mision.setEditable(false);
		this.mision.setBounds(60, 100, 200, 100);
		this.mision.setLineWrap(true);
		this.mision.setText(textoMision);
		this.mision.setWrapStyleWord(true);
		this.mision.setBorder(javax.swing.BorderFactory.createBevelBorder(
		javax.swing.border.BevelBorder.LOWERED, null, null, null,
		new java.awt.Color(0, 0, 0)));
		this.add(mision);
		
		textoVision = "Ser reconocidos como el centro medico a nivel "
		+ "nacional e internacional por brindar soluciones integrales "
		+ "y servicios de calidad a la comunidad";

		this. vision = new JTextArea();
		this.vision.setEditable(false);
		this.vision.setBounds(60, 230, 200, 100);
		this.vision.setLineWrap(true);
		this.vision.setText(textoVision);
		this.vision.setWrapStyleWord(true);
		this.vision.setBorder(javax.swing.BorderFactory.createBevelBorder(
		javax.swing.border.BevelBorder.LOWERED, null, null, null,
		new java.awt.Color(0, 0, 0)));
		this.add(vision);
	}

	private void crearBotones(){
		this.volver=new JButton();
		this.volver.setText("Volver");
		this.volver.setBounds(110, 350, 120, 20);
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
