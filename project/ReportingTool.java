/**
 * Provides various reports related to the library management system, including reports
 * on current loans, overdue loans, available books, specific member activities, and
 * fees collected. This class utilizes the Catalog, LoanManager, MemberManager, and
 * FeeCalculator classes to gather necessary information for these reports, offering
 * a comprehensive overview of library operations and member activities.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0318 (last modified)
 * @since 17.0 (minimum Java version)
 */
import java.time.LocalDate;
public class ReportingTool {
    private Catalog catalog;
    private LoanManager loanManager;
    private MemberManager memberManager;
    private FeeCalculator feeCalculator;

    /**
     * Constructs a new ReportingTool with references to the catalog, loan manager,
     * member manager, and fee calculator for generating reports.
     *
     * @param catalog The catalog of books.
     * @param loanManager The manager for book loans.
     * @param memberManager The manager for library members.
     * @param feeCalculator The calculator for overdue fees.
     */
    public ReportingTool(Catalog catalog, LoanManager loanManager, MemberManager memberManager, FeeCalculator feeCalculator) {
        this.catalog = catalog;
        this.loanManager = loanManager;
        this.memberManager = memberManager;
        this.feeCalculator = feeCalculator;
    }

    /**
     * Generates and prints a report of all current loans within the library system.
     */
    public void generateLoanReport() {
        System.out.println("Current Loans Report:");
        loanManager.listLoans().forEach(System.out::println);
    }

    /**
     * Generates and prints a report of all overdue loans as of the given current date.
     *
     * @param currentDate The date to compare due dates against for determining overdue status.
     */
    public void generateOverdueReport(LocalDate currentDate) {
        System.out.println("Overdue Loans Report:");
        loanManager.listLoans().stream()
                .filter(loan -> loanManager.getDueDate(loan.split(",")[0].split(":")[1].trim()).isBefore(currentDate))
                .forEach(System.out::println);
    }

    /**
     * Generates and prints a report of all books currently available for borrowing.
     */
    public void generateAvailabilityReport() {
        System.out.println("Available Books Report:");
        catalog.getAvailableBooks().forEach(book ->
            System.out.println(book.getTitle() + " by " + book.getAuthor()));
    }

    /**
     * Generates and prints a report for a specific member, detailing their borrowed books.
     *
     * @param memberId The ID of the member to generate the report for.
     */
    public void generateMemberReport(String memberId) {
        Member member = memberManager.findMemberByID(memberId);
        if (member != null) {
            System.out.println("Report for member: " + member.getName());
            System.out.println("Borrowed Books:");
            member.getBorrowedBooks().forEach(book ->
                System.out.println(book.getTitle() + " by " + book.getAuthor()));
        } else {
            System.out.println("No member found with ID: " + memberId);
        }
    }

    /**
     * Generates and prints a report of the total fees collected from all members.
     */
    public void generateFeesCollectedReport() {
        double totalFees = memberManager.listAllMembers().stream()
                .mapToDouble(member -> feeCalculator.getOutstandingFees(member))
                .sum();
        System.out.println("Total Fees Collected: $" + totalFees);
    }
}
