package cl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class KKClient {
	public static void main(String[] args) {
		try {
			
			String url="http://localhost:8080/RestApi_Rest_Server_07June/services/ab/abc";
		    Client client = Client.create();
		    WebResource wr = client.resource(url);
		    ClientResponse t = wr.accept("application/text").post(ClientResponse.class,"91");
		    String rslt = t.getEntity(String.class);
		    System.out.println("Xml AT REST CLIENT "+rslt);
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
