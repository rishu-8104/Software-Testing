import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

public class MemberTest {

    @Test
    public void testMemberConstructorWithNameAndID() {
        String testName = "John Doe";
        String testID = "001";

        Member member = new Member(testName, testID);

        assertEquals("Name should match", testName, member.getName());
        assertEquals("ID should match", testID, member.getID());
        assertEquals("No books should be borrowed initially", 0, member.getBorrowedBooks().size());
        System.out.println("Test Passed: Member constructor with name and ID");
    }

    @Test
    public void testMemberConstructorWithEmptyNameAndID() {
        String testName = "";
        String testID = "";

        Member member = new Member(testName, testID);

        assertEquals("Name should match", testName, member.getName());
        assertEquals("ID should match", testID, member.getID());
        assertEquals("No books should be borrowed initially", 0, member.getBorrowedBooks().size());
        System.out.println("Test Passed: Member constructor with empty name and ID");
    }

    @Test
    public void testMemberConstructorWithNullNameAndID() {
        String testName = null;
        String testID = null;

        Member member = new Member(testName, testID);

        assertEquals("Name should match", testName, member.getName());
        assertEquals("ID should match", testID, member.getID());
        assertEquals("No books should be borrowed initially", 0, member.getBorrowedBooks().size());
        System.out.println("Test Passed: Member constructor with null name and ID");
    }
    @Test
    public void testGetName() {
        String testName = "John Doe";
        String testID = "001";

        Member member = new Member(testName, testID);

        assertEquals("Name should match", testName, member.getName());
        System.out.println("Test Passed: getName() returns member's name");
    }

    @Test
    public void testGetNameWithEmptyName() {
        String testName = "";
        String testID = "001";

        Member member = new Member(testName, testID);

        assertEquals("Name should match", testName, member.getName());
        System.out.println("Test Passed: getName() returns empty name");
    }

    @Test
    public void testGetNameWithNullName() {
        String testName = null;
        String testID = "001";

        Member member = new Member(testName, testID);

        assertEquals("Name should match", testName, member.getName());
        System.out.println("Test Passed: getName() returns null name");
    }

    @Test(expected = NoSuchElementException.class)
    public void testReturnBookWithNonBorrowedBook() {
        String testName = "John Doe";
        String testID = "001";

        Member member = new Member(testName, testID);
        Book book = new Book("Title", "Author", "1234567890"); // Providing ISBN
        // Attempt to return a book that was not borrowed
        member.returnBook(book);
    }
    @Test
    public void testGetID() {
        String testName = "John Doe";
        String testID = "001";

        Member member = new Member(testName, testID);

        assertEquals("ID should match", testID, member.getID());
        System.out.println("Test Passed: getID() returns member's ID");
    }

    @Test
    public void testGetIDWithEmptyID() {
        String testName = "Jane Smith";
        String testID = "";

        Member member = new Member(testName, testID);

        assertEquals("ID should match", testID, member.getID());
        System.out.println("Test Passed: getID() returns empty ID");
    }

    @Test
    public void testGetIDWithNullID() {
        String testName = "Alice Johnson";
        String testID = null;

        Member member = new Member(testName, testID);

        assertEquals("ID should match", testID, member.getID());
        System.out.println("Test Passed: getID() returns null ID");
    }
    @Test
    public void testGetBorrowedBooksWhenEmpty() {
        String testName = "John Doe";
        String testID = "001";

        Member member = new Member(testName, testID);

        List<Book> borrowedBooks = member.getBorrowedBooks();

        assertEquals("Borrowed books list should be empty", 0, borrowedBooks.size());
        System.out.println("Test Passed: getBorrowedBooks() returns empty list when no books are borrowed");
    }

    @Test
    public void testGetBorrowedBooksAfterBorrowing() {
        String testName = "Jane Smith";
        String testID = "002";

        Member member = new Member(testName, testID);

        Book book1 = new Book("Title1", "Author1", "ISBN1");
        Book book2 = new Book("Title2", "Author2", "ISBN2");

        member.borrowBook(book1);
        member.borrowBook(book2);

        List<Book> borrowedBooks = member.getBorrowedBooks();

        assertEquals("Borrowed books list should contain 2 books", 2, borrowedBooks.size());
        System.out.println("Test Passed: getBorrowedBooks() returns list of borrowed books");
    }

    @Test
    public void testGetBorrowedBooksAfterReturning() {
        String testName = "Alice Johnson";
        String testID = "003";

        Member member = new Member(testName, testID);

        Book book1 = new Book("Title1", "Author1", "ISBN1");
        Book book2 = new Book("Title2", "Author2", "ISBN2");

        member.borrowBook(book1);
        member.borrowBook(book2);

        member.returnBook(book1);

        List<Book> borrowedBooks = member.getBorrowedBooks();

        assertEquals("Borrowed books list should contain 1 book after returning", 1, borrowedBooks.size());
        System.out.println("Test Passed: getBorrowedBooks() returns updated list of borrowed books after returning a book");
    }
    @Test
    public void testBorrowBookWhenAvailable() {
        String testName = "John Doe";
        String testID = "001";

        Member member = new Member(testName, testID);
        Book book = new Book("Title", "Author", "ISBN");

        member.borrowBook(book);

        List<Book> borrowedBooks = member.getBorrowedBooks();

        assertEquals("Borrowed books list should contain 1 book", 1, borrowedBooks.size());
        assertEquals("Borrowed book should match the one borrowed", book, borrowedBooks.get(0));
        System.out.println("Test Passed: borrowBook() adds book to borrowed list when available");
    }

    @Test
    public void testBorrowBookWhenNotAvailable() {
        String testName = "Jane Smith";
        String testID = "002";

        Member member = new Member(testName, testID);
        Book book = new Book("Title", "Author", "ISBN");

        // Mark the book as not available
        book.borrowBook();

        member.borrowBook(book);

        List<Book> borrowedBooks = member.getBorrowedBooks();

        assertEquals("Borrowed books list should be empty", 0, borrowedBooks.size());
        System.out.println("Test Passed: borrowBook() does not add book to borrowed list when not available");
    }

    @Test
    public void testBorrowBookMultipleBooks() {
        String testName = "Alice Johnson";
        String testID = "003";

        Member member = new Member(testName, testID);
        Book book1 = new Book("Title1", "Author1", "ISBN1");
        Book book2 = new Book("Title2", "Author2", "ISBN2");

        member.borrowBook(book1);
        member.borrowBook(book2);

        List<Book> borrowedBooks = member.getBorrowedBooks();

        assertEquals("Borrowed books list should contain 2 books", 2, borrowedBooks.size());
        System.out.println("Test Passed: borrowBook() adds multiple books to borrowed list");
    }
}
