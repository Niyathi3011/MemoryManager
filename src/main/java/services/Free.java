package services;

import models.Process;
import models.Variable;

public class Free extends Service {
    @Override
    public void perform(String[] fields) {

        for(Process process:memoryManager.getProcessList()){
            if(process.getName().equalsIgnoreCase(fields[1]))
                for(Variable variable:process.getVariableList())
                    if(variable.getName().equalsIgnoreCase(fields[2])) {
                        process.getVariableList().remove(variable);
                        break;
                    }
        }

    }
}
