package com.sapient.assignment.util;

import com.sapient.assignment.beans.Employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary().compareTo(o2.getSalary());
    }
}
