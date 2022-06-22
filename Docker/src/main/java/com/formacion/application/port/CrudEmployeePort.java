package com.formacion.application.port;

import com.formacion.domain.Employee;
import java.util.List;

public interface CrudEmployeePort {
    List<Employee> findAll();
    void insertEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
