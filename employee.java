package com.jspiders.Entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;
@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeid;

    private String employeeName;
    private String employeeEmail;
    private String password;
    private long contact;
    private int salary;
    private String designation;
    private LocalDateTime datatime;
    private boolean accountstatus;
    @ManyToOne
    private department department;



    public void addEmployees(department depart) {
        this.department = depart;
        depart.getListofemployees().add(this);
    }
}
