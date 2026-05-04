package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDateTime;

/**
 * CPU represents a central processing unit component.
 * It extends PCPart and adds current load and temperature fields.
 */
public class CPU extends PCPart {
    private double currentTemp;
    private double currentLoad;

    public CPU(String brand, String model, LocalDateTime installDate, 
               MaintType maintType, LocalDateTime maintDate, 
               int totalLife, int totalUptime, double currentLoad, double currentTemp) {
        super(brand, model, installDate, maintType, maintDate, totalLife, totalUptime);
        this.setTotalLife(3650);
        this.currentTemp = currentTemp;
        this.currentLoad = currentLoad;
    }

    public void setCurrentTemp(double temp) {
        this.currentTemp = temp;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentLoad(double load) {
        this.currentLoad = load;
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nCurrent Load: " + currentLoad + "%" +
               "\nCurrent Temp: " + currentTemp + "C";
    }
}