package be.envano.edged;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Edged {

    private static final String PROMPT = "edged: ";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Edged().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setCaretColor(Color.WHITE);
        textArea.setText(PROMPT);

        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setBlinkRate(500); // blink every 500 ms

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null);

        JFrame frame = new JFrame("Edged");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        textArea.requestFocusInWindow();
    }

}
