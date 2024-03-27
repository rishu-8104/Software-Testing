import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String ID;
    private List<Book> borrowedBooks;

    public Member(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and methods
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            borrowedBooks.add(book);
            System.out.println(name + " has borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
            System.out.println(name + " has returned the book: " + book.getTitle());
        }
    }
}