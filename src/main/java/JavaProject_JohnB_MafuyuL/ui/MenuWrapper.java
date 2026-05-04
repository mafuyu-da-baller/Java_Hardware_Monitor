package JavaProject_JohnB_MafuyuL.ui;

import java.time.LocalDateTime;
import java.util.Scanner;

import JavaProject_JohnB_MafuyuL.model.PCPart;
import JavaProject_JohnB_MafuyuL.service.DisplayStatusReportService;
import JavaProject_JohnB_MafuyuL.service.HardwarePollingService;
import JavaProject_JohnB_MafuyuL.service.MaintenanceLoggerService;
import JavaProject_JohnB_MafuyuL.util.LifespanCalcUtil;

/**
 * Handles the Display Menu
 */
public class MenuWrapper{
    private final PCPart[] partsList;
    private final DisplayStatusReportService reportService;
    private final HardwarePollingService poller;

    public MenuWrapper(PCPart[] importedParts){
        this.partsList = importedParts;
        this.reportService = new DisplayStatusReportService();
        this.poller = new HardwarePollingService();
    }
    /**
     * Main loop that runs while the program is active
     */
    public void start(){
        Scanner keyboard = new Scanner(System.in);
        // Correctly instantiated the logging service
        MaintenanceLoggerService logger = new MaintenanceLoggerService(); 
        int userInput = 0;

        do{
            /**
             * Display Screen and take input
             */
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
            /**
             * Output the general Telemetry
             */
            if(userInput == 1){
                // Update live telemetry before printing
                for (PCPart p : partsList) {
                    poller.updatePartTelemetry(p);
                }
                reportService.printOverview(partsList, poller);
            }
            //Output submenu and collect input again
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
                int subMenuInput = keyboard.nextInt();
                //Input Validation and refresh telemetry
                if (subMenuInput >= 1 && subMenuInput <= partsList.length) {
                    PCPart selectedPart = partsList[subMenuInput - 1];
                    poller.updatePartTelemetry(selectedPart);
                    reportService.printStatusReport(selectedPart);
                } else {
                    System.out.println("Invalid selection.");
                }
            }
            //Output upcoming maintenance needed
            if(userInput == 3){
                System.out.println("========== Upcoming Maintenance & Replacements ==========");
                boolean foundIssue = false;
                //Go through all parts to check the maintenance needed
                for (PCPart p : partsList) {
                    //Check the MaintenanceMap
                    if (!p.getMaintenanceMap().isEmpty()) {
                        for (var entry : p.getMaintenanceMap().entrySet()) {
                            // Updated to use LocalDateTime and daysBetween
                            long daysUntilMaint = JavaProject_JohnB_MafuyuL.util.DateFormatterUtil.daysBetween(LocalDateTime.now(), entry.getValue());
                            
                            //Flags if maintenance is due in 30 or less days
                            //Will output everything with 0s until initialized by the user 
                            if (daysUntilMaint <= 30) { 
                                System.out.print("Maintenance needed: [" + p.getName() + "] needs " + entry.getKey());
                                if (daysUntilMaint < 0) {
                                    System.out.println(" (Overdue by " + Math.abs(daysUntilMaint) + " days)");
                                } else {
                                    System.out.println(" in " + daysUntilMaint + " days.");
                                }
                                foundIssue = true;
                            }
                        }
                    }
                    
                    //Check EOL using calcLifespan
                    long daysLeft = LifespanCalcUtil.calcLifespan(p);
                    if (daysLeft >= 0 && daysLeft <= 30) {
                        System.out.println("Replacement suggested: [" + p.getName() + "] nears estimated End-of-Life in " + daysLeft + " days.");
                        foundIssue = true;
                    }
                }
                
                if (!foundIssue) {
                    System.out.println("All parts are healthy. No maintenance or replacements required in the near future.");
                }
            }

            if(userInput == 4){
                logger.createLog(keyboard, partsList);
            }

        }while (userInput != 5);
        
        System.out.println("Shutting down monitor...");
        keyboard.close();
    }
}