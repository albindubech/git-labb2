package com.example;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {

    static private EmployeeRepository employeeRepository;
    static private BankService bankService;
    static private EmployeeManager employeeManager;

    @BeforeAll
    static void setUp() {
        employeeRepository = new EmployeeRepositoryStub(List.of(
                new Employee("1", 20_000.0),
                new Employee("2", 30_000.0),
                new Employee("3", 40_000.0)));
        bankService = mock(BankService.class);
        employeeManager = new EmployeeManager(employeeRepository, bankService);
    }

    @Test
    void payEmployeesShouldReturnThree() {
        assertThat(employeeManager.payEmployees()).isEqualTo(3);
    }
}