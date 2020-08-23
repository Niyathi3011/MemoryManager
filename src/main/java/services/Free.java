package services;

import models.Memory;
import models.Process;
import models.Result;
import models.Variable;

import java.util.List;

import static system.MemoryMangerSystem.*;
import static system.MemoryMangerSystem.getUsedMemory;

public class Free extends MemoryManager {

    @Override
    public void perform(String[] fields) {

        Process process = getProcessList().get(fields[1]);
        if (process != null) {
            for (Variable variable : process.getVariableList()) {
                if (variable.getName().equalsIgnoreCase(fields[2])) {
                    for (Memory memory : variable.getMemoryList()) {
                        getFreeBlocks().add(memory);
                        int m = memory.getSize();
                        setAvailableMemory(getAvailableMemory() + m);
                        setUsedMemory(getUsedMemory() - m);
                    }
                    process.getVariableList().remove(variable);
                    break;
                }
            }

            new Result(Result.Type.success,getAvailableMemory(),getUsedMemory());
        }
        else new Result(Result.Type.error,getAvailableMemory(),getUsedMemory());
    }
}
