package services;

import models.Memory;
import models.Process;
import models.Result;
import models.Variable;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;
import static models.Result.Type.success;
import static system.MemoryMangerSystem.*;

public class Allocate extends MemoryManager {

    @Override
    public void perform(String[] fields) {

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
            setUsedMemory(getUsedMemory() + blockSize);
            setAvailableMemory(getAvailableMemory() - blockSize);
            allocate(fields[1], fields[2], blocks);


        } else
            new Result(Result.Type.success, getAvailableMemory(), getUsedMemory()).toString();


    }

    public void getBlocksAvailable(int blockSize, String continuityReq, List<Memory> blocks) {
        for (Memory m : getFreeBlocks()) {
            int size = m.getSize();
            if (size == blockSize) {
                blocks.add(m);
                getFreeBlocks().remove(m);
                break;

            } else if (size > blockSize) {
                Memory memory = new Memory(m.getStartBlock() + blockSize, m.getEndBlock());
                blocks.add(new Memory(m.getStartBlock(), m.getStartBlock() + blockSize));
                getFreeBlocks().remove(m);
                getFreeBlocks().add(memory);
                break;

            } else {
                if (continuityReq.equalsIgnoreCase("false")) {
                    blocks.add(m);
                    getFreeBlocks().remove(m);
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
        new Result(Result.Type.success, getAvailableMemory(), getUsedMemory()).toString();


    }

    public boolean checkAvailability(int size) {
        if (size > getAvailableMemory() * 0.25) {
            new Result(success, getAvailableMemory(), getUsedMemory()).toString();
            return false;
        }
        return true;

    }
}

