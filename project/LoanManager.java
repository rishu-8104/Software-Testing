import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanManager {
    private Catalog catalog;
    private Map<String, String> bookLoans; // Maps ISBN to memberId
    private Map<String, LocalDate> dueDates; // Maps ISBN to due date

    public LoanManager(Catalog catalog) {
        this.catalog = catalog;
        this.bookLoans = new HashMap<>();
        this.dueDates = new HashMap<>();
    }

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

    public List<String> listLoans() {
        List<String> loans = new ArrayList<>();
        bookLoans.forEach((isbn, memberId) -> loans.add("ISBN: " + isbn + ", Member ID: " + memberId + ", Due Date: " + dueDates.get(isbn)));
        return loans;
    }

    public boolean isBookAvailable(String isbn) {
        return catalog.getAvailableBooks().stream().anyMatch(book -> book.getISBN().equals(isbn));
    }

    public LocalDate getDueDate(String isbn) {
        return dueDates.get(isbn);
    }
}
