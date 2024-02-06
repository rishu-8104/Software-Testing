/**
 * The ValueOrderDecider class determines the order of three integer values.
 * It provides a method to decide the order and returns the result as a formatted string.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class ValueOrderDecider {
    /**
     * Exercise: 2.1
     * Write the ValueOrderDecider program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int a = 15;
        int b = 4;
        int c = 7;

        String result = decideOrder(a, b, c);
        System.out.println(result);
    }

    /**
     * Determines the order of three integer values.
     *
     * @param a The first integer value.
     * @param b The second integer value.
     * @param c The third integer value.
     * @return A string indicating the order of the values.
     */
    public static String decideOrder(int a, int b, int c) {
        int biggest = Math.max(a, Math.max(b, c));
        int smallest = Math.min(a, Math.min(b, c));
        int middle = a + b + c - biggest - smallest;

        return String.format("%d is the biggest\n%d is in the middle\n%d is the smallest", biggest, middle, smallest);
    }
}
