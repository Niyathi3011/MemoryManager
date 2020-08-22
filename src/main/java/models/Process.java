package models;

import java.util.ArrayList;
import java.util.List;

public class Process {

    private final String name;
    private List<Variable>variableList;

    public Process(String name) {
        this.name = name;
        this.variableList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Variable> getVariableList() {
        return variableList;
    }
}
