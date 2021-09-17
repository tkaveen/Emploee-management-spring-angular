package com.empmgt.emploeemanagement.service;

import com.empmgt.emploeemanagement.exception.UserNotFoundException;
import com.empmgt.emploeemanagement.model.Employee;
import com.empmgt.emploeemanagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    //  Add Employee
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    //  Get All Employees
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    //  Find Employee By Id
    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + "not found"));
    }

    //  Update Employees
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    //  Delete Employee By Id
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
