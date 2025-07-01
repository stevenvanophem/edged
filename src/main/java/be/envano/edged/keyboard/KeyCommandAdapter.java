package be.envano.edged.keyboard;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class KeyCommandAdapter extends KeyAdapter {

    private final String prompt;
    private final JTextArea textArea;

    public KeyCommandAdapter(String prompt, JTextArea textArea) {
        this.prompt = prompt;
        this.textArea = textArea;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            keyEvent.consume();
            SwingUtilities.invokeLater(() -> {
                final String fullText = textArea.getText();
                final int lastPrompt = fullText.lastIndexOf(prompt);
                final String command = fullText.substring(lastPrompt + prompt.length()).trim();
                if (command.equalsIgnoreCase(KeyboardCommands.QUIT.name())) {
                    this.closeWindow();
                } else {
                    textArea.append(prompt);
                    textArea.setCaretPosition(textArea.getDocument().getLength());
                }
            });
        }
    }

    private void closeWindow() {
        Window window = SwingUtilities.getWindowAncestor(textArea);
        if (window != null) {
            window.dispose();
        } else {
            System.exit(0);
        }
    }

}
