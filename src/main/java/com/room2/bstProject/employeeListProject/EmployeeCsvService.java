package com.room2.bstProject.employeeListProject;

import com.room2.bstProject.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public interface EmployeeCsvService {
  Logger LOGGER = LogManager.getLogger(App.class);
  //Gets employee data from a CSV file in resources and puts it into storage
   static void employeeCSVGetterAndStore(int numberOfEmployeesToGet){
    try {
      String result[] = EmployeeFactory.getEmployees(numberOfEmployeesToGet);
      Employee temp;
      for(String data: result) {
        temp = EmployeeConverter.createEmployeeFromData(data);
        EmployeeStorage.getEmployeeStorage().addEmployeeToList(temp);
      }
    } catch (IOException e) {
      LOGGER.error(e.getMessage(), e);
    } catch (RuntimeException e){
      LOGGER.error(e.getMessage(), e);
    }
  }
}
