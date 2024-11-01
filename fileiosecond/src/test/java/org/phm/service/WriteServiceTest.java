package org.phm.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.phm.configuration.IoConfiguration;
import org.phm.exception.FileIoException;
import org.phm.frame.UserInputFrame;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WriteServiceTest {
    private WriteService writeService;
    private IoConfiguration mockIoConfiguration;
    private Logger mockLogger;
    private UserInputFrame mockFrame;

    @BeforeEach
    public void setUp() {
        mockIoConfiguration = Mockito.mock(IoConfiguration.class);
        mockLogger = Mockito.mock(Logger.class, "XXXX");
        mockFrame = Mockito.mock(UserInputFrame.class, "RRRRRR");
        writeService = new WriteService(mockIoConfiguration, mockLogger, mockFrame);
    }

    @Test
    public void logErrorWhenPathNotSet() throws FileIoException {
        when(mockIoConfiguration.getWritePath()).thenThrow(new FileIoException("my error"));
        writeService.write();

        verify(mockFrame, times(0)).startFrame(anyString());
        verify(mockLogger).severe("Write file path has not been set. Writing will not be handled");
        verify(mockIoConfiguration).getWritePath();
    }

    @Test
    public void shouldInvokeFrameWhenPathIsSet() throws FileIoException {
        when(mockIoConfiguration.getWritePath()).thenReturn("myPath");

        writeService.write();

        verify(mockLogger, times(0)).severe(anyString());
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(mockFrame).startFrame(argument.capture());
        assertEquals("myPath", argument.getValue());
        verify(mockIoConfiguration).getWritePath();
    }
}