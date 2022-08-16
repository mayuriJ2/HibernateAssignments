package com.citiustech.hibernate;
import java.util.Objects;

import com.citiustech.DAO.MovieDAO;
import com.citiustech.DAO.MovieDAOImpl;
import com.citiustech.model.Movie1;

//done
public class App {

	private static MovieDAO dao = new MovieDAOImpl();

	public static void main(String[] args) throws Exception {
		//insert();
	//read();
		//update();
		delete();
	}

	private static void delete() {
		dao.deleteMovie("MOVIE-001");
	}

	private static void update() {
		Movie1 movie = dao.getMovieDetails("MOVIE-001");
		if(!Objects.isNull(movie)) {
			movie.setRevenueInDollars(movie.getRevenueInDollars()+100);
			dao.updateMovie(movie);
			System.out.println("Data updated successfully");
		}else System.out.println("Data is not updated");
		
	}

	private static void read() {
		Movie1 movie = dao.getMovieDetails("MOVIE-001");
		System.out.println("\n"+movie);
	}

	private static void insert() throws Exception {
		Movie1 movie = new Movie1("MOVIE-001", "She hunk", "English", 2022, 85000);
		System.out.println(dao.addMovie(movie));
	}

}
