package JavaProject_JohnB_MafuyuL.service;
import java.util.List;

import JavaProject_JohnB_MafuyuL.model.CPU;
import JavaProject_JohnB_MafuyuL.model.Fan;
import JavaProject_JohnB_MafuyuL.model.GPU;
import JavaProject_JohnB_MafuyuL.model.PCPart;
import JavaProject_JohnB_MafuyuL.model.RAM;
import JavaProject_JohnB_MafuyuL.model.Storage;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;
/**
 * Istantiates OSHI, grabs raw telemetry, and constructs/updates PCParts
 */
public class HardwarePollingService {
    private final HardwareAbstractionLayer hal;
    /**
     * Uses a temporary SystemInfo to create the hal to free up memory
     */
    public HardwarePollingService() {
        SystemInfo sysInfo = new SystemInfo();
        this.hal = sysInfo.getHardware();
    }

    public CentralProcessor getCPU() {
        return hal.getProcessor();
    }

    public GlobalMemory getMem() {
        return hal.getMemory();
    }

    public long getAvailable(){
        return hal.getMemory().getAvailable();
    }

    public List<GraphicsCard> getGPU() {
        return hal.getGraphicsCards();
    }

    public int[] getFanSpeeds() {
        return hal.getSensors().getFanSpeeds();
    }

    public double getCPUTemp() {
        return hal.getSensors().getCpuTemperature();
    }
    public double getCPULoad() {
        return hal.getProcessor().getSystemCpuLoad(1000) * 100.0; 
    }

    public long getTotalMemory() {
        return hal.getMemory().getTotal();
    }

    public long getUsedMemory() {
        return hal.getMemory().getTotal() - hal.getMemory().getAvailable();
    }

    public List<oshi.hardware.HWDiskStore> getDisks() {
        return hal.getDiskStores();
    }
    /**
     * PCPart telemetry updater for the brand and model
     */
    public void updatePartTelemetry(PCPart part) {
        switch (part) {
            case CPU cpuPart -> {
                var cpu = getCPU();
                cpuPart.setBrand(cpu.getProcessorIdentifier().getVendor());
                cpuPart.setModel(cpu.getProcessorIdentifier().getModel());
                cpuPart.setCurrentTemp(getCPUTemp());

            }
            case GPU gpuPart -> {
                var gpus = getGPU();
                if (!gpus.isEmpty()) {
                    gpuPart.setBrand(gpus.get(0).getVendor());
                    gpuPart.setModel(gpus.get(0).getName());
                    gpuPart.setVramTotal(gpus.get(0).getVRam());
                    gpuPart.setFanHealth("OK");
                }
                
            }
            case RAM ramPart -> {
                var physMem = getMem().getPhysicalMemory();
                if (!physMem.isEmpty()) {
                    ramPart.setBrand(physMem.get(0).getManufacturer());
                    ramPart.setModel(physMem.get(0).getMemoryType());
                    ramPart.setCapacity(getTotalMemory());
                    ramPart.setCurrentCapacity(getUsedMemory());
                }
                
            }
            case Storage storagePart -> {
                var disks = hal.getDiskStores();
                if (!disks.isEmpty()) {
                    storagePart.setBrand("Hard Drive/SSD");
                    storagePart.setModel(disks.get(0).getModel());
                    storagePart.setTotalSpace(disks.get(0).getSize());
                    storagePart.setFreeSpace(disks.get(0).getSize() / 2); // Placeholder
                    storagePart.setSmartStatus("OK");
                }
                
            }
            case Fan fanPart -> {
                int[] speeds = getFanSpeeds();
                if (speeds.length > 0) {
                    fanPart.setRPM(speeds[0]);
                }
                fanPart.setBrand("System");
                fanPart.setModel("Internal Fan");
            }
            default -> {
            }
        }
    }
}