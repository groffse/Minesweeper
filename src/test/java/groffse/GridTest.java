package groffse;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GridTest {


    @Test
    public void testSetHeight() {
        Grid grid = new Grid();
        int height = 9;
        grid.setHeight(height);
        assertEquals(height, grid.getHeight());
    }

    @Test
    public void testSetWidth() {
        Grid grid = new Grid();
        int width = 2;
        grid.setWidth(width);
        assertEquals(width, grid.getWidth());
    }

    @Test
    public void testSetNumberOfBombs() {
        Grid grid = new Grid();
        grid.setWidth(10);
        grid.setHeight(10);
        int numberOfBombs = 10;
        grid.setNumberOfBombs(numberOfBombs);
        assertEquals(numberOfBombs, grid.getNumberOfBombs());
    }

    @Test
    public void testThatExceptionIsThrownWhenNumberOfBombsIsGreaterThanPanels() {
        Grid grid = new Grid();
        int height = 2;
        int width = 2;
        int numberOfBombs = (height*width) + 1;
        grid.setHeight(height);
        grid.setWidth(width);
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class,
                        ()-> grid.setNumberOfBombs(numberOfBombs),
                        "The number of bombs is greater than the number of panels. Expected setNumberOfBombs() to throw");
        assertTrue(thrown.getMessage().contains("Number of bombs has to be less than height * width"));
    }

    // If height and width does not a equal, an exception should be thrown when we fill the grid with bombs and numbers
    @Test
    public void testThatExcpetionIsThrownWhenGridIsNotSquare(){
        Grid grid = new Grid();
        grid.setHeight(4);
        grid.setHeight(5);
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class,
                        () -> grid.generateBoard(),
                        "Grid is not a square. Expected generateBoard to throw");
        assertTrue(thrown.getMessage().contains("Width and height has to be equal!"));
    }

    @Test
    public void testReset() {
        Grid grid = new Grid();
        grid.setHeight(5);
        grid.setWidth(5);
    }

}