package employeeListProject;


import java.util.ArrayList;
import java.util.List;

public class EmployeeStorage implements EmployeeStorageInterface {

    private static List<Employee> employeeList;

    private static EmployeeStorage employeeStorage;

    private EmployeeStorage(){

    }
    public static EmployeeStorage createEmployeeStorage() {
        if (employeeStorage == null) {
            employeeList = new ArrayList<>();
            employeeStorage = new EmployeeStorage();
            return employeeStorage;
        }
        return employeeStorage;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static EmployeeStorage getEmployeeStorage() {
        return employeeStorage;
    }

    @Override
    public void insertEmployeesIntoLinkedList(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public Employee getEmployeeFromList(int index){
        return employeeList.get(index);
    }

}
