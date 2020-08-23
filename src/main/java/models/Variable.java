package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class Variable {

    private final String name;
    private final List<Memory>memoryList;

    public Variable(String name, List<Memory> memoryList) {
        this.name = name;
        this.memoryList = memoryList;

    }

    public String getName() {
        return name;
    }

    public List<Memory> getMemoryList() {
        return memoryList;
    }

}
