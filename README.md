# Binary Search Tree Project - SOLID/OOP

This project is a group project that must be run as Scrum projects, and the group must consist of 5 or 6 members. The project aims to apply SOLID and OO principles, use the MVC pattern where appropriate, and well-known design patterns. It must include comprehensive JUnit testing or equivalent, log4j2 for appropriate runtime logging or equivalent, appropriate exception handling, and be hosted on GitHub with thorough documentation through a README.md file.

## Purpose

The purpose of this project is to give trainees an opportunity to:

* Parse data into a suitable data structure
* Use the Collections framework
* Develop a collection class from scratch
* Create and use a nested class
* Populate a binary tree from unsorted data
* Provide a user interface and searching capability
* Use interfaces

## Requirements

### Phase 1

1. Add the provided factory class, `EmployeeFactory.java`, to a suitable package within your project.
2. Add the provided sample data file, `employees.csv`, to the `src/main/resources` folder in your project.
3. Call `EmployeeFactory.getEmployees(n)` to generate an array of random employee data of size n (1 <= n <= 1000).
4. Employee data is provided as an array of Strings, returned from `getEmployees()`, each String representing:
    * `emp_no` (up to 8 digits)
    * `birth_date` (YYYY-MM-DD, ISO 8601 calendar date format)
    * `first_name` (alpha characters and spaces only)
    * `last_name` (alpha characters and spaces only)
    * `gender` (single character)
    * `hire_date` (YYYY-MM-DD)
    The values for the employee data will be separated by commas within the String.
5. Convert each element in the array into an `Employee` object, having created a suitable class, and store it in a `List` using a suitable concrete type.

### Phase 2

1. Once the provided data have been stored in a `List`, convert the `List` to a binary tree using a class you've created for this purpose (using `last_name` as the key).
2. Use a nested class to represent a node in the tree.
3. The tree should allow for multiple employees with the same `last_name`.
4. Allow the user to search for a specific employee by `last_name`.

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Run `EmployeeFactory.java` to generate random employee data.
4. Run `App.java` to start the application.

## Contributors

* Cristian Bitca
* James Reed
* Elliott Horton-Stephens
* Marcella Chessa
* Marcin Sebastian Jakobik
* Narmada Janaki Reddy

## License

This project is licensed under the MIT License - see the `LICENSE` file for details.
