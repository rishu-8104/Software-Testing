package project;

public class FeeCalculator {
    private static final double FEE_PER_DAY = 0.50; // Example fee per day overdue

    // Calculates the fee based on days overdue
    public static double calculateFee(long daysOverdue) {
        return daysOverdue * FEE_PER_DAY;
    }

    // Checks if a member has outstanding fees
    public static boolean hasOutstandingFees(Member member) {
        return member.getFees() > 0;
    }

    // Records a payment of fees for a member
    public static void payFees(Member member, double amount) {
        member.payFees(amount);
        System.out.println("Paid $" + amount + " of fees for " + member.getName() + ". Remaining fees: $" + member.getFees());
    }

    // Gets the total outstanding fees for a member
    public static double getOutstandingFees(Member member) {
        return member.getFees();
    }

    // Clears all fees for a member
    public static void clearMemberFees(Member member) {
        member.clearFees();
        System.out.println("All fees cleared for " + member.getName());
    }
}

