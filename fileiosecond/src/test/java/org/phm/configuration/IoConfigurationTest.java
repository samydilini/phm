package org.phm.configuration;

import org.junit.jupiter.api.Test;
import org.phm.exception.FileIoException;

import static org.junit.jupiter.api.Assertions.*;
import static org.phm.configuration.IoConfiguration.FILE_PATH;


class IoConfigurationTest {
    IoConfiguration ioConfiguration = new IoConfiguration();

    @Test
    public void shouldThrowErrorWhenFilepathIsEmpty() {
        System.setProperty(FILE_PATH, "");

        FileIoException thrown = assertThrows(FileIoException.class, () -> ioConfiguration.getWritePath());

        assertEquals("File path is empty or null", thrown.getMessage());
    }

    @Test
    public void shouldReturnAWriteFilePathWhenSystemVariableSet() throws FileIoException {
        String filePathString = "filePathString/";

        System.setProperty(FILE_PATH, filePathString);
        assertTrue(ioConfiguration.getWritePath().contains(filePathString));
        assertTrue(ioConfiguration.getWritePath().endsWith(".txt"));
    }

}