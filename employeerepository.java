package com.jspiders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.Entity.Employee;

public interface Employeerepository extends JpaRepository<Employee, Integer>
{

List<Employee> findByDepartment_DepartmentName(String departmentName);

	List<Employee> findByDepartment_DepartmentId(int departmentId);

}
