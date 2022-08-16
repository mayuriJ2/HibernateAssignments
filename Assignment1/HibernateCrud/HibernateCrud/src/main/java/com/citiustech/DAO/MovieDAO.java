package com.citiustech.DAO;

import com.citiustech.model.Movie1;

public interface MovieDAO {

	String addMovie(Movie1 movie) throws Exception;

	void deleteMovie(String id);

	void updateMovie(Movie1 movie);

	Movie1 getMovieDetails(String string);
}
