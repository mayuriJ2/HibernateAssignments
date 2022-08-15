package com.citiustech.DAO;
import java.util.Objects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.DBoperations.MovieOperation;
import com.citiustech.model.Movie1;


public class MovieDAOImpl implements MovieDAO {

	private SessionFactory sessionFactory;
	private Session session;

	public MovieDAOImpl() {
		sessionFactory = MovieOperation.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	public String addMovie(Movie1 movie) throws Exception {
		try {
			session.save(movie);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception("Data is not inserted");
		}
		return "Data inserted Successfully";
	}

	public void deleteMovie(String id) {
		Movie1 movie = getMovieDetails(id);
		if (!Objects.isNull(movie)) {
			session.remove(movie);
			session.getTransaction().commit();
		}
	}

	public void updateMovie(Movie1 movie) {
		session.update(movie);
		session.getTransaction().commit();
	}

	public Movie1 getMovieDetails(String id) {
		return session.get(Movie1.class, id);
	}


}
