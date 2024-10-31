package org.phm.read.service;

import org.phm.configuration.IoConfiguration;
import org.phm.exception.FileIoException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

public class ReadService {
    private final Logger logger;
    private final IoConfiguration ioConfiguration;

    public ReadService(IoConfiguration ioConfiguration) {
        this.ioConfiguration = ioConfiguration;
        logger = Logger.getLogger(ReadService.class.getName());
    }

    //unit testing purposes
    public ReadService( IoConfiguration ioConfiguration, Logger logger) {
        this.ioConfiguration = ioConfiguration;
        this.logger = logger;
    }

    public void read() {

        try {
            Scanner in = new Scanner(new FileReader(ioConfiguration.getReadFilePath()));
            while(in.hasNext()) {
                System.out.println(in.nextLine());
            }
            in.close();
        } catch (FileNotFoundException | FileIoException e) {
            logger.severe("Error while reading the file.");
        }

    }
}
