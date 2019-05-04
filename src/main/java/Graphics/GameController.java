package Graphics;

import groffse.Grid;

/*
* This beauty is in control of everything!*/
public final class GameController {

    private static Grid panel_grid;
    private static GameState gameState;
    private static GameStatus gameStatus;

    public static void init() {
        panel_grid = new Grid();
    }

    public static void restart () {
        panel_grid.reset();
    }

    public static GameState getGameState() {
        return gameState;
    }

    public static void setGameState(GameState gs) {
        GameController.gameState = gs;
    }

    private static GameStatus getGameStatus() {
        return gameStatus;
    }

    private static void setGameStatus(GameStatus gs) {
        GameController.gameStatus = gs;
    }
}
