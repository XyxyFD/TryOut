package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    @Test
    public void testInitialSetup() {
        TicTacToe game = new TicTacToe();
        assertNotNull(game);
    }
}
