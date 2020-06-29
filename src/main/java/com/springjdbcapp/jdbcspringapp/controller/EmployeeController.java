package com.springjdbcapp.jdbcspringapp.controller;

import com.springjdbcapp.jdbcspringapp.dao.EmployeeDao;
import com.springjdbcapp.jdbcspringapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping(value="/save")
    public String saveEmp(@RequestBody Employee employee){

        return employeeDao.saveEmployee(employee);
    }

    @GetMapping(value="/getemp")
    public List<Employee> getEmpList(){
        return employeeDao.getEmpList();
    }

    @GetMapping(value="/getemp1/{id}")
    public Employee getEmpById(@PathVariable Integer id){
        return employeeDao.getEmpById(id);
    }

    @PutMapping(value="/update/{id}/{name}")
    public String updateEmp(@PathVariable Integer id,
                              @PathVariable String name){
        return employeeDao.updateEmp(id,name);
    }
}
