package org.softwaretechnologies;

import org.junit.jupiter.api.Test;
import org.softwaretechnologies.employee.EmployeeType;
import org.mockito.MockedStatic;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class CompanyTest {

    @Test
    void getMonthSalary() {
        Company test = new Company("test");
        assertEquals("test", test.getName());
        test.addEmployee("test1", 1, EmployeeType.Tester);
        test.addEmployee("test1", 1, EmployeeType.Tester);
        test.addEmployee("test1", 1000, EmployeeType.Manager);
        test.addEmployee("test1", 1000, EmployeeType.Programmer);
        String instantExpected = "2017-01-01";
        LocalDate parse = LocalDate.parse(instantExpected);
        try (MockedStatic<LocalDate> mockedStatic = mockStatic(LocalDate.class)) {
            mockedStatic.when(LocalDate::now).thenReturn(parse);
            int december = test.getMonthSalary(12);
            assertEquals(2062, december);
            int february = test.getMonthSalary(2);
            assertEquals(2056, february);
            int march = test.getMonthSalary(3);
            assertEquals(1562, march);
        }
    }

    @Test
    void getMonthSalaryLeapYear() {
        Company test = new Company("test");
        assertEquals("test", test.getName());
        test.addEmployee("test1", 1, EmployeeType.Tester);
        test.addEmployee("test1", 1000, EmployeeType.Manager);
        test.addEmployee("test1", 1000, EmployeeType.Programmer);
        String instantExpected = "2016-01-01";
        LocalDate parse = LocalDate.parse(instantExpected);
        try (MockedStatic<LocalDate> mockedStatic = mockStatic(LocalDate.class)) {
            mockedStatic.when(LocalDate::now).thenReturn(parse);
            int february = test.getMonthSalary(2);
            assertEquals(2029, february);
            int march = test.getMonthSalary(3);
            assertEquals(1531, march);
        }
    }
}