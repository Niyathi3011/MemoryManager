package services;

import models.MemoryManager;
import models.Process;

public abstract class Service {
      MemoryManager memoryManager;
      abstract public void perform(String []fields);
      public static void calculateMemory(){

      }
}
