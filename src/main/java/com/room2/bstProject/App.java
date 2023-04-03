package com.room2.bstProject;

import com.room2.bstProject.binaryTree.BinarySearchTree;
import com.room2.bstProject.binaryTree.BinarySearchTreeInterface;
import com.room2.bstProject.binaryTree.BinaryTreeStarter;
import com.room2.bstProject.employeeListProject.EmployeeCsvService;
import com.room2.bstProject.employeeListProject.EmployeeStorage;
import com.room2.bstProject.employeeListProject.EmployeeStorageInterface;
import com.room2.bstProject.employeeListProject.EmployeeStorageStarter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.room2.bstProject.userInterface.UserInterfaceRunner;

public class App {
  private static final Logger LOGGER = LogManager.getLogger(App.class);
  public static void main(String[] args) {
    //Initializes the Employee Storage + Binary Tree
    EmployeeStorageStarter.start();
    BinaryTreeStarter.start();
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


}