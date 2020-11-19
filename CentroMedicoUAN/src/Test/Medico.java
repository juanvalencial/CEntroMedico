package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Controlador.Fachada;
import Modelo.CentroMedico;
import Modelo.Medicos;

public class Medico {
	String id;
	String nomb;
	String apell;
	String tel;
	Medicos med=new Medicos();
	CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	@Test
	public void testMedicoCreado() {
		med.setIdentificacion(id);
		med.setNombreMedico(nomb);
		med.setApellidoMedico(apell);
		med.setTelefonoMedico(tel);
		a.crearMedico(med);
		assertEquals(med,med);
	}
	
	@Test
	public void testMedicoConsultado() {
		a.buscarMedico(med, id);
		assertEquals(med,med);
	}
	
	@Test
	public void testMedicoEliminado() {
		a.eliminarMedico(id);
		assertEquals(med,med);
	}
	
	@Before
	public void setUpClass() {
		id="1234567890";
		nomb="N";
		apell="S";
		tel="1234567";
	}
	
	@After
	public void tearDownClass() {
		id="";
		nomb="";
		apell="";
		tel="";
	}
}
