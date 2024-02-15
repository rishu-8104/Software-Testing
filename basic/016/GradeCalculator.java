/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */

public class GradeCalculator {
    
    /**
     * Writes the GradeCalculator program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        GradeCalculator calculator = new GradeCalculator();
        String result = calculator.calculateAndDisplayFinalGrade(2, 2, 1, 4, 3, 4);
        System.out.println(result);
    }

    /**
     * Calculates the final grade based on the weighted average of exam, design, and implementation grades.
     *
     * @param examECTS           The ECTS credits for the exam.
     * @param examGrade          The grade for the exam.
     * @param designECTS         The ECTS credits for the design.
     * @param designGrade        The grade for the design.
     * @param implementationECTS The ECTS credits for the implementation.
     * @param implementationGrade The grade for the implementation.
     * @return A string representing the final grade calculation results.
     */
    public String calculateAndDisplayFinalGrade(int examECTS, int examGrade,
                                                int designECTS, int designGrade,
                                                int implementationECTS, int implementationGrade) {
        double totalECTS = examECTS + designECTS + implementationECTS;
        double weightedAverage = calculateWeightedAverage(examECTS, examGrade, designECTS, designGrade,
                implementationECTS, implementationGrade);
        double finalGrade = weightedAverage / totalECTS;

        return displayResults(totalECTS, finalGrade);
    }

    /**
     * Calculates the weighted average of exam, design, and implementation grades.
     *
     * @param examECTS           The ECTS credits for the exam.
     * @param examGrade          The grade for the exam.
     * @param designECTS         The ECTS credits for the design.
     * @param designGrade        The grade for the design.
     * @param implementationECTS The ECTS credits for the implementation.
     * @param implementationGrade The grade for the implementation.
     * @return The weighted average of the grades.
     */
    public double calculateWeightedAverage(int examECTS, int examGrade,
                                           int designECTS, int designGrade,
                                           int implementationECTS, int implementationGrade) {
        return (examECTS * examGrade + designECTS * designGrade + implementationECTS * implementationGrade);
    }

    /**
     * Formats and displays the final grade calculation results.
     *
     * @param totalECTS  The total ECTS credits.
     * @param finalGrade The final grade.
     * @return A string representing the final grade calculation results.
     */
    public String displayResults(double totalECTS, double finalGrade) {
        StringBuilder result = new StringBuilder();
        result.append("-----------------------------\n");
        result.append(String.format("Exam            %d      %d\n", 2, 2));
        result.append(String.format("Design          %d      %d\n", 1, 4));
        result.append(String.format("Implementation  %d      %d\n", 3, 4));
        result.append("-----------------------------\n");
        result.append(String.format("Totals          %.3f      %.3f (Final Grade)\n", totalECTS, finalGrade));
        return result.toString();
    }
}
