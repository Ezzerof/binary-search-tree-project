package com.room2.bstProject.employeeListProject;

import com.room2.bstProject.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface EmployeeConverter {
    Logger LOGGER = LogManager.getLogger(App.class);
    /*
        Uses data from the CSV service to create an employee object and return it to caller

     */
    static Employee createEmployeeFromData(String employeeData) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
            String[] dataList = employeeData.split(",");
            int empNo = Integer.parseInt(dataList[0]);
            LocalDate birthDate = LocalDate.parse(dataList[7], formatter);
            String firstName = dataList[2];
            String lastName = dataList[4];
            Gender gender = Gender.valueOf(dataList[5].charAt(0));
            LocalDate hireDate = LocalDate.parse(dataList[8], formatter);
            return new Employee(empNo, birthDate, firstName, lastName, gender, hireDate);
        }catch (NullPointerException e){
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

}
