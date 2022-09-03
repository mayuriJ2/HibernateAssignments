package com.citiustech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.citiustech.dao.DaoLayer;
import com.citiustech.entity.Project;
import com.citiustech.exception.ExceptionClass;
import com.citiustech.model.Model;

@Service
public class ServiceLayerImpl implements ServiceLayer {
	@Autowired
	private DaoLayer dao;

	@Override
	public Project addProjectDetails(Model project) {
		Project p = new Project();
		p.setid(project.getid());
		p.setname(project.getname());
		p.setteamsize(project.getteamsize());
		p.setduration(project.getduration());
		p.setbudget(project.getbudget());
		p.setendDate(project.getendDate());
		p.setmanagerName(project.getmanagername());

		Project p1 = dao.save(p);
		return p1;

	}

	@Override
	public void updateProjectDetails(int ProjectId, Model Model) throws ExceptionClass {
		Optional<Project> opt = dao.findById(ProjectId);
		Project c = opt.get();
		if (Model.getname() != null) {
			c.setname(Model.getname());
		}
		if (Model.getbudget() != null) {
			c.setbudget(Model.getbudget());
		}
		if (Model.getduration() != null) {
			c.setduration(Model.getduration());
		}
		if (Model.getendDate() != null) {
			c.setendDate(Model.getendDate());
		}
		if (Model.getmanagername() != null) {
			c.setmanagerName(Model.getmanagername());
		}
		if (Model.getteamsize() != null) {
			c.setteamsize(Model.getteamsize());
		}
		Project save = dao.save(c);
	}

	@Override
	public void deleteProjectDetails(int ProjectId) throws ExceptionClass {
		dao.deleteById(ProjectId);

	}

	@Override
	public List<Model> listProjectDetails() throws ExceptionClass {
		Iterable<Project> projects = dao.findAll();
		List<Model> projects2 = new ArrayList<>();
		projects.forEach(p -> {
			Model p2 = new Model();
			p2.setid(p.getid());
			p2.setname(p.getname());
			p2.setteamsize(p.getteamsize());
			p2.setduration(p.getduration());
			p2.setendDate(p.getendDate());
			p2.setmanagername(p.getmanagerName());
			p2.setbudget(p.getbudget());
			projects2.add(p2);
		});
		if (projects2.isEmpty())
			throw new ExceptionClass("Service.CUSTOMERS_NOT_FOUND");
		return projects2;
	}

	@Override
	public Model getProject(Integer ProjectId) throws ExceptionClass {

		Optional<Project> optional = dao.findById(ProjectId);
		Project project = optional.get();

		Model m1 = new Model();
		m1.setid(project.getid());
		m1.setname(project.getname());
		m1.setteamsize(project.getteamsize());
		m1.setduration(project.getduration());
		m1.setbudget(project.getbudget());
		m1.setendDate(project.getendDate());
		m1.setmanagername(project.getmanagerName());

		return m1;
	}

	@Override
	public boolean isProjectExist(Integer id) {
		Optional<Project> p = dao.findById(id);
		if (p.isPresent()) {
			return true;
		} else {
			return false;
		}
	}
}
