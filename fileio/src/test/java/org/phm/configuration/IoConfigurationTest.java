package org.phm.configuration;

import org.junit.jupiter.api.Test;
import org.phm.exception.FileIoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class IoConfigurationTest {
    IoConfiguration ioConfiguration = new IoConfiguration();


    @Test
    public void testReturningCorrectFilePathVariableProperlySet() throws FileIoException {
        String filePathString = "filePathString";

        System.setProperty("file.path", filePathString);

        assertEquals(filePathString, ioConfiguration.getReadFilePath());
    }

    @Test
    public void shouldThrowErrorWhenFilepathIsEmpty() {
        System.setProperty("file.path", "");

        FileIoException thrown = assertThrows(FileIoException.class, () -> ioConfiguration.getReadFilePath());

        assertEquals("File path is empty or null", thrown.getMessage());
    }

}