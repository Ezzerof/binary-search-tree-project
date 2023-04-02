package com.room2.bstProject;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import com.room2.bstProject.binaryTree.BinarySearchTree;
import com.room2.bstProject.binaryTree.BinarySearchTreeInterface;
import com.room2.bstProject.binaryTree.BinaryTreeStarter;
import com.room2.bstProject.binaryTree.ChildNotFoundException;
import com.room2.bstProject.employeeListProject.Employee;


import com.room2.bstProject.employeeListProject.Gender;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BinaryTreeTest {



  @BeforeAll
  static void beforeAll() {
    BinaryTreeStarter.start();

  }


  @Test
  @Order(1)
  @DisplayName("1. Testing Null Root Value Exception")
  void testGetRootNodeWhenValueIsNull(){
    BinarySearchTreeInterface tree = BinarySearchTree.getBinarySearchTree();
    Assertions.assertThrows(NoSuchElementException.class, () -> tree.getRootElement());
  }

  @Test
  @Order(2)
  @DisplayName("2. Test Adding Node to Empty Tree - Root Node Test")
  void testAddingNodeToEmptyTree() {
    BinarySearchTreeInterface tree = BinarySearchTree.getBinarySearchTree();
    Employee
        employee =
        new Employee(1234567, LocalDate.of(1995, 1, 23), "", "testNameOne", Gender.MALE,
            LocalDate.of(2012, 4, 12));
    tree.addElement(employee);
    Assertions.assertEquals("testNameOne", tree.getRootElement().getVal());

  }

  @Test
  @Order(3)
  @DisplayName("3. Testing Left and Right Child Custom Exception")
  void testGetRightAndLeftChildCustomException(){

    BinarySearchTree bst = BinarySearchTree.getBinarySearchTree();
    Assertions.assertThrows(ChildNotFoundException.class, () -> bst.getLeftChildHelper("testNameOne"));
    Assertions.assertThrows(ChildNotFoundException.class, () -> bst.getRightChildHelper("testNameOne"));
  }

  @Test
  @Order(4)
  @DisplayName("4. Test Node Exists")
  void testBooleanMethodForNodeExistsCheck() {
    BinarySearchTreeInterface tree = BinarySearchTree.getBinarySearchTree();
    Assertions.assertTrue(tree.isElementInTree("testNameOne"));
  }

  @Test
  @Order(5)
  @DisplayName("5. Check Size Of Tree")
  void checkTheSizeOfTheBinaryTreeShouldGet2() {
    BinarySearchTreeInterface tree = BinarySearchTree.getBinarySearchTree();
    Assertions.assertEquals(1, tree.getNumberOfElements());
  }


  @Test
  @Order(6)
  @DisplayName("6. Test Adding Node To Populated Tree")
  void testAddingNodeToPopulatedTree() {
    BinarySearchTreeInterface tree = BinarySearchTree.getBinarySearchTree();
    Employee employee1 = new Employee(1234567, LocalDate.of(1995, 1, 23), "", "testNameOnee", Gender.MALE,
            LocalDate.of(2012, 4, 12));
    Employee employee2 = new Employee(1234567, LocalDate.of(1995, 1, 23), "", "testNameOn", Gender.MALE,
            LocalDate.of(2012, 4, 12));
    tree.addElement(employee1);
    tree.addElement(employee2);
    Assertions.assertEquals(3, tree.getNumberOfElements());
  }

  @Test
  @Order(7)
  @DisplayName("7. Test Searching of Tree")
  void testSearchingInATree() {
    BinarySearchTreeInterface tree = BinarySearchTree.getBinarySearchTree();
    Assertions.assertEquals("testNameOne", tree.findElement("testNameOne").getVal());
    Assertions.assertEquals("testNameOn", tree.findElement("testNameOn").getVal());
    Assertions.assertEquals("testNameOnee", tree.findElement("testNameOnee").getVal());
  }

  @Test
  @Order(8)
  @DisplayName("8. Testing Left and Right Child Getter")
  void testGetRightAndLeftChildOfNode(){
    BinarySearchTreeInterface tree = BinarySearchTree.getBinarySearchTree();
    Assertions.assertEquals("testNameOn", tree.getLeftChild("testNameOne"));
    Assertions.assertEquals("testNameOnee", tree.getRightChild("testNameOne"));
  }


/*

Old tests for int based tree

 */
//  @Test
//  @DisplayName("Check the root value of the BinaryTree should be 5")
//  void checkTheRootValueOfTheBinaryTreeShouldBe5() {
//    tree.addElement(5);
//    assertEquals(5, tree.getRootElement());
//  }
//
//  @Test
//  @DisplayName("Getting root value of a null Binary Tree should get NoSuchElementException")
//  void gettingRootValueOfANullBinaryTreeShouldGetNoSuchElementException() {
//    assertThrows(NoSuchElementException.class, () -> tree.getRootElement());
//  }
//
//
//  @Test
//  @DisplayName("Should add an array of ints to the Binary Tree")
//  void shouldAddAnArrayOfIntsToTheBinaryTree() {
//    int[] list = {10, 2, 4};
//    tree.addElements(list);
//
//  }


}
