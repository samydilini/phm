package org.phm.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class UserInputFrame {
    private final Logger logger;
    private boolean isTesting = false;

    public UserInputFrame() {
        logger = Logger.getLogger(UserInputFrame.class.getName());
    }

    public UserInputFrame(Logger logger, boolean isTesting) {
        this.logger = logger;
        this.isTesting = isTesting;
    }

    public void startFrame(String writePath) {
        JFrame frame = new JFrame("Text Area Validation Example");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Create the text area
        JTextArea textArea = new JTextArea(5, 20);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create the Save button
        JButton saveButton = new JButton("Save");
        frame.add(saveButton, BorderLayout.SOUTH);

        // Add an action listener to the Save button
        saving(saveButton, textArea, frame, writePath, logger, isTesting);

        closing(frame, logger);
        // Display the frame
        frame.setVisible(true);
    }

    private static void closing(JFrame frame, Logger logger) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Perform any actions needed before closing
                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit before saving?", "Confirm Exit",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (confirm == JOptionPane.YES_OPTION) {
                    logger.info("Performing cleanup before closing...");
                    // Dispose of the frame to close it
                    frame.dispose();
                }
                logger.info("User didn't choose confirm to close. Continuing..");
            }
        });
    }

    private static void saving(JButton saveButton, JTextArea textArea, JFrame frame, String writePath, Logger logger, boolean isTesting) {
        saveButton.addActionListener(e -> {
            // Perform validation on text area content
            String text = textArea.getText().trim();
            if (text.isEmpty()) {
                String message = "Text area cannot be empty!";
                logger.info(message);
                if (!isTesting)
                    JOptionPane.showMessageDialog(frame, message, "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else {
                File file = new File(writePath);
                try (BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
                    output.write(text);
                    String message = "Content saved successfully!";
                    logger.info(message);
                    if (!isTesting)
                        JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                } catch (IOException ex) {
                    String message = "Error saving file: " + ex.getMessage();
                    logger.severe(message);
                    if (!isTesting)
                        JOptionPane.showMessageDialog(frame, message, "Save Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    frame.setEnabled(true);
                }
            }
        });
    }
}
