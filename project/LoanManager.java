package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanManager {
    private Map<String, LoanRecord> loans; // Maps ISBN to a loan record

    // Constructor
    public LoanManager() {
        this.loans = new HashMap<>();
    }

    // Nested class to hold loan information
    private static class LoanRecord {
        String memberId;
        LocalDate dueDate;

        LoanRecord(String memberId, LocalDate dueDate) {
            this.memberId = memberId;
            this.dueDate = dueDate;
        }
    }

    // Checks out a book to a member
    public void checkoutBook(String isbn, String memberId, LocalDate dueDate) {
        if (isBookAvailable(isbn)) {
            loans.put(isbn, new LoanRecord(memberId, dueDate));
        } else {
            throw new IllegalStateException("Book with ISBN " + isbn + " is not available for checkout.");
        }
    }

    // Returns a book to the library
    public void returnBook(String isbn) {
        if (loans.containsKey(isbn)) {
            loans.remove(isbn);
        } else {
            throw new IllegalStateException("Book with ISBN " + isbn + " is not currently loaned out.");
        }
    }

    // Lists all current loans
    public List<String> listLoans() {
        List<String> currentLoans = new ArrayList<>();
        for (Map.Entry<String, LoanRecord> entry : loans.entrySet()) {
            currentLoans.add("ISBN: " + entry.getKey() + ", Member ID: " + entry.getValue().memberId + ", Due Date: " + entry.getValue().dueDate);
        }
        return currentLoans;
    }

    // Checks if a book is available for checkout
    public boolean isBookAvailable(String isbn) {
        return !loans.containsKey(isbn);
    }

    // Gets the due date for a returned book
    public LocalDate getDueDate(String isbn) {
        LoanRecord record = loans.get(isbn);
        if (record != null) {
            return record.dueDate;
        } else {
            throw new IllegalStateException("No loan record found for ISBN " + isbn);
        }
    }
}

