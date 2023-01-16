package cl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ServJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		ServicesBO servicesBO= new ServicesBO();
		   String rst = servicesBO.servicesCall();
		System.out.println("job cron "+rst);
	}

}
