package org.phm.read.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.phm.configuration.IoConfiguration;
import org.phm.exception.FileIoException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReadServiceTest {
    private ReadService readService;
    private IoConfiguration mockIoConfiguration;
    private Logger mockLogger;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        mockIoConfiguration = Mockito.mock(IoConfiguration.class);
        mockLogger = Mockito.mock(Logger.class);
        readService = new ReadService(mockIoConfiguration, mockLogger);
    }

    @Test
    public void successfullyReadFileWhenCorrectPathReturned() throws FileIoException {
        when(mockIoConfiguration.getReadFilePath()).thenReturn("src/test/resources/testFile.txt");
        readService.read();
        assertEquals("this is the test file", outContent.toString().replace("\n", "")
                .replace("\r", ""));
    }

    @Test
    public void logErrorWhenFileNotFound() throws FileIoException {
        when(mockIoConfiguration.getReadFilePath()).thenReturn("src/test/resources/noFile.txt");
        readService.read();
        assertEquals("", outContent.toString().replace("\n", "")
                .replace("\r", ""));
        verify(mockLogger).severe("Error while reading the file.");
    }

    @Test
    public void logErrorWhenPathNotConfigured() throws FileIoException {
        when(mockIoConfiguration.getReadFilePath()).thenThrow(new FileIoException("my error"));
        readService.read();
        assertEquals("", outContent.toString().replace("\n", "")
                .replace("\r", ""));
        verify(mockLogger).severe("Error while reading the file.");
    }
}