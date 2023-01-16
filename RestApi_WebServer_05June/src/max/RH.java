package max;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/ab")
public class RH {
	@POST
	@Path("/abc")
	public String getData(String str)
	{
		String[] p = str.split(",");
		  for(String t:p)
		  {
			  System.out.println(t);
		  }
		System.out.println("in server");
		return "Hi "+str;
	}
	
	@POST
	@Path("/abcd")
	public String getData1()
	{
		System.out.println("in server 1");
		return "Hi Gunjan ";
	}

	
	// logical Urlthat Client Provied
	//http://localhost:8888/YRestServer/gunjan/ab/abc
	//http://localhost:8888/YRestServer/gunjan/ab/abcd
	}


