package org.phm.service;

import org.phm.configuration.IoConfiguration;
import org.phm.exception.FileIoException;
import org.phm.frame.UserInputFrame;

import java.util.logging.Logger;

public class WriteService {
    private final IoConfiguration ioConfiguration;
    private final Logger logger;
    private final UserInputFrame frame;

    public WriteService(IoConfiguration ioConfiguration) {
        this.ioConfiguration = ioConfiguration;
        logger = Logger.getLogger(WriteService.class.getName());
        this.frame = new UserInputFrame();
    }

    public WriteService(IoConfiguration ioConfiguration, Logger logger, UserInputFrame frame) {
        this.ioConfiguration = ioConfiguration;
        this.logger = logger;
        this.frame = frame;
    }

    public void write() {
        try {
            frame.startFrame(ioConfiguration.getWritePath());
        } catch (FileIoException ex) {
            logger.severe("Write file path has not been set. Writing will not be handled");
        }
    }
}
