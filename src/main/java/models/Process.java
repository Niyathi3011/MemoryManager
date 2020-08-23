package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Getter
public class Process {

    private final List<Variable> variableList;

   public List<Variable> getVariableList() {
        return variableList;
    }

    public Process() {
        this.variableList = new ArrayList<>();
    }

}
