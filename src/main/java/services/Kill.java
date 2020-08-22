package services;

import models.MemoryManager;
import models.Process;

public class Kill extends Service {

    @Override
    public void perform(String[] fields) {
        for(Process p:memoryManager.getProcessList())
            if(p.getName().equalsIgnoreCase(fields[1]))
                memoryManager.getProcessList().remove(p);
    }
}
