package com.jspiders.dto;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Employeeresponsedto 
{
		private int Employeeid;
		private String employeeName;
		private String employeeEmail;
		private long contact;
		private int salary;
		private String designation;
		private String departmeantName;
		
	
	

}
