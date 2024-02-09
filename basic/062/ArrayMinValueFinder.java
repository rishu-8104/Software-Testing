/**
 * The ArrayMinValueFinder class provides a method to find the minimum value in an integer array.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class ArrayMinValueFinder {

    /**
     * Finds the minimum value in the given integer array.
     *
     * @param array The array containing integers.
     * @param length The length of the array.
     * @return The minimum value in the array.
     */
    public int min(int[] array, int length) {
        int min = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int length = 3;
        int[] array = {3, 1, 2};
        ArrayMinValueFinder finder = new ArrayMinValueFinder();
        int min = finder.min(array, length);
        System.out.println("Minimum value of the array: " + min);
    }
}
