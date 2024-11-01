package org.phm.configuration;

import org.junit.jupiter.api.Test;
import org.phm.exception.FileIoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.phm.configuration.IoConfiguration.FILE_PATH;
import static org.phm.configuration.IoConfiguration.READ_FILE;


class IoConfigurationTest {
    IoConfiguration ioConfiguration = new IoConfiguration();


    @Test
    public void shouldReturnCorrectReadFilePathWhenSystemVariableSet() throws FileIoException {
        String filePathString = "filePathString/";

        System.setProperty(FILE_PATH, filePathString);

        assertEquals(filePathString + READ_FILE, ioConfiguration.getReadFilePath());
    }

    @Test
    public void shouldThrowErrorWhenFilepathIsEmpty() {
        System.setProperty(FILE_PATH, "");

        FileIoException thrown = assertThrows(FileIoException.class, () -> ioConfiguration.getReadFilePath());

        assertEquals("File path is empty or null", thrown.getMessage());
    }

}