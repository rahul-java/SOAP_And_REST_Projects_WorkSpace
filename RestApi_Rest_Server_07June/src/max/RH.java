package max;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import soa.RequestHandlerProxy;

@Path("/ab")
public class RH {
	@POST
	@Path("/abc")
	public String getData(String Countrycode) throws JSONException
	{
		
		try {
			RequestHandlerProxy requestHandlerProxy=new RequestHandlerProxy();
			String stxml = requestHandlerProxy.getStateDetails();
			
			JSONObject jb = XML.toJSONObject(stxml);
			return jb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		     
	}
	
	
	
	
	}


