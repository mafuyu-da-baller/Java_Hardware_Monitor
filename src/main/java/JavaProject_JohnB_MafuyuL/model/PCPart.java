package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PCPart{
    private String brand; //Brand of the part
    private String model; //Model number of the part
    private Map<MaintType, LocalDate> maintenanceSchedule; //Next recommended date for maintenance
    private LocalDate installDate; //Date it was installed on the PC
    private long totalLife; //Estimated total lifespan of the part
    private long totalUptime; //Estimated total Uptime of the part
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
    public PCPart(String b, String m, LocalDate md, MaintType mt, LocalDate id, long tl, long ut){
        this.brand = b;
        this.model = m;
        this.maintenanceSchedule.put(mt, md);
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
    public void addMaintenance(MaintType type, LocalDate date){
        this.maintenanceSchedule.put(type, date);
    }
    /**
     * @return a LocalDate for a given maintType or null if it DNE
     */
    public LocalDate getMaintenanceDate(MaintType type){
        return this.maintenanceSchedule.get(type);
    }
    /**
     * @return the map of maintTypes performed on the part
     */
    public Map<MaintType, LocalDate> getMaintenanceMap(MaintType type){
        return this.maintenanceSchedule;
    }
    /**
     * Manually set or adjust the date the part was installed on the PC
     */
    public void setInstallDate(LocalDate id){
        this.installDate = id;
    }
    /**
     * @return a LocalDate containing the date the part was installed on the PC
     */
    public LocalDate getInstallDate(){
        return this.installDate;
    }
    /**
     * Manually set or adjust the estimated lifepan of the part using {@link LifespanCalc#calcTotalLife()}
     */
    public void setTotalLife(long tl){
        this.totalLife = tl;
    }
    /**
     * @return a Long containing the estimated lifepan of the part
     */
    public long getTotalLife(){
        return this.totalLife;
    }
    /**
     * Manually set or adjust the total uptime of the part
     */
    public void setUptime(long ut){
        this.totalUptime = ut;
    }
    /**
     * @return a Long containing the total uptime of the part
     */
    public long getUptime(){
        return this.totalUptime;
    }
    /**
     * Output an objects fields
     */
    @Override
    public String toString(){
        return  "PCPart: \n" +
                "Brand = "           + brand + "\n" +
                "model = "           + model + "\n" +
                "installDate = "     + installDate + "\n" +
                "maintenanceDate(s) = " + maintenanceSchedule + "\n" +
                "totalLife = "       + totalLife + "\n" +
                "totalUptime = "     + totalUptime + "\n"
                ;
    }
}