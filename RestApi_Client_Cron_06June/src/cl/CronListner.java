package cl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CronListner implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized");
		CronTimeClass h=new CronTimeClass();
		
	}

}
