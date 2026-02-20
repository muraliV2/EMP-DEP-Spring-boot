package com.jspiders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.Entity.department;
@Repository
public interface departmentrepository extends JpaRepository<department,Integer>{

}
