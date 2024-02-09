/**
 * The ArrayReversePrinter class displays values in an array in reverse order.
 * It provides a method to print the array elements in reverse.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class ArrayReversePrinter {

    /**
     * Prints the values in the array in reverse order.
     *
     * @param array The array whose elements need to be printed in reverse order.
     * @return A string representing the array elements in reverse order.
     */
    public String printReverse(int[] array) {
        StringBuilder result = new StringBuilder();
        result.append("Display:\n");

        // Print array elements in reverse order
        for (int i = array.length - 1; i > 0; i--) {
            result.append(array[i]).append(", ");
        }
        if (array.length > 0) {
            result.append(array[0]); // Append last element without the comma
        }

        return result.toString();
    }

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};
        ArrayReversePrinter printer = new ArrayReversePrinter();
        String result = printer.printReverse(array);
        System.out.println(result);
    }
}
