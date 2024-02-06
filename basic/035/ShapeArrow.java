/**
 * The ShapeArrow class generates and displays a shape resembling an arrow.
 * The size of the arrow is determined by the specified size and character.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0206 (last modified: 2024.0206)
 * @since 17.0 (minimum Java version)
 */
public class ShapeArrow {
    /**
     * Exercise: 3.5
     * Write a program to display a shape resembling an arrow.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int size = 5; // Change this value to set the size of the arrow
        char character = '*'; // Change this character to adjust the displayed character

        // Print the arrow shape
        for (int i = 0; i < size; i++) {
            // Print leading spaces for indentation
            for (int j = 0; j < (i < size - 2 ? i : size - 1 - i); j++) {
                System.out.print("    "); // Four spaces for indentation
            }

            // Print the character pattern for the current row
            for (int j = 0; j < size; j++) {
                System.out.print(character + " "); // Print character followed by a space
            }

            System.out.println(); // Move to the next line after each row
        }
    }
}
