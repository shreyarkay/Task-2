package com.example.Task6.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="details1")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
    private int YearsofService;
    private int PerformanceScore;
    private String email; 

    
    public int getYearsOfService() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setYearsofService(int yearsofService) {
		YearsofService = yearsofService;
	}
	public int getPerformanceScore() {
		return PerformanceScore;
	}
	public void setPerformanceScore(int performanceScore) {
		PerformanceScore = performanceScore;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String name;
    private String position;
    private String department;
    private Double salary;
    private Date joiningDate;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
}
