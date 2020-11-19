package Test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import Parser.ReadXMLFile;

public class LoadXML {
	ReadXMLFile xml = new ReadXMLFile();
	
	@Test
	public void testLoadXML() throws ParserConfigurationException, SAXException, IOException {
		xml.cargar_xml();
		assertEquals(xml,xml);
	}
}
