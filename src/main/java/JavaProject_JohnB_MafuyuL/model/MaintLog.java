package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDate;

public class MaintLog{
    private PCPart PCPart;
    private LocalDate currentDate;
    private MaintType maintType;

    public MaintLog(PCPart part, LocalDate time, MaintType TYPE){
        this.PCPart = part;
        this.currentDate = time;
        this.maintType = TYPE;
    }
    @Override
    public String toString() {
        return currentDate + " | " + part.getName() + " | " + maintType;
    }
}