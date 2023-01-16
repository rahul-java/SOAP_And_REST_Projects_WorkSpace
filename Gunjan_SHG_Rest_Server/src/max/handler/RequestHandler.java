package max.handler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import max.bean.SHGBean;
import max.dao.Save_Into_DB;

@Path("reqhandler")
public class RequestHandler {
	
	  @GET
	  @Path("getData") 
	  public String getData() throws JsonGenerationException,
	  JsonMappingException, IOException 
	  { 
		  Set<SHGBean> set = new HashSet<SHGBean>(Save_Into_DB.fetch()); 
		  System.out.println(new ObjectMapper().writeValueAsString(Save_Into_DB.fetch())); 
		  return new ObjectMapper().writeValueAsString(set); 
		  }
	 
		
			/*
			 * public static void main(String[] args) throws JsonParseException,
			 * JsonMappingException, JsonGenerationException, IOException {
			 * 
			 * Set<SHGBean> l=new ObjectMapper().readValue(new RequestHandler().getData(),
			 * new TypeReference<Set<SHGBean>>() { }); //
			 * System.out.println("RequestHandler "+l.size()); System.out.println(new
			 * RequestHandler().getData()); }
			 */
		 
}
