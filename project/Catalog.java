/**
 * Manages a collection of books as a catalog. This class allows for adding, removing,
 * and searching books in the catalog based on various criteria such as title, author,
 * ISBN, and availability status. It provides a comprehensive management system for
 * a library's book inventory.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0318 (last modified)
 * @since 17.0 (minimum Java version)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Catalog {
    private List<Book> books;

    /**
     * Constructs a new Catalog instance. Initializes an empty list of books.
     */
    public Catalog() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a book to the catalog.
     *
     * @param book The book to be added to the catalog.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a book from the catalog based on its ISBN.
     *
     * @param isbn The ISBN of the book to be removed.
     */
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getISBN().equals(isbn));
    }

    /**
     * Finds books by title. The search is case-insensitive.
     *
     * @param title The title of the books to search for.
     * @return A list of books with titles matching the search criteria.
     */
    public List<Book> findBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    /**
     * Finds books by author. The search is case-insensitive.
     *
     * @param author The author of the books to search for.
     * @return A list of books with authors matching the search criteria.
     */
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    /**
     * Gets all available books in the catalog.
     *
     * @return A list of all books that are currently available for borrowing.
     */
    public List<Book> getAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    /**
     * Finds a book by its ISBN.
     *
     * @param isbn The ISBN of the book to find.
     * @return The book with the specified ISBN, or null if no such book is found.
     */
    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null; // Consider improving this by possibly throwing a custom exception if a book is not found.
    }

    /**
     * Returns the list of all books in the catalog.
     *
     * @return A list containing all books in the catalog.
     */
    public List<Book> getBooks() {
        return books;
    }

}
