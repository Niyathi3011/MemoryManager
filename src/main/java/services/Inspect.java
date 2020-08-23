package services;

import static system.MemoryMangerSystem.getProcessList;

import models.Memory;
import models.Process;
import models.Variable;

import java.util.Arrays;

public class Inspect extends MemoryManager {

    @Override
    public void perform(String[] fields) {

        Process process = getProcessList().get(fields[1]);
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
