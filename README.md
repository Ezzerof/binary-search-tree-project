# Binary Search Tree Project

An application that allows users to create, update, sort and search through employee information. We utilised a binary search tree to sift and sort through the large employee information data set.

## Learning Objectives

* Parse data into a suitable data structure
* Use the given employee factory design pattern
* Use the Collections framework
* Develop a collection class from scratch
* Create and use a nested class
* Populate a binary tree from unsorted data
* Provide a user interface and searching capability
* Use interfaces

## User Stories

```

"As a user, I want to add a node to an empty tree,
 so it'll become the root node." 

"As a user, I want to add a node to a created tree,
 so that I can expand the tree." 

"As a user, I want to add multiple nodes to a created tree,
 so that I can expand the tree with bigger data sets." 

"As a user, I want to search through the tree,
 so that I can find a certain node." 

"As a user, I want to sort the tree in ascending order, 
so that I can search through ascending order."

```

## Sample Acceptance Criteria (Gherkin Script)

```

Scenario: Adding a node to an empty tree

Happy Path: Adding a node to an empty tree
GIVEN, I have an empty employee database tree
WHEN, I add a new employee node with employee information
THEN, the employee node should become the root of the employee database tree
AND, the employee database tree should no longer be empty

Sad Path: Adding wrong node to empty tree
GIVEN, I have an empty employee database tree
WHEN, I add a new employee node with “null” information
THEN, no tree should be created.

Scenario: Searching through the tree to find a certain node

Happy: Finds the node requested.
GIVEN, I have populated tree.
WHEN, I enter  node I want to find.
AND, press “enter”
THEN, node I am looking for is displayed.

Sad: Node is not displayed.
GIVEN, I have populated tree.
WHEN, I enter  node I want to find.
AND, press “enter”
THEN, node I am looking for is not displayed.

Alternative: A different node is displayed than requested
GIVEN, I have populated tree.
WHEN, I enter  node I want to find.
AND, press “enter”
THEN, different node is displayed.

```

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Run `App.java` to start the application.
4. Follow instructions laid out by command-line-interface.

##  Our Process

This project was completed over 3 - 5 days. We were given a specification which we used to create user stories. From the user stories, we used a Kanban board to plot our product backlog items. We then used TDD and pair programming to produce it. During our 3 - 5 day sprint, we met in the afternoon to discuss current progress and then we would collectively assign programming-pairs their tickets. We ended our sessions with retros to talk about any blockers, update the kanbam board and to delegate tasks for the next day.

The project aims to apply SOLID and OO principles, use the MVC pattern where appropriate, and well-known design patterns. We developed the application using TDD,(JUnit). We used log4j2 for appropriate runtime logging and applied exception handling where applicable.

## Program Notes

### Employee Objects Useful Methods
**Getters and setters:**

- `(get/set)EmpNo;`
- `(get/set)BirthDate;`
- `(get/set)FirstName;`
- `(get/set)LastName;`
- `(get/set)Gender;`
- `(get/set)HireDate;`

**Convert Employee Object to a String:**
- `employeeObject.toString()`

### Creating Employee data from a String and storing it manually.
1. Start storage:
    - `EmployeeStorageStarter.start();`
2. Get a reference to the storage instance through the interface:
    - `EmployeeStorageInterface employeeStorage = EmployeeStorage.getEmployeeStorage();`
3. Setup data <-> String format required: 
   - ` Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary`
   - *Example String*: `111111,Mr.,John,J,Doe,M,john.doe@johndoe.com,1/31/1981,01/01/2001,111111`
4. Pass the string to the converter to return an employee object:
    - `Employee newEmployee = EmployeeConverter.createEmployeeFromData(*Example String*);`
5. Use reference setup in step 2 to add employee:
   - `employeeStorage.addEmployeeToList(newEmployee);`
6. *Optional* Use reference setup in step 2 to access storage methods:
    - `employeeStorage.getEmployeeList();` - Returns a list of employee objects
    - `employeeStorage.getEmployeeFromList(n);` - Returns a single employee object

### Reading in Employee data automatically from a CSV file.
1. Start storage:
    - `EmployeeStorageStarter.start();`
2. Get a reference to the storage instance through the interface: 
   - `EmployeeStorageInterface employeeStorage = EmployeeStorage.getEmployeeStorage();`
3. Specify amount of data to read & store from CSV: (n = quantity to read in)
    - `EmployeeCsvService.employeeCSVGetterAndStore(n);`
4. Use reference setup in step 2 to access storage methods:
   - `employeeStorage.getEmployeeList();` - Returns a list of employee objects
   - `employeeStorage.getEmployeeFromList(n);` - Returns a single employee object

## Contributors

* Cristian Bitca
* James Reed
* Elliott Horton-Stephens
* Marcella Chessa
* Marcin Sebastian Jakobik
* Narmada Janaki Reddy

## License

This project is licensed under the MIT License - see the `LICENSE` file for details.
