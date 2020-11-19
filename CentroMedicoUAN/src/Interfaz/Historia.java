package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Historia extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel historia;
	private JTextArea historiaTi;
	private String textoHistoria="";
	private JButton volver;
	
	public Historia(){
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage
		(ClassLoader.getSystemResource("Imagenes/Hospital.jpg")));
		this.setTitle("Historia");
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
		
		this.historia=new JLabel();
		this.historia.setText("Historia");
		this.historia.setBounds(10, 60, 200, 80);
		this.add(historia);
	}

	private void crearTexto() {
		textoHistoria = "El 27 de agosto del 2017, a las 2:30 de la tarde fue inagurado "
		+ "el Centro Medico UAN con el fin de brindar buen servicio de calidad en el "
		+ "ambito de la medicina, dia tras dia hemos ido evolucionando en tipos de " 
		+ "servicios medicos.";
				
		this.historiaTi = new JTextArea();
		this.historiaTi.setEditable(false);
		this.historiaTi.setBounds(60, 100, 200, 120);
		this.historiaTi.setLineWrap(true);
		this.historiaTi.setText(textoHistoria);
		this.historiaTi.setWrapStyleWord(true);
		this.historiaTi.setBorder(javax.swing.BorderFactory.createBevelBorder(
		javax.swing.border.BevelBorder.LOWERED, null, null, null,
		new java.awt.Color(0, 0, 0)));
		this.add(historiaTi);
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
