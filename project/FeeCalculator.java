import java.util.HashMap;
import java.util.Map;

public class FeeCalculator {
    private Map<String, Double> memberFees; // Maps member ID to outstanding fees
    private static final double FEE_PER_DAY = 0.5; // Fixed fee per day overdue

    public FeeCalculator() {
        this.memberFees = new HashMap<>();
    }

    public double calculateFee(long daysOverdue) {
        return daysOverdue * FEE_PER_DAY;
    }

    public boolean hasOutstandingFees(Member member) {
        return memberFees.getOrDefault(member.getID(), 0.0) > 0;
    }

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

    public double getOutstandingFees(Member member) {
        return memberFees.getOrDefault(member.getID(), 0.0);
    }

    public void clearMemberFees(Member member) {
        if (hasOutstandingFees(member)) {
            memberFees.put(member.getID(), 0.0);
            System.out.println("All fees cleared for " + member.getName());
        }
    }

    public void addFee(Member member, double amount) {
        double currentFees = memberFees.getOrDefault(member.getID(), 0.0);
        memberFees.put(member.getID(), currentFees + amount);
        System.out.println("Fee of $" + amount + " added for " + member.getName() + ". Total outstanding fees: $" + (currentFees + amount));
    }

}
