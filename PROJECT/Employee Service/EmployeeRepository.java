package com.example.EMS.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EMS.entity.Employee;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
