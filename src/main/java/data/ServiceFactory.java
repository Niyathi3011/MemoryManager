package data;
import system.MemoryMangerSystem;
import services.*;

public class ServiceFactory {

    public static MemoryManager getService(String field){

        switch (field){
            case "allocate": return new Allocate();
            case "kill":return new Kill();
            case "inspect":return new Inspect();
            case "free":return new Free();
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }
    }
}
