package max;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/ab")
public class RH {
	@POST
	@Path("/abc")
	public String getData(String str) throws JSONException
	{
		      JSONArray ja = new JSONArray(str);
		      for(int i=0; i<ja.length();i++)
		      {
		    	 JSONObject j = ja.getJSONObject(i);
		    	String adhar= j.getString("adhar");
		    	String age= j.getString("age");
		    	String name= j.getString("name");
		    	System.out.println(adhar+ " "+age+ " "+name);
		      }
		
		return "Hi "+str;
	}
	
	@POST
	@Path("/abcd")
	public String getData1()
	{
		System.out.println("in server 1");
		return "Hi Gunjan ";
	}

	
	
	}


