import data.ServiceFactory;
import models.Memory;
import services.MemoryManager;
import system.MemoryMangerSystem;

import java.util.Scanner;

import static data.ServiceFactory.getService;
import static system.MemoryMangerSystem.*;

public class Main {

    MemoryMangerSystem memoryMangerSystem = new MemoryMangerSystem();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total Memory");
        setAvailableMemory(sc.nextInt());
        setUsedMemory(0);
        getFreeBlocks().add(new Memory(0, getAvailableMemory()));
        String s = "Yes";
        while (s.matches("Yes")) {

            String command;
            System.out.println("Enter the command");
            command = sc.nextLine();
            String[] commands = command.split(" ");
            MemoryManager memoryManager=getService(commands[0]);
            memoryManager.perform(commands);

            System.out.println("Yes/No");
            s = sc.nextLine();

        }
    }
}

