/**
 * Manages the loaning process of books within a library system. This class handles book
 * checkouts, returns, and tracks due dates for borrowed books. It operates with a catalog
 * of books to determine availability and manage the status of each book regarding whether
 * it is loaned out or available for borrowing.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0318 (last modified)
 * @since 17.0 (minimum Java version)
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class LoanManager {
    private Catalog catalog;
    private Map<String, String> bookLoans; // Maps ISBN to memberId
    private Map<String, LocalDate> dueDates; // Maps ISBN to due date

    /**
     * Constructs a LoanManager with a reference to a Catalog.
     *
     * @param catalog The catalog of books this LoanManager will manage loans for.
     */
    public LoanManager(Catalog catalog) {
        this.catalog = catalog;
        this.bookLoans = new HashMap<>();
        this.dueDates = new HashMap<>();
    }

    /**
     * Checks out a book to a member, assuming the book is available.
     *
     * @param isbn The ISBN of the book to check out.
     * @param memberId The ID of the member borrowing the book.
     */
    public void checkoutBook(String isbn, String memberId) {
        List<Book> availableBooks = catalog.getAvailableBooks();
        for (Book book : availableBooks) {
            if (book.getISBN().equals(isbn) && book.isAvailable()) {
                book.borrowBook(); // Update book status
                bookLoans.put(isbn, memberId);
                dueDates.put(isbn, LocalDate.now().plusWeeks(2)); // Assuming a 2-week loan period
                System.out.println("Book checked out to " + memberId + ". Due date: " + dueDates.get(isbn).toString());
                return;
            }
        }
        System.out.println("Book is not available for checkout.");
    }

    /**
     * Returns a book and updates its status in the catalog.
     *
     * @param isbn The ISBN of the book being returned.
     * @param memberId The ID of the member returning the book.
     */
    public void returnBook(String isbn, String memberId) {
        if (bookLoans.containsKey(isbn) && bookLoans.get(isbn).equals(memberId)) {
            bookLoans.remove(isbn);
            dueDates.remove(isbn);
            catalog.findBookByISBN(isbn).returnBook(); // Ensure you implement this method in Catalog
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book was not loaned to this member.");
        }
    }

    /**
     * Lists all current loans along with their due dates.
     *
     * @return A list of strings, each representing a loan in the format:
     *         "ISBN: [isbn], Member ID: [memberId], Due Date: [dueDate]".
     */
    public List<String> listLoans() {
        List<String> loans = new ArrayList<>();
        bookLoans.forEach((isbn, memberId) -> loans.add("ISBN: " + isbn + ", Member ID: " + memberId + ", Due Date: " + dueDates.get(isbn)));
        return loans;
    }

    /**
     * Checks if a specific book is currently available for borrowing.
     *
     * @param isbn The ISBN of the book to check.
     * @return True if the book is available, false otherwise.
     */
    public boolean isBookAvailable(String isbn) {
        return catalog.getAvailableBooks().stream().anyMatch(book -> book.getISBN().equals(isbn));
    }

    /**
     * Retrieves the due date for a borrowed book.
     *
     * @param isbn The ISBN of the book to check the due date for.
     * @return The due date of the book.
     */
    public LocalDate getDueDate(String isbn) {
        return dueDates.get(isbn);
    }
}
