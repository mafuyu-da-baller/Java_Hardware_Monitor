package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PCPart{
    private String brand; //Brand of the part
    private String model; //Model number of the part
    private final Map<MaintType, LocalDateTime> maintenanceSchedule; //Next recommended date for maintenance
    private LocalDateTime installDate; //Date it was installed on the PC
    private int totalLife; //Estimated total lifespan of the part
    private int totalUptime; //Estimated total Uptime of the part

    /**
     * Default Constructor
     */
    public PCPart(){
        this.brand = "";
        this.model = "";
        this.maintenanceSchedule = new HashMap<>();
        this.installDate = null;
        this.totalLife = -1;
        this.totalUptime = -1;
    }

    /**
     * Full Constructor
     */
    public PCPart(String b, String m, LocalDateTime id, MaintType mt, LocalDateTime md, int tl, int ut){
        this.brand = b;
        this.model = m;
        this.maintenanceSchedule = new HashMap<>();
        if (mt != null && md != null) {
            this.maintenanceSchedule.put(mt, md);
        }
        this.installDate = id;
        this.totalLife = tl;
        this.totalUptime = ut;
    }

    /**
     * @return a String containing the PCPart name
     */
    public String getName(){
        return this.getClass().getSimpleName();
    }

    /**
     * Manually set or adjust the Brand
     */
    public void setBrand(String b){
        this.brand = b;
    }

    /**
     * @return a String containing the Brand
     */
    public String getBrand(){
        return this.brand;
    }

    /**
     * Manually set or adjust the Model
     */
    public void setModel(String m){
        this.model = m;
    }

    /**
     * @return a String containing the Model
     */
    public String getModel(){
        return this.model;
    }

    /**
     * add in or remap an instance of maintenance performed
     */
    public void addMaintenance(MaintType type, LocalDateTime date){
        this.maintenanceSchedule.put(type, date);
    }

    /**
     * @return the map of maintTypes performed on the part
     */
    public Map<MaintType, LocalDateTime> getMaintenanceMap(){
        return this.maintenanceSchedule;
    }

    /**
     * Manually set or adjust the date the part was installed on the PC
     */
    public void setInstallDate(LocalDateTime id){
        this.installDate = id;
    }

    /**
     * @return a LocalDateTime containing the date the part was installed on the PC
     */
    public LocalDateTime getInstallDate(){
        return this.installDate;
    }

    /**
     * Manually set or adjust the estimated lifepan of the part
     */
    public void setTotalLife(int tl){
        this.totalLife = tl;
    }

    /**
     * @return an int containing the estimated lifepan of the part
     */
    public int getTotalLife(){
        return this.totalLife;
    }

    /**
     * Manually set or adjust the total uptime of the part
     */
    public void setUptime(int ut){
        this.totalUptime = ut;
    }

    /**
     * @return an int containing the total uptime of the part
     */
    public int getUptime(){
        return this.totalUptime;
    }

    /**
     * Output an objects fields
     */
    @Override
    public String toString(){
        return  """
                PCPart: 
                Brand = """           + brand + "\n" +
                "model = "           + model + "\n" +
                "installDate = "     + installDate + "\n" +
                "maintenanceDate(s) = " + maintenanceSchedule + "\n" +
                "totalLife = "       + totalLife + "\n" +
                "totalUptime = "     + totalUptime + "\n"
                ;
    }
}