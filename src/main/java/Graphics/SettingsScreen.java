package Graphics;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.TextFieldComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.Input;

import groffse.App;
import groffse.Settings;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SettingsScreen extends Screen {

    public static final String SCREEN_NAME = "SETTINGS";
    private TextFieldComponent numberOfBombs;

    public SettingsScreen() {super(SCREEN_NAME);}

    @Override
    public void render(final Graphics2D g) {
        if(Game.world().environment() != null) {
            Game.world().environment().render(g);
        }



        g.setFont(App.GUI_FONT);
        g.setColor(Color.WHITE);

        String title_name = "Settings";
        double title_nameX = Game.window().getCenter().getX() - g.getFontMetrics().stringWidth(title_name) / 2.0;
        double title_nameY = g.getFontMetrics().getHeight() + 30;
        TextRenderer.render(g,title_name,title_nameX,title_nameY);

        super.render(g);
    }

    // Only used to listen to escape key
    @Override
    public void prepare() {
        super.prepare();
        Input.keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> {
            if (this.isVisible()) {

                Settings.NumberOfBombs = Integer.parseInt(numberOfBombs.getText());

                Game.window().getRenderComponent().fadeOut(1000);
                this.setVisible(false);
                Game.screens().get("MENU").setVisible(true);
                Game.screens().display("MENU");
                Game.window().getRenderComponent().fadeIn(1000);
            }
        });
    }

    @Override
    public void initializeComponents() {
        super.initializeComponents();

        numberOfBombs = new TextFieldComponent(50,50,150,50,null, "Bombs");

        this.getComponents().add(numberOfBombs);
    }
}
