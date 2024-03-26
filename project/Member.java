package project;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String id;
    private List<Book> borrowedBooks;
    private double fees;

    // Constructor
    public Member(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>(); // Initialize the list of borrowed books.
    }

    // Returns the name of the member.
    public String getName() {
        return name;
    }

    // Returns the unique ID of the member.
    public String getID() {
        return id;
    }

    // Returns a list of books currently borrowed by the member.
    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks); // Return a copy to prevent external modification.
    }

    // Adds a book to the member's list of borrowed books, if not already borrowed.
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.borrowBook(); // Mark the book as borrowed.
        } else {
            throw new IllegalStateException("This book is currently not available for borrowing.");
        }
    }

    // Removes a book from the member's list of borrowed books.
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook(); // Mark the book as returned and available for borrowing again.
        } else {
            throw new IllegalArgumentException("This book was not borrowed by the member.");
        }
    }

    public double getFees() {
        return fees;
    }

    public void addFees(double amount) {
        this.fees += amount;
    }

    public void payFees(double amount) {
        this.fees -= amount;
        if (this.fees < 0) {
            this.fees = 0; // Prevent fees from going negative
        }
    }

    public void clearFees() {
        this.fees = 0;
    }

}
