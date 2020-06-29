package com.springjdbcapp.jdbcspringapp.dao;

import com.springjdbcapp.jdbcspringapp.model.Employee;
import com.springjdbcapp.jdbcspringapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String saveEmployee(Employee employee) {
        String sql="insert into employee values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getId(),
                            employee.getName(),employee.getCity() });
        return "Employee saved";
    }

    @Override
    public List<Employee> getEmpList() {

        String sql="select * from employee";
        List<Employee> list=jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Employee.class));
        return list;
    }

    @Override
    public Employee getEmpById(Integer id) {
        String sql="select * from employee where id=?";
        Employee employee= (Employee) jdbcTemplate.queryForObject(sql,new Object[]{id},
                new BeanPropertyRowMapper(Employee.class));
        return employee;
    }

    @Override
    public String updateEmp(Integer id, String name) {
        String sql="update employee set name=? where id=?";
        jdbcTemplate.update(sql,new Object[]{name,id});
        return "Employee Updated";
    }
}
