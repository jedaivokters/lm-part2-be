package com.example.crud.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.crud.entity.Employee;
import com.example.crud.service.EmployeeServiceImp;

import graphql.kickstart.tools.GraphQLMutationResolver;
import javax.persistence.EntityNotFoundException;

@Component
public class Mutation implements GraphQLMutationResolver {
    private EmployeeServiceImp employeeServiceImp;

    @Autowired
    public Mutation(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    public Employee createEmployee(String firstName, String middleName, String lastName) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setMiddleName(middleName);
        employee.setLastName(lastName);

        employeeServiceImp.saveEmployee(employee);

        return employee;
    }

    public boolean deleteEmployee(Long id) {
        employeeServiceImp.deleteEmployeeById(id);
        return true;
    }


}
