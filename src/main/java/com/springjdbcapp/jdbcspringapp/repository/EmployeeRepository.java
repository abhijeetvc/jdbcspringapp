package com.springjdbcapp.jdbcspringapp.repository;

import com.springjdbcapp.jdbcspringapp.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    String saveEmployee(Employee employee);

    List<Employee> getEmpList();

    Employee getEmpById(Integer id);

    String updateEmp(Integer id,String name);
}
