package com.sapient.assignment.services;

import com.sapient.assignment.beans.Employee;
import com.sapient.assignment.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
         return  employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByPlace(String place) {
        return employeeRepository.findByPlace(place);
    }

    public List<Employee> findBySupervisor(int supervisorId) {
        return employeeRepository.findBySupervisorId(supervisorId);
    }

    public List<Employee> findByBusinessUnit(String businessUnit) {
        return employeeRepository.findByBusinessUnit(businessUnit);
    }

    public List<Employee> findByTitle(String title) {
        return employeeRepository.findByTitle(title);
    }

    public void createEmployee(Employee list){
        employeeRepository.save(list);
    }
}