package com.room2.projectBST.employeeListProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFactory {

    public static String[] getEmployees(int numEmployees) throws IOException {
        if (numEmployees < 1 || numEmployees > 1000)
            throw new IllegalArgumentException("Argument 'numEmployees' must be between 1 and 1000");
        String employeeLine;
        List<String> result = new ArrayList<>();
        BufferedReader f = new BufferedReader(new FileReader("src/main/resources/employees.csv"));
// read all the records from the file and add them to the list
        while ((employeeLine = f.readLine()) != null)
            result.add(employeeLine);
// randomise
        Collections.shuffle(result);
// return the first numEmployees values as an array
        return result.subList(0,numEmployees).toArray(new String[0]);
    }

}
