package com.sapient.assignment.services;

import com.sapient.assignment.beans.Employee;
import com.sapient.assignment.repositories.EmployeeRepository;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    List<Employee> findByPlace(String place);
    //void createEmployee(List<Employee> list);
}
