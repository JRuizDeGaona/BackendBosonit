package com.formacion.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    String employeeId;
    String employeeName;
    String employeeEmail;
    String employeeAddress;
}
