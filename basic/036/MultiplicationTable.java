/**
 * The MultiplicationTable class generates and displays a multiplication table of a specified size.
 * The size of the table determines the number of rows and columns in the table.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0206 (last modified: 2024.0206)
 * @since 17.0 (minimum Java version)
 */
public class MultiplicationTable {
    /**
     * Exercise: 3.6
     * Write a program to display a multiplication table of a specified size with evenly spaced output.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int size = 9; // Change this value to set the size of the multiplication table

        // Print header row
        System.out.print("    |");
        for (int i = 1; i <= size; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println("\n-----------------------------------------");

        // Print table rows
        for (int i = 1; i <= size; i++) {
            System.out.printf("%3d |", i);
            for (int j = 1; j <= size; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
