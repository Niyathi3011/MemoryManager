package services;

import models.Memory;
import models.Process;
import models.Result;
import models.Variable;

import static system.MemoryMangerSystem.*;

public class Inspect extends MemoryManager {

    @Override
    public Result perform(String[] fields) {

        Process process = getProcessList().get(fields[1]);
        extractedMethod(process);

        return new Result(Result.Type.success,getUsedMemory(),getAvailableMemory());

    }

    private void extractedMethod(Process process) {
        for (Variable variable : process.getVariableList()) {
            StringBuilder sb = new StringBuilder();
            sb.append(variable.getName());
            for (Memory memory : variable.getMemoryList()) {
                sb.append(memory.getStartBlock());
                sb.append("-");
                sb.append(memory.getEndBlock());

            }
            System.out.println(sb.toString());
        }
    }
}
