package models;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {

    private final List<Process> processList;

    public MemoryManager() {
        processList = new ArrayList<>();
    }

    public List<Process> getProcessList() {
        return processList;
    }


}
