package com.sapient.assignment.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "EmployeeId")
    private int employeeId;

    @Column(name = "EmployeeName")
    private String employeeName;

    @Column(name = "Title")
    private String title;

    @Column(name = "BusinessUnit")
    private String businessUnit;

    @Column(name = "Place")
    private String place;

    @Column(name = "SupervisorId")
    private int supervisorId;

    @Column(name = "Competencies")
    private String competencies;

    @Column(name = "Salary")
    private Double salary;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getCompetencies() {
        return competencies;
    }

    public void setCompetencies(String competencies) {
        this.competencies = competencies;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                supervisorId == employee.supervisorId &&
                employeeName.equals(employee.employeeName) &&
                title.equals(employee.title) &&
                businessUnit.equals(employee.businessUnit) &&
                place.equals(employee.place) &&
                competencies.equals(employee.competencies) &&
                salary.equals(employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName, title, businessUnit, place, supervisorId, competencies, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", title='" + title + '\'' +
                ", businessUnit='" + businessUnit + '\'' +
                ", place='" + place + '\'' +
                ", supervisorId=" + supervisorId +
                ", competencies='" + competencies + '\'' +
                ", Salary=" + salary +
                '}';
    }
}