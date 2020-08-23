package system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import models.Memory;
import models.Process;
import services.MemoryManager;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public class MemoryMangerSystem {

    private static int availableMemory;
    private static int usedMemory;
    private static List<Memory>freeBlocks;
    private static HashMap<String, Process>processList;

    public static List<Memory> getFreeBlocks() {
        return freeBlocks;
    }

    private static MemoryManager memoryManager;

    public static int getAvailableMemory() {
        return availableMemory;
    }

    public static void setAvailableMemory(int availableMemory) {
        MemoryMangerSystem.availableMemory = availableMemory;
    }

    public static int getUsedMemory() {
        return usedMemory;
    }

    public static void setUsedMemory(int usedMemory) {
        MemoryMangerSystem.usedMemory = usedMemory;
    }

    public static HashMap<String, Process> getProcessList() {
        return processList;
    }

    public static MemoryManager getMemoryManager() {
        return memoryManager;
    }
}
