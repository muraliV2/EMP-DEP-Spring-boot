package com.jspiders.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jspiders.dto.departmentdto;
import com.jspiders.services.departmentservice;
import com.jspiders.util.ResponseStructure;



@RestController
@RequestMapping("/department")
public class departmentcontroller 
{
	@Autowired
private departmentservice departmentser;
@PostMapping("/register")
public ResponseEntity<?> registerdepartment( @RequestBody departmentdto dto)
{
	
	ResponseStructure<departmentdto> structure = departmentser.registerdepartment(dto);
	return new ResponseEntity<>(structure,HttpStatus.CREATED);
}
@PostMapping("/update")
public ResponseEntity<?> updatedepartment(@RequestBody departmentdto dto)
{
	ResponseStructure<departmentdto> structure = departmentser.updatedepartment(dto);
	return new ResponseEntity<>(structure,HttpStatus.OK);
}
@DeleteMapping("/delete/{departmentId}")
public ResponseEntity<?> deletedepartment(@PathVariable int departmentId)
{
	ResponseStructure<String> structure = departmentser.deletedepartment(departmentId);
	return new ResponseEntity<>(structure,HttpStatus.OK);
}

@GetMapping("get/{departmentId}")
public ResponseEntity<?> getDepartmentbyid(@PathVariable int departmentId)
{
ResponseStructure<departmentdto> structure = departmentser.getDepartmentbyid(departmentId);
return new ResponseEntity<>(structure,HttpStatus.OK);
}
}
