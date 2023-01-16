package cl;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class CronTimeClass {
	
	public CronTimeClass()
	{
		try {
			
			   SchedulerFactory st = new StdSchedulerFactory();
			  Scheduler schedulr = st.getScheduler();
			  schedulr.start();
			  
			  JobDetail jDetail = new JobDetail("t1","t2",ServJob.class);
			 
	          // CronTrigger crnTrigger = new CronTrigger("t3","t2","0/10 * * * * ?");
			  CronTrigger crnTrigger = new CronTrigger("t3","t2"," 0 0 * * * ?");
	           schedulr.scheduleJob(jDetail, crnTrigger);
	           
	          
			  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
