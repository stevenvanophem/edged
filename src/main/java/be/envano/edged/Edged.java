package be.envano.edged;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Edged {

    private List<Command> commands = new ArrayList<>();

    public static Edged of() {
        return new Edged();
    }

    public Edged command(Command command) {
        Objects.requireNonNull(command);
        this.commands.add(command);
        return this;
    }

}
