package groffse;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Grid {
    private ArrayList<ArrayList<Panel>> panel_grid;
    private int width;
    private int height;
    private int numberOfBombs;
    private int flaggedPanels;

    /*Public methods*/

    Grid() {
        panel_grid = new ArrayList<ArrayList<Panel>>();
        width = 0;
        height = 0;
        numberOfBombs = 0;
    }

    public void reset() {

    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setNumberOfBombs(int numberOfBombs) {
        if(numberOfBombs > width*height)
            throw new IllegalArgumentException("Number of bombs has to be less than height * width");
        this.numberOfBombs = numberOfBombs;
    }

    public int getHeight() {return height;}

    public int getWidth() {return width;}

    public int getNumberOfBombs() {
        return numberOfBombs;
    }

    public void floodFill() {

    }

    public void generateBoard() {
        if(height != width)
            throw new IllegalArgumentException("Width and height has to be equal!");
    }

    /*Private methods*/

    private ArrayList<Integer> generate_bomb_positions() {
        ArrayList<Integer> bomb_positions = new ArrayList<Integer>();
        return bomb_positions;
    }

}
