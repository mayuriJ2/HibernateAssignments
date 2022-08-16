package com.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.util.HibernateUtil;

public class Operation {

	public static void main(String[] args) {
		
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();

		Session session = sessionfactory.openSession();
		Transaction t = session.beginTransaction();
		
		Query query1 = session.createQuery("SELECT MAX(revenueInDollars) FROM Movie");
		//System.out.println("\nMAX revenue In Dollars --> "+query1.list()+"\n");
		
		//Min
		Query query2 = session.createQuery("SELECT MIN(revenueInDollars) FROM Movie");
		//System.out.println("\nMIN revenue In Dollars --> "+query2.list()+"\n");
		
		//Sum
		Query query3 = session.createQuery("SELECT SUM(revenueInDollars) FROM Movie");
		//System.out.println("\nSUM revenue In Dollars --> "+query3.list()+"\n");
		
		//AVG
		Query query4 = session.createQuery("SELECT AVG(revenueInDollars) FROM Movie");
		//System.out.println("\nAVG revenue In Dollars --> "+query4.list()+"\n");
		
		//COUNT
		String language = "Marathi";
		Query query5 = session.createQuery("SELECT COUNT(*) FROM Movie where language=:lan");
		query5.setString("lan", language);
		System.out.println("\nAs per Provided language total count -->  "+query5.list()+"\n");
		
		//Group By
		Query query6 = session.createQuery("SELECT COUNT(*) FROM Movie m GROUP BY m.language");
		System.out.println(query6.list()+"\n");
	}
}
