import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.out.println("******************************************************************");
        System.out.println("------------------LIBRARY MANAGEMENT SYSTEM-----------------------");
        System.out.println("******************************************************************\n\n");


        // Initialization of catalog, loan manager, search engine, and notification service
        Catalog catalog = new Catalog();
        LoanManager loanManager = new LoanManager(catalog);

        NotificationService notificationService = new NotificationService();
        MemberManager memberManager = new MemberManager(); // Initialize MemberManager

        // Adding sample books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789");
        Book book2 = new Book("1984", "George Orwell", "987654321");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "111213141");
        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);

        // Creating members
        Member member1 = new Member("John Doe", "001");
        Member member2 = new Member("Jane Doe", "002");
        memberManager.addMember(member1); // Adding members to the member manager
        memberManager.addMember(member2);
        notificationService.registerForMemberNotices(member1); // Register member1 for notifications
        System.out.println("------------------------------------------------------------\n");
        // Checking out books for the member
        System.out.println("Checking out books for member:");
        loanManager.checkoutBook("123456789", member1.getID());
        loanManager.checkoutBook("987654321", member1.getID());
        System.out.println("------------------------------------------------------------\n");

        // Returning a book triggers a book available notice
        System.out.println("\nReturning a book:");
        loanManager.returnBook(book1.getISBN(), member1.getID());
        notificationService.sendBookAvailableNotice(book1);
        System.out.println("------------------------------------------------------------\n");

        // Displaying current loans
        System.out.println("\nCurrent loans:");
        loanManager.listLoans().forEach(System.out::println);
        System.out.println("------------------------------------------------------------\n");

        // Send a general notice to all registered members
        System.out.println("\nSending a general notice:");
        notificationService.sendGeneralNotice("The library will be closed on all Fridays in December.");
        System.out.println("------------------------------------------------------------\n");

        // Member management demonstrations
        System.out.println("\nListing all members:");
        memberManager.listAllMembers().forEach(m ->
            System.out.println(m.getName() + " with ID " + m.getID()));
            System.out.println("------------------------------------------------------------\n");

        // Find a member by ID
        System.out.println("\nFinding member by ID '001':");
        Member foundMember = memberManager.findMemberByID("001");
        if(foundMember != null) {
            System.out.println("Found member: " + foundMember.getName());
        } else {
            System.out.println("No member found with ID '001'.");
        }
        System.out.println("------------------------------------------------------------\n");

        // Removing a member
        System.out.println("\nRemoving member with ID '002':");
        memberManager.removeMember("002");
        System.out.println("After removal, listing all members:");
        memberManager.listAllMembers().forEach(m ->
            System.out.println(m.getName() + " with ID " + m.getID()));
            System.out.println("------------------------------------------------------------\n");

        // Unregistering a member from notifications
        notificationService.unregisterForMemberNotices(member1);

        FeeCalculator feeCalculator = new FeeCalculator();
        System.out.println("------------------------------------------------------------\n");

        // Simulating late returns and fee processing
        long daysOverdue = 5; // Example overdue duration
        double fee = feeCalculator.calculateFee(daysOverdue);
        System.out.println("Fee for " + daysOverdue + " days overdue: $" + fee);
        System.out.println("------------------------------------------------------------\n");

        // Add fee to member's account
        feeCalculator.addFee(member1, fee);

        // Check if the member has outstanding fees
        if (!feeCalculator.hasOutstandingFees(member1)) {
            System.out.println(member1.getName() + " has no outstanding fees.");
        } else {
            // If there are outstanding fees, attempt to pay part of the fee and then clear all fees
            feeCalculator.payFees(member1, 2); // Pay $2
            feeCalculator.clearMemberFees(member1);
        }
        System.out.println("------------------------------------------------------------\n");

        ReportingTool reportingTool = new ReportingTool(catalog, loanManager, memberManager, feeCalculator);

        // Assuming some interactions to generate data

        // Generate various reports
        reportingTool.generateLoanReport();
        reportingTool.generateOverdueReport(LocalDate.now());
        reportingTool.generateAvailabilityReport();
        reportingTool.generateMemberReport("001");
        reportingTool.generateFeesCollectedReport();

        System.out.println("------------------------------------------------------------\n");

         // Initialize ReservationManager
         ReservationManager reservationManager = new ReservationManager(notificationService);


         // Assuming book1 is checked out and member2 wants to reserve it
         reservationManager.reserveBook(book1.getISBN(), member2.getID()); // Member2 reserves book1

         // Listing current reservations
         System.out.println("Current Reservations:");
         reservationManager.listReservations();

         // Returning book1 triggers a check for reservations and notifies member2
         System.out.println("\nReturning a reserved book:");
         loanManager.returnBook(book1.getISBN(), member1.getID()); // Member1 returns book1
         reservationManager.checkAndNotifyIfBookAvailable(book1.getISBN()); // Check reservation for book1 and notify member2

         // Cancel a reservation (demonstration purpose)
         reservationManager.cancelReservation(book1.getISBN());
         reservationManager.listReservations(); // Listing reservations again to show the effect of cancellation
    }
}
