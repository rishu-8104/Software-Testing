/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class ArraySumCalculator {

    /**
     * Calculates the sum of the elements in the given integer array.
     *
     * @param array The array containing integers.
     * @param length The length of the array.
     * @return The sum of the elements in the array.
     */
    public int sum(int[] array, int length) {
        int total = 0;
        for (int i = 0; i < length; i++) {
            total += array[i];
        }
        return total;
    }

    /**
     * Mains method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int length = 3;
        int[] array = {3, 1, 2};
        ArraySumCalculator calculator = new ArraySumCalculator();
        int sum = calculator.sum(array, length);
        System.out.println("Sum of the array: " + sum);
    }
}
