import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



public class LoanManagerTest {

    private LoanManager loanManager;
    private Catalog catalog;

    @Before
    public void setUp() {
        catalog = new Catalog();
        loanManager = new LoanManager(catalog);
    }

    @Test
    public void testCheckoutBookValid() {
        String isbn = "9780061120084";
        String memberId = "12345";

        // Adding a book to the catalog
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", isbn);
        catalog.addBook(book);

        // Checking out the book
        loanManager.checkoutBook(isbn, memberId);

        // Verifying the book is no longer available in the catalog
        assertFalse(loanManager.isBookAvailable(isbn));
    }

    @Test
    public void testCheckoutBookNotAvailable() {
        String isbn = "9780061120084";
        String memberId = "12345";

        // Attempting to checkout a book that's not available
        loanManager.checkoutBook(isbn, memberId);

        // Verifying that the book couldn't be checked out
        assertFalse(loanManager.isBookAvailable(isbn));
    }

    @Test
    public void testCheckoutBookInvalidIsbn() {
        String isbn = "9780061120084";
        String memberId = "12345";

        // Trying to checkout a book with an invalid ISBN
        loanManager.checkoutBook("1234567890", memberId);

        // Verifying that the book couldn't be checked out
        assertFalse(loanManager.isBookAvailable(isbn));
    }
    @Test
    public void testReturnBookSuccess() {
        String isbn = "9780061120084";
        String memberId = "12345";

        // Adding a book to the catalog and checking it out
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", isbn);
        catalog.addBook(book);
        loanManager.checkoutBook(isbn, memberId);

        // Returning the book
        loanManager.returnBook(isbn, memberId);

        // Verifying the book is available again
        assertTrue(loanManager.isBookAvailable(isbn));
    }

    @Test
    public void testReturnBookNotLoaned() {
        String isbn = "9780061120084";
        String memberId = "12345";

        // Attempting to return a book that was not loaned
        loanManager.returnBook(isbn, memberId);

        // Verifying that the book remains unavailable
        assertFalse(loanManager.isBookAvailable(isbn));
    }

    @Test
    public void testReturnBookDifferentMember() {
        String isbn = "9780061120084";
        String memberId1 = "12345";
        String memberId2 = "54321";

        // Adding a book to the catalog and checking it out to memberId1
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", isbn);
        catalog.addBook(book);
        loanManager.checkoutBook(isbn, memberId1);

        // Attempting to return the book with a different member ID
        loanManager.returnBook(isbn, memberId2);

        // Verifying that the book remains unavailable
        assertFalse(loanManager.isBookAvailable(isbn));
    }
    @Test
    public void testListLoansNotEmpty() {
        String isbn = "9780061120084";
        String memberId = "12345";

        // Adding a book to the catalog and checking it out
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", isbn);
        catalog.addBook(book);
        loanManager.checkoutBook(isbn, memberId);

        // Listing loans and checking if the list is not empty
        assertFalse(loanManager.listLoans().isEmpty());
    }

    @Test
    public void testListLoansEmpty() {
        // Listing loans when there are no loans
        assertTrue(loanManager.listLoans().isEmpty());
    }

    @Test
    public void testListLoansWithDueDateNull() {
        String isbn = "9780061120084";
        String memberId = "12345";

        // Adding a book to the catalog without checking it out
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", isbn);
        catalog.addBook(book);

        // Listing loans and checking if the list is empty
        assertTrue(loanManager.listLoans().isEmpty());
    }
    @Test
    public void testIsBookAvailableWithException() {
        // Create a loan manager without initializing the catalog
        LoanManager loanManager = new LoanManager(null);

        // Call the isBookAvailable() method with any ISBN
        boolean isAvailable = loanManager.isBookAvailable("1234567890");

        // Verify that the method returns false due to the exception
        assertFalse(isAvailable);
    }
    @Test
    public void testIsBookAvailableValidIsbn() {
        // Create a loan manager with a valid catalog
        Catalog catalog = new Catalog();
        LoanManager loanManager = new LoanManager(catalog);

        // Add a book to the catalog
        Book book = new Book("Example Book", "Example Author", "1234567890");
        catalog.addBook(book);

        // Check if the book with valid ISBN is available
        boolean isAvailable = loanManager.isBookAvailable("1234567890");

        // Verify that the book is available
        assertTrue(isAvailable);
    }
    @Test
    public void testIsBookAvailableInvalidIsbn() {
        // Create a loan manager with a valid catalog
        Catalog catalog = new Catalog();
        LoanManager loanManager = new LoanManager(catalog);

        // Add a book to the catalog
        Book book = new Book("Example Book", "Example Author", "1234567890");
        catalog.addBook(book);

        // Check if a book with invalid ISBN is available
        boolean isAvailable = loanManager.isBookAvailable("0987654321");

        // Verify that the book is not available
        assertFalse(isAvailable);
    }
    @Test
    public void testIsBookAvailableExceptionHandling() {
        // Create a loan manager without initializing the catalog
        LoanManager loanManager = new LoanManager(null);

        // Check if a book is available (should result in exception)
        boolean isAvailable = loanManager.isBookAvailable("1234567890");

        // Verify that the book is not available due to exception
        assertFalse(isAvailable);
    }

    @Test
    public void testGetDueDateValidIsbn() {
        // Create a loan manager with a valid catalog
        Catalog catalog = new Catalog();
        LoanManager loanManager = new LoanManager(catalog);

        // Add a book to the catalog and check it out
        Book book = new Book("Example Book", "Example Author", "1234567890");
        catalog.addBook(book);
        loanManager.checkoutBook("1234567890", "member123");

        // Get the due date for the book
        LocalDate dueDate = loanManager.getDueDate("1234567890");

        // Verify that the due date is not null
        assertNotNull(dueDate);
    }
    @Test
    public void testGetDueDateInvalidIsbn() {
        // Create a loan manager with a valid catalog
        Catalog catalog = new Catalog();
        LoanManager loanManager = new LoanManager(catalog);

        // Get the due date for a book with an invalid ISBN
        LocalDate dueDate = loanManager.getDueDate("0987654321");

        // Verify that the due date is null
        assertNull(dueDate);
    }
    @Test
    public void testGetDueDateExceptionHandling() {
        // Create a loan manager without initializing the catalog
        LoanManager loanManager = new LoanManager(null);

        // Get the due date for a book (should result in exception)
        LocalDate dueDate = loanManager.getDueDate("1234567890");

        // Verify that the due date is null due to exception
        assertNull(dueDate);
    }
}
