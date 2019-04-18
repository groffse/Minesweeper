package groffse;

public class Panel {
    private boolean isBomb;
    private int ID;
    private int adjacentBombs;
    private boolean isRevealed; // If true, the panel should reveal the number of adjacent bombs or that it is a bomb

    public void setBomb(boolean b) {
        isBomb = b;
    }
    public boolean isBomb() {
        return isBomb;
    }
    public void reveal() {isRevealed = true;}
    public int getAdjacentBombs () {return adjacentBombs;}
    public void setAdjacentBombs(int adjacentBombs) {this.adjacentBombs = adjacentBombs;}
    public boolean isRevealed() {return isRevealed;}

}
