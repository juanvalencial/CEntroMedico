package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Controlador.Fachada;
import Modelo.CentroMedico;
import Modelo.Servicios;

public class Servicio {
	String nombr;
	String descr;
	String complej;
	String dur;
	String cost;
	Servicios ser=new Servicios();
	CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	@Test
	public void testServicioCreado() {
		ser.setNombreServicio(nombr);
		ser.setDescripcionServicio(descr);
		ser.setComplejidadServicio(complej);
		ser.setDuracionServicio(dur);
		ser.setCostoServicio(cost);
		a.crearServicio(ser);
		assertEquals(ser,ser);
	}
	
	@Test
	public void testServicioConsultado() {
		a.buscarServicio(ser, nombr);
		assertEquals(ser,ser);
	}
	
	@Test
	public void testServicioEliminado() {
		a.eliminarServicio(nombr);
		assertEquals(ser,ser);
	}
	
	@Before
	public void setUpClass() {
		nombr="Medicina General";
		descr="Examinación General";
		complej="Media";
		dur="20";
		cost="25000";
	}
	
	@After
	public void tearDownClass() {
		nombr="";
		descr="";
		complej="";
		dur="";
		cost="";
	}
}
