package Graphics;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.GuiProperties;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.TextFieldComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.Input;

import de.gurkenlabs.litiengine.resources.Resource;
import de.gurkenlabs.litiengine.resources.Resources;
import groffse.App;
import groffse.Settings;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SettingsScreen extends Screen {

    public static final String SCREEN_NAME = "SETTINGS";
    private TextFieldComponent numberOfBombs;
    private TextFieldComponent grid_height, grid_width;
    private ImageComponent setting_group;

    private double x;
    private double y;

    private double width;
    private double height;

    public SettingsScreen() {
        super(SCREEN_NAME);
        x = Game.window().getCenter().getX();
        y = Game.window().getCenter().getY()/2;

        width = Game.window().getResolution().getWidth() / 3;
        height = Game.window().getResolution().getHeight() / 8;
    }

    @Override
    public void render(final Graphics2D g) {
        if(Game.world().environment() != null) {
            Game.world().environment().render(g);
        }

        g.setFont(App.GUI_FONT);
        g.setColor(Color.WHITE);

        // Tile screen
        String title_name = "Settings";
        double title_nameX = Game.window().getCenter().getX() - g.getFontMetrics().stringWidth(title_name) / 2.0;
        double title_nameY = g.getFontMetrics().getHeight() + 30;
        TextRenderer.render(g,title_name,title_nameX,title_nameY);

        String textNumberOfBombs = "Bombs:";
        TextRenderer.render(g, textNumberOfBombs, x - width / 2.0 - 55, (y + height / 2.0)+ 42.5);

        String textHeight = "Height:";

        super.render(g);
    }

    // Only used to listen to escape key
    @Override
    public void prepare() {
        super.prepare();
        Input.keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> {
            if (this.isVisible()) {

                try{
                    Settings.numberOfBombs = Integer.parseInt(numberOfBombs.getText());
                }
                catch(NumberFormatException exception) {
                    // Give user warning
                    System.out.println("Err: Cannot set number of bombs " + exception.getMessage());
                }
                finally {
                    // Set default
                    Settings.numberOfBombs = 16;
                }

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


        numberOfBombs   = new TextFieldComponent(x - width / 2.0, (y + height / 2.0),width, 60,null, Integer.toString(Settings.numberOfBombs));
        grid_height     = new TextFieldComponent(x - width / 2.0, (y + height / 2.0)+70,width, 60, null, Integer.toString(Settings.height));
        grid_width      = new TextFieldComponent(x - width / 2.0, (y + height / 2.0)+140,width, 60, null, Integer.toString(Settings.width));
        setting_group   = new ImageComponent(400,400, Resources.images().get("res/Settings_overlay.png"));

        this.getComponents().add(numberOfBombs);
        this.getComponents().add(grid_height);
        this.getComponents().add(grid_width);
        this.getComponents().add(setting_group);
    }
}
