package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Modelo.Especialidades;
import Modelo.Medicos;

public class Especialidad {
	String nombrEsp;
	Especialidades esp = new Especialidades();
	Medicos med=new Medicos();
	
	@Test
	public void testEspecialidadCreado() {
		esp.setNombreEspecialidad(nombrEsp);
		med.crearEspecialidad(esp);
		assertEquals(esp,esp);
	}
	
	@Test
	public void testEspecialidadConsultado() {
		med.buscarEspecialidad(esp, nombrEsp);
		assertEquals(esp,esp);
	}
	
	@Before
	public void setUpClass() {
		nombrEsp="Medicina Inerna";
	}
	
	@After
	public void tearDownClass() {
		nombrEsp="";
	}

}
