package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDateTime;

/**
 * Fan represents a case or CPU fan component.
 */
public class Fan extends PCPart {
    private int RPM;

    public Fan(String brand, String model, LocalDateTime installDate, 
               MaintType maintType, LocalDateTime maintDate, 
               int totalLife, int totalUptime, int RPM) {
        super(brand, model, installDate, maintType, maintDate, totalLife, totalUptime);
        this.setTotalLife(2190);
        this.RPM = RPM;
    }
    
    public int getRPM() {
        return RPM;
    }
    
    public void setRPM(int rpm) {
        this.RPM = rpm;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRPM: " + RPM;
    }
}