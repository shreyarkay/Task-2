package com.example.student_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	
	@Column(name="name")
private String Name;
	
	@Column(name="age")
private int Age;
	
private String Grade;
private String Address;

public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public String getGrade() {
	return Grade;
}
public void setGrade(String grade) {
	Grade = grade;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
