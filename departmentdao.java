package com.jspiders.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.Entity.department;
import com.jspiders.repository.departmentrepository;
@Repository
public class departmentdao 
{

	
	@Autowired
	departmentrepository deparrepository;
	public department registerdepartment(department department) {
		
		
		
		Optional<department> opt =  deparrepository.findById(department.getDepartmentId());
		if(opt.isPresent())
		{
			throw new IllegalArgumentException("Department id already available");
		}
		else
		{
			return deparrepository.save(department);
		}
	}
	public department updatedepartment(department depart) {
		Optional<department> opt = deparrepository.findById(depart.getDepartmentId());
		if(opt.isPresent())
		{
			return deparrepository.save(depart);	
			}
		else
		{
			throw new IllegalArgumentException("the department id is wrong");
		}
		
	}
	public String deletedepartment(int departmentId) {
		Optional<department> opt = deparrepository.findById(departmentId);
		if(opt.isPresent())
		{
			deparrepository.deleteById(departmentId);
			return "Department deleted Successfully";
		}
		else
		{
			throw new IllegalArgumentException("department deleted successfully");
		}
		
	}
	public department getDepartmentbyid(int departmentId) {
		return deparrepository.findById(departmentId).orElseThrow(() -> new IllegalArgumentException("no department id found"));
		
	}
	public department getdepartmentbyname(String departmentName) {
	return deparrepository.findByDepartmentName(departmentName).orElseThrow(() -> new IllegalArgumentException("no department name found"));
	}


}
