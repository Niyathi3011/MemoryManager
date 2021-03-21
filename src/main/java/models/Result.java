package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
@ToString
@Getter
@AllArgsConstructor
public class Result {
    public enum Type{
        success,error
    }
    private final Type type;
    private final int availableMemory;
    private final int usedMemory;

}
