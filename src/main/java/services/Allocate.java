package services;

import models.Memory;
import models.Process;
import models.Result;
import models.Variable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;
import static models.Result.Type.success;
import static system.MemoryMangerSystem.*;

public class Allocate extends MemoryManager {

    @Override
    public Result perform(String[] fields) {

        Collections.sort(getFreeBlocks(), new Comparator<Memory>() {
            @Override
            public int compare(Memory t1, Memory t2) {
                return t1.getStartBlock() - t2.getStartBlock();
            }
        });

        List<Memory> blocks = new ArrayList<>();
        int blockSize = Integer.valueOf(fields[3]);
        getBlocksAvailable(blockSize, fields[4], blocks);

        if (blocks.size() != 0) {
            int availableMemory = getAvailableMemory() - blockSize;
            int unAvailableMemory = getUsedMemory() + blockSize;
            setMemory(availableMemory, unAvailableMemory);
            allocate(fields[1], fields[2], blocks);
            return new Result(Result.Type.success, getAvailableMemory(), getUsedMemory());


        } else
            return new Result(Result.Type.success, getAvailableMemory(), getUsedMemory());


    }

    public void getBlocksAvailable(int blockSize, String continuityReq, List<Memory> blocks) {
        for (Memory memory : getFreeBlocks()) {
            int size = memory.getSize();
            if (size == blockSize) {
                blocks.add(memory);
                getFreeBlocks().remove(memory);
                break;

            } else if (size > blockSize) {
                Memory memory1= new Memory(memory.getStartBlock() + blockSize, memory.getEndBlock());
                blocks.add(new Memory(memory.getStartBlock(), memory.getStartBlock() + blockSize));
                getFreeBlocks().remove(memory);
                getFreeBlocks().add(memory1);
                break;

            } else {
                if (continuityReq.equalsIgnoreCase("false")) {
                    blocks.add(memory);
                    getFreeBlocks().remove(memory);
                    blockSize = blockSize - size;
                }
            }
        }
    }


    public void allocate(String processName, String variableName, List<Memory> blocks) {

        if (!getProcessList().containsKey(processName))
            getProcessList().put(processName, new Process());

        Variable variable = new Variable(variableName, blocks);
        getProcessList().get(processName).getVariableList().add(variable);


    }

}

