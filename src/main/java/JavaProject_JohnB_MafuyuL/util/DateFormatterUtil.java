package JavaProject_JohnB_MafuyuL.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Formats internal dates to allow them to be handled easily
 */
public class DateFormatterUtil {
    // Creates a consistent display of the date for menus and logs
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    /**
     * Convert LocalDateTime to String
     * @param date defines the date that you want to format
     * @return a string of the date in "MM-dd-yyyy" format
     */
    public static String convertDate(LocalDateTime date) {
        return (date == null) ? "N/A" : date.format(FORMATTER);
    }

    /**
     * Calculate the date for the next maintenance
     * @param start defines the date of the maintenance
     * @param amount defines the time to add to the start date
     * @param unit defines the unit of time
     * @return the LocalDateTime for the suggested next maintenance
     */
    public static LocalDateTime addInterval(LocalDateTime start, long amount, ChronoUnit unit) {
        return (start == null) ? null : start.plus(amount, unit);
    }

    /**
     * Calculates days between two dates
     * @param start defines the beginning of the date range
     * @param end defines the end of the date range
     * @return defines the estimated number of days between dates
     */
    public static long daysBetween(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) return 0;
        return ChronoUnit.DAYS.between(start, end);
    }
}