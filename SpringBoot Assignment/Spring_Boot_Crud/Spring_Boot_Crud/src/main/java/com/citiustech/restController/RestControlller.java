package com.citiustech.restController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.exception.ExceptionClass;
import com.citiustech.model.Model;
import com.citiustech.service.ServiceLayer;

@RestController
@RequestMapping(value = "/ct")

public class RestControlller {
	@Autowired
	private Environment environment;

	@Autowired
	private ServiceLayer service;

	@GetMapping(value = "/projects")
	public ResponseEntity<List<Model>> getAllProjectsDetails() throws ExceptionClass {
		List<Model> projectList = service.listProjectDetails();
		return new ResponseEntity<>(projectList, HttpStatus.OK);
	}

	@PostMapping("/addProject")
	public ResponseEntity<String> addProjectDetails(@RequestBody Model projectDetails) {
		service.addProjectDetails(projectDetails);
		return new ResponseEntity<String>("Product successfully added", HttpStatus.CREATED);

	}

	@PutMapping(value = "/updateProject/{projectId}")
	public ResponseEntity<String> updateProjectDetails(@PathVariable Integer projectId,
			@RequestBody Model Model) throws ExceptionClass {
		if (service.isProjectExist(projectId)) {
			service.updateProjectDetails(projectId, Model);
			String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		}
		String failMsg = environment.getProperty("Service.PROJECT_NOT_FOUND");
		return new ResponseEntity<>(failMsg, HttpStatus.NOT_FOUND);

	}

	@DeleteMapping(value = "/deleteProject/{projectId}")
	public ResponseEntity<String> deleteProject(@PathVariable Integer projectId) throws ExceptionClass {
		if (service.isProjectExist(projectId)) {
			service.deleteProjectDetails(projectId);
			String successMessage = environment.getProperty("API.DELETE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		}
		String failMsg = environment.getProperty("Service.PROJECT_NOT_FOUND");
		return new ResponseEntity<>(failMsg, HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getProject/{projectId}")
	public ResponseEntity<Model> getProject(@PathVariable Integer projectId) throws ExceptionClass {
		if (service.isProjectExist(projectId)) {
			Model Model = service.getProject(projectId);
			return new ResponseEntity<>(Model, HttpStatus.OK);
		}
		Model Model = null;
		return new ResponseEntity<>(Model, HttpStatus.NOT_FOUND);
	}

}
