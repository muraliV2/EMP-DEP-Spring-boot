package com.jspiders.services;



import java.time.LocalDateTime;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.Entity.department;
import com.jspiders.dao.departmentdao;
import com.jspiders.dto.departmentdto;
import com.jspiders.util.ResponseStructure;


@Service
public class departmentservice {

	
	@Autowired
	departmentdao departmentdao;
	
	 @Autowired
	 private  ModelMapper mapper;
	
	
	public  ResponseStructure<departmentdto> registerdepartment(departmentdto dto) 
	{
	department department = mapper.map(dto,department.class);
	department depart = departmentdao.registerdepartment(department);
    departmentdto dto2 = mapper.map(depart, departmentdto.class);
    
    ResponseStructure<departmentdto> structure = new ResponseStructure<>();
structure.setData(dto2);
structure.setStatusCode(200);
structure.setTimeStamp(LocalDateTime.now());
structure.setMessage("Department registered Successfully");
	return structure;
    
    
	
	
		
	}

	public ResponseStructure<departmentdto> updatedepartment(departmentdto dto) 
	{
	department depart = mapper.map(dto,department.class);
	department depart1 = departmentdao.updatedepartment(depart);
	departmentdto newdepat = mapper.map(depart1,departmentdto.class);
	ResponseStructure<departmentdto> structure = new ResponseStructure<departmentdto>();
	structure.setData(newdepat);
	structure.setStatusCode(200);
	structure.setTimeStamp(LocalDateTime.now());
	structure.setMessage("department updated Successfully0");
	
		return structure;
	}



	public ResponseStructure<String> deletedepartment(int departmentId) {
		String message = departmentdao.deletedepartment(departmentId);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(message);
		structure.setMessage("department deleted successfully");
		structure.setStatusCode(200);
		structure.setTimeStamp(LocalDateTime.now());
		return structure;
	}

	public ResponseStructure<departmentdto> getDepartmentbyid(int departmentId) {
		
		department depart =departmentdao.getDepartmentbyid(departmentId);
		ResponseStructure<departmentdto> structure = new ResponseStructure<departmentdto>();
		departmentdto depdto = mapper.map(depart, departmentdto.class);
		structure.setData(depdto);
		structure.setMessage("We got the department via id");
		structure.setStatusCode(200);
		structure.setTimeStamp(LocalDateTime.now());
		return structure;
		
		
	}

	public ResponseStructure<departmentdto> getdepartmentbyname(String departmentName) {
		department depart = departmentdao.getdepartmentbyname(departmentName);
		ResponseStructure<departmentdto> structure = new ResponseStructure<departmentdto>();
		departmentdto dto = mapper.map(depart, departmentdto.class);
		structure.setData(dto);
		structure.setMessage("we got the data with respect to the department");
		structure.setStatusCode(200);
		structure.setTimeStamp(LocalDateTime.now());
		return structure;
	}

}
