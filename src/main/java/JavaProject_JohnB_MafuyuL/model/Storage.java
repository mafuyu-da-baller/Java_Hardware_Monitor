package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDate;

public class Storage extends PCPart{
    private long totalSpace;
    private long freeSpace;
    private String smartStatus;

    public Storage(String b, String m, LocalDate md, MaintType mt, LocalDate id, long tl, long ut, long ts, long fs, String ss){
        super(b, m, md, mt, id, tl, ut);
        this.totalSpace = ts;
        this.freeSpace = fs;
        this.smartStatus = ss;
    }
}