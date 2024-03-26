package project;
import java.time.LocalDate;

public class LibrarySystem {
    private MemberManager memberManager;
    private Catalog catalog;
    private LoanManager loanManager;
    private SearchEngine searchEngine;
    private Member currentMember; // Track the currently logged-in member

    public LibrarySystem(MemberManager memberManager, Catalog catalog, LoanManager loanManager) {
        this.memberManager = memberManager;
        this.catalog = catalog;
        this.loanManager = loanManager;
        this.searchEngine = new SearchEngine(catalog);
        this.currentMember = null;
    }

    // Logs in a library member
    public boolean loginMember(String memberId) {
        Member member = memberManager.findMemberByID(memberId);
        if (member != null) {
            currentMember = member;
            System.out.println("Member " + member.getName() + " successfully logged in.");
            return true;
        }
        System.out.println("Member ID not found.");
        return false;
    }

    // Logs out the current library member
    public void logoutMember() {
        if (currentMember != null) {
            System.out.println("Member " + currentMember.getName() + " logged out.");
            currentMember = null;
        } else {
            System.out.println("No member is currently logged in.");
        }
    }

    // Allows the logged-in member to search the catalog
    public void searchCatalog(String query) {
        if (currentMember == null) {
            System.out.println("Please log in to search the catalog.");
            return;
        }
        System.out.println("Search results for: " + query);
        // Assuming a simplified search that directly matches the query with titles
        searchEngine.searchByTitle(query).forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));
    }

    // Allows a member to borrow a book using its ISBN
    public void borrowBook(String isbn) {
        if (currentMember == null) {
            System.out.println("Please log in to borrow a book.");
            return;
        }
        if (loanManager.isBookAvailable(isbn)) {
            loanManager.checkoutBook(isbn, currentMember.getID(), LocalDate.now().plusWeeks(2)); // Assuming a 2-week loan period
            System.out.println("Book with ISBN " + isbn + " borrowed successfully.");
        } else {
            System.out.println("Book with ISBN " + isbn + " is currently not available.");
        }
    }

    // Facilitates the return of a borrowed book
    public void returnBook(String isbn) {
        if (currentMember == null) {
            System.out.println("Please log in to return a book.");
            return;
        }
        // Assuming book return involves removing the loan and optionally calculating fees
        loanManager.returnBook(isbn);
        System.out.println("Book with ISBN " + isbn + " returned successfully.");
        // Additional logic for fee calculation could be included here
    }
}
