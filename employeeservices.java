package com.jspiders.services;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.jspiders.Entity.Employee;
import com.jspiders.Entity.department;
import com.jspiders.dao.Employeedao;
import com.jspiders.dto.EmployeeRequestdto;
import com.jspiders.dto.Employeeresponsedto;
import com.jspiders.repository.departmentrepository;
import com.jspiders.util.ResponseStructure;
@Service
public class EmployeeService {
	@Autowired
	private departmentrepository departmentRepository;
	@Autowired
	private Employeedao dao;
	@Autowired
	private ModelMapper mapper;
	public ResponseStructure<Employeeresponsedto> registeremployee(EmployeeRequestdto dto) {
	
		department department = departmentRepository.findByDepartmentName(dto.getDepartmentName())
				.orElseThrow(() -> new RuntimeException("Department not found"));
		
		Employee employee = mapper.map(dto,Employee.class );
		employee.setDepartment(department);
		
		Employee employee2 =  dao.registeremployee(employee);
		if(employee2 == null)
		{
			throw new RuntimeException("No Employeee Found in this Department");
		}
		Employeeresponsedto Empdto = mapper.map(employee2, Employeeresponsedto.class);
		Empdto.setDepartmeantName(
				employee2.getDepartment() != null ? employee2.getDepartment().getDepartmentName() : null);
		ResponseStructure<Employeeresponsedto> structure = new ResponseStructure<Employeeresponsedto>();
		structure.setData(Empdto);
		structure.setMessage("Employee added Successfully");
		structure.setStatusCode(200);
		structure.setTimeStamp(LocalDateTime.now());
		return structure;
	}
	
	public ResponseStructure<List<Employeeresponsedto>> getalldept() {
		List<Employee> employees = dao.getalldept();
		List<Employeeresponsedto> dto = employees.stream().map(employee ->
		{
			Employeeresponsedto Empdto = mapper.map(employee, Employeeresponsedto.class);
			Empdto.setDepartmeantName(
					employee.getDepartment() != null ? employee.getDepartment().getDepartmentName() : null);
			return Empdto;

		}).toList();
		
		ResponseStructure<List<Employeeresponsedto>> structure = new ResponseStructure<List<Employeeresponsedto>>();
		structure.setData(dto);
		structure.setMessage("the list of employees ");
		structure.setStatusCode(200);
		structure.setTimeStamp(LocalDateTime.now());
		return structure;
	}

	public ResponseStructure<Employeeresponsedto> findEmployeeById( int employeeId) 
	{
	Optional<Employee> employeeopt = dao.findEmployeeById(employeeId);
	if(employeeopt.isPresent())
	{
		Employee emp = employeeopt.get();
	ResponseStructure<Employeeresponsedto> structure = new ResponseStructure<Employeeresponsedto>();
	Employeeresponsedto dto = mapper.map(emp, Employeeresponsedto.class);
	structure.setData(dto);
	structure.setMessage("he is the employee of the department");
	structure.setStatusCode(200);
	structure.setTimeStamp(LocalDateTime.now());
	
	return structure;
	}
	else
	{
		throw new RuntimeException("Employee Not Found");
	}
	
	}

public ResponseStructure<List<Employeeresponsedto>> findbydept(String departmentName) {
		List<Employee> employees = dao.findbydept(departmentName);
		List<Employeeresponsedto> dto = employees.stream().map(employee ->
		{
			Employeeresponsedto empdto = mapper.map(employee, Employeeresponsedto.class);
			empdto.setDepartmeantName(
					
					employee.getDepartment() != null ? employee.getDepartment().getDepartmentName() : null);
			return  empdto;
			
		}).toList();
		
		ResponseStructure<List<Employeeresponsedto>> structure = new ResponseStructure<List<Employeeresponsedto>>();
		structure.setData(dto);
		structure.setMessage("the employees belong to the department");
		structure.setStatusCode(200);
		structure.setTimeStamp(LocalDateTime.now());
		return structure;
		
				
	
	
	
	
	}

public ResponseStructure<List<Employeeresponsedto>> findbydepid(int departmentId) {
	List<Employee> employees = dao.findbydeptid(departmentId);
	List<Employeeresponsedto> dto = employees.stream().map(employee ->
	{
		Employeeresponsedto empdto = mapper.map(employee, Employeeresponsedto.class);
		
		empdto.setDepartmeantName(
				employee.getDepartment() != null ? employee.getDepartment().getDepartmentName() : null);
		return empdto;
		
	}).toList();
	ResponseStructure<List<Employeeresponsedto>> structure = new ResponseStructure<List<Employeeresponsedto>>();
	structure.setData(dto);
	structure.setMessage("the Employees belong to this DepartmentId");
	structure.setStatusCode(200);
	structure.setTimeStamp(LocalDateTime.now());
	return structure;
}

public ResponseStructure<String> deleteempbyid(int employeeid) {
	String message = dao.deleteempbyid(employeeid);
	ResponseStructure<String> structure = new ResponseStructure<String>();
	structure.setData(message);
	structure.setMessage("deleted successfully");
	structure.setStatusCode(200);
	structure.setTimeStamp(LocalDateTime.now());
	return structure;
}
	
}
