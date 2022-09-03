package com.citiustech.service;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.citiustech.dao.DaoLayer;
import com.citiustech.entity.Project;
import com.citiustech.exception.ExceptionClass;
import com.citiustech.model.Model;


@SpringBootTest
public class ServiceLayerImpl {
	@InjectMocks
	private ServiceLayerImpl serviceImpl;
	
	@Mock
	private DaoLayer dao;

	@Test
	@DisplayName("JUnit test for addProjectDetailsTest method")
	public void  addProjectDetailsTest() {
		LocalDate date2 = LocalDate.of (2019, Month.JANUARY, 03);
		Model project = 
				new Model(22, "DATA", 10.00, 10, 1, date2, "Mayuri");
		
		Project projectEntity = new Project();
		projectEntity.setid(project.getid());
		projectEntity.setname(project.getname());
		projectEntity.setteamsize(project.getteamsize());
		projectEntity.setduration(project.getduration());
		projectEntity.setbudget(project.getbudget());
		projectEntity.setendDate(project.getendDate());
		projectEntity.setmanagerName(project.getmanagername());
		
		Project q = projectEntity; 
		
		when(dao.save(projectEntity)).thenReturn(projectEntity);
		
		when(ServiceLayerImpl.addProjectDetails(project)).
				thenReturn(projectEntity);
		
		assertEquals(q, projectEntity);
		
	}
	
	
	@Test
	@DisplayName("JUnit test for updateProjectDetailsTest method")
	public void updateProjectDetailsTest() {
		
		LocalDate date2 = LocalDate.of (2019, Month.JANUARY, 03);
		Project p = new Project(22, "DATA", 10.00, 10, 1, date2, "Mayuri");
		Project q = p;
		when(dao.findById(22)).thenReturn(Optional.empty());
		when(dao.save(p)).thenReturn(p);
		
		assertEquals(p, q);
	}
	
	@Test
	@DisplayName("JUnit test for deleteProjectDetailsTest method")
	public void deleteProjectDetailsTest() throws ExceptionClass {
		when(dao.findById(22)).thenReturn(Optional.empty());
		doNothing().when(dao).deleteById(22);
		serviceImpl.deleteProjectDetails(22);
		verify(dao,times(1)).deleteById(22);
	}
	
	private void deleteProjectDetails(int i) {
		// TODO Auto-generated method stub
		
	}

	@Test
	@DisplayName("JUnit test for listProjectDetailsTest method")
	public void listProjectDetailsTest() throws ExceptionClass {
		
		LocalDate date2 = LocalDate.of (2018, Month.OCTOBER, 12);
		Project p1 = new Project(22, "DATA", 10.00, 10, 1, date2, "Mayuri");
		Project p2 = new Project(23, "INFO", 10.00, 10, 1, date2, "Samantha");
		
		List<Project> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		
		Model pm1 = new Model(22, "DATA", 10.00, 10, 1, date2, "Mayuri");
		Model pm2 = new Model(23, "INFO", 10.00, 10, 1, date2, "Samantha");
		
		List<Model> listPM = new ArrayList<>();
		listPM.add(pm1);
		listPM.add(pm2);
		
		
		when(dao.findAll()).thenReturn(list);
		assertNotEquals(serviceImpl.listProjectDetailsTest(), listPM);
	}
	
	@Test
	@DisplayName("JUnit test for getProjectTest method")
	public void getProjectTest() throws ExceptionClass {
		LocalDate date2 = LocalDate.of (2018, Month.OCTOBER, 12);
		Model pm1 =new Model(22, "DATA", 10.00, 10, 1, date2, "Mayuri");
		Optional<Project> p1 = Optional.of(new Project(22, "DATA", 10.00, 10, 1, date2, "Mayuri"));
		when(dao.findById(22)).thenReturn(p1);
		assertNotEquals(serviceImpl.getProject(22),pm1);
	}

	
}