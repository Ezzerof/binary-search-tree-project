package com.room2.bstProject;

import com.room2.bstProject.binaryTree.BinarySearchTree;
import com.room2.bstProject.binaryTree.BinarySearchTreeInterface;
import com.room2.bstProject.binaryTree.BinaryTreeStarter;
import com.room2.bstProject.employeeListProject.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.room2.bstProject.userInterface.UserInterfaceRunner;

import java.util.ArrayList;
import java.util.List;

public class App {
  private static final Logger LOGGER = LogManager.getLogger(App.class);
  public static void main(String[] args) {
//    //Initializes the Employee Storage + Binary Tree
    EmployeeStorageStarter.start();
    BinaryTreeStarter.start();
    EmployeeCsvService.employeeCSVGetterAndStore(1000);
    EmployeeCsvService.employeeCSVGetterAndStore(1000);
    EmployeeCsvService.employeeCSVGetterAndStore(1000);
    EmployeeCsvService.employeeCSVGetterAndStore(1000);
    EmployeeCsvService.employeeCSVGetterAndStore(1000);
    //Gets reference to the storage and tree
    EmployeeStorageInterface employeeStorage = EmployeeStorage.getEmployeeStorage();
    BinarySearchTreeInterface tree = BinarySearchTree.getBinarySearchTree();
    tree.addElements(employeeStorage.getEmployeeList());

    //Printing the current employees added to the tree in-order
    System.out.println(tree.traverse());
    tree.preOrder(tree.getRootElement());
    //Runs the user interface
    try {
      UserInterfaceRunner.getUserInput(tree);
    } catch (NullPointerException e) {
        LOGGER.error(e);
    }
    }


//    String employeeData = "1234567,Mr.,Teagan,J,Griffittttt,F,teagan@gmail.com,01/23/1995,04/12/2012,15689";
//    String employeeData1 = "1234567,Mr.,Teagan,J,Griffit,F,teagan@gmail.com,01/23/1995,04/12/2012,15689";
//    String employeeData2 = "1234567,Mr.,Teagan,J,Griffit,F,teagan@gmail.com,01/23/1995,04/12/2012,15689";
//    String employeeData3 = "1234567,Mr.,Teagan,J,Griffit,F,teagan@gmail.com,01/23/1995,04/12/2012,15689";
//    String employeeData4 = "1234567,Mr.,Teagan,J,Griffit,F,teagan@gmail.com,01/23/1995,04/12/2012,15689";
//    Employee employee = EmployeeConverter.createEmployeeFromData(employeeData);
//    Employee employee1 = EmployeeConverter.createEmployeeFromData(employeeData1);
//    Employee employee2 = EmployeeConverter.createEmployeeFromData(employeeData2);
//    Employee employee3 = EmployeeConverter.createEmployeeFromData(employeeData2);
//    Employee employee4 = EmployeeConverter.createEmployeeFromData(employeeData2);
//    Employee employeeNull = EmployeeConverter.createEmployeeFromData(null);
//    List<Employee> employeeList = new ArrayList<>();
//    employeeList.add(employee);
//    employeeList.add(employee2);
//    employeeList.add(employee1);
//    tree.addElement(employee);
//    tree.addElement(employee1);
//    tree.addElement(employee2);
//    tree.addElement(employee3);
//    tree.addElement(employee4);
////    System.out.println(tree.getLeftChild("Griffith"));
//    BinarySearchTree.TreeNode node = tree.findElement("Griffit");
//    System.out.println(node.getVal());
//    System.out.println(node.getDuplicate());


  }
