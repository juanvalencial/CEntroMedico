package Modelo;

import java.util.ArrayList;

public class CentroMedico {

	private String nombreCentroMedico = "Centro Medico UAN";
	private ArrayList<Medicos> lstMedicos = new ArrayList<Medicos>();
	private ArrayList<Servicios> lstServicios = new ArrayList<Servicios>();
	private ArrayList<Eps> lstEps = new ArrayList<Eps>();
	private ArrayList<Clientes> lstCliente = new ArrayList<Clientes>();
	
	public CentroMedico() {

	}
	
	public Eps buscarEps(Eps eps, String nombre){
		for(int i=0; i<getLstEps().size();i++){
			if(getLstEps().get(i).getNombreEps().equals(nombre)){
				eps = (Eps) getLstEps().get(i);
			}
		}
		return eps;
	}
	
	public Clientes buscarCliente(Clientes cliente, String identificacion){
		for(int i=0; i<getLstCliente().size();i++){
			if(getLstCliente().get(i).getIdentificacionCliente().equals(identificacion)){
				cliente = (Clientes) getLstCliente().get(i);
			}
		}
		return cliente;
	}
	
	public Medicos buscarMedico(Medicos medico, String identificacion) {
		for (int i = 0; i < getLstMedicos().size(); i++) {
			if (getLstMedicos().get(i).getIdentificacion().equals(identificacion)) {
				 medico = (Medicos) getLstMedicos().get(i); 
			}
		}
		return medico;
	}
	
	public void eliminarMedico(String identificacion) {
		for (int i = 0; i < lstMedicos.size(); i++) {
			if (lstMedicos.get(i).getIdentificacion().equals(identificacion)) {
				lstMedicos.remove(i);
			}
		}
	}
	
	public Servicios buscarServicio(Servicios servicio, String nombre) {
		for (int i = 0; i < getLstServicios().size(); i++) {
			if (getLstServicios().get(i).getNombreServicio().equals(nombre)) {
				 servicio = (Servicios) getLstServicios().get(i); 
			}
		}
		return servicio;
	}
	
	public void eliminarServicio(String nombreServicio) {
		for (int i = 0; i < lstServicios.size(); i++) {
			if (lstServicios.get(i).getNombreServicio().equals(nombreServicio)) {
				lstServicios.remove(i);
			}
		}
	}
	
	public void crearMedico(Medicos medico) {
		lstMedicos.add(medico);
	}
	
	public void crearServicio(Servicios servicio) {
		lstServicios.add(servicio);
	}
	
	public void crearEps(Eps eps){
		lstEps.add(eps);
	}
	
	public void crearCliente(Clientes cliente){
		lstCliente.add(cliente);
	}

	public ArrayList<Eps> getLstEps() {
		return lstEps;
	}

	public void setLstEps(ArrayList<Eps> lstEps) {
		this.lstEps = lstEps;
	}

	public ArrayList<Medicos> getLstMedicos() {
		return lstMedicos;
	}

	public void setLstMedicos(ArrayList<Medicos> lstMedicos) {
		this.lstMedicos = lstMedicos;
	}

	public ArrayList<Servicios> getLstServicios() {
		return lstServicios;
	}

	public void setLstServicios(ArrayList<Servicios> lstServicios) {
		this.lstServicios = lstServicios;
	}

	public ArrayList<Clientes> getLstCliente() {
		return lstCliente;
	}

	public void setLstCliente(ArrayList<Clientes> lstCliente) {
		this.lstCliente = lstCliente;
	}

	public String getNombreCentroMedico() {
		return nombreCentroMedico;
	}

	public void setNombreCentroMedico(String nombreCentroMedico) {
		this.nombreCentroMedico = nombreCentroMedico;
	}
}