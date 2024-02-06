/**
 * The SquareDrawer class draws a square to the screen based on the defined size.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0206 (last modified: 2024.0206)
 * @since 17.0 (minimum Java version)
 */
public class SquareDrawer {
    /**
     * Exercise: 3.4
     * Write a program to display a square to the screen based on defined SIZE.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int size = 4; // Change this value to set the size of the square

        // Loop to iterate through each row
        for (int i = 0; i < size; i++) {
            // Loop to iterate through each column
            for (int j = 0; j < size; j++) {
                System.out.print("x"); // Print "x" for each cell within the square
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
