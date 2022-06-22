package com.formacion.infraestructure.mapper;

import com.formacion.domain.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getString("employeeId"));
        employee.setEmployeeAddress(rs.getString("employeeAddress"));
        employee.setEmployeeEmail(rs.getString("employeeEmail"));
        employee.setEmployeeName(rs.getString("employeeName"));

        return employee;
    }
}
