package org.phm;

import org.phm.configuration.IoConfiguration;
import org.phm.service.WriteService;

public class Main {

    public static void main(String[] args) {
        IoConfiguration ioConfiguration = new IoConfiguration();
        System.out.println("#############################");
        System.out.println("Welcome to File IO write solution");
        WriteService writeService = new WriteService(ioConfiguration);
        writeService.write();

    }
}