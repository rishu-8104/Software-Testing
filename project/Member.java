/**
 * Represents a library member. This class stores information about a member, including
 * their name and ID, and tracks the books they have borrowed. It provides functionality
 * to borrow and return books, automatically updating the list of currently borrowed books
 * and the availability status of each book.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0318 (last modified)
 * @since 17.0 (minimum Java version)
 */

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String ID;
    private List<Book> borrowedBooks;

    /**
     * Constructs a new Member instance with the specified name and ID. Initializes
     * an empty list to track borrowed books.
     *
     * @param name The name of the member.
     * @param ID The ID of the member.
     */
    public Member(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.borrowedBooks = new ArrayList<>();
    }

    /**
     * Returns the name of the member.
     *
     * @return The name of the member.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of the member.
     *
     * @return The ID of the member.
     */
    public String getID() {
        return ID;
    }

    /**
     * Returns the list of books currently borrowed by the member.
     *
     * @return A list of borrowed books.
     */
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    /**
     * Attempts to borrow a book for the member. If the book is available, it
     * is marked as borrowed and added to the member's list of borrowed books.
     *
     * @param book The book to be borrowed.
     */
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            borrowedBooks.add(book);
            System.out.println(name + " has borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    /**
     * Returns a borrowed book. If the member has the book, it is marked as returned
     * and removed from the member's list of borrowed books.
     *
     * @param book The book to be returned.
     */
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
            System.out.println(name + " has returned the book: " + book.getTitle());
        }
    }
}
