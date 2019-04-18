package groffse;

import org.junit.Before;
//import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class PanelTest {


    @Test
    public void testThatPanelIsBomb() {
        Panel panel = new Panel();
        panel.setBomb(true);
        assertEquals(true, panel.isBomb());
    }
    // Test that we can set a number of adjacent bombs and then read that value back
    @Test
    public void testAdjecentBombs() {
        Panel panel = new Panel();
        int number_of_bombs = 5;
        panel.setAdjacentBombs(number_of_bombs);
        assertEquals(number_of_bombs, panel.getAdjacentBombs());
    }

    @Test
    public void testThatPanelIsRevealed() {
        Panel panel = new Panel();
        panel.reveal();
        assertEquals(true, panel.isRevealed());
    }
}