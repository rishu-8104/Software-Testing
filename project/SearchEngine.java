/**
 * Facilitates searching the catalog of books based on various criteria such as title, author, ISBN,
 * and availability. This class allows for both simple searches (e.g., by title) and more complex
 * searches (e.g., combining title and author). It serves as an intermediary between the user and
 * the catalog, providing a streamlined interface for querying books.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0318 (last modified)
 * @since 17.0 (minimum Java version)
 */
import java.util.List;
import java.util.stream.Collectors;
public class SearchEngine {
    private Catalog catalog;

    /**
     * Constructs a new SearchEngine with a reference to an existing Catalog.
     *
     * @param catalog The catalog of books to be searched.
     */
    public SearchEngine(Catalog catalog) {
        this.catalog = catalog;
    }

    /**
     * Searches for books by title, ignoring case.
     *
     * @param title The title of the book(s) to search for.
     * @return A list of books with titles matching the search criteria.
     */
    public List<Book> searchByTitle(String title) {
        return catalog.getBooks().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    /**
     * Searches for books by author, ignoring case.
     *
     * @param author The author of the book(s) to search for.
     * @return A list of books with authors matching the search criteria.
     */
    public List<Book> searchByAuthor(String author) {
        return catalog.getBooks().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    /**
     * Searches for a book by its ISBN.
     *
     * @param isbn The ISBN of the book to find.
     * @return The book with the specified ISBN, or null if no such book exists.
     */
    public Book searchByISBN(String isbn) {
        return catalog.getBooks().stream()
                .filter(book -> book.getISBN().equals(isbn))
                .findFirst()
                .orElse(null); // Consider improving this by handling a null result appropriately.
    }

    /**
     * Searches for books by their availability status.
     *
     * @param availability The availability status of the book(s) to search for.
     * @return A list of books matching the availability criteria.
     */
    public List<Book> searchByAvailability(boolean availability) {
        return catalog.getBooks().stream()
                .filter(book -> book.isAvailable() == availability)
                .collect(Collectors.toList());
    }

    /**
     * Performs an advanced search by querying both the title and author fields.
     *
     * @param query The query string to search for in both title and author fields.
     * @return A list of books that match the query in either title or author.
     */
    public List<Book> advancedSearch(String query) {
        return catalog.getBooks().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase())
                             || book.getAuthor().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
