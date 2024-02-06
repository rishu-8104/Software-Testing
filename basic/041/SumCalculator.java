/**
 * The MultiplicationTable class generates and displays a multiplication table of a specified size.
 * The size of the table determines the number of rows and columns in the table.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class SumCalculator {

    /**
     * Calculates the arithmetic sum from 1 to the specified number.
     *
     * @param n The upper limit of the sum.
     * @return The total sum from 1 to n.
     */
    public int sum(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        SumCalculator calculator = new SumCalculator();
        int total = calculator.sum(10); // Calculates the sum from 1 to 10
        System.out.println("Total sum: " + total);
    }
}
