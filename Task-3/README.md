### README

# Student Management System

This is a simple Java-based Student Management System that allows you to add, remove, update, search, display, load from a file, and save to a file information about students.
This project is a console-based application that helps manage student information. It allows users to perform various operations on student data and store this data in a text file.

## Features

- Add a new student.
- Remove an existing student.
- Update student details.
- Search for a student by ID.
- Display all students.
- Load student data from a file.
- Save student data to a file.

## Usage
1. Compile the Java files:
   Student.java
   StudentManager.java
   Main.java

## Classes

### Student Class

Represents a student with the following attributes:
- `int id`: Unique identifier for the student.
- `String name`: Name of the student.
- `int age`: Age of the student.
- `String grade`: Grade of the student.
- `String address`: Address of the student.

**Methods:**
- Constructors
- Getters and setters
- `toString()`: Returns a string representation of the student.
- `equals()`: Checks if two students are equal based on their ID.
- `hashCode()`: Returns the hash code of the student.

### StudentManager Class

Manages a list of students with the following methods:
- `void addStudent(Student student)`: Adds a new student to the list.
- `void removeStudent(int id)`: Removes a student from the list by ID.
- `void updateStudent(int id, String name, int age, String grade, String address)`: Updates the details of a student.
- `Student searchStudent(int id)`: Searches for a student by ID.
- `void displayAllStudents()`: Displays all students.
- `void loadFromFile(String filename)`: Loads student data from a file.
- `void saveToFile(String filename)`: Saves student data to a file.

### Main Class

Provides a menu-driven interface to interact with the `StudentManager`. Handles user input and calls the appropriate methods on the `StudentManager`.

### students.dat 
The file in which user input is stored.
### output
Shows the output of the program

## Example

Here's an example of how you might interact with the program:

```plaintext
1. Add Student
2. Remove Student
3. Update Student
4. Search Student
5. Display All Students
6. Load from File
7. Save to File
8. Exit
Enter your choice: 1
Enter student ID: 1
Enter name: John Doe
Enter age: 20
Enter grade: A
Enter address: 123 Main St
Student added successfully.
