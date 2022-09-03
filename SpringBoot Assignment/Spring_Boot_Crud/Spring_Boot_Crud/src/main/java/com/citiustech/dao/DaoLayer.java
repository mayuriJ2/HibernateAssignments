package com.citiustech.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.entity.Project;


public interface DaoLayer extends JpaRepository<Project, Integer> {

}
