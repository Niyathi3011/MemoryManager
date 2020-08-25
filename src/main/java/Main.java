import data.ServiceFactory;
import models.Memory;
import org.slf4j.LoggerFactory;
import services.MemoryManager;
import system.MemoryMangerSystem;

import java.util.Scanner;
import java.util.logging.Logger;

import static data.ServiceFactory.getService;
import static system.MemoryMangerSystem.*;

public class Main {

    //private static final Logger logger = (Logger) LoggerFactory.getLogger(Main.class);

    MemoryMangerSystem memoryMangerSystem=new MemoryMangerSystem();

    public static void main(String[] args) {
        //logger.info("Starting");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total Memory");
        setAvailableMemory(sc.nextInt());
        setUsedMemory(0);
        //logger.info("set the available and use memories to their respective values");
        getFreeBlocks().add(new Memory(0, getAvailableMemory()));
        String s = "Yes";
        while (s.matches("Yes")) {

            String command;
            //logger.info("Taking the command");
            System.out.println("Enter the command");
            command = sc.nextLine();
            String[] commands = command.split(" ");
            //logger.info("Getting the respective service");
            MemoryManager memoryManager = getService((commands[0]));
            //logger.info("Performing");
            memoryManager.perform(commands);
            //logger.info("If we want to enter next command or not");
            System.out.println("Yes/No");
            s = sc.nextLine();

        }
        //logger.info("Done with all the commands");
    }
}

