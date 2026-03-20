package com.jspiders.dto;

import lombok.Data;

@Data
public class EmployeeRequestdto 
{
    private String employeeName;
    private String employeeEmail;
    private long contact;
    private int salary;
    private String password;
    private String designation;
    private String departmentName; 
}
