package org.phm.frame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class UserInputFrameTest {
    @Mock
    private Logger mockLogger;
    private UserInputFrame userInputFrame;
    private JFrame frame;
    private JButton saveButton;

    @BeforeEach
    public void setUp() {
        mockLogger = Mockito.mock(Logger.class);
        userInputFrame = new UserInputFrame(mockLogger, true);
        frame = Mockito.mock(JFrame.class);
        saveButton = new JButton("myButton");
        frame.add(saveButton);

    }

    @Test
    public void logTextAreaEmptyValidation() {
        Method saveMethod;
        try {
            saveMethod = UserInputFrame.class.getDeclaredMethod("saving", JButton.class, JTextArea.class, JFrame.class, String.class, Logger.class, boolean.class);
            saveMethod.setAccessible(true);

            JTextArea textArea = new JTextArea("");

            String writePath = "myPath";
            saveMethod.invoke(userInputFrame, saveButton, textArea, frame, writePath, mockLogger, true);

            saveButton.doClick();

            ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
            verify(mockLogger).info(argument.capture());
            assertEquals("Text area cannot be empty!", argument.getValue());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void logErrorOnIOException() {
        Method saveMethod;
        try {
            saveMethod = UserInputFrame.class.getDeclaredMethod("saving", JButton.class, JTextArea.class, JFrame.class, String.class, Logger.class, boolean.class);
            saveMethod.setAccessible(true);

            JTextArea textArea = new JTextArea("my text");

            String writePath = "/invalid/path/to/file.txt";
            saveMethod.invoke(userInputFrame, saveButton, textArea, frame, writePath, mockLogger, true);

            saveButton.doClick();

            ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
            verify(mockLogger).severe(argument.capture());
            System.out.println("################");
            System.out.println(argument.getValue());
            assertEquals("Error saving file: /invalid/path/to/file.txt (No such file or directory)", argument.getValue());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldWriteToMethodIfAllConditionsRight() {
        Method saveMethod = null;
        try {
            saveMethod = UserInputFrame.class.getDeclaredMethod("saving", JButton.class, JTextArea.class, JFrame.class, String.class, Logger.class, boolean.class);
            saveMethod.setAccessible(true);

            JTextArea textArea = new JTextArea("my text");

            String writePath = "src/test/resources/testFile.txt";
            saveMethod.invoke(userInputFrame, saveButton, textArea, frame, writePath, mockLogger, true);

            saveButton.doClick();

            ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
            verify(mockLogger).info(argument.capture());
            System.out.println("################");
            System.out.println(argument.getValue());
            assertEquals("Content saved successfully!", argument.getValue());
            verify(frame).dispose();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}