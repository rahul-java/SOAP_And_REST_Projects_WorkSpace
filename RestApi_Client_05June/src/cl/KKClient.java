package cl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class KKClient {
	public static void main(String[] args) {
		try {
			String detail = "Gunjan,22-12-1990,Noida";
			String url = "http://localhost:8080/RestApi_WebServer_06June/gunjan/ab/abc";
			Client client = Client.create();
			WebResource wr = client.resource(url);
			ClientResponse t = wr.accept("application/text").post(ClientResponse.class, detail);
			String rslt = t.getEntity(String.class);
			System.out.println("client Response " + rslt);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
