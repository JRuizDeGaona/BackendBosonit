package com.formacion.infraestructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomError {
    private Date timestamp;
    private int HttpCode;
    private String mensajeError;
}
