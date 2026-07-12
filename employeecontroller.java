package com.jspiders.controller;
import java.net.http.HttpRequest;
import java.util.List;
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
import com.jspiders.dto.EmployeeRequestdto;
import com.jspiders.dto.Employeeresponsedto;
import com.jspiders.services.EmployeeService;
import com.jspiders.util.ResponseStructure;
@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
@Autowired
private EmployeeService empser;
	@PostMapping("/register")
public ResponseEntity<?> registeremployee(@RequestBody EmployeeRequestdto dto)
{
ResponseStructure<Employeeresponsedto> structure = empser.registeremployee(dto);	
return new ResponseEntity<>(structure,HttpStatus.CREATED);
}
@GetMapping("/findall")
	public ResponseEntity<?> getalldept()
	{
		ResponseStructure<List<Employeeresponsedto>> structure = empser.getalldept();
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	@GetMapping("/findby/{employeeId}")
	public ResponseEntity<?> findEmployeeById( @PathVariable int employeeId)
	{
		ResponseStructure<Employeeresponsedto> structure = empser.findEmployeeById(employeeId);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	@GetMapping("/find/{departmentName}")
	public ResponseEntity<?> findbydept(@PathVariable String departmentName)
	{
		ResponseStructure<List<Employeeresponsedto>> structure = empser.findbydept(departmentName);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	@GetMapping("/findbydepid/{departmentId}")
	public ResponseEntity<?> findbydepid(@PathVariable int departmentId)
	{
		ResponseStructure<List<Employeeresponsedto>> structure = empser.findbydepid(departmentId);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	@DeleteMapping("delete/{employeeid}")
	public ResponseEntity<?> deleteempbyid(@PathVariable int employeeid)
	{
	ResponseStructure<String> structure = empser.deleteempbyid(employeeid);
	return new ResponseEntity<>(structure,HttpStatus.OK);
	}
}

