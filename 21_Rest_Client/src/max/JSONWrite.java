package max;

import org.codehaus.jackson.map.ObjectMapper;

public class JSONWrite {

	
	public static String generateJSON(SHGDetails sHGDetails)
	{
		try {
			ObjectMapper ob = new ObjectMapper();
			String shgString = ob.writeValueAsString(sHGDetails);
			return shgString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
