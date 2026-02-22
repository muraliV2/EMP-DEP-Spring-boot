package com.jspiders.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class department 
{
	@Id
private int departmentId;
private String departmentName;
private String location;
@OneToMany(mappedBy = "department")
private List<Employee> listofemployees = new ArrayList<Employee>();

private void addEmployee(Employee employee)
{
	listofemployees.add(employee);
employee.setDepartment(this);
}
private void removerEmployee(Employee employee)
{
	listofemployees.remove(employee);
	employee.setDepartment(null);
}
}
