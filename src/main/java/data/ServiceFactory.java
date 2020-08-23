package data;
import system.MemoryMangerSystem;
import services.*;

public class ServiceFactory {

    public static MemoryManager getService(String field){

        switch (field){
            case "allocate": return new Allocate();break;
            case "kill":return new Kill();break;
            case "inspect":return new Inspect();break;
            case "free":return new Free();break;
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }
    }
}
