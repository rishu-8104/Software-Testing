/**
 * The ArrayAverageCalculator class provides a method to calculate the average of an integer array.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class ArrayAverageCalculator {

    /**
     * Calculates the average of the elements in the given integer array.
     *
     * @param array The array containing integers.
     * @param length The length of the array.
     * @return The average of the array elements.
     */
    public double average(int[] array, int length) {
        if (length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += array[i];
        }
        return (double) sum / length;
    }

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int length = 3;
        int[] array = {3, 1, 2};
        ArrayAverageCalculator calculator = new ArrayAverageCalculator();
        double average = calculator.average(array, length);
        System.out.println("Average of the array: " + average);
    }
}
