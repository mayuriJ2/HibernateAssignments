package com.citiustech.model;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;


public class Model {

	private Integer id;
	private String name;
	private Double budget;
	private Integer teamsize;
	private Integer duration;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	private String managername;
	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model(Integer id, String name, Double budget, Integer teamsize, Integer duration,
			LocalDate endDate, String managername) {
		super();
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.teamsize = teamsize;
		this.duration = duration;
		this.endDate = endDate;
		this.managername = managername;
	}
	public Integer getid() {
		return id;
	}
	public void setid(Integer id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public Double getbudget() {
		return budget;
	}
	public void setbudget(Double budget) {
		this.budget = budget;
	}
	public Integer getteamsize() {
		return teamsize;
	}
	public void setteamsize(Integer teamsize) {
		this.teamsize = teamsize;
	}
	public Integer getduration() {
		return duration;
	}
	public void setduration(Integer duration) {
		this.duration = duration;
	}
	public LocalDate getendDate() {
		return endDate;
	}
	public void setendDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getmanagername() {
		return managername;
	}
	public void setmanagername(String managername) {
		this.managername = managername;
	}
	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", budget=" + budget
				+ ", teamsize=" + teamsize + ", duration=" + duration + ", endDate=" + endDate
				+ ", managername=" + managername + "]";
	}
	
}
