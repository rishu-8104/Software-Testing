import java.time.LocalDate;

public class ReportingTool {
    private Catalog catalog;
    private LoanManager loanManager;
    private MemberManager memberManager;
    private FeeCalculator feeCalculator;

    public ReportingTool(Catalog catalog, LoanManager loanManager, MemberManager memberManager, FeeCalculator feeCalculator) {
        this.catalog = catalog;
        this.loanManager = loanManager;
        this.memberManager = memberManager;
        this.feeCalculator = feeCalculator;
    }

    public void generateLoanReport() {
        System.out.println("Current Loans Report:");
        loanManager.listLoans().forEach(System.out::println);
    }

    public void generateOverdueReport(LocalDate currentDate) {
        System.out.println("Overdue Loans Report:");
        loanManager.listLoans().stream()
                .filter(loan -> loanManager.getDueDate(loan.split(",")[0].split(":")[1].trim()).isBefore(currentDate))
                .forEach(System.out::println);
    }

    public void generateAvailabilityReport() {
        System.out.println("Available Books Report:");
        catalog.getAvailableBooks().forEach(book ->
            System.out.println(book.getTitle() + " by " + book.getAuthor()));
    }

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

    public void generateFeesCollectedReport() {
        double totalFees = memberManager.listAllMembers().stream()
                .mapToDouble(member -> feeCalculator.getOutstandingFees(member))
                .sum();
        System.out.println("Total Fees Collected: $" + totalFees);
    }
}
