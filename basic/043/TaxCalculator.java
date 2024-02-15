/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class TaxCalculator {

    /**
     * Calculates yearly taxes based on the yearly salary and tax percentage.
     *
     * @param yearlySalary The yearly salary of the individual.
     * @param percentage   The tax percentage to be applied.
     * @return The amount of taxes to be paid yearly.
     */
    public double yearlyTaxes(double yearlySalary, double percentage) {
        return yearlySalary * (percentage / 100.0);
    }

    /**
     * Mains method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        double yearlySalary = 50000.0;
        double percentage = 25.0;
        TaxCalculator taxCalculator = new TaxCalculator();
        double taxes = taxCalculator.yearlyTaxes(yearlySalary, percentage);
        System.out.println("Yearly taxes: " + taxes);
    }
}
