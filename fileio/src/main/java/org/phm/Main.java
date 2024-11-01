package org.phm;

import org.phm.configuration.IoConfiguration;
import org.phm.read.service.ReadService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IoConfiguration ioConfiguration = new IoConfiguration();
        System.out.println("#############################");
        System.out.println("Welcome to File IO solution");
        System.out.println("To get to the read solution enter 1 \n to exit enter X");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String inString;

        do {

            inString = scanner.nextLine().trim().toUpperCase();
            switch (inString) {
                case "1":
                    System.out.println("You've selected read");
                    ReadService readService = new ReadService(ioConfiguration);
                    readService.read();
                    break;
                case "X":
                    System.out.println("You are exiting the system");
                    break;
                default:
                    System.out.println(inString + " is not a valid input");
            }
        } while (!inString.equals("X"));

        scanner.close();
        System.out.println("#############################");
    }
}