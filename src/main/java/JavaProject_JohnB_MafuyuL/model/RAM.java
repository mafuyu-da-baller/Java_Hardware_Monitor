package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDate;

public class RAM extends PCPart{
    private long totalCapacity;
    private long usedCapacity;

    public RAM(String b, String m, LocalDate md, MaintType mt, LocalDate id, long tl, long ut, long tc, long uc){
        super(b, m, md, mt, id, tl, ut);
        this.totalCapacity = tc;
        this.usedCapacity = uc;
    }
}