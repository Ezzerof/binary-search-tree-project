package com.room2.bstProject;

import com.room2.bstProject.binaryTree.BinarySearchTree;
import com.room2.bstProject.binaryTree.BinarySearchTreeInterface;
import com.room2.bstProject.binaryTree.BinaryTreeStarter;
import com.room2.bstProject.binaryTree.ChildNotFoundException;
import com.room2.bstProject.employeeListProject.Employee;
import com.room2.bstProject.employeeListProject.EmployeeConverter;
import com.room2.bstProject.employeeListProject.EmployeeCsvService;
import com.room2.bstProject.employeeListProject.EmployeeStorage;
import com.room2.bstProject.employeeListProject.EmployeeStorageInterface;
import com.room2.bstProject.employeeListProject.EmployeeStorageStarter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main(String[] args) {
    //Initializes the Employee Storage + Binary Tree
    EmployeeStorageStarter.start();
    BinaryTreeStarter.start();
    EmployeeCsvService.employeeCSVGetterAndStore(100);
    //Gets reference to the storage and tree
    EmployeeStorageInterface employeeStorage = EmployeeStorage.getEmployeeStorage();
    BinarySearchTreeInterface tree = BinarySearchTree.getBinarySearchTree();




    String employeeData = "1234567,Mr.,Teagan,J,Griffith,F,teagan@gmail.com,01/23/1995,04/12/2012,15689";
    String employeeData1 = "1234567,Mr.,Teagan,J,Griffit,F,teagan@gmail.com,01/23/1995,04/12/2012,15689";
    String employeeData2 = "1234567,Mr.,Teagan,J,Griffithhh,F,teagan@gmail.com,01/23/1995,04/12/2012,15689";
    Employee employee = EmployeeConverter.createEmployeeFromData(employeeData);
    Employee employee1 = EmployeeConverter.createEmployeeFromData(employeeData1);
    Employee employee2 = EmployeeConverter.createEmployeeFromData(employeeData2);
    Employee employeeNull = EmployeeConverter.createEmployeeFromData(null);
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(employee);
    employeeList.add(employee2);
    employeeList.add(employee1);
    tree.addElement(employee);
    tree.addElement(employee1);
    tree.addElement(employee2);
    System.out.println(tree.getLeftChild("Griffith"));
    System.out.println(tree.findElement("Griffit").getVal());








  }


}