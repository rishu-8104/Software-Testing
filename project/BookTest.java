import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testBookConstructorValidInput() {
        String title = "To Kill a Mockingbird";
        String author = "Harper Lee";
        String ISBN = "9780061120084";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing Book constructor with valid input...");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("Is Available: " + book.isAvailable());

        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(ISBN, book.getISBN());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBookConstructorEmptyTitle() {
        String title = "";
        String author = "J.K. Rowling";
        String ISBN = "9780545010221";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing Book constructor with empty title...");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("Is Available: " + book.isAvailable());

        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(ISBN, book.getISBN());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBookConstructorNullAuthor() {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = null;
        String ISBN = "9780747532743";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing Book constructor with null author...");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("Is Available: " + book.isAvailable());

        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(ISBN, book.getISBN());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testGetTitle() {
        String title = "To Kill a Mockingbird";
        String author = "Harper Lee";
        String ISBN = "9780061120084";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing getTitle() method...");
        System.out.println("Title: " + book.getTitle());

        assertEquals(title, book.getTitle());
    }

    @Test
    public void testGetTitleEmpty() {
        String title = "";
        String author = "J.K. Rowling";
        String ISBN = "9780545010221";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing getTitle() method with empty title...");
        System.out.println("Title: " + book.getTitle());

        assertEquals(title, book.getTitle());
    }

    @Test
    public void testGetTitleNull() {
        String title = null;
        String author = "J.R.R. Tolkien";
        String ISBN = "9780547928210";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing getTitle() method with null title...");
        System.out.println("Title: " + book.getTitle());

        assertEquals(title, book.getTitle());
    }

    @Test
    public void testGetAuthor() {
        String title = "To Kill a Mockingbird";
        String author = "Harper Lee";
        String ISBN = "9780061120084";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing getAuthor() method...");
        System.out.println("Author: " + book.getAuthor());

        assertEquals(author, book.getAuthor());
    }

    @Test
    public void testGetAuthorEmpty() {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "";
        String ISBN = "9780747532743";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing getAuthor() method with empty author...");
        System.out.println("Author: " + book.getAuthor());

        assertEquals(author, book.getAuthor());
    }

    @Test
    public void testGetAuthorNull() {
        String title = "The Hobbit";
        String author = null;
        String ISBN = "9780547928210";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing getAuthor() method with null author...");
        System.out.println("Author: " + book.getAuthor());

        assertEquals(author, book.getAuthor());
    }
    @Test
    public void testGetISBN() {
        String title = "To Kill a Mockingbird";
        String author = "Harper Lee";
        String ISBN = "9780061120084";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing getISBN() method...");
        System.out.println("ISBN: " + book.getISBN());

        assertEquals(ISBN, book.getISBN());
    }

    @Test
    public void testGetISBNEmpty() {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "J.K. Rowling";
        String ISBN = "";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing getISBN() method with empty ISBN...");
        System.out.println("ISBN: " + book.getISBN());

        assertEquals(ISBN, book.getISBN());
    }

    @Test
    public void testGetISBNNull() {
        String title = "The Hobbit";
        String author = "J.R.R. Tolkien";
        String ISBN = null;

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing getISBN() method with null ISBN...");
        System.out.println("ISBN: " + book.getISBN());

        assertEquals(ISBN, book.getISBN());
    }

    @Test
    public void testIsAvailable() {
        String title = "To Kill a Mockingbird";
        String author = "Harper Lee";
        String ISBN = "9780061120084";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing isAvailable() method...");
        System.out.println("Is Available: " + book.isAvailable());

        assertTrue(book.isAvailable());
    }

    @Test
    public void testIsAvailableAfterBorrowing() {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "J.K. Rowling";
        String ISBN = "9780545010221";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing isAvailable() method after borrowing...");
        book.borrowBook();
        System.out.println("Is Available: " + book.isAvailable());

        assertFalse(book.isAvailable());
    }

    @Test
    public void testIsAvailableAfterReturning() {
        String title = "The Hobbit";
        String author = "J.R.R. Tolkien";
        String ISBN = "9780547928210";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing isAvailable() method after returning...");
        book.borrowBook();
        book.returnBook();
        System.out.println("Is Available: " + book.isAvailable());

        assertTrue(book.isAvailable());
    }

    @Test
    public void testBorrowBook() {
        String title = "To Kill a Mockingbird";
        String author = "Harper Lee";
        String ISBN = "9780061120084";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing borrowBook() method...");
        System.out.println("Initial Availability: " + book.isAvailable());

        book.borrowBook();
        System.out.println("Availability after borrowing: " + book.isAvailable());

        assertFalse(book.isAvailable());
    }

    @Test
    public void testReturnBook() {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "J.K. Rowling";
        String ISBN = "9780545010221";

        Book book = new Book(title, author, ISBN);
        book.borrowBook(); // Initially borrow the book
        System.out.println("................................................");
        System.out.println("Testing returnBook() method...");
        System.out.println("Initial Availability: " + book.isAvailable());

        book.returnBook();
        System.out.println("Availability after returning: " + book.isAvailable());

        assertTrue(book.isAvailable());
    }

    @Test
    public void testBorrowAndReturnBook() {
        String title = "The Hobbit";
        String author = "J.R.R. Tolkien";
        String ISBN = "9780547928210";

        Book book = new Book(title, author, ISBN);
        System.out.println("................................................");
        System.out.println("Testing borrowBook() and returnBook() methods...");
        System.out.println("Initial Availability: " + book.isAvailable());

        book.borrowBook();
        System.out.println("Availability after borrowing: " + book.isAvailable());

        assertFalse(book.isAvailable());

        book.returnBook();
        System.out.println("Availability after returning: " + book.isAvailable());

        assertTrue(book.isAvailable());
    }

    @Test(expected = IllegalStateException.class)
    public void testBorrowBookException() {
        String title = "The Hobbit";
        String author = "J.R.R. Tolkien";
        String ISBN = "9780547928210";

        // Create a book and borrow it
        Book book = new Book(title, author, ISBN);
        book.borrowBook(); // Now the book is borrowed

        // Attempt to borrow the book again, which should throw an IllegalStateException
        book.borrowBook();
    }

}