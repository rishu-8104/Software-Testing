/**
 * Represents a book in a library system. This class stores information about a book,
 * including its title, author, ISBN, and availability status. It allows for the book to
 * be borrowed and returned, updating its availability status accordingly.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0318 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    /**
     * Constructs a new Book instance with the specified title, author, and ISBN.
     * Initially, all books are marked as available.
     *
     * @param title The title of the book.
     * @param author The author of the book.
     * @param ISBN The International Standard Book Number of the book.
     */
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    /**
     * Returns the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the International Standard Book Number of the book.
     *
     * @return The ISBN of the book.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Checks if the book is currently available for borrowing.
     *
     * @return True if the book is available, false otherwise.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Marks the book as borrowed, making it unavailable, if it is not already borrowed.
     * If the book is already borrowed, it prints a message indicating that the book
     * is not available for borrowing.
     */
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            throw new IllegalStateException("Book is not available for borrowing.");
        }
    }

    /**
     * Marks the book as returned, making it available again.
     */
    public void returnBook() {
        isAvailable = true;
    }
}
