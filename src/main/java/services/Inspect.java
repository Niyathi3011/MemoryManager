package services;

import models.Process;

import java.util.Arrays;

public class Inspect extends Service {
    @Override
    public void perform(String[] fields) {
       for(Process p: memoryManager.getProcessList())
           if(p.getName().equalsIgnoreCase(fields[1]))
               System.out.println(Arrays.toString(p.getVariableList().toArray()));
    }
}
