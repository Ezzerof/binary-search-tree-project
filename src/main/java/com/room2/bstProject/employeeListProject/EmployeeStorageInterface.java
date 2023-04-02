package com.room2.bstProject.employeeListProject;

import java.util.List;

public interface EmployeeStorageInterface {
    //Gets list of employees currently stored
    List<Employee> getEmployeeList();
    //Adds an employee to the list
    void addEmployeeToList(Employee employee);
    //Gets an employee from the list by index in the list
    Employee getEmployeeFromList(int index);


}
