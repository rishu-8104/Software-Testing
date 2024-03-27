/**
 * Manages and calculates fees for library members based on overdue books. This class
 * provides functionalities to calculate fees based on the number of days a book has been
 * overdue, track outstanding fees for each member, make payments towards outstanding fees,
 * and clear all fees for a member. It uses a fixed fee per day overdue for fee calculations.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0318 (last modified)
 * @since 17.0 (minimum Java version)
 */
import java.util.HashMap;
import java.util.Map;
public class FeeCalculator {
    private Map<String, Double> memberFees; // Maps member ID to outstanding fees
    private static final double FEE_PER_DAY = 0.5; // Fixed fee per day overdue

    /**
     * Constructs a new FeeCalculator instance. Initializes the member fees map.
     */
    public FeeCalculator() {
        this.memberFees = new HashMap<>();
    }

    /**
     * Calculates the fee based on the number of days a book has been overdue.
     *
     * @param daysOverdue The number of days a book has been overdue.
     * @return The calculated fee.
     */
    public double calculateFee(long daysOverdue) {
        return daysOverdue * FEE_PER_DAY;
    }

    /**
     * Checks if a member has any outstanding fees.
     *
     * @param member The member to check for outstanding fees.
     * @return True if the member has outstanding fees, false otherwise.
     */
    public boolean hasOutstandingFees(Member member) {
        return memberFees.getOrDefault(member.getID(), 0.0) > 0;
    }

    /**
     * Allows a member to pay off a portion or all of their outstanding fees.
     *
     * @param member The member making the payment.
     * @param amount The amount being paid.
     */
    public void payFees(Member member, double amount) {
        double currentFees = memberFees.getOrDefault(member.getID(), 0.0);
        double updatedFees = Math.max(0, currentFees - amount); // Prevent negative fees
        memberFees.put(member.getID(), updatedFees);

        if(updatedFees == 0) {
            System.out.println("All fees cleared for " + member.getName());
        } else {
            System.out.println("Payment recorded for " + member.getName() + ". Outstanding fees: $" + updatedFees);
        }
    }

    /**
     * Retrieves the total outstanding fees for a given member.
     *
     * @param member The member whose fees are being queried.
     * @return The total outstanding fees for the member.
     */
    public double getOutstandingFees(Member member) {
        return memberFees.getOrDefault(member.getID(), 0.0);
    }

    /**
     * Clears all outstanding fees for a member.
     *
     * @param member The member whose fees are to be cleared.
     */
    public void clearMemberFees(Member member) {
        if (hasOutstandingFees(member)) {
            memberFees.put(member.getID(), 0.0);
            System.out.println("All fees cleared for " + member.getName());
        }
    }

    /**
     * Adds a specified amount of fees to a member's account.
     *
     * @param member The member to add fees to.
     * @param amount The amount of fees to add.
     */
    public void addFee(Member member, double amount) {
        double currentFees = memberFees.getOrDefault(member.getID(), 0.0);
        memberFees.put(member.getID(), currentFees + amount);
        System.out.println("Fee of $" + amount + " added for " + member.getName() + ". Total outstanding fees: $" + (currentFees + amount));
    }

}
