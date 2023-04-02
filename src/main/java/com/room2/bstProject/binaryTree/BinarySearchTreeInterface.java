package com.room2.bstProject.binaryTree;

import com.room2.bstProject.employeeListProject.Employee;

import java.util.List;

public interface BinarySearchTreeInterface {

    //Gets root element of the BST if there is a root
    BinarySearchTree.TreeNode getRootElement();
    //Gets the number of nodes in the BST
    int getNumberOfElements();
    //Adds a single employee to the tree
    void addElement(Employee element);
    //Adds a list of employees to the BST
    void addElements(List<Employee> elements);

    //Search for a node by employee last name
    BinarySearchTree.TreeNode findElement(String value);
    //Check if an employee with the specified last name exists in the tree
    boolean isElementInTree(String value);
    //Sorts the tree in ascending order and returns a string array of the last names
    String[] getSortedTreeAsc();
    //Sorts the tree in descending order and returns a string array of the last names
    String[] getSortedTreeDesc();
    //Traverses the tree in pre-order
    void preOrder(BinarySearchTree.TreeNode root);
    //Traverses the tree in-order
    List<String> traverse();
    //Get left child of a Node
    String getLeftChild(String element);
    //Get right child of a Node
    String getRightChild(String element);


}
