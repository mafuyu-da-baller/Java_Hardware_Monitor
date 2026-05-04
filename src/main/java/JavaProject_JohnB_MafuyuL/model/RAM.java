package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDateTime;

/**
 * RAM represents a memory module component.
 */
public class RAM extends PCPart {
    private long totalCapacity;
    private long usedCapacity;

    public RAM(String brand, String model, LocalDateTime installDate, 
               MaintType maintType, LocalDateTime maintDate, 
               int totalLife, int totalUptime, long totalCapacity, long usedCapacity) {
        super(brand, model, installDate, maintType, maintDate, totalLife, totalUptime);
        this.setTotalLife(5475);
        this.totalCapacity = totalCapacity;
        this.usedCapacity = usedCapacity;
    }

    public long getCapacity() {
        return totalCapacity;
    }

    public void setCapacity(long total) {
        this.totalCapacity = total;
    }

    public long getCurrentCapacity() {
        return usedCapacity;
    }

    public void setCurrentCapacity(long used) {
        this.usedCapacity = used;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nTotal Capacity (MB): " + totalCapacity +
               "\nUsed Capacity (MB): " + usedCapacity;
    }
}