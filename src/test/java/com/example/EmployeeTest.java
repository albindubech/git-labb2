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
    void setIdShouldReturn2() {
        employee.setId("2");

        assertThat(employee.getId()).isEqualTo("2");
    }

    @Test
    void getSalaryShouldReturn20_000() {
        assertThat(employee.getSalary()).isEqualTo(20_000.0);
    }

    @Test
    void setSalaryShouldReturn18_000() {
        employee.setSalary(18_000.0);

        assertThat(employee.getSalary()).isEqualTo(18_000.0);
    }

    @Test
    void isPaidShouldReturnFalse() {
        assertThat(employee.isPaid()).isFalse();
    }

    @Test
    void setPaidShouldReturnTrueWhenTrue() {
        employee.setPaid(true);

        assertThat(employee.isPaid()).isTrue();
    }

    @Test
    void toStringShouldReturnEmployeeSummary() {
        assertThat(employee).hasToString("Employee [id=" + employee.getId() + ", salary=" + employee.getSalary() + "]");
    }
}
