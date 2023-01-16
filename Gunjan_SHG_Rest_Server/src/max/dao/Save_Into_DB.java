package max.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import max.bean.MemberNBean;
import max.bean.SHGBean;

public class Save_Into_DB
{

	//static Connection con=JDBCUtility.getConn();
	@SuppressWarnings("deprecation")
	public static boolean insert_Details(SHGBean sHGBean)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
		if((int)ses.save(sHGBean)>0)
			{
			List<MemberNBean> l = sHGBean.getMbean();
			l.forEach(v->ses.save(v));
			tx.commit();
			return true;
			}
		tx.rollback();
		return false;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static List<SHGBean> fetch()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		List<SHGBean> result = ses.createCriteria(SHGBean.class).list();
		return result;
		
	}
	
	
	/*
	 * public static void main(String[] args) { List<SHGBean>
	 * list=Save_Into_DB.fetch();
	 * list.forEach(v->v.getMbean().forEach(w->System.out.println(w.getMname())));
	 * System.out.println("dao "+list.size()); }
	 */
	 
}
