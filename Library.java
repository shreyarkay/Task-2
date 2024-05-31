import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryOperations {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    @Override
    public boolean issueBook(Book book, Member member) {
        if (!book.isIssued() && member.issueBook(book)) {
            System.out.println("Book issued: " + book.getTitle() + " to " + member.getName());
            return true;
        }
        System.out.println("Failed to issue book: " + book.getTitle());
        return false;
    }

    @Override
    public boolean returnBook(Book book, Member member) {
        if (book.isIssued() && member.returnBook(book)) {
            System.out.println("Book returned: " + book.getTitle() + " by " + member.getName());
            return true;
        }
        System.out.println("Failed to return book: " + book.getTitle());
        return false;
    }
}
