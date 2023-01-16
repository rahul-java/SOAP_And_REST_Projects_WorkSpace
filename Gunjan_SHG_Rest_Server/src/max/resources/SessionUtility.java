package max.resources;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtility {
	private SessionUtility()
	{
		
	}
  private static ThreadLocal<Session>	ses=new ThreadLocal<Session>();
   static SessionFactory sf=null;
  static
	{
		try {
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			  sf = conf.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Session getSession()
	{
		    Session s = ses.get();
		    if(s==null)
		    {
		    	s=sf.openSession();
		    	ses.set(s);
		    }
		    return s;
	}
	
	public static void sessionClose()
	{
		Session s = ses.get();
		if(s!=null)
		{
			ses.set(null);
		}
		
	}
	
	
}
