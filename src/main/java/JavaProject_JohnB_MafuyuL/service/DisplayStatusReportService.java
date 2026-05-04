package JavaProject_JohnB_MafuyuL.service;

import java.time.LocalDateTime;

import JavaProject_JohnB_MafuyuL.model.PCPart;
import JavaProject_JohnB_MafuyuL.util.DateFormatterUtil;
import JavaProject_JohnB_MafuyuL.util.LifespanCalcUtil;

public class DisplayStatusReportService {
    /**
     * Prints a report on a specific PCPart
     */
    public void printStatusReport(PCPart part) {
        System.out.println("==========" + part.getName() + "==========");
        System.out.println("Brand/Model: " + part.getBrand() + " " + part.getModel());
        
        //Use Utilities for calculations
        LocalDateTime projectedEnd = LifespanCalcUtil.calcEOL(part);
        long daysLeft = LifespanCalcUtil.calcLifespan(part);
        
        System.out.println("Install Date: " + DateFormatterUtil.convertDate(part.getInstallDate()));
        System.out.println("Estimated Replacement: " + DateFormatterUtil.convertDate(projectedEnd));
        System.out.println("Days of Life Remaining: " + (daysLeft >= 0 ? daysLeft : "N/A"));
        System.out.println("==============================");
    }
    /**
     * Prints a general overview of PCParts
     */
    public void printOverview(PCPart[] parts, HardwarePollingService poller) {
        System.out.println("========== System Overview ==========");
        //Live telemetry from the Polling Service File
        System.out.println("Components Found: ");
        for (PCPart p : parts) {
            System.out.println("[ " + p.getName() + " ]");
            System.out.println("==============================");
        }
        System.out.println("========== Live Reports ==========");
        //CPU Temp
        System.out.println("CPU Temp: " + poller.getCPUTemp() + "°C");
        System.out.println("CPU Load: " + poller.getCPULoad());
        //Fan speeds
        int[] fans = poller.getFanSpeeds();
        for (int i = 0; i < fans.length; i++) {
            System.out.println("Fan " + (i + 1) + ": " + fans[i] + " RPM");
        }
        //Memory
        System.out.println("Total Physical Memory: " + poller.getMem());
        System.out.println("Available Memory: " + (poller.getAvailable() / 1073741824L) + " GB");
    }
}