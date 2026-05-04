package JavaProject_JohnB_MafuyuL.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import JavaProject_JohnB_MafuyuL.model.PCPart;
import JavaProject_JohnB_MafuyuL.model.MaintType;

/**
 * Calculates the total lifespan of a PCPart as well as it's next projected maintenance date
 */
public class LifespanCalcUtil {
    
    /**
     * Calculates the projected date the part will reach the end of its life
     * @param part defines the PCPart to calc this for
     * @return the projected LocalDateTime
     */
    public static LocalDateTime calcEOL(PCPart part) {
        if (part.getInstallDate() == null || part.getTotalLife() <= 0) {
            return null;
        }
        return part.getInstallDate().plusDays(part.getTotalLife());
    }

    /**
     * Calculates how many days left until EOL
     * @param part is the PCPart to calc this for
     * @return defines the number of days remaining
     */
    public static long calcLifespan(PCPart part) {
        if (part.getInstallDate() == null) {
            return -1;
        }
        long daysUsed = ChronoUnit.DAYS.between(part.getInstallDate(), LocalDateTime.now());
        long remaining = part.getTotalLife() - daysUsed;
        
        return Math.max(remaining, 0);
    }

    /**
     * Defines the standard intervals for maintenance
     * @param type defines a MaintType from our enum
     */
    public static int getMaintenanceInterval(MaintType type) {
        return switch (type) {
            case DUSTING, FILTER -> 30;         // 1 Month
            case STORAGE -> 90;                 // 3 Months
            case LUBRICATING -> 180;            // 6 Months
            case THERMALPASTE, COOLANT -> 365;  // 1 Year
        };
    }
}