package soa;

public class RequestHandler {
public String getStateDetails()
{
	String xml = GenerateXML.generateXML(new StateDAO().getStateDetails());
	System.out.println("XmlAtSOAServer  "+xml);
	return xml;
	}
}
