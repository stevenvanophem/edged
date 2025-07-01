package be.envano.edged;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Command {

    private final List<String> inputs = new ArrayList<>();
    private final List<Action> actions = new ArrayList<>();

    public Command(String input) {
        Objects.requireNonNull(input);

        if (input.isBlank())
            throw new IllegalArgumentException("Input cannot be blank");

        this.inputs.add(input);
    }

    public static Command on(String input) {
        return new Command(input);
    }

    public Command perform(Action action) {
        Objects.requireNonNull(action);
        this.actions.add(action);
        return this;
    }

}
