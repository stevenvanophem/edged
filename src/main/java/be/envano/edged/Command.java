package be.envano.edged;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Command {

    private final List<String> inputs = new ArrayList<>();
    private final List<PredefinedAction> actions = new ArrayList<>();

    public Command(String input) {
        Objects.requireNonNull(input);

        if (input.isBlank())
            throw new IllegalArgumentException("Input cannot be blank");

        this.inputs.add(input);
    }

    public static Command on(String input) {
        return new Command(input);
    }

    public Command perform(PredefinedAction action) {
        Objects.requireNonNull(action);
        this.actions.add(action);
        return this;
    }

    Definitions definitions() {
        return new Definitions(inputs, actions);
    }

    record Definitions(List<String> inputs, List<PredefinedAction> actions) {

        Definitions {
            Objects.requireNonNull(inputs);
            Objects.requireNonNull(actions);
            inputs = List.copyOf(inputs);
            actions = List.copyOf(actions);
        }

    }

}
