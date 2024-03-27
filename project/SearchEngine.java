import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {
    private Catalog catalog;

    public SearchEngine(Catalog catalog) {
        this.catalog = catalog;
    }

    public List<Book> searchByTitle(String title) {
        return catalog.getBooks().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return catalog.getBooks().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public Book searchByISBN(String isbn) {
        return catalog.getBooks().stream()
                .filter(book -> book.getISBN().equals(isbn))
                .findFirst()
                .orElse(null); // Consider handling a null result in your system
    }

    public List<Book> searchByAvailability(boolean availability) {
        return catalog.getBooks().stream()
                .filter(book -> book.isAvailable() == availability)
                .collect(Collectors.toList());
    }

    // Example of an advanced search that combines title and author search for simplicity
    public List<Book> advancedSearch(String query) {
        return catalog.getBooks().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase())
                             || book.getAuthor().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
