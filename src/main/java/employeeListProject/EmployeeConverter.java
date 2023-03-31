package com.room2.projectBST.employeeListProject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeConverter implements Converter{

    public Employee createEmployeeFromData(String employeeData) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String[] dataList = employeeData.split(",");
        int empNo = Integer.parseInt(dataList[0]);
        LocalDate birthDate = LocalDate.parse(dataList[7], formatter);
        String firstName = dataList[2];
        String lastName = dataList[4];
        Gender gender = Gender.valueOf(dataList[5].charAt(0));
        LocalDate hireDate = LocalDate.parse(dataList[8], formatter);
        return new Employee(empNo, birthDate, firstName, lastName, gender, hireDate);
    }

}
