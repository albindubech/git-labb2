package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class EmployeeTest {
    Employee employee = new Employee("1", 20_000.0);

    @Test
    void getIdShouldReturn1() {
        assertThat(employee.getId()).isEqualTo("1");
    }

    @Test
    void setIdShouldReturn2(){
        employee.setId("2");

        assertThat(employee.getId()).isEqualTo("2");
    }
}
