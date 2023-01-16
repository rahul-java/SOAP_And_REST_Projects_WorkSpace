package max;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/ab")
public class RH {
	@POST
	@Path("/abc")
	public String getData(String str) 
	{
		     
		
		
		     System.out.println("str "+str);
		
		return "Hi "+str;
	}
	
	
	
	}


