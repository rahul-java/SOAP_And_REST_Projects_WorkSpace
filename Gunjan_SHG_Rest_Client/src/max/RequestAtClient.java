package max;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/RequestAtClient")
public class RequestAtClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RequestAtClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "http://localhost:8080/SHG_SERVER_RETASK/reqhandler/getData";
		Client cl = Client.create();
		WebResource w = cl.resource(url);
		ClientResponse cr = w.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class);
		String res = cr.getEntity(String.class);
		
		ObjectMapper o = new ObjectMapper();
		Set<SHGBean> l = (Set<SHGBean>)o.readValue(res, SHGBean.class);
		System.out.println("RequestAtClient "+l.size());
		request.setAttribute("list", l);
		request.getRequestDispatcher("view.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
