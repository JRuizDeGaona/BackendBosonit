package com.formacion.infraestructure.controller;

import com.formacion.application.port.CrudEmployeePort;
import com.formacion.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {
    @Autowired
    CrudEmployeePort crudEmployeePort;

    @GetMapping("/getAll")
    public List<Employee> getEmployee() {
        return crudEmployeePort.findAll();
    }

    @PostMapping("/add")
    public void addEmployee(Employee employee) {
        crudEmployeePort.insertEmployee(employee);
    }

    @PutMapping("/update")
    public void updateEmployee (Employee employee) {
        crudEmployeePort.updateEmployee(employee);
    }

    @DeleteMapping("/delete")
    public void deleteEmployee (Employee employee) {
        crudEmployeePort.updateEmployee(employee);
    }
}
