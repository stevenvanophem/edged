package be.envano.edged;

import java.awt.*;
import java.util.List;
import java.util.Objects;

import javax.swing.*;
import javax.swing.Action;

public class TuiLauncher {

    private final JFrame frame;
    private final Edged.Definitions definitions;

    public TuiLauncher(Edged edged) {
        Objects.requireNonNull(edged);

        this.definitions = edged.definitions();
        this.frame = new JFrame("Edged");
        this.initUI();
    }

    private void initUI() {
        JTextField inputField = new JTextField();
        inputField.setFont(new Font("Monospaced", Font.PLAIN, 16));
        inputField.setCaretColor(Color.GREEN);
        inputField.setForeground(Color.WHITE);
        inputField.setBackground(Color.BLACK);
        inputField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputField.addActionListener(e -> {
            String input = inputField.getText().trim();
            inputField.setText("");
            findCorrelatingActions(input).forEach(action -> {
                switch (action) {
                    case CLOSE_WINDOW -> {
                        frame.dispose();
                    }
                }
            });
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(inputField, BorderLayout.CENTER);
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private List<PredefinedAction> findCorrelatingActions(String input) {
        String trimmedInput = input.trim();
        return definitions.commands().stream()
          .filter(command -> command.definitions().inputs().contains(trimmedInput))
          .flatMap(command -> command.definitions().actions().stream())
          .toList();
    }

}
