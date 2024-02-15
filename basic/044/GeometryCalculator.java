/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class GeometryCalculator {

    /**
     * Calculates the area of a circle based on its radius.
     *
     * @param radius The radius of the circle.
     * @return The area of the circle.
     */
    public double areaCircle(double radius) {
        return Math.PI * radius * radius;
    }

    /**
     * Mains method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        double radius = 5.0;
        GeometryCalculator geometryCalculator = new GeometryCalculator();
        double area = geometryCalculator.areaCircle(radius);
        System.out.println("Area of the circle: " + area);
    }
}
