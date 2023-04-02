package com.room2.bstProject;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.room2.bstProject.employeeListProject.Employee;
import com.room2.bstProject.employeeListProject.EmployeeConverter;
import com.room2.bstProject.employeeListProject.EmployeeFactory;
import com.room2.bstProject.employeeListProject.EmployeeStorage;
import com.room2.bstProject.employeeListProject.EmployeeStorageInterface;
import com.room2.bstProject.employeeListProject.EmployeeStorageStarter;
import com.room2.bstProject.employeeListProject.Gender;

public class EmployeeFactoryTest {


    private static final Logger logger = LogManager.getLogger(EmployeeFactoryTest.class);
    @Test
    @DisplayName("Test Get Employees With Valid Input Size")
    void testGetEmployeesWithValidInputSize() {

        try {
            Assertions.assertEquals(10, EmployeeFactory.getEmployees(10).length);
        } catch (Exception e) {
            logger.trace(e.getMessage(), e);
        }

    }

    @Test
    @DisplayName("Test get Employees with invalid input size")
    void testGetEmployeesWithInvalidInputSize() {
        assertThrows(IllegalArgumentException.class, () -> EmployeeFactory.getEmployees(0));
    }

    @Test
    @DisplayName("Test convert Employee data To Employee object")
    void testConvertEmployeeDataToEmployeeObject() {
        String employeeData = "1234567,Mr.,Teagan,J,Griffith,F,teagan@gmail.com,01/23/1995,04/12/2012,15689";
        Employee employee = EmployeeConverter.createEmployeeFromData(employeeData);
        assertEquals(1234567, employee.getEmpNo());
        assertEquals("1995-01-23", employee.getBirthDate().toString());
        assertEquals("Teagan", employee.getFirstName());
        assertEquals("Griffith", employee.getLastName());
        assertEquals(Gender.FEMALE, employee.getGender());
        assertEquals("2012-04-12", employee.getHireDate().toString());
    }

//    @Test
//    @DisplayName("Test Create Employee list")
//    void testCreateEmployeeList() {
//        String[] employeeDataArray = {
//                "1234567,1995-01-23,Teagan,Griffith,F,2012-04-12",
//                "2345678,1996-02-24,Tommy,Smith,M,2013-05-13"
//        };
//        Employee employee1 = EmployeeFactory.createEmployeeFromData(employeeDataArray[0]);
//        Employee employee2 = EmployeeFactory.createEmployeeFromData(employeeDataArray[1]);
//        EmployeeRepository.addEmployee(employee1);
//        EmployeeRepository.addEmployee(employee2);
//
//        assertEquals(2, EmployeeRepository.getEmployeeList().size());
//        assertEquals(1234567, EmployeeRepository.getEmployeeList().get(0).getEmpNo());
//        assertEquals(2345678, EmployeeRepository.getEmployeeList().get(1).getEmpNo());
//    }

//    @Test
//    @DisplayName("Test Create Employee list")
//    void testCreateEmployeeList() {
//        try {
//            EmployeeConverter employeeConverter = new EmployeeConverter();
//            EmployeeStorageStarter.start(500);
//            EmployeeStorageInterface employeeStorage = EmployeeStorage.getEmployeeStorage();
//
//
//            String[] employeeDataArray = EmployeeFactory.getEmployees(2);
//            Employee employee1 = employeeConverter.createEmployeeFromData(employeeDataArray[0]);
//            Employee employee2 = employeeConverter.createEmployeeFromData(employeeDataArray[1]);
//
//            employeeStorage.addEmployeeToList(employee1);
//            employeeStorage.addEmployeeToList(employee2);
//
//            assertEquals(2, employeeStorage.getEmployeeList().size());
//            assertEquals(employee1.getEmpNo(), employeeStorage.getEmployeeFromList(0).getEmpNo());
//            assertEquals(employee2.getEmpNo(), employeeStorage.getEmployeeFromList(1).getEmpNo());
//        } catch(Exception e) {
//            logger.trace(e.getMessage(), e);
//        }
//
//    }

}
