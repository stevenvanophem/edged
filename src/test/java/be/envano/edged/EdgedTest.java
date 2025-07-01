package be.envano.edged;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sun.jdi.PathSearchingVirtualMachine;

class EdgedTest {

    public static void main(String[] args) {
        Edged edged = Edged.of()
          .command(
            Command.on("quit").perform(PredefinedAction.CLOSE_WINDOW)
          );

        new TuiLauncher(edged);

    }

    @Test
    @DisplayName("I can create a edged thing")
    void testCreateEdged() {
        Edged edged = Edged.of()
          .command(
            Command.on("quit").perform(PredefinedAction.CLOSE_WINDOW)
          );

        new TuiLauncher(edged);

    }

}