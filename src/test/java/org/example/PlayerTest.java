package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testPlayerMarker() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }
}
