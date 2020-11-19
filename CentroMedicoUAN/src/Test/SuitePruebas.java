package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Cliente.class, 
				Disponibilidad.class, 
				Especialidad.class, 
				LoadJSON.class, 
				LoadXML.class, 
				Medico.class,
				Servicio.class })
public class SuitePruebas {

}
