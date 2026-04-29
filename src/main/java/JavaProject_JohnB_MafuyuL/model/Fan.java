package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDate;

public class Fan extends PCPart{
    private int RPM;

    public Fan(String b, String m, LocalDate md, MaintType mt, LocalDate id, long tl, long ut, int rpm){
        super(b, m, md, mt, id, tl, ut);
        this.RPM = rpm;
    }
    
}