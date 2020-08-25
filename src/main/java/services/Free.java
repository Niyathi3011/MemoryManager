package services;

import models.Memory;
import models.Process;
import models.Result;
import models.Variable;

import static system.MemoryMangerSystem.*;
import static system.MemoryMangerSystem.getUsedMemory;

public class Free extends MemoryManager {

    @Override
    public Result perform(String[] fields) {

        Process process = getProcessList().get(fields[1]);
        if (process != null) {
            for (Variable variable : process.getVariableList()) {
                if (variable.getName().equalsIgnoreCase(fields[2])) {
                    for (Memory memory : variable.getMemoryList()) {
                        getFreeBlocks().add(memory);
                        int m = memory.getSize();
                        int availableMemory = getAvailableMemory() + m;
                        int unAvailableMemory = getUsedMemory() - m;
                        setMemory(availableMemory,unAvailableMemory);
                    }
                    process.getVariableList().remove(variable);
                    break;
                }
            }

            return new Result(Result.Type.success, getAvailableMemory(), getUsedMemory());
        } else return new Result(Result.Type.error, getAvailableMemory(), getUsedMemory());
    }
}
