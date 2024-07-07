package com.example.Task6.controller;

import com.example.Task6.entity.Employee;
import com.example.Task6.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeService.getEmployeeById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(employeeDetails.getName());
            employee.setPosition(employeeDetails.getPosition());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setSalary(employeeDetails.getSalary());
            employee.setJoiningDate(employeeDetails.getJoiningDate());
            return employeeService.saveEmployee(employee);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        return employeeService.getEmployeesByDepartment(department);
    }
    @PatchMapping("/{id}/salary")
    public Employee updateEmployeeSalary(@PathVariable Long id, @RequestBody Double salary) {
        return employeeService.updateEmployeeSalary(id, salary);
    }

    @GetMapping("/total-salary/{department}")
    public Double calculateTotalSalaryByDepartment(@PathVariable String department) {
        return employeeService.calculateTotalSalaryByDepartment(department);
    }

    @GetMapping("/joining-date")
    public List<Employee> findEmployeesByJoiningDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        return employeeService.findEmployeesByJoiningDateRange(startDate, endDate);
    }

    @PatchMapping("/{id}/position")
    public Employee updateEmployeePositionBasedOnExperience(@PathVariable Long id, @RequestParam int yearsOfExperience) {
        return employeeService.updateEmployeePositionBasedOnExperience(id, yearsOfExperience);
    }

    @GetMapping("/report/{id}")
    public String generateEmployeeReport(@PathVariable Long id) {
        return employeeService.generateEmployeeReport(id);
    }

    @GetMapping("/average-salary/{position}")
    public Double calculateAverageSalaryByPosition(@PathVariable String position) {
        return employeeService.calculateAverageSalaryByPosition(position);
    }

    @GetMapping("/promotion-eligibility/{id}")
    public boolean checkPromotionEligibility(@PathVariable Long id) {
        return employeeService.checkPromotionEligibility(id);
    }

    @PostMapping("/send-notification")
    public void sendNotificationToEmployees(@RequestBody String message) {
        employeeService.sendNotificationToEmployees(message);
    }

    @GetMapping("/performance-analysis")
    public List<String> analyzeDepartmentPerformance() {
        return employeeService.analyzeDepartmentPerformance();
    }

    @PatchMapping("/update-budget/{department}")
    public Double updateDepartmentBudgetBasedOnEmployeeCount(@PathVariable String department) {
        return employeeService.updateDepartmentBudgetBasedOnEmployeeCount(department);
    }

    @GetMapping("/top-paid/{n}")
    public List<Employee> findTopNHighestPaidEmployees(@PathVariable int n) {
        return employeeService.findTopNHighestPaidEmployees(n);
    }

    @GetMapping("/check-duplicates")
    public List<Employee> checkForDuplicateEmployees() {
        return employeeService.checkForDuplicateEmployees();
    }    
}
