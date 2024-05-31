# Library Management System
This project implements a library management system using Java. It demonstrates the use of OOP principles such as encapsulation, inheritance, polymorphism, and abstraction.

## Classes and Interfaces

- `Book`: Represents a book with attributes like bookID, title, author, and isIssued.
- `Member`: Represents a library member with attributes like memberID, name, maxBooksIssued, and currentIssuedBooks.
- `Librarian`: Extends `Member` and includes additional methods to add and remove books from the library.
- `LibraryOperations`: Defines methods for issuing and returning books.
- `Library`: Implements `LibraryOperations` and manages a list of books and members.
- `StudentMember` and `TeacherMember`: Specialized member classes with different `maxBooksIssued` values.

## Compilation and Execution

1. **Compile the Java files**:

   ```sh
   javac
   Book.java
   Member.java
   Librarian.java
   LibraryOperations.java
   Library.java
   StudentMember.java
    TeacherMember.java
    Main.java
