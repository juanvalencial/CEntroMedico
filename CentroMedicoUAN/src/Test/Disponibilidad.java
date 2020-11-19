package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Modelo.Disponibilidades;
import Modelo.Medicos;

public class Disponibilidad {

	String fecha;
	String horaI;
	String horaF;
	Medicos med=new Medicos();
	Disponibilidades dsp=new Disponibilidades();
	
	@Test
	public void testDisponibilidadCreado() {
		dsp.setFecha(fecha);
		dsp.setHora_inicio(horaI);
		dsp.setHora_fin(horaF);
		med.crearDisponibilidad(dsp);
		assertEquals(dsp,dsp);
	}
	
	@Test
	public void testDisponibilidadConsultado() {
		med.buscarDisponibilidad(dsp, fecha);
		assertEquals(dsp,dsp);
	}
	
	@Before
	public void setUpClass() {
		fecha="13/10/18";
		horaI="12:00";
		horaF="13:00";
	}
	
	@After
	public void tearDownClass() {
		fecha="";
		horaI="";
		horaF="";
	}

}
