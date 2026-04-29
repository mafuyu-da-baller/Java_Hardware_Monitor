package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDate;

public class GPU extends PCPart{
    private long vramTotal;
    private double currentLoad;
    private double currentTemp;
    private String fanHealth;

    public GPU(String b, String m, LocalDate md, MaintType mt, LocalDate id, long tl, long ut, long vram, double cl, double ct, String fh){
            super(b, m, md, mt, id, tl, ut);
            this.vramTotal = vram;
            this.currentLoad = cl;
            this.currentTemp = ct;
            this.fanHealth = fh;
        }
}