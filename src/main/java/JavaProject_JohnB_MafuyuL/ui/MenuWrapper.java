package JavaProject_JohnB_MafuyuL.ui;
import JavaProject_JohnB_MafuyuL.service.HardwarePollingService;
import JavaProject_JohnB_MafuyuL.service.MaintenanceLoggerService;
import JavaProject_JohnB_MafuyuL.model.*;

import java.util.Scanner;

import JavaProject_JohnB_MafuyuL.service.MaintenanceLoggerService;
/**
 * Handles the Display Menu
 */
public class MenuWrapper{
    private PCPart[] partsList;

    public MenuWrapper(PCPart[] importedParts){
        this.partsList = importedParts;
    }
    /**
     * Main loop that runs while the program is active
     */
    public void start(PCPart[] thisPC){
        Scanner keyboard = new Scanner(System.in);
        MaintenanceLoggerService myLogger = new MaintenanceLoggerService();
        int userInput = 0;
        do{
            System.out.println("========================================");
            System.out.println("Make a selection");
            System.out.println("========================================");
            System.out.println("1. Check Stats");
            System.out.println("2. Check Upcoming Maintenance");
            System.out.println("3. Enter New Maintenance Log");
            System.out.println("4. Exit");
            System.out.println("========================================");
            userInput = keyboard.nextInt();
            if(userInput == 1){
                System.out.println(toString(partsList[0]));
                System.out.println(toString(partsList[1]));
                System.out.println(toString(partsList[2]));
                System.out.println(toString(partsList[3]));
                System.out.println(toString(partsList[4]));
            }
            if(userInput == 2){
                //Call lifespanCalc and print if less than a month away
                // if()System.out.println("");
                // if()System.out.println("");
                // if()System.out.println("");
                // if()System.out.println("");
                // if()System.out.println("");
            }
            if(userInput == 3){
                myLogger.createLog(keyboard, partsList);
            }

        }while(userInput != 5);
        keyboard.close();
    }
}