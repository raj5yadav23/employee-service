package com.springboot.employeeservice.controller;

import com.springboot.employeeservice.model.Employee;
import com.springboot.employeeservice.respository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public static final Logger LOGGER=LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    public EmployeeRepository employeeRepository;


    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeRepository.addEmployee(employee);
        return employee;
    }

    @GetMapping("/findAll")
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable("id") Long id){
        return employeeRepository.findByDepartmentId(id);
    }
}
