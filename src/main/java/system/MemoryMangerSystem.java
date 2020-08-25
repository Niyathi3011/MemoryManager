package system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import models.Memory;
import models.Process;
import services.MemoryManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public final class MemoryMangerSystem {

    private static int availableMemory;
    private static int usedMemory;
    private static List<Memory>freeBlocks;

    public MemoryMangerSystem() {
    }

    private static HashMap<String,Process>processList;

    public static int getAvailableMemory() {
        return availableMemory;
    }

    public static int getUsedMemory() {
        return usedMemory;
    }

    public static List<Memory> getFreeBlocks() {
        return freeBlocks;
    }

    public static HashMap<String, Process> getProcessList() {
        return processList;
    }


    public static void setMemory(int available,int unavailableMemory){
        usedMemory=unavailableMemory;
        availableMemory=available;
    }



}
