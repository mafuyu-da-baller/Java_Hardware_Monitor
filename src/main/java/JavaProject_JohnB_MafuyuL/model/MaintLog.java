package JavaProject_JohnB_MafuyuL.model;
import java.time.LocalDateTime;

public class MaintLog{
    private final PCPart PCPart;
    private final LocalDateTime currentDate;
    private final MaintType maintType;

    public MaintLog(PCPart part, LocalDateTime time, MaintType TYPE){
        this.PCPart = part;
        this.currentDate = time;
        this.maintType = TYPE;
    }
    @Override
    public String toString() {
        return currentDate + " | " + PCPart.getName() + " | " + maintType;
    }
}