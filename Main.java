public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian(1, "Alice");

        // Adding books to the library
        Book book1 = new Book(101, "Java Programming", "Author A");
        Book book2 = new Book(102, "Data Structures", "Author B");
        Book book3 = new Book(103, "Algorithms", "Author C");

        librarian.addBook(library, book1);
        librarian.addBook(library, book2);
        librarian.addBook(library, book3);

        // Adding members
        Member student = new StudentMember(201, "John");
        Member teacher = new TeacherMember(202, "Dr. Smith");

        library.getMembers().add(student);
        library.getMembers().add(teacher);

        // Issuing and returning books
        library.issueBook(book1, student); // Successful
        library.issueBook(book2, student); // Successful
        library.issueBook(book3, student); // Successful
        library.issueBook(book3, teacher); // Fail, book already issued

        library.returnBook(book1, student); // Successful
        library.issueBook(book3, teacher); // Successful after return

        // Removing a book
        librarian.removeBook(library, book2);
        librarian.removeBook(library, book2); // Fail, book already removed
    }
}
