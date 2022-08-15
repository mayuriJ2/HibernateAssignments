package com.hibernate;

import java.sql.Date;

import javax.persistence.JoinColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Customer;
import com.model.Locker;
import com.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Customer c = new Customer();
		c.setCustId(2005);
		c.setCustName("Amruta");
		c.setCustDOB(new Date(2020, 12, 10));
		c.setCustAdd("Pune");
		c.setCustPhone("8877665544");

		Locker lock = new Locker();
		lock.setLockerId("lock2212");
		lock.setLockerType("large");
		lock.setRent(2500);

		c.setLocker(lock);

		System.out.println("Record inserted in Locker successfully");
		session.save(c); 
		System.out.println("Record inserted in Customer successfully");
		System.out.println("----------------------");
		Customer customer = session.get(Customer.class, 2005);
		
		System.out.println(customer);
		
		t.commit();

		session.close();

	}
}
