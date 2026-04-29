package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDate;

public class CPU extends PCPart{
    private double currentLoad;
    private double currentTemp;

    public CPU(String b, String m, LocalDate md, MaintType mt, LocalDate id, long tl, long ut, double cl, double ct){
        super(b, m, md, mt, id, tl, ut);
        this.currentLoad = cl;
        this.currentTemp = ct;
    }


}