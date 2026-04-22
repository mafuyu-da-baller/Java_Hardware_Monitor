package JavaProject_JohnB_MafuyuL;
import java.util.List;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;

public class Storage extends PCPart{
    //Just here to keep VSC from removing the imports
    SystemInfo si = new SystemInfo();
    private List<HWDiskStore> oshiDrives;
    //
}