package com.example.Task6.service;

import java.util.List;
import java.util.Optional;
import org.springframework.util.StringUtils;
import jakarta.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Task6.entity.Employee;
import com.example.Task6.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    public Employee saveEmployee(Employee employee) {
        validateEmployeeData(employee);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
    public Employee updateEmployeeSalary(Long id, Double salary) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setSalary(salary);
            return employeeRepository.save(employee);
        }
        return null;
    }

    public Double calculateTotalSalaryByDepartment(String department) {
        List<Employee> employees = employeeRepository.findByDepartment(department);
        return employees.stream().mapToDouble(Employee::getSalary).sum();
    }

    public List<Employee> findEmployeesByJoiningDateRange(Date startDate, Date endDate) {
        return employeeRepository.findByJoiningDateBetween(startDate, endDate);
    }

    public Employee updateEmployeePositionBasedOnExperience(Long id, int yearsOfExperience) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            if (yearsOfExperience > 5 && "Junior".equals(employee.getPosition())) {
                employee.setPosition("Senior");
            }
            return employeeRepository.save(employee);
        }
        return null;
    }

    public String generateEmployeeReport(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return String.format("Employee Report:\nName: %s\nPosition: %s\nDepartment: %s\nSalary: %.2f",
                    employee.getName(), employee.getPosition(), employee.getDepartment(), employee.getSalary());
        }
        return "Employee not found";
    }

    public void validateEmployeeData(Employee employee) {
        if (!StringUtils.hasText(employee.getName())) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        if (employee.getSalary() <= 0) {
            throw new IllegalArgumentException("Salary must be a positive number");
        }
        if (!employee.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public Double calculateAverageSalaryByPosition(String position) {
        List<Employee> employees = employeeRepository.findAll().stream()
                .filter(e -> position.equals(e.getPosition()))
                .collect(Collectors.toList());
        return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

    public boolean checkPromotionEligibility(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return employee.getPerformanceScore() >= 85 && employee.getYearsOfService() > 2;
        }
        return false;
    }

    public void sendNotificationToEmployees(String message) {
        System.out.println("Notification sent: " + message);
    }

    public List<String> analyzeDepartmentPerformance() {
        Map<String, Double> departmentPerformance = new HashMap<>();
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            departmentPerformance.merge(employee.getDepartment(), (double) employee.getPerformanceScore(),
                    Double::sum);
        }
        return departmentPerformance.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Double updateDepartmentBudgetBasedOnEmployeeCount(String department) {
        List<Employee> employees = employeeRepository.findByDepartment(department);
        Double newBudget = employees.size() * 10000.0; 
        return newBudget;
    }

    public List<Employee> findTopNHighestPaidEmployees(int n) {
        return employeeRepository.findAll().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Employee> checkForDuplicateEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        Map<String, Long> emailCountMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getEmail, Collectors.counting()));
        return emailCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .flatMap(entry -> employees.stream()
                        .filter(emp -> emp.getEmail().equals(entry.getKey())))
                .collect(Collectors.toList());
    }
    
  }
