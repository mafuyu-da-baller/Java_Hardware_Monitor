package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDateTime;

/**
 * Storage represents a storage device such as an SSD or HDD.
 */
public class Storage extends PCPart {
    private long totalSpace;
    private long freeSpace;
    private String smartStatus;

    public Storage(String brand, String model, LocalDateTime installDate, 
                   MaintType maintType, LocalDateTime maintDate, 
                   int totalLife, int totalUptime, long totalSpace, long freeSpace, String smartStatus) {
        super(brand, model, installDate, maintType, maintDate, totalLife, totalUptime);
        this.setTotalLife(1825);
        this.totalSpace = totalSpace;
        this.freeSpace = freeSpace;
        this.smartStatus = smartStatus;
    }

    public long getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(long totalSpace) {
        this.totalSpace = totalSpace;
    }

    public long getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(long freeSpace) {
        this.freeSpace = freeSpace;
    }

    public String getSmartStatus() {
        return smartStatus;
    }

    public void setSmartStatus(String status) {
        this.smartStatus = status;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nTotal Space (GB): " + totalSpace +
               "\nFree Space (GB): " + freeSpace +
               "\nSMART Status: " + smartStatus;
    }
}