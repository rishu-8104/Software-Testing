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
        calculator.calculateAndDisplayBMI(55, 1.75);
    }

    public void calculateAndDisplayBMI(double weight, double height) {
        double bmi = calculateBMI(weight, height);
        displayResults(weight, height, bmi);
    }

    public double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public void displayResults(double weight, double height, double bmi) {
        System.out.printf("Weight (kg): %.2f\n", weight);
        System.out.printf("Height (m): %.2f\n", height);
        System.out.printf("BMI       : %.2f\n", bmi);
    }
}

// End of file
