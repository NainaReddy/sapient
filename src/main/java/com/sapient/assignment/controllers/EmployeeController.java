package com.sapient.assignment.controllers;

import com.sapient.assignment.beans.Employee;
import com.sapient.assignment.beans.GenericEmployeeResponse;
import com.sapient.assignment.services.EmployeeServiceImpl;
import com.sapient.assignment.util.EmployeeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    // Fetch employee by place
    @GetMapping("/place/{place}")
    @Cacheable(value = "employeeList", key = "#place")
    public List<Employee> getByPlace(@PathVariable("place") String place){

        List<Employee> employeeList =  employeeService.findByPlace(place);
        return employeeList;
    }

    // Fetch employee by supervisor id
    @GetMapping("/supervisorId/{supervisorId}")
    public ResponseEntity<List<Employee>> getBySupervisor(@PathVariable("supervisorId") Integer supervisorId){

        List<Employee> employeeList =  employeeService.findBySupervisor(supervisorId);

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // Fetch employee by business unit
    @GetMapping("/businessunit/{BU}")
    public ResponseEntity<List<Employee>> getByBU(@PathVariable("BU") String businessUnit){

        List<Employee> employeeList =  employeeService.findByBusinessUnit(businessUnit);

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // Fetch range of salaries for given title
    @GetMapping("/title/{title}")
    public ResponseEntity<String> getRangeOfSalaries(@PathVariable("title") String title){

        List<Employee> employeeList =  employeeService.findByTitle(title);
        Collections.sort(employeeList, new EmployeeComparator());
        String result = "Title: "+title+", Range of salaries: "
                +employeeList.get(0).getSalary()+"-"+employeeList.get(employeeList.size()-1).getSalary();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // Fetch all the employees
    @GetMapping("/listofemployees")
    @Cacheable(value = "employeeList")
    public List<Employee> getAll(){
        List<Employee> employeeList =  employeeService.findAll();
        return employeeList;
    }

    // Update employee salary by percentage given place
    @PutMapping("/place/{place}/salary/{percentage}")
    public ResponseEntity<List<Employee>> updateEmployee(@PathVariable("place") String place,
                                                                  @PathVariable("percentage") Double percentage){

        List<Employee> employeeList = employeeService.findByPlace(place);
        for (Employee employee:employeeList) {
            employee.setSalary(employee.getSalary() + ((employee.getSalary()*percentage)/100));
            employeeService.createEmployee(employee);
        }
        employeeList = employeeService.findByPlace(place);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
}