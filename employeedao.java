package com.jspiders.dao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jspiders.Entity.Employee;
import com.jspiders.dto.Employeeresponsedto;
import com.jspiders.repository.Employeerepository;

@Repository
public class Employeedao {
    @Autowired
    private Employeerepository emprep;

    public Employee registeremployee(Employee employee) {
        return emprep.save(employee);
    }


	public List<Employee> getalldept() {
		return emprep.findAll();
	}

	public Optional<Employee> findEmployeeById(int employeeId) {
		
		return emprep.findById(employeeId);
	}



	public List<Employee> findbydept(String departmentName) {
		
		return emprep.findByDepartment_DepartmentName(departmentName);
	}




	public String deleteempbyid(int employeeid) 
	{
		Optional<Employee> opt = emprep.findById(employeeid);
		if(opt.isPresent())
		{
			 emprep.deleteById(employeeid);
			 return "Employee deleted Succesfully";
			
		}
		else
		{
			throw new IllegalArgumentException("there is a error in your code");
		}

		
	}



	public List<Employee> findbydeptid(int departmentId) {
		
		return emprep.findByDepartment_DepartmentId(departmentId);
	}



	
}
