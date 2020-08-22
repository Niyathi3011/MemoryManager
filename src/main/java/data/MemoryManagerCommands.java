package data;

import services.*;

public class MemoryManagerCommands {

    private static int NUMBER_OF_BLOCKS;
    private static void implementCommands(String command){
        String [] fields=command.split(" ");

        Service service;
        switch(fields[0]){
            case "allocate": service=new Allocate();break;
            case "kill":service=new Kill();break;
            case "inspect":service=new Inspect();break;
            case "free":service=new Free();break;
            default:
                throw new IllegalStateException("Unexpected value: " + fields[0]);
        }
        service.perform(fields);

    }

}
