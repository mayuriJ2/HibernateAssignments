package com.citiustech;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.citiustech.model.Model;


@SpringBootApplication
public class RestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Model project = new Model();
		addProjectDetail();
		//updateProjectDetail(2);
		//deleteProjectDetail(2);
		//getProjectDetails();
	}
	
	public void addProjectDetail() {
		String url = "http://localhost:8080/ct/addProject";
		Model p= new Model();
		p.setBudget(10.00);
		p.setDuration(1);
		p.setEndDate(LocalDate.now());
		p.setManagerName("RRR");
		p.setTeamSize(15);
		p.setProjectName("DELTA");
		RestTemplate restTemplate = new RestTemplate();
		//1st parameter is url,2nd parameter is request body, 3rd parameter is return type
		String response = restTemplate.postForObject(url, p, String.class);
		System.out.println(response);
	}
	
	public void updateProjectDetail(Integer projectId) {
		String url = "http://localhost:8080/ct/updateProject/{projectId}";
		RestTemplate restTemplate = new RestTemplate();
		Model p = new Model();
		restTemplate.put(url, p,projectId);
	}
	
	public void deleteProjectDetail(Integer projectId) {
		String url = "http://localhost:8080/ct/deleteProject/{projectId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url, projectId);
	}
	
	public void getProjectDetails() {
		String url = "http://localhost:8080/ct/projects";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Model[]> response = restTemplate.getForEntity(url, Model[].class);
		Model[] projectDetails= response.getBody();
		if(projectDetails!=null && projectDetails.length>0) {
			for(Model project: projectDetails) {
				System.out.println(project);
			}
		}
	}
	
	
}
