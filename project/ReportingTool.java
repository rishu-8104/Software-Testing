package project;

import java.time.LocalDate;
import java.util.List;

public class ReportingTool {
    private Catalog catalog;
    private LoanManager loanManager;
    private FeeCalculator feeCalculator;

    // Constructor
    public ReportingTool(Catalog catalog, LoanManager loanManager, FeeCalculator feeCalculator) {
        this.catalog = catalog;
        this.loanManager = loanManager;
        this.feeCalculator = feeCalculator;
    }

    // Generates a report of all current loans
    public void generateLoanReport() {
        List<String> loans = loanManager.listLoans();
        System.out.println("Current Loans Report:");
        loans.forEach(System.out::println);
    }

    // Generates a report of all overdue books
    public void generateOverdueReport() {
        System.out.println("Overdue Loans Report:");
        // Assuming a method to get overdue loans exists
        loanManager.listOverdueLoans().forEach(
                (isbn, details) -> System.out.println("ISBN: " + isbn + ", Details: " + details)
        );
    }

    // Generates a report of all available books
    public void generateAvailabilityReport() {
        List<Book> availableBooks = catalog.getAvailableBooks();
        System.out.println("Available Books Report:");
        availableBooks.forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));
    }

    // Generates a report for a specific member
    public void generateMemberReport(Member member) {
        System.out.println("Report for Member: " + member.getName());
        System.out.println("Borrowed Books:");
        member.getBorrowedBooks().forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));
        System.out.println("Outstanding Fees: $" + member.getFees());
    }

    // Generates a report of fees collected
    public void generateFeesCollectedReport() {
        // Assuming a method to calculate total fees exists
        double totalFees = feeCalculator.calculateTotalFeesCollected();
        System.out.println("Total Fees Collected: $" + totalFees);
    }
}

