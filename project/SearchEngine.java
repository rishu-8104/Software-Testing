package project;

import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {
    private Catalog catalog;

    // Constructor
    public SearchEngine(Catalog catalog) {
        this.catalog = catalog;
    }

    // Searches books by title
    public List<Book> searchByTitle(String title) {
        return catalog.getAllBooks().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Searches books by author
    public List<Book> searchByAuthor(String author) {
        return catalog.getAllBooks().stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Searches for a book by ISBN
    public Book searchByISBN(String isbn) {
        return catalog.getAllBooks().stream()
                .filter(book -> book.getISBN().equals(isbn))
                .findFirst()
                .orElse(null); // Returns null if no book is found with the given ISBN.
    }

    // Searches for books by availability
    public List<Book> searchByAvailability(boolean availability) {
        return catalog.getAllBooks().stream()
                .filter(book -> book.isAvailable() == availability)
                .collect(Collectors.toList());
    }

    // Performs an advanced search with multiple parameters
    public List<Book> advancedSearch(String query) {
        // Assuming 'query' is a delimited string containing various search parameters
        // For simplicity, we'll just use title and author in the example
        String[] params = query.split(";");
        String title = params[0];
        String author = params.length > 1 ? params[1] : "";

        return catalog.getAllBooks().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()) &&
                        book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }
}
