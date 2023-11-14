package com.example.crud.resolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.crud.entity.Employee;
import com.example.crud.service.EmployeeServiceImp;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;

@Component
public class Query implements GraphQLQueryResolver {
    Logger logger = LoggerFactory.getLogger(Query.class);
    private EmployeeServiceImp employeeServiceImp;

    GraphQLScalarType longScalar = ExtendedScalars.newAliasedScalar("Long")
            .aliasedScalar(ExtendedScalars.GraphQLLong)
            .build();

    @Autowired
    public Query(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    public Iterable<Employee> findAllEmployees() {
        return employeeServiceImp.fetchAllEmployees();
    }

    public Employee employeeById(Long id) {
        return employeeServiceImp.getEmployeeById(id);
    }
}
