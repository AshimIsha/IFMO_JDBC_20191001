package com.efimchick.ifmo.web.jdbc;

import com.efimchick.ifmo.web.jdbc.domain.Employee;
import com.efimchick.ifmo.web.jdbc.domain.FullName;
import com.efimchick.ifmo.web.jdbc.domain.Position;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.math.BigInteger;

public class RowMapperFactory {

    public RowMapper<Employee> employeeRowMapper() {
       // throw new UnsupportedOperationException();
        RowMapper<Employee> rowMapper = new RowMapper<Employee>(){

            @Override
            public Employee  mapRow(ResultSet resultSet){
                try{
                    BigInteger id_number= new BigInteger(resultSet.getString("id"));
                    LocalDate date = LocalDate.parse(resultSet.getString("hiredate"));
                    FullName name = new FullName(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("middlename"));
                    BigDecimal salary = resultSet.getBigDecimal("salary");
                    Position pos = Position.valueOf(resultSet.getString("position"));
                    return new Employee(id_number, name, pos, date, salary);
                }
                catch (SQLException exception){
                    return null;
                }
            }
        };
        return rowMapper;
    }
    // T mapRow(ResultSet resultSet);

}
