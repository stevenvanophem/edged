package be.envano.edged;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DefaultCaret;

import be.envano.edged.keyboard.KeyCommandAdapter;

public class Edged {

    private static final String PROMPT = "edged: ";
    private static final String TERMINAL_FONT = "Consolas";
    private static final int FONT_SIZE = 16;
    private static final Color TEXT_COLOR = new Color(192, 192, 192);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Edged().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font(TERMINAL_FONT, Font.PLAIN, FONT_SIZE));
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(TEXT_COLOR);
        textArea.setCaretColor(Color.WHITE);
        textArea.setText(PROMPT);
        textArea.setMargin(new Insets(5, 5, 5, 5));
        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(new PromptDocumentFilter(PROMPT));
        textArea.addKeyListener(new KeyCommandAdapter(PROMPT, textArea));

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
