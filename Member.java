import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberID;
    private String name;
    private int maxBooksIssued;
    private List<Book> currentIssuedBooks;

    public Member(int memberID, String name, int maxBooksIssued) {
        this.memberID = memberID;
        this.name = name;
        this.maxBooksIssued = maxBooksIssued;
        this.currentIssuedBooks = new ArrayList<>();
    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public int getMaxBooksIssued() {
        return maxBooksIssued;
    }

    public List<Book> getCurrentIssuedBooks() {
        return currentIssuedBooks;
    }

    public boolean issueBook(Book book) {
        if (currentIssuedBooks.size() < maxBooksIssued && !book.isIssued()) {
            currentIssuedBooks.add(book);
            book.setIssued(true);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (currentIssuedBooks.contains(book)) {
            currentIssuedBooks.remove(book);
            book.setIssued(false);
            return true;
        }
        return false;
    }
}
