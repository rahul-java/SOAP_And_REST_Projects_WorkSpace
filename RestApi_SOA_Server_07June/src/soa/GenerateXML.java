package soa;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class GenerateXML {
	
	
	
public static String generateXML(StateMasterList allState)
{
	  try {
		 
		 JAXBContext ct = JAXBContext.newInstance(StateMasterList.class);
		  Marshaller cm = ct.createMarshaller();
		 StringWriter sw = new StringWriter();
		 cm.marshal(allState, sw);
		return  sw.toString();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
}
