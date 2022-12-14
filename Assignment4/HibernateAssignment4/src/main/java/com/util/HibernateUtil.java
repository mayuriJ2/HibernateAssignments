package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.model.Director;
import com.model.MarathiMovies;
import com.model.Movie;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
		            try {
	                Configuration configuration = new Configuration();
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
	                settings.put(Environment.URL, "jdbc:sqlserver://CM1VA753\\SQLEXPRESS;trustServerCertificate=true;databaseName=HibernateAssignment4");
	                 settings.put(Environment.USER, "sa");			
	                settings.put(Environment.PASS, "password_123");
	                //org.hibernate.dialect.MySQLInnoDBDialect;; org.hibernate.dialect.MySQL57Dialect, "org.hibernate.dialect.MySQL8Dialect");SQLServer2008Dialect
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2008Dialect");
	                settings.put(Environment.SHOW_SQL, "true");
	                settings.put(Environment.FORMAT_SQL,"true");
	                settings.put(Environment.HBM2DDL_AUTO, "update");
		                configuration.setProperties(settings);
		                configuration.addAnnotatedClass(Director.class);
		                configuration.addAnnotatedClass(Movie.class);
		                configuration.addAnnotatedClass(MarathiMovies.class);
		                
		                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                   .applySettings(configuration.getProperties()).build();
	              sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	
	            } catch (Exception e) {
	
	            }
	
	        }
	
	        return sessionFactory;

	    }

	
	
}
