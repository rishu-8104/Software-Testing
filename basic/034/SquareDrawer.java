/**
 * The SquareDrawer class draws a square to the screen based on the defined size.
 * It provides a method to draw the square.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class SquareDrawer {
    private int size; // The size of the square

    /**
     * Constructs a SquareDrawer object with the given size.
     *
     * @param size The size of the square.
     */
    public SquareDrawer(int size) {
        this.size = size;
    }

    /**
     * Draws a square and returns it as a string.
     *
     * @return The square as a string.
     */
    public String drawSquare() {
        StringBuilder square = new StringBuilder();

        // Loop to iterate through each row
        for (int i = 0; i < size; i++) {
            // Loop to iterate through each column
            for (int j = 0; j < size; j++) {
                square.append("x"); // Append "x" for each cell within the square
            }
            square.append("\n"); // Move to the next line after each row
        }

        return square.toString();
    }

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int size = 4; // Change this value to set the size of the square
        SquareDrawer squareDrawer = new SquareDrawer(size);
        String square = squareDrawer.drawSquare();
        System.out.println(square);
    }
}
