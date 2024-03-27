import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    private Book book;

    @Before
    public void setUp() {
        book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789");
    }

    @Test
    public void testGetTitle() {
        assertEquals("The Great Gatsby", book.getTitle());
    }



    @Test
    public void testGetAuthor() {
        assertEquals("F. Scott Fitzgerald", book.getAuthor());
    }

    @Test
    public void testGetISBN() {
        assertEquals("123456789", book.getISBN());
    }

    @Test
    public void testIsAvailableInitially() {
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBorrowBookWhenAvailable() {
        book.borrowBook();
        assertFalse(book.isAvailable());
    }

    @Test
    public void testBorrowBookWhenUnavailable() {
        book.borrowBook(); // First borrow
        book.borrowBook(); // Attempt to borrow again
        assertFalse(book.isAvailable()); // The book should still be unavailable
    }

    @Test
    public void testReturnBook() {
        book.borrowBook(); // First, borrow the book to change its status
        book.returnBook(); // Then, return it
        assertTrue(book.isAvailable()); // The book should now be available
    }

    @Test
public void testGetTitleConsistency() {
    assertEquals("Checking title consistency across multiple calls", "The Great Gatsby", book.getTitle());
}

@Test
public void testGetAuthorConsistency() {
    assertEquals("Checking author consistency across multiple calls", "F. Scott Fitzgerald", book.getAuthor());
}

@Test
public void testGetISBNConsistency() {
    assertEquals("Checking ISBN consistency across multiple calls", "123456789", book.getISBN());
}

@Test
public void testIsAvailableAfterReturning() {
    book.borrowBook(); // Borrow the book first
    book.returnBook(); // Return the book
    assertTrue("Book should be available after returning", book.isAvailable());
}

@Test
public void testBorrowBookTwiceConsecutively() {
    book.borrowBook(); // First time borrowing the book
    assertTrue("Book should be unavailable after first borrow", !book.isAvailable());
    book.returnBook(); // Return the book
    book.borrowBook(); // Borrow again
    assertFalse("Book should be able to be borrowed again after return", book.isAvailable());
}

@Test
public void testReturnBookWithoutBorrowing() {
    // Trying to return a book that hasn't been borrowed should have no adverse effect
    book.returnBook(); // Return without borrowing
    assertTrue("Book should still be available after returning without prior borrow", book.isAvailable());
}

@Test
public void testAvailabilityAfterMultipleBorrowReturnCycles() {
    for (int i = 0; i < 5; i++) {
        book.borrowBook();
        assertFalse("Book should be unavailable after borrowing", book.isAvailable());
        book.returnBook();
        assertTrue("Book should be available after returning", book.isAvailable());
    }
}

@Test
public void testIsAvailableBeforeAndAfterBorrowing() {
    assertTrue("Book should initially be available", book.isAvailable());
    book.borrowBook();
    assertFalse("Book should not be available after borrowing", book.isAvailable());
}
@Test
public void testGetTitleUnchangedAfterReturn() {
    book.borrowBook();
    book.returnBook();
    assertEquals("Title should remain unchanged after book is returned", "The Great Gatsby", book.getTitle());
}

@Test
public void testGetAuthorUnchangedAfterReturn() {
    book.borrowBook();
    book.returnBook();
    assertEquals("Author should remain unchanged after book is returned", "F. Scott Fitzgerald", book.getAuthor());
}
@Test
public void testGetISBNUnchangedAfterReturn() {
    book.borrowBook();
    book.returnBook();
    assertEquals("ISBN should remain unchanged after book is returned", "123456789", book.getISBN());
}

}
