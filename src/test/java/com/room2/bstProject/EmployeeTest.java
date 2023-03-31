package com.room2.bstProject;


import employeeListProject.Employee;
import employeeListProject.Gender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {


    @Test
    @DisplayName("Test employee constructor")
    void testEmployeeConstructor() {
        Employee employee = new Employee(1234567, LocalDate.of(1995, 1, 23), "Teagan", "Griffith", Gender.FEMALE, LocalDate.of(2012, 4, 12));
        assertEquals(1234567, employee.getEmpNo());
        assertEquals("1995-01-23", employee.getBirthDate().toString());
        assertEquals("Teagan", employee.getFirstName());
        assertEquals("Griffith", employee.getLastName());
        assertEquals(Gender.FEMALE, employee.getGender());
        assertEquals("2012-04-12", employee.getHireDate().toString());
    }



}
