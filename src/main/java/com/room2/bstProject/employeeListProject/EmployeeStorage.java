package com.room2.bstProject.employeeListProject;


import java.util.ArrayList;
import java.util.List;

public class EmployeeStorage implements EmployeeStorageInterface {

    private static List<Employee> employeeList;

    private static EmployeeStorage employeeStorage;

    private EmployeeStorage(){

    }
    //Creates instance of employee storage object, once and only once (Singleton)
    protected static EmployeeStorage createEmployeeStorage() {
        if (employeeStorage == null) {
            employeeList = new ArrayList<>();
            employeeStorage = new EmployeeStorage();
            return employeeStorage;
        }
        return employeeStorage;
    }
    //Gets instance of employee storage object
    public static EmployeeStorage getEmployeeStorage() {
        return employeeStorage;
    }
    //Implementation of: Gets list of employees currently stored
    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    //Implementation of: Adds an employee to the list
    @Override
    public void addEmployeeToList(Employee employee) {
        employeeList.add(employee);
    }
    //Implementation of: Gets an employee from the list by index in the list
    @Override
    public Employee getEmployeeFromList(int index){
        return employeeList.get(index);
    }

}
