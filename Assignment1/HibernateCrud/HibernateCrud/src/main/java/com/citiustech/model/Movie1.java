package com.citiustech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie1 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Movie1() {
			
	}
	public Movie1(String movieId, String movieName, String language, Integer releasedIn,
			Integer revenueInDollars) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.language = language;
		this.releasedIn = releasedIn;
		this.revenueInDollars = revenueInDollars;
	}

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MovieId")
	private String movieId;

	@Column(name = "MovieName")
	private String movieName;

	@Column(name = "Language")
	private String language;

	@Column(name = "ReleasedIn")
	private Integer releasedIn;

	@Column(name = "RevenueInDollars")
	private Integer revenueInDollars;


	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getReleasedIn() {
		return releasedIn;
	}

	public void setReleasedIn(Integer releasedIn) {
		this.releasedIn = releasedIn;
	}

	public Integer getRevenueInDollars() {
		return revenueInDollars;
	}

	public void setRevenueInDollars(Integer revenueInDollars) {
		this.revenueInDollars = revenueInDollars;
	}
	@Override
	public String toString() {
		return "Movie1 [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", releasedIn="
				+ releasedIn + ", revenueInDollars=" + revenueInDollars + "]";
	}

	
}

