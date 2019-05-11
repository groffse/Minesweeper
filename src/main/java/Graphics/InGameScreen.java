package Graphics;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.GuiComponent;
import de.gurkenlabs.litiengine.gui.ImageComponentList;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.Input;
import groffse.Settings;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class InGameScreen extends Screen {
    private final static String SCREEN_NAME = "INGAME";
    private ArrayList<PanelComponent> panelList;

    public InGameScreen() {
        super(SCREEN_NAME);
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);
    }

    @Override
    public void prepare() {
        super.prepare();
        GameController.setGameStatus(GameStatus.NEW); // New game when entering the ingame screen from menu
        Input.keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> {
            if (this.isVisible()) {
                Game.window().getRenderComponent().fadeOut(1000);
                this.setVisible(false);
                Game.screens().get("MENU").setVisible(true);
                Game.screens().display("MENU");
                //Game.screens().remove(Game.screens().get("INGAME"));
                Game.window().getRenderComponent().fadeIn(1000);
            }
        });
    }

    @Override
    protected void initializeComponents() {
        super.initializeComponents();
        //test_panel = new PanelComponent(200,200,0);
        //this.getComponents().add(test_panel);
        initPanelComponentsList();
        gameEvent();
    }


    /*TODO: Adjust position and size of panels according to resolution*/
    private void initPanelComponentsList() {
        int index = 0;
        panelList = new ArrayList<>();
        for(int i = 0; i < Settings.height; i++) {
            for(int j = 0; j < Settings.width; j++) {
                panelList.add(new PanelComponent(100+(60*j), 100 + (60*i), index));
                this.getComponents().add(panelList.get(index));
                index++;
            }
        }
    }

    public void update() {
        this.getComponents().clear();
        panelList.clear();
        this.initializeComponents();
    }

    public void updateInGamePanelList (Iterable<Integer> list) {
        for(GuiComponent component : this.getComponents()) {
            if(component instanceof PanelComponent) {
                for(Integer id : list) {
                    if(((PanelComponent) component).getID() == id) {
                        ((PanelComponent) component).adjacentBombs = 0;
                        ((PanelComponent) component).clicked = true;
                    }
                }
            }
        }
    }

    private void gameEvent() {
        for(PanelComponent pc : panelList) {
            pc.onClicked(e ->{
                updateInGamePanelList( GameController.click(pc.getID()) );
                //System.out.println(e.getEvent().getButton()); /*1 is left click and 3 right click*/
            });
        }
    }
}
