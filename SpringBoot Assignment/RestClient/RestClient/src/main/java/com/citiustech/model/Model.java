package com.citiustech.model;
import java.time.LocalDate;


public class Model {
	private Integer projectId;
	private String projectName;
	private Double budget;
	private Integer teamSize;
	private Integer duration;
	private LocalDate endDate;
	private String managerName;
	
	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Model(Integer projectId, String projectName, Double budget, Integer teamSize, Integer duration,
			LocalDate endDate, String managerName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.budget = budget;
		this.teamSize = teamSize;
		this.duration = duration;
		this.endDate = endDate;
		this.managerName = managerName;
		
			
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Integer getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
		
		}

	@Override
	public String toString() {
		return "Model [projectId=" + projectId + ", projectName=" + projectName + ", budget=" + budget + ", teamSize="
				+ teamSize + ", duration=" + duration + ", endDate=" + endDate + ", managerName=" + managerName + "]";
	}	
	
	}