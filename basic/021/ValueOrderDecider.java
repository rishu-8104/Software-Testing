/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class ValueOrderDecider {
    /**
     * Writes the ValueOrderDecider program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int a = 15;
        int b = 4;
        int c = 7;

        ValueOrderDecider orderDecider = new ValueOrderDecider();
        String result = orderDecider.decideOrder(a, b, c);
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
    public String decideOrder(int a, int b, int c) {
        int biggest = Math.max(a, Math.max(b, c));
        int smallest = Math.min(a, Math.min(b, c));
        int middle = a + b + c - biggest - smallest;

        return String.format("%d is the biggest\n%d is in the middle\n%d is the smallest", biggest, middle, smallest);
    }
}
