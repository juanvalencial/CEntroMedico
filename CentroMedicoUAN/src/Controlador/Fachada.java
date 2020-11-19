package Controlador;

import Modelo.CentroMedico;

public class Fachada {
	private static String nombre = "Centro Medico UAN";
	private CentroMedico a;
	private static Fachada fachada = null;

	private Fachada() {
		a = new CentroMedico();
		a.setNombreCentroMedico(nombre);
	}

	public static Fachada getInstance() {
		if (fachada == null) {
			fachada = new Fachada();  
		}
		return fachada;
	}

	public CentroMedico getCentroMedico() {
		return a;
	}

}
