package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Controlador.Fachada;
import Modelo.CentroMedico;
import Modelo.Clientes;

public class Cliente {
	String nombr;
	String apell;
	String id;
	String edad;
	String telef;
	String citaMed;
	String citaSer;
	String fechaCit;
	String horaIni;
	String horaFin;
	String precioC;
	
	Clientes cli=new Clientes();
	CentroMedico a = Fachada.getInstance().getCentroMedico();
	
	@Test
	public void testClienteCreado() {
		cli.setNombreCliente(nombr);
		cli.setApellidoCliente(apell);
		cli.setIdentificacionCliente(id);
		cli.setEdadCliente(edad);
		cli.setTelefonoCliente(telef);
		cli.setCitaMedico(citaMed);
		cli.setCitaServicio(citaSer);
		cli.setFechaCita(fechaCit);
		cli.setHoraInicioCita(horaIni);
		cli.setHoraFinCita(horaFin);
		cli.setPrecioCita(precioC);
		a.crearCliente(cli);
		assertEquals(cli,cli);
	}
	
	@Test
	public void testClienteConsultado() {
		a.buscarCliente(cli, id);
		assertEquals(cli,cli);
	}
	
	@Before
	public void setUpClass() {
		nombr="N";
		apell="S";
		id="1234569";
		edad="21";
		telef="1234543";
		citaMed="Juan";
		citaSer="Medicina General";
		fechaCit="12/10/18";
		horaIni="12:00";
		horaFin="12:30";
		precioC="28000";
	}
	
	@After
	public void tearDownClass() {
		nombr="";
		apell="";
		id="";
		edad="";
		telef="";
		citaMed="";
		citaSer="";
		fechaCit="";
		horaIni="";
		horaFin="";
		precioC="";
	}
}
