package com.room2.bstProject.userInterface;

import com.room2.bstProject.employeeListProject.Employee;

interface UserPrinter {
    //Interface for printing Employee and their details
     static void printUser(Employee employee) {
        System.out.println(employee.toString());
    }

}
