package JavaProject_JohnB_MafuyuL;
import java.util.List;

import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;

public class GPU extends PCPart{
    //Just here to keep VSC from removing the imports
    SystemInfo si = new SystemInfo();
    private List<GraphicsCard> oshiGpus;
    //
}