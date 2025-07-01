package be.envano.edged;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EdgedTest {

    @Test
    @DisplayName("I can create a edged thing")
    void testCreateEdged() {
        Edged.of()
          .command(
            Command.on("quit").perform(Action.CLOSE_WINDOW)
          );

    }

}