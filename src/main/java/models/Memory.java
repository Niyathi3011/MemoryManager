package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Memory {

    private final int startBlock;
    private final int endBlock;

    public Memory(int startBlock, int endBlock) {
        this.startBlock = startBlock;
        this.endBlock = endBlock;
    }

    public int getStartBlock() {
        return startBlock;
    }

    public int getEndBlock() {
        return endBlock;
    }
}
