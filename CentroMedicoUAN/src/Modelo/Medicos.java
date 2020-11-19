package Modelo;

import java.util.ArrayList;

public class Medicos {
	private String identificacion;
	private String nombreMedico;
	private String apellidoMedico;
	private String telefonoMedico;
	private ArrayList<Disponibilidades> lstDisponibilidades = new ArrayList<Disponibilidades>();
	private ArrayList<Especialidades> lstEspecialidades = new ArrayList<Especialidades>();

	public Medicos() {

	}
	
	public Especialidades buscarEspecialidad(Especialidades espec, String nombre) {
		for (int i = 0; i < getLstEspecialidades().size(); i++) {
			if (getLstEspecialidades().get(i).getNombreEspecialidad().equals(nombre)) {
				 espec = (Especialidades) getLstEspecialidades().get(i); 
			}
		}
		return espec;
	}
	
	public void eliminarEspecialidad(String nombre){
		for (int i = 0; i < lstEspecialidades.size(); i++) {
			if (lstEspecialidades.get(i).getNombreEspecialidad().equals(nombre)) {
				lstEspecialidades.remove(i);
			}
		}
	}
	
	public Disponibilidades buscarDisponibilidad(Disponibilidades dispo, String fecha) {
		for (int i = 0; i < getLstDisponibilidades().size(); i++) {
			if (getLstDisponibilidades().get(i).getFecha().equals(fecha)) {
				 dispo = (Disponibilidades) getLstDisponibilidades().get(i); 
			}
		}
		return dispo;
	}
	
	public void eliminarDisponibilidad(String fecha){
		for (int i = 0; i < lstDisponibilidades.size(); i++) {
			if (lstDisponibilidades.get(i).getFecha().equals(fecha)) {
				lstDisponibilidades.remove(i);
			}
		}
	}
	
	public void crearEspecialidad(Especialidades especialidad) {
		lstEspecialidades.add(especialidad);
	}
	
	public void crearDisponibilidad(Disponibilidades disponibilidad){
		lstDisponibilidades.add(disponibilidad);
	}

	public ArrayList<Disponibilidades> getLstDisponibilidades() {
		return lstDisponibilidades;
	}

	public void setLstDisponibilidades(ArrayList<Disponibilidades> lstDisponibilidades) {
		this.lstDisponibilidades = lstDisponibilidades;
	}

	public ArrayList<Especialidades> getLstEspecialidades() {
		return lstEspecialidades;
	}

	public void setLstEspecialidades(ArrayList<Especialidades> lstEspecialidades) {
		this.lstEspecialidades = lstEspecialidades;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getApellidoMedico() {
		return apellidoMedico;
	}

	public void setApellidoMedico(String apellidoMedico) {
		this.apellidoMedico = apellidoMedico;
	}

	public String getTelefonoMedico() {
		return telefonoMedico;
	}

	public void setTelefonoMedico(String telefonoMedico) {
		this.telefonoMedico = telefonoMedico;
	}
}
