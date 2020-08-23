package data;

import services.*;

public class ServiceFactory {

    public static void getService(String field){
        MemoryManager memoryManager;
        switch (field){
            case "allocate": memoryManager= new Allocate();break;
            case "kill":memoryManager=new Kill();break;
            case "inspect":memoryManager=new Inspect();break;
            case "free":memoryManager=new Free();break;
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }
    }
}
