/**
 * The TaxCalculator class calculates taxes based on total earnings and stock earnings.
 * It provides methods to calculate taxes and display the results.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class TaxCalculator {
    /**
     * Exercise: 1.7
     * Write the TaxCalculator program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator();
        String result = calculator.calculateAndDisplayTaxes(134000, 23000);
        System.out.println(result);
    }

    /**
     * Calculates taxes based on total earnings and stock earnings, and displays the results.
     *
     * @param totalEarnings  The total earnings.
     * @param stockEarnings  The earnings from stocks.
     * @return A string representing the tax calculation results.
     */
    public String calculateAndDisplayTaxes(double totalEarnings, double stockEarnings) {
        double workEarnings = totalEarnings - stockEarnings;
        double taxesTotal = calculateTaxesTotal(workEarnings, stockEarnings);
        double netIncome = totalEarnings - taxesTotal;

        return displayResults(totalEarnings, workEarnings, stockEarnings, taxesTotal, netIncome);
    }

    /**
     * Calculates the total taxes based on work earnings and stock earnings.
     *
     * @param workEarnings   The earnings from work.
     * @param stockEarnings  The earnings from stocks.
     * @return The total taxes.
     */
    public double calculateTaxesTotal(double workEarnings, double stockEarnings) {
        double nominalTaxRate = 27.3 / 100;
        double governmentTaxRate = 21 / 100;

        double workTaxes = workEarnings * nominalTaxRate;
        double stockTaxes = stockEarnings * governmentTaxRate;

        return workTaxes + stockTaxes;
    }

    /**
     * Formats and displays the tax calculation results.
     *
     * @param totalEarnings  The total earnings.
     * @param workEarnings   The earnings from work.
     * @param stockEarnings  The earnings from stocks.
     * @param taxesTotal     The total taxes.
     * @param netIncome      The net income after taxes.
     * @return A string representing the tax calculation results.
     */
    public String displayResults(double totalEarnings, double workEarnings, double stockEarnings,
                                 double taxesTotal, double netIncome) {
        StringBuilder result = new StringBuilder();
        result.append("All income    : ").append(totalEarnings).append("\n");
        result.append("Work earnings : ").append(workEarnings).append("\n");
        result.append("Stock earnings: ").append(stockEarnings).append("\n\n");
        result.append("Taxes total   : ").append(taxesTotal).append("\n");
        result.append("Net income    : ").append(netIncome).append(" (after taxes)");
        return result.toString();
    }
}
