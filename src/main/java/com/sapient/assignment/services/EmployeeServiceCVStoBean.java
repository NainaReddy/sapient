package com.sapient.assignment.services;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.sapient.assignment.beans.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceCVStoBean {

    private List<Employee> employeeList = new ArrayList<>();

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostConstruct
    public void init(){

        // Hashmap to map CSV data to Bean attributes.
        Map<String, String> mapping = new HashMap<>();
        mapping.put("EmployeeID","employeeId"); mapping.put("EmployeeName","employeeName");
        mapping.put("Title","title"); mapping.put("BusinessUnit","businessUnit");
        mapping.put("Place","place"); mapping.put("SupervisorID","supervisorId");
        mapping.put("Competencies","competencies"); mapping.put("Salary","salary");

        // HeaderColumnNameTranslateMappingStrategy for Student class
        HeaderColumnNameTranslateMappingStrategy<Employee> mappingStrategy
                = new HeaderColumnNameTranslateMappingStrategy<>();
        mappingStrategy.setType(Employee.class);
        mappingStrategy.setColumnMapping(mapping);

        try{
            CsvToBeanBuilder<Employee> csvToBeanBuilder = new CsvToBeanBuilder<>(new FileReader("src/main/resources/assets/Employee.csv"));
            employeeList = csvToBeanBuilder.withMappingStrategy(mappingStrategy).build().parse();
            //dump employee list

        } catch (Exception e){
            e.getMessage();
        }

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("------------------ CSV file loading while application startup ----------------------------");
        System.out.println("------------------------------------------------------------------------------------------");
        for (Employee e: employeeList){
            System.out.println(e.toString());
            employeeService.createEmployee(e);
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("---------------------------- CSV file has loaded successfully ----------------------------");
        System.out.println("------------------------------------------------------------------------------------------");
    }
}