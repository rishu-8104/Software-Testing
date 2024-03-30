import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class SearchEngineTest {

    private SearchEngine searchEngine;

    @Before
    public void setUp() {
        Catalog catalog = new Catalog();
        catalog.addBook(new Book("ISBN123", "Author1", "Title1"));
        catalog.addBook(new Book("ISBN456", "Author2", "Title2"));
        catalog.addBook(new Book("ISBN789", "Author3", "Title3"));
        searchEngine = new SearchEngine(catalog);
    }



    @Test
    public void testSearchByAuthor() {
        List<Book> result = searchEngine.searchByAuthor("Author2");
        assertEquals(1, result.size());
        assertEquals("Author2", result.get(0).getAuthor());
    }



    @Test
    public void testSearchByAvailableBooks() {
        List<Book> result = searchEngine.searchByAvailability(true);
        assertEquals(3, result.size());
    }

    @Test
    public void testSearchByUnavailableBooks() {
        List<Book> result = searchEngine.searchByAvailability(false);
        assertEquals(0, result.size());
    }


    @Test
    public void testAdvancedSearchWithAuthor() {
        List<Book> result = searchEngine.advancedSearch("Author3");
        assertEquals(1, result.size());
        assertEquals("Author3", result.get(0).getAuthor());
    }



    @Test
    public void testAdvancedSearchWithNonExistentQuery() {
        List<Book> result = searchEngine.advancedSearch("nonexistent");
        assertEquals(0, result.size());
    }
    @Test
    public void testSearchByNonexistentTitle() {
        List<Book> result = searchEngine.searchByTitle("Nonexistent Title");
        assertEquals(0, result.size());
    }

    @Test
    public void testSearchByNonexistentAuthor() {
        List<Book> result = searchEngine.searchByAuthor("Nonexistent Author");
        assertEquals(0, result.size());
    }

    @Test
    public void testSearchByNonexistentISBN() {
        Book result = searchEngine.searchByISBN("Nonexistent ISBN");
        assertNull(result);
    }

    public void testSearchByTitleIgnoreCase() {
        List<Book> result = searchEngine.searchByTitle("title2");
        assertEquals(1, result.size());
        assertEquals("Title2", result.get(0).getTitle());
    }

    @Test
    public void testSearchByAuthorIgnoreCase() {
        List<Book> result = searchEngine.searchByAuthor("AUTHOR3");
        assertEquals(1, result.size());
        assertEquals("Author3", result.get(0).getAuthor());
    }

    @Test
    public void testSearchByTitleNotFound() {
        List<Book> result = searchEngine.searchByTitle("Title4");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchByAuthorNotFound() {
        List<Book> result = searchEngine.searchByAuthor("Author4");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchByISBNNotFound() {
        Book result = searchEngine.searchByISBN("ISBN4567");
        assertNull(result);
    }

    @Test
    public void testSearchByAvailableBooksNotFound() {
        List<Book> result = searchEngine.searchByAvailability(false);
        assertTrue(result.isEmpty());
    }


    @Test
    public void testAdvancedSearchWithEmptyQuery() {
        List<Book> result = searchEngine.advancedSearch("");
        assertEquals(3, result.size());
    }

    @Test
    public void testAdvancedSearchWithNonexistentQuery() {
        List<Book> result = searchEngine.advancedSearch("Nonexistent Query");
        assertTrue(result.isEmpty());
    }

    // Non-existent ISBN
    @Test
    public void testSearchByNonexistentISBN2() {
        Book result = searchEngine.searchByISBN("ISBN999");
        assertNull(result);
    }

    // Test with null ISBN
    @Test
    public void testSearchByNullISBN() {
        Book result = searchEngine.searchByISBN(null);
        assertNull(result);
    }

    // Test with empty string ISBN
    @Test
    public void testSearchByEmptyISBN() {
        Book result = searchEngine.searchByISBN("");
        assertNull(result);
    }

}
