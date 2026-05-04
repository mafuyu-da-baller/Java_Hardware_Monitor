package JavaProject_JohnB_MafuyuL.ui;

import JavaProject_JohnB_MafuyuL.model.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        PCPart[] myPC = new PCPart[5];
        
        // Constructors match the 11-parameter GPU, 9-parameter CPU, etc.
        myPC[0] = new GPU("TBD", "TBD", now, MaintType.DUSTING, now, 3650, 0, 0L, 0.0, 0.0, "OK");
        myPC[1] = new CPU("TBD", "TBD", now, MaintType.THERMALPASTE, now, 3650, 0, 0.0, 0.0);
        myPC[2] = new RAM("TBD", "TBD", now, MaintType.DUSTING, now, 5475, 0, 0L, 0L);
        myPC[3] = new Storage("TBD", "TBD", now, MaintType.STORAGE, now, 1825, 0, 0L, 0L, "OK");
        myPC[4] = new Fan("TBD", "TBD", now, MaintType.DUSTING, now, 2190, 0, 0);

        MenuWrapper menu = new MenuWrapper(myPC);
        menu.start();
    }
}