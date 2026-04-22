/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package JavaProject_JohnB_MafuyuL;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
/**
 *
 * @author jbre9
 */
public class JavaProject {

    public static void main(String[] args) {
        System.out.println("Booting up hardware monitor...");

        // 1. Initialize OSHI
        SystemInfo si = new SystemInfo();
        
        // 2. Grab the Hardware layer
        HardwareAbstractionLayer hal = si.getHardware();
        
        // 3. Get the CPU
        CentralProcessor cpu = hal.getProcessor();

        // 4. Print the name!
        System.out.println("CPU Detected: " + cpu.getProcessorIdentifier().getName());
    }
}
