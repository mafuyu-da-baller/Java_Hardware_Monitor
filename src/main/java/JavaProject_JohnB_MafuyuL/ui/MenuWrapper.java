package JavaProject_JohnB_MafuyuL.ui;
import JavaProject_JohnB_MafuyuL.service.HardwarePollingService;
import JavaProject_JohnB_MafuyuL.service.MaintenanceLogger;
import JavaProject_JohnB_MafuyuL.model.*;
import java.util.Scanner;
/**
 * Handles the Display Menu
 */
public class MenuWrapper{
    private PCPart[] partsList;

    public MenuWrapper(PCParts[] importedParts){
        this.partsList = importedParts;
    }
    /**
     * Main loop that runs while the program is active
     */
    public void start(PCPart[] thisPC){
        Scanner keyboard = new Scanner(System.in);
        MaintenanceLogger myLogger = new MaintenanceLogger();
        int userInput = 0;
        do{
            System.out.println("========================================");
            System.out.println("Make a selection");
            System.out.println("========================================");
            System.out.println("1. Check Stats");
            System.out.println("2. Inspect Part");
            System.out.println("3. Check Upcoming Maintenance");
            System.out.println("4. Enter New Maintenance Log");
            System.out.println("5. Exit");
            System.out.println("========================================");
            userInput = keyboard.nextInt();
            if(userInput == 1){
                //Call overview method
            }
            if(userInput == 2){
                System.out.println("========================================");
                System.out.println("Make a selection");
                System.out.println("========================================");
                System.out.println("1. GPU");
                System.out.println("2. CPU");
                System.out.println("3. RAM");
                System.out.println("4. STORAGE");
                System.out.println("5. FAN");
                System.out.println("========================================");
                userInput = keyboard.nextInt();
                switch(userInput){
                    case 1:
                        thisPC[0].getStats();
                    case 2:
                        thisPC[1].getStats();
                    case 3:
                        thisPC[2].getStats();
                    case 4:
                        thisPC[3].getStats();
                    case 5:
                        thisPC[4].getStats();
                }
            }
            if(userInput == 3){
                //call output() of PCParts w/ maintDate < 1 month
            }
            if(userInput == 4){
                myLogger.createLog(keyboard, partsList);
            }

        }while(userInput != 5);
        keyboard.close();
    }
}