package max;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ServicesCode {

	
	public static String getResponseByServer(String jrst)
	{
		try {
			
	String url="http://localhost:8080/21RestServer/abc/ab/abc";
			Client client = Client.create();
			WebResource wr = client.resource(url);
			 ClientResponse t = wr.accept("application/json").post(ClientResponse.class,jrst);
			   String rslt = t.getEntity(String.class);
			return rslt;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
