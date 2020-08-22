package models;

public class Result {
    public enum Type{
        success,error
    }
    private final Type type;
    private final int availableMemory;
    private final int usedMemory;

    public Result(Type type, int availableMemory, int usedMemory) {
        this.type = type;
        this.availableMemory = availableMemory;
        this.usedMemory = usedMemory;
    }

    public Type getType() {
        return type;
    }

    public int getAvailableMemory() {
        return availableMemory;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    @Override
    public String toString() {
        return "Result{" +
                "type=" + type +
                ", availableMemory=" + availableMemory +
                ", usedMemory=" + usedMemory +
                '}';
    }
}
