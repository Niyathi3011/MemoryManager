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
        boolean flag = false;

        for (Memory m : getFreeBlocks()) {
            int size = m.getEndBlock() - m.getStartBlock();
            if (size == blockSize) {
                blocks.add(m);
                getFreeBlocks().remove(m);
                flag = true;
                break;

            } else if (size > blockSize) {
                Memory memory = new Memory(m.getStartBlock() + blockSize, m.getEndBlock());
                blocks.add(new Memory(m.getStartBlock(), m.getStartBlock() + blockSize));
                getFreeBlocks().remove(m);
                getFreeBlocks().add(memory);
                flag = true;
                break;

            } else if (size < blockSize && fields[3].equalsIgnoreCase("false")) {
                blocks.add(m);
                getFreeBlocks().remove(m);
                blockSize = blockSize - size;

            }

        }

        if (flag || blockSize == 0) {
            allocate(fields[1], fields[2], blocks);
        }


    }

    public void allocate(String processName, String variableName, List<Memory> blocks) {

        if (!getProcessList().containsKey(processName))
            getProcessList().put(processName, new Process());

        Variable variable = new Variable(variableName, blocks);
        getProcessList().get(processName).getVariableList().add(variable);

    }
}
