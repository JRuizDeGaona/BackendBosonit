package com.formacion.application;

import com.formacion.application.port.CrudEmployeePort;
import com.formacion.domain.Employee;
import com.formacion.infraestructure.mapper.EmployeeRowMapper;
import lombok.NoArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class CrudEmployeeUseCase implements CrudEmployeePort {
    NamedParameterJdbcTemplate template;
    public CrudEmployeeUseCase(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Employee> findAll() {
        return template.query("select * from employee", new EmployeeRowMapper());
    }

    @Override
    public void insertEmployee(Employee employee) {
        String consulta = "Insert into employee(employeeId, employeeName , employeeAddress,employeeEmail) values(:employeeId,:employeeName,:employeeEmail,:employeeAddress)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parametros = new MapSqlParameterSource()
                .addValue("employeeId", employee.getEmployeeId())
                .addValue("employeeName", employee.getEmployeeName())
                .addValue("employeeAddress", employee.getEmployeeAddress())
                .addValue("employeeEmail", employee.getEmployeeEmail());

        template.update(consulta, parametros, keyHolder);
    }

    @Override
    public void updateEmployee(Employee employee) {
        String consulta = "update employee set employeeName=:employeeName, employeeAddress=:employeeAddress, employeeEmail=:employeeEmail where employeeId=:employeeId";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parametros = new MapSqlParameterSource()
                .addValue("employeeId", employee.getEmployeeId())
                .addValue("employeeName", employee.getEmployeeName())
                .addValue("employeeAddress", employee.getEmployeeAddress())
                .addValue("employeeEmail", employee.getEmployeeEmail());

        template.update(consulta, parametros, keyHolder);

    }

    @Override
    public void deleteEmployee(Employee employee) {
        String consulta = "delete from employee where employeeId=:employeeId";

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("employeeId", employee.getEmployeeId());

        template.execute(consulta, mapa, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }
}
