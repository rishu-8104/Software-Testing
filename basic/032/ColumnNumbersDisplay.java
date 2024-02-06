/**
 * The ColumnNumbersDisplay class displays 10-based column numbers to the screen with a configurable length.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0206 (last modified: 2024.0206)
 * @since 17.0 (minimum Java version)
 */
public class ColumnNumbersDisplay {
    /**
     * Exercise: 3.2
     * Write a program to display 10-based column numbers to the screen with a configurable length.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int length = 25; // Change this value to set the length of the display

        // Loop to display 10-based column numbers
        for (int i = 1; i <= length; i++) {
            System.out.print(i % 10); // Print the current number modulo 10 to get 10-based column numbers
        }
        System.out.println(); // Move to the next line after displaying the numbers
    }
}
