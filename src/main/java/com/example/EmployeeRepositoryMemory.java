package com.example;

import java.util.List;

public class EmployeeRepositoryMemory implements EmployeeRepository {

    List<Employee> employees;

    public EmployeeRepositoryMemory(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {

        employees.stream()
                .filter(employee -> employee.getId().equals(e.getId()))
                .findFirst()
                .ifPresentOrElse(employee -> employees.set(employees.indexOf(employee),e),() -> employees.add(e));

        return e;
    }
}