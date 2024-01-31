import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintProgram {

    public static void main(String[] args) {

        PrintProgram printer = new PrintProgram();

        String currentDate = getCurrentDate();
        String firstName = "Rishu";
        String lastName = "Kumar";
        int height = 185;
        String output = printer.displayInformation(currentDate, firstName, lastName, height);
        System.out.println(output);
    }

    public String displayInformation(String currentDate, String firstName, String lastName, int height) {
        StringBuilder output = new StringBuilder();
        output.append("The date is ").append(currentDate).append("\n");
        output.append("Hello, I'm ").append(firstName).append(" ").append(lastName).append("\n");
        output.append("I'm ").append(height).append(" cm tall");
        return output.toString();
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }
}
