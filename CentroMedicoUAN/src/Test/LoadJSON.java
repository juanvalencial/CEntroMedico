package Test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import Parser.ReadJSONFile;

public class LoadJSON {
	ReadJSONFile json = new ReadJSONFile();
	
	@Test
	public void testLoadJSON() throws ParserConfigurationException, SAXException, IOException {
		json.CargarJson();
		assertEquals(json,json);
	}

}
