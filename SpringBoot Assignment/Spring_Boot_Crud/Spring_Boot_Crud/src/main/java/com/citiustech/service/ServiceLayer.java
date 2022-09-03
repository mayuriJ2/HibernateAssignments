package com.citiustech.service;
import java.util.List;

import com.citiustech.entity.Project;
import com.citiustech.exception.ExceptionClass;
import com.citiustech.model.Model;


public interface ServiceLayer {

	public Project addProjectDetails(Model project);
	public void updateProjectDetails(int ProjectId, Model Model) throws ExceptionClass;
	public void deleteProjectDetails(int projectId) throws ExceptionClass;
	public List<Model> listProjectDetails() throws ExceptionClass;
	public Model getProject(Integer ProjectId) throws ExceptionClass;
	public boolean isProjectExist(Integer projectId);
}
