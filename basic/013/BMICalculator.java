/**
 * @author      Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version     2024.0131 (last modified)
 * @since       17.0 (miminimum Java version)
 */

public class BMICalculator {
/**
     * Exercise: 1.3
     * Write the BMI calculator program.
     *
     * @param  args  Command line arguments. Not used.
     */
    public static void main(String[] args) {
        BMICalculator calculator = new BMICalculator();
        String result = calculator.calculateAndDisplayBMI(55, 1.75);
        System.out.println(result);
    }

    public String calculateAndDisplayBMI(double weight, double height) {
        double bmi = calculateBMI(weight, height);
        return displayResults(weight, height, bmi);
    }

    public double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public String displayResults(double weight, double height, double bmi) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Weight (kg): %.2f\n", weight));
        result.append(String.format("Height (m): %.2f\n", height));
        result.append(String.format("BMI       : %.2f\n", bmi));
        return result.toString();
    }
}

// End of file
