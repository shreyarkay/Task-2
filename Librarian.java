public class Librarian extends Member {
    public Librarian(int memberID, String name) {
        super(memberID, name, Integer.MAX_VALUE); // Librarian can issue an unlimited number of books
    }

    public void addBook(Library library, Book book) {
        library.getBooks().add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(Library library, Book book) {
        if (library.getBooks().remove(book)) {
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found: " + book.getTitle());
        }
    }
}
