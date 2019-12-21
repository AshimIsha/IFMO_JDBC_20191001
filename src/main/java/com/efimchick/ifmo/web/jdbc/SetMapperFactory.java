package com.efimchick.ifmo.web.jdbc;

import java.util.Set;

import com.efimchick.ifmo.web.jdbc.domain.*;
import java.util.HashSet;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetMapperFactory {

    public SetMapper<Set<Employee>> employeesSetMapper() {
        //throw new UnsupportedOperationException();
        return new SetMapper<Set<Employee>>() {
            @Override
            public Set<Employee> mapSet(ResultSet resultSet) {
                Set<Employee> employee = new HashSet<>();
                try {
                    while (resultSet.next()) {
                        employee.add(mapRow(resultSet));
                    }
                    return employee;
                }
                catch (SQLException exeption) {
                    throw new UnsupportedOperationException();
                }
            }
            private Employee mapRow(ResultSet resultSet) throws SQLException {
                Employee manager = null;
                if (resultSet.getString("manager") != null) {
                    int row = resultSet.getRow();
                    int identity = resultSet.getInt("manager");
                    resultSet.absolute(0);
                    while (resultSet.next()) {
                        if (Integer.parseInt(resultSet.getString("id")) == identity)
                            manager = mapRow(resultSet);

                    }
                    resultSet.absolute(row);
                }
                return  new Employee((resultSet.getBigDecimal("id").toBigInteger()),
                        new FullName(resultSet.getString("firstname"),resultSet.getString("lastname"),resultSet.getString("middlename")),Position.valueOf(resultSet.getString("position")),resultSet.getDate("hiredate").toLocalDate(),resultSet.getBigDecimal("salary"),manager);
            }
        };
    }
}
