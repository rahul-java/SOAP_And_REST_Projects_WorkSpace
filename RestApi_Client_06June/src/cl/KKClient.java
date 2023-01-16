package cl;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class KKClient {
	public static void main(String[] args) {
		try {
			while(true)
			{
			JSONObject j = new JSONObject();
			j.put("name", "rampal");
			j.put("adhar", "1222222");
			j.put("age", "25");
			
			JSONObject j1 = new JSONObject();
			j1.put("name", "rajpal");
			j1.put("adhar", "777777");
			j1.put("age", "35");
			
			 JSONArray ja = new JSONArray();
			ja.put(j);
			ja.put(j1);
			
			String url="http://localhost:8080/RestApi_WebServer_06June/gunjan/ab/abc";
		Client client = Client.create();
		WebResource wr = client.resource(url);
		 ClientResponse t = wr.accept("application/json").post(ClientResponse.class,ja.toString());
		   String rslt = t.getEntity(String.class);
		   System.out.println("client Response "+rslt);
		   Thread.sleep(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
