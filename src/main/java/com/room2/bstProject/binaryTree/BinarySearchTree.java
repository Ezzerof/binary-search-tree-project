package com.room2.bstProject.binaryTree;

import com.room2.bstProject.App;
import com.room2.bstProject.employeeListProject.Employee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearchTree implements BinarySearchTreeInterface {
    private static final Logger LOGGER = LogManager.getLogger(App.class);
    //Nested TreeNode class
    public class TreeNode {

        private String val;

        private Employee employee;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Employee employee) {
            this.employee = employee;
            this.val = employee.getLastName();
            this.left = null;
            this.right = null;
        }

        public String getVal() {
            return val;
        }

        public Employee getEmployee() {
            return employee;
        }

    }
    private TreeNode root;

    private int size;

    private static BinarySearchTree binarySearchTree;

    private BinarySearchTree(){

    }
    //Creates instance of binary search tree object, once and only once (Singleton)
    protected static BinarySearchTree createBinaryTree() {
        if (binarySearchTree == null) {
            binarySearchTree = new BinarySearchTree();
            return binarySearchTree;
        }
        return binarySearchTree;
    }

    //Gets instance of the BST object
    public static BinarySearchTree getBinarySearchTree() {
        return binarySearchTree;
    }

    //Implementation of: Gets root element of the BST if there is a root
    @Override
    public TreeNode getRootElement() {
        if (isEmpty(root))
            throw new NoSuchElementException("Tree is empty");

        return root;
    }

    //Implementation of: Gets the number of nodes in the BST
    @Override
    public int getNumberOfElements() {
        return size;
    }

    //Implementation of: Adding a node to the tree
    @Override
    public void addElement(Employee element) {
       try{
           if(element != null) {
               if (isEmpty(root)) {
                   root = new TreeNode(element);
               } else {
                   addElementHelper(root, element);
               }
               size++;
           }
       } catch (NullPointerException e){
           LOGGER.error(e.getMessage(), e);
       }
    }

    //Helper method for adding a node to the tree
    //Compares last_name of an employee object to the current nodes value (last_name) to decide where to insert
    //Allows for duplicate names
    public void addElementHelper(TreeNode node, Employee element) {
        try {
            if (element.getLastName().compareTo(node.val) < 0) {
                if (isEmpty(node.left)) {
                    node.left = new TreeNode(element);
                } else {
                    addElementHelper(node.left, element);
                }
            } else if (element.getLastName().compareTo(node.val) > 0) {
                if (isEmpty(node.right)) {
                    node.right = new TreeNode(element);
                } else {
                    addElementHelper(node.right, element);
                }
            } else if (element.getLastName().equals(node.val)) {
                if (isEmpty(node.left)) {
                    node.left = new TreeNode(element);
                } else {
                    addElementHelper(node.left, element);
                }
            }
        }catch (NullPointerException e){
            LOGGER.error(e.getMessage(), e);
        }

    }

    //Helper method for true/false checks
    private boolean isEmpty(TreeNode node) {
        return node == null;
    }

    //Implementation of: Adds a list of employees to the BST
    @Override
    public void addElements(List<Employee> elements) {
        for (Employee element : elements) {
            addElement(element);
        }
    }

    //Implementation of: Search for a node by employee last name
    @Override
    public TreeNode findElement(String value) {
        if (root.val.compareTo(value) == 0) {
            return root;
        }

        return findElementHelper(root, value);
    }

    //Helper method for finding a node -- needs to log null exception
    public TreeNode findElementHelper(TreeNode node, String value) {
        if (isEmpty(node)) {
            return null;
        }
        if (node.val.equals(value)) {
            return node;
        }
        if (value.compareTo(node.val) < 0) {
           return findElementHelper(node.left, value);
        }

        return findElementHelper(node.right, value);
    }

    //Implementation of: Check if an employee with the specified last name exists in the tree
    @Override
    public boolean isElementInTree(String value) {
        return findElement(value) != null;
    }

    //Implementation of: Sorts the tree in ascending order and returns a string array of the last names
    @Override
    public String[] getSortedTreeAsc() {
        List<String> list = traverse();
        String[] ascendingOrderList = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ascendingOrderList[i] = list.get(i);
        }

        return ascendingOrderList;
    }
    //Implementation of: Sorts the tree in descending order and returns a string array of the last names
    @Override
    public String[] getSortedTreeDesc() {
        List<String> list = traverse();
        String[] descendingOrderList = new String[list.size()];

        for (int i = 1; i <= list.size(); i++) {
            descendingOrderList[i - 1] = list.get(list.size() - i);
        }

        return descendingOrderList;
    }
    //Implementation of: Traverse the tree in pre-order
    @Override
    public void preOrder(TreeNode root)
    {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    //Implementation of: Traverse the tree in-order
    @Override
    public List<String> traverse() {
        List<String> list = new ArrayList<>();
        traverseHelper(root, list);
        return list;
    }
    //Helper method for traverse
    private void traverseHelper(TreeNode node, List<String> list) {
        if (!isEmpty(node)) {
            traverseHelper(node.left, list);
            list.add(node.val);
            traverseHelper(node.right, list);
        }
    }
    //Implementation of: Get left child of a Node
    @Override
    public String getLeftChild(String element){
        try {
            return getLeftChildHelper(element);
        } catch (ChildNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return "No left child found for element: " + element;
    }
    //Implementation of: Get right child of a Node
    @Override
    public String getRightChild(String element){
        try {
            return getRightChildHelper(element);
        }catch (ChildNotFoundException e){
            LOGGER.error(e.getMessage(), e);
        }
        return "No right child found for element " + element;
    }

    //Left child helper method
    public String getLeftChildHelper(String element) throws ChildNotFoundException  {

        TreeNode node = findElement(element);
        if (isEmpty(node) || isEmpty(node.left)) {
            throw new ChildNotFoundException("Left child not found");
        }
        return node.left.val;
    }
    //Right child helper method
    public String getRightChildHelper(String element) throws ChildNotFoundException {
        TreeNode node = findElement(element);
        if (isEmpty(node) || isEmpty(node.right)) {
            throw new ChildNotFoundException("Right child not found");
        }

        return node.right.val;
    }
}
