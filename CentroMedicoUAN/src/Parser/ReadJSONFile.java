package Parser;

import java.io.FileInputStream;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import Controlador.Fachada;
import Modelo.CentroMedico;
import Modelo.Disponibilidades;
import Modelo.Eps;
import Modelo.Especialidades;
import Modelo.Medicos;
import Modelo.Servicios;

public class ReadJSONFile {
	private Medicos medico;
	private Servicios servicio ;
	private Especialidades espec ;
	private Disponibilidades dispo;
	private Eps eps;
	private String n,d,f,f1;
	private CentroMedico a = Fachada.getInstance().getCentroMedico();

	public ReadJSONFile(){
		
	}
		
	public  void CargarJson() throws IOException{
		
		FileInputStream fr = new FileInputStream("json/UanMedica v2.json");
		JsonReader reader = Json.createReader(fr);
		JsonObject CmedObject = reader.readObject();
		reader.close();
		
		eps = new Eps();
		
		eps.setNombreEps( CmedObject.getString("nombre"));
		
		eps.setMunicipioEps( CmedObject.getString("ciudad"));
		
		eps.setDireccionEps( CmedObject.getString("direccion"));
		
		eps.setTelefonoEps(CmedObject.getString("telefono"));
		
		a.crearEps(eps);
		
		JsonObject datesObject = CmedObject.getJsonObject("datos");
		JsonArray servicioArreglo = datesObject.getJsonArray("servicio");
		
		for(JsonObject servObject : servicioArreglo.getValuesAs(JsonObject.class)) {
			
			servicio = new Servicios();
			
			servicio.setNombreServicio(servObject.getString("nombre")); 
			
			servicio.setDescripcionServicio(servObject.getString("codigo"));
			
			servicio.setComplejidadServicio(servObject.getString("complejidad"));
			
			servicio.setDuracionServicio(servObject.getString("tiempo"));
			
			servicio.setCostoServicio(servObject.getString("valor"));
			
			a.crearServicio(servicio);
		}
		
		JsonArray doctorArreglo = datesObject.getJsonArray("doctor");
		
		for(JsonObject docObject : doctorArreglo.getValuesAs(JsonObject.class)) {
		
			medico = new Medicos();
			espec = new Especialidades();
			Especialidades espec2 = new Especialidades();
			dispo= new Disponibilidades ();
			Disponibilidades dispo2=new Disponibilidades();
			
			medico.setIdentificacion(docObject.getString("cedula"));
			
			medico.setNombreMedico(docObject.getString("nombre"));
			
			medico.setApellidoMedico(docObject.getString("apellido"));
			
			medico.setTelefonoMedico(docObject.getString("telefono"));
			
			if(docObject.getString("especialidades").equals("MG, MI")){
				espec.setNombreEspecialidad("Medicina General");
				medico.crearEspecialidad(espec);
				
				espec2.setNombreEspecialidad("Medicina Interna");
				medico.crearEspecialidad(espec2);
			}else
				if(docObject.getString("especialidades").equals("OD")){
					espec.setNombreEspecialidad("Odontologia");
					medico.crearEspecialidad(espec);
				}else
					if(docObject.getString("especialidades").equals("MI, MG")){
						espec.setNombreEspecialidad("Medicina Interna");
						medico.crearEspecialidad(espec);
						
						espec2.setNombreEspecialidad("Medicina General");
						medico.crearEspecialidad(espec2);
					}
			
			JsonArray dispoarreglo = docObject.getJsonArray("semana");

			for (JsonObject dispObject : dispoarreglo.getValuesAs(JsonObject.class)) {

				dispo = new Disponibilidades();
				dispo2 = new Disponibilidades(); 
				n=dispObject.getString("numero");
				d=dispObject.getString("dia");
				
				if(n.equals("49")||d.equals("Lunes, Miercoles")){
					f="2017-12-04";
					f1="2017-12-06";
					dispo.setFecha(f);
					dispo2.setFecha(f1);
				}else
					if(n.equals("49")||d.equals("Martes, Jueves")){
						f="2017-12-05";
						f1="2017-12-07";
						dispo.setFecha(f);
						dispo2.setFecha(f1);
					}
				
				JsonArray especialidadArray = dispObject.getJsonArray("asignacion");
		
				for (JsonObject Object : especialidadArray.getValuesAs(JsonObject.class)) {

					dispo.setHora_inicio(Object.getString("inicio_citas"));

					dispo.setHora_fin(Object.getString("fin_citas"));
					
					dispo2.setHora_inicio(Object.getString("inicio_citas"));

					dispo2.setHora_fin(Object.getString("fin_citas"));
				}
				medico.crearDisponibilidad(dispo);
				medico.crearDisponibilidad(dispo2);
			}
			a.crearMedico(medico);
		}
	}
}