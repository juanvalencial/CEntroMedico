package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Politica extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel politica;
	private JTextArea politicaTi;
	private String textoPolitica="";
	private JButton volver;
	
	public Politica(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Hospital.jpg")));
		this.setTitle("Historia");
		this.setSize(380, 390);
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
		this.titulo.setBounds(105, 5, 200, 80);
		titulo.setFont(new java.awt.Font("Verdana", 1, 15));
		this.add(titulo);
		
		this.politica=new JLabel();
		this.politica.setText("Politica de Calidad");
		this.politica.setBounds(10, 60, 200, 80);
		this.add(politica);
	}

	private void crearTexto() {
		textoPolitica = "En el Centro Medico UAN nuestro objetivo del Sistema de "
		+ "Calidad que se a implementado, es la consolidación de la labor que hemos "
		+ "venido adelantando, a través de todos nuestros procesos dirigidos a evitar, " 
		+ "prevenir o resolver oportunamente situaciones que puedan afectar de manera "
		+ "negativa la atención en salud y el logro de los mayores beneficios posibles "
		+ "para los pacientes, con los menores riesgos.";
				
		this.politicaTi = new JTextArea();
		this.politicaTi.setEditable(false);
		this.politicaTi.setBounds(60, 120, 250, 180);
		this.politicaTi.setLineWrap(true);
		this.politicaTi.setText(textoPolitica);
		this.politicaTi.setWrapStyleWord(true);
		this.politicaTi.setBorder(javax.swing.BorderFactory.createBevelBorder(
		javax.swing.border.BevelBorder.LOWERED, null, null, null,
		new java.awt.Color(0, 0, 0)));
		this.add(politicaTi);
	}

	private void crearBotones() {
		this.volver=new JButton();
		this.volver.setText("Volver");
		this.volver.setBounds(125, 320, 120, 20);
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
