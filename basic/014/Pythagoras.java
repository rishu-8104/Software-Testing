/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0126 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class Pythagoras {

    /**
     * Calculates the length of the hypotenuse of a right triangle given the lengths of the other two sides.
     *
     * @param a The length of one side of the right triangle.
     * @param b The length of the other side of the right triangle.
     * @return The length of the hypotenuse of the right triangle.
     */
    public static double calculate(double a, double b){
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return c;
    }

    /**
     * Demonstrates the use of the calculate method.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        double answer = calculate(3, 4);
        System.out.println(answer);
    }
}
