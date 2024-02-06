/**
 * The EventCalendar class displays events based on date and time.
 * It provides a method to determine if there is an event at the specified time.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0206 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class EventCalendar {
    final static String MONDAY = "Mon";
    final static String WEDNESDAY = "Wed";
    final static String SATURDAY = "Sat";

    /**
     * Exercise: 2.5
     * Write a program that displays events based on date and time.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        EventCalendar eventCalendar = new EventCalendar();

        String weekday = MONDAY; // Change this value to the desired weekday (Mon, Wed, Sat)
        int hour = 19; // Change this value to the desired hour
        int minute = 0; // Change this value to the desired minute

        String eventNotification = eventCalendar.getEventNotification(weekday, hour, minute);
        System.out.println(eventNotification);
    }

    /**
     * Determines if there is an event at the specified date and time.
     *
     * @param weekday The weekday (Mon, Wed, Sat).
     * @param hour The hour of the event.
     * @param minute The minute of the event.
     * @return The event notification if there is a matching event, otherwise "No events for WEEKDAY HH:MM".
     */
    public String getEventNotification(String weekday, int hour, int minute) {
        if (weekday.equals(MONDAY) && hour == 19 && minute >= 0 && minute <= 30) {
            return "Mon 19:00-20:30 volleyball";
        } else if (weekday.equals(WEDNESDAY) && hour == 20 && minute >= 30 && minute <= 59) {
            return "Wed 20:30-21:30 badminton";
        } else if (weekday.equals(SATURDAY) && hour == 10 && minute >= 0 && minute <= 59) {
            return "Sat 10:00-11:00 gym";
        } else {
            return "No events for " + weekday + " " + String.format("%02d:%02d", hour, minute);
        }
    }
}
