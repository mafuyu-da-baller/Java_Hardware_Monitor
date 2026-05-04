package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDateTime;

/**
 * GPU represents a graphics processing unit component.
 */
public class GPU extends PCPart {
    private long vramTotal;
    private double currentLoad;
    private double currentTemp;
    private String fanHealth;

    public GPU(String brand, String model, LocalDateTime installDate, 
               MaintType maintType, LocalDateTime maintDate, 
               int totalLife, int totalUptime, long vramTotal, 
               double currentLoad, double currentTemp, String fanHealth) {
        super(brand, model, installDate, maintType, maintDate, totalLife, totalUptime);
        this.setTotalLife(2555);
        this.vramTotal = vramTotal;
        this.currentLoad = currentLoad;
        this.currentTemp = currentTemp;
        this.fanHealth = fanHealth;
    }

    public long getVramTotal() {
        return vramTotal;
    }

    public void setVramTotal(long vram) {
        this.vramTotal = vram;
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(double load) {
        this.currentLoad = load;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double temp) {
        this.currentTemp = temp;
    }

    public String getFanHealth() {
        return fanHealth;
    }

    public void setFanHealth(String fan) {
        this.fanHealth = fan;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nVRAM Total (MB): " + vramTotal +
               "\nCurrent Load: " + currentLoad + "%" +
               "\nCurrent Temp: " + currentTemp + "C" +
               "\nFan Health: " + fanHealth;
    }
}