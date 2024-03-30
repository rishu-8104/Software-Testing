import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CatalogTest {

    @Test
    public void testAddBookWhenBookDoesNotExist() {
        Catalog catalog = new Catalog();
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");

        System.out.println("................................................");
        System.out.println("Testing addBook() method when book does not exist...");
        System.out.println("Initial books count: " + catalog.getBooks().size());

        catalog.addBook(book);

        System.out.println("Books count after adding: " + catalog.getBooks().size());
        assertTrue(catalog.getBooks().contains(book));
    }

    @Test
    public void testAddBookWhenBookAlreadyExists() {
        Catalog catalog = new Catalog();
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");

        catalog.addBook(book1); // Add the first book

        System.out.println("................................................");
        System.out.println("Testing addBook() method when book already exists...");
        System.out.println("Initial books count: " + catalog.getBooks().size());

        catalog.addBook(book2); // Try to add the same book again

        System.out.println("Books count after adding: " + catalog.getBooks().size());
        assertTrue(catalog.getBooks().contains(book1));
        assertFalse(catalog.getBooks().contains(book2));
    }

    @Test
    public void testAddBookWithDifferentISBN() {
        Catalog catalog = new Catalog();
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780547928210");

        catalog.addBook(book1); // Add the first book

        System.out.println("................................................");
        System.out.println("Testing addBook() method with different ISBN...");
        System.out.println("Initial books count: " + catalog.getBooks().size());

        catalog.addBook(book2); // Add the book with different ISBN

        System.out.println("Books count after adding: " + catalog.getBooks().size());
        assertTrue(catalog.getBooks().contains(book1));
        assertTrue(catalog.getBooks().contains(book2));
    }
    @Test
    public void testRemoveBookWhenBookExists() {
        Catalog catalog = new Catalog();
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        catalog.addBook(book);

        System.out.println("................................................");
        System.out.println("Testing removeBook() method when book exists...");
        System.out.println("Initial books count: " + catalog.getBooks().size());

        catalog.removeBook("9780061120084");

        System.out.println("Books count after removal: " + catalog.getBooks().size());
        assertFalse(catalog.getBooks().contains(book));
    }

    @Test
    public void testRemoveBookWhenBookDoesNotExist() {
        Catalog catalog = new Catalog();
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");

        System.out.println("................................................");
        System.out.println("Testing removeBook() method when book does not exist...");
        System.out.println("Initial books count: " + catalog.getBooks().size());

        catalog.removeBook("9780061120084");

        System.out.println("Books count after removal: " + catalog.getBooks().size());
        assertFalse(catalog.getBooks().contains(book));
    }

    @Test
    public void testRemoveBookFromEmptyCatalog() {
        Catalog catalog = new Catalog();

        System.out.println("................................................");
        System.out.println("Testing removeBook() method from an empty catalog...");
        System.out.println("Initial books count: " + catalog.getBooks().size());

        catalog.removeBook("9780061120084");

        System.out.println("Books count after removal: " + catalog.getBooks().size());
        assertEquals(0, catalog.getBooks().size());
    }
    @Test
    public void testFindBooksByTitleWhenTitleExists() {
        Catalog catalog = new Catalog();
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        Book book2 = new Book("To Kill a Mockingbird", "Another Author", "9781234567890");
        catalog.addBook(book1);
        catalog.addBook(book2);

        System.out.println("................................................");
        System.out.println("Testing findBooksByTitle() method when title exists...");
        System.out.println("Searching for title: To Kill a Mockingbird");

        List<Book> foundBooks = catalog.findBooksByTitle("To Kill a Mockingbird");

        System.out.println("Found " + foundBooks.size() + " books with the title: To Kill a Mockingbird");
        assertEquals(2, foundBooks.size());
    }

    @Test
    public void testFindBooksByTitleWhenTitleDoesNotExist() {
        Catalog catalog = new Catalog();
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        catalog.addBook(book);

        System.out.println("................................................");
        System.out.println("Testing findBooksByTitle() method when title does not exist...");
        System.out.println("Searching for title: Harry Potter");

        List<Book> foundBooks = catalog.findBooksByTitle("Harry Potter");

        System.out.println("Found " + foundBooks.size() + " books with the title: Harry Potter");
        assertEquals(0, foundBooks.size());
    }

    @Test
    public void testFindBooksByTitleWithEmptyCatalog() {
        Catalog catalog = new Catalog();

        System.out.println("................................................");
        System.out.println("Testing findBooksByTitle() method with an empty catalog...");
        System.out.println("Searching for title: To Kill a Mockingbird");

        List<Book> foundBooks = catalog.findBooksByTitle("To Kill a Mockingbird");

        System.out.println("Found " + foundBooks.size() + " books with the title: To Kill a Mockingbird");
        assertEquals(0, foundBooks.size());
    }
    @Test
    public void testFindBooksByAuthorWhenAuthorExists() {
        Catalog catalog = new Catalog();
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780545010221");
        catalog.addBook(book1);
        catalog.addBook(book2);

        System.out.println("................................................");
        System.out.println("Testing findBooksByAuthor() method when author exists...");
        System.out.println("Searching for author: Harper Lee");

        List<Book> foundBooks = catalog.findBooksByAuthor("Harper Lee");

        System.out.println("Found " + foundBooks.size() + " books by author: Harper Lee");
        assertEquals(1, foundBooks.size());
    }

    @Test
    public void testFindBooksByAuthorWhenAuthorDoesNotExist() {
        Catalog catalog = new Catalog();
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        catalog.addBook(book);

        System.out.println("................................................");
        System.out.println("Testing findBooksByAuthor() method when author does not exist...");
        System.out.println("Searching for author: J.K. Rowling");

        List<Book> foundBooks = catalog.findBooksByAuthor("J.K. Rowling");

        System.out.println("Found " + foundBooks.size() + " books by author: J.K. Rowling");
        assertEquals(0, foundBooks.size());
    }

    @Test
    public void testFindBooksByAuthorWithEmptyCatalog() {
        Catalog catalog = new Catalog();

        System.out.println("................................................");
        System.out.println("Testing findBooksByAuthor() method with an empty catalog...");
        System.out.println("Searching for author: J.R.R. Tolkien");

        List<Book> foundBooks = catalog.findBooksByAuthor("J.R.R. Tolkien");

        System.out.println("Found " + foundBooks.size() + " books by author: J.R.R. Tolkien");
        assertEquals(0, foundBooks.size());
    }

    @Test
    public void testGetAvailableBooksWhenSomeBooksAreAvailable() {
        Catalog catalog = new Catalog();
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780545010221");
        catalog.addBook(book1);
        catalog.addBook(book2);

        System.out.println("................................................");
        System.out.println("Testing getAvailableBooks() method when some books are available...");
        book1.borrowBook();

        List<Book> availableBooks = catalog.getAvailableBooks();

        System.out.println("Found " + availableBooks.size() + " available books in the catalog");
        assertEquals(1, availableBooks.size());
    }

    @Test
    public void testGetAvailableBooksWhenAllBooksAreAvailable() {
        Catalog catalog = new Catalog();
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780545010221");
        catalog.addBook(book1);
        catalog.addBook(book2);

        System.out.println("................................................");
        System.out.println("Testing getAvailableBooks() method when all books are available...");

        List<Book> availableBooks = catalog.getAvailableBooks();

        System.out.println("Found " + availableBooks.size() + " available books in the catalog");
        assertEquals(2, availableBooks.size());
    }

    @Test
    public void testGetAvailableBooksWhenNoBooksAreAvailable() {
        Catalog catalog = new Catalog();
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780545010221");
        catalog.addBook(book1);
        catalog.addBook(book2);
        book1.borrowBook();
        book2.borrowBook();

        System.out.println("................................................");
        System.out.println("Testing getAvailableBooks() method when no books are available...");

        List<Book> availableBooks = catalog.getAvailableBooks();

        System.out.println("Found " + availableBooks.size() + " available books in the catalog");
        assertEquals(0, availableBooks.size());
    }
    @Test
    public void testFindBookByISBNWhenBookExists() {
        Catalog catalog = new Catalog();
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        catalog.addBook(book);

        System.out.println("................................................");
        System.out.println("Testing findBookByISBN() method when the book exists...");
        System.out.println("Searching for book with ISBN: 9780061120084");

        Book foundBook = catalog.findBookByISBN("9780061120084");

        assertNotNull(foundBook);
        assertEquals(book.getISBN(), foundBook.getISBN());
    }

    @Test
    public void testFindBookByISBNWhenBookDoesNotExist() {
        Catalog catalog = new Catalog();
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        catalog.addBook(book);

        System.out.println("................................................");
        System.out.println("Testing findBookByISBN() method when the book does not exist...");
        System.out.println("Searching for book with ISBN: 9780545010221");

        Book foundBook = catalog.findBookByISBN("9780545010221");

        assertNull(foundBook);
    }

    @Test
    public void testFindBookByISBNWithEmptyCatalog() {
        Catalog catalog = new Catalog();

        System.out.println("................................................");
        System.out.println("Testing findBookByISBN() method with an empty catalog...");
        System.out.println("Searching for book with ISBN: 9780061120084");

        Book foundBook = catalog.findBookByISBN("9780061120084");

        assertNull(foundBook);
    }
}
