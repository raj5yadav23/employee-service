package com.springboot.employeeservice.respository;

import com.springboot.employeeservice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    public List<Employee> employeeList=new ArrayList<Employee>();



    public Employee addEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
    }

    public Employee findById(Long id){
        return employeeList.stream()
                .filter(employee-> employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll(){
        return employeeList;
    }

    public List<Employee> findByDepartmentId(Long departmentId){
        return employeeList.stream()
                .filter(employee-> employee.departmentId().equals(departmentId))
                .collect(Collectors.toList());
    }
}
