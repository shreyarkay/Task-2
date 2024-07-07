package com.example.Task6.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


//import org.springframework.stereotype.Repository;
import com.example.Task6.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(String department);
    @Query("SELECT e FROM Employee e WHERE e.joiningDate BETWEEN :startDate AND :endDate")
    List<Employee> findByJoiningDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Employee> findByEmail(String email);
    
}
