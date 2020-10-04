package com.sapient.assignment.repositories;

import com.sapient.assignment.beans.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll();

    List<Employee> findBySupervisorId(int id);

    List<Employee> findByBusinessUnit(String businessUnit);

    List<Employee> findByTitle(String title);

    List<Employee> findByPlace(String place);

    Employee save(Employee list);
}

