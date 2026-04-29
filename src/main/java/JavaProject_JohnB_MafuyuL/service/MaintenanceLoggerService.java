package JavaProject_JohnB_MafuyuL.service;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class MaintenanceLoggerService {
    /**
     * This creates a new Maintenance Log and saves it to a file using writeToFile
     * @param keyboard defines the user's input
     * @param partsList defines the different types of PCParts
     *  */    
    public void createLog(Scanner keyboard, PCPart[] partsList) {
        // Get the Part by String
        System.out.println("Which part was maintained?");
        String partInput = keyboard.next().toUpperCase();
        
        PCPart selectedPart = null;
        
        // Loop through the array to find the matching part name
        for (PCPart p : partsList) {
            if (p.getName().equals(partInput)) { 
                selectedPart = p;
                break;
            }
        }
        // Input validation
        if (selectedPart == null) {
            System.out.println("Error: Part '" + partInput + "' not found.");
            return;
        }
        //Get the MaintType
        System.out.println("What type of maintenance was done?");
        System.out.println("(Options: DUSTING, LUBRICATING, THERMALPASTE, STORAGE, FILTER, COOLANT)");
        String typeInput = keyboard.next().toUpperCase();
        MaintType selectedType;
        //Try to convert to MaintType
        try {
            selectedType = MaintType.valueOf(typeInput); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid maintenance type.");
            return;
        }
        //Create the Log and call writeToFile
        MaintLog newEntry = new MaintLog(selectedPart, LocalDate.now(), selectedType);
        writeToFile(newEntry);
        System.out.println("Log successfully saved!");
    }
    /**
     * @param entry defines the new maintenance log to be stored
     */
    private void writeToFile(MaintLog entry) {
        try (PrintWriter out = new PrintWriter(new FileWriter("maint_history.txt", true))) {
            out.println(entry.toString());
        } catch (IOException e) {
            System.out.println("Error: Could not save log.");
        }
    }
}