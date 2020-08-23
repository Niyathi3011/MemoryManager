package services;

import models.Memory;
import models.Result;
import models.Variable;
import system.MemoryMangerSystem;

import static system.MemoryMangerSystem.*;

public class Kill extends MemoryManager {

    @Override
    public void perform(String[] fields) {

        if (getProcessList().containsKey(fields[1])) {
            for (Variable variable : getProcessList().get(fields[1]).getVariableList()) {
                for (Memory memory : variable.getMemoryList()) {
                    getFreeBlocks().add(memory);
                    int m = memory.getSize();
                    setAvailableMemory(getAvailableMemory() + m);
                    setUsedMemory(getUsedMemory() - m);
                }
            }
            getProcessList().remove(fields[1]);
            new Result(Result.Type.success, getAvailableMemory(), getUsedMemory());

        } else
            new Result(Result.Type.error, getAvailableMemory(), getUsedMemory());

    }
}
