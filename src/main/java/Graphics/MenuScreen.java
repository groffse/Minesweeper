package Graphics;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.Input;
import groffse.App;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuScreen extends Screen {

    public static final String SCREEN_NAME = "MENU";
    private ImageComponent playButton;
    private ImageComponent settingsButton;
    private ImageComponent creditButton;
    private ImageComponent exitButton;

    private final double MENU_BUTTON_GAP = 70;

    public MenuScreen() {
        super(SCREEN_NAME);
    }

    @Override
    public void render(final Graphics2D g) {

        if(Game.world().environment() != null) {
            Game.world().environment().render(g);
        }

        String title_name = "Minesweeper 2.0";
        String info = "A game made with litiengine";

        g.setFont(App.GUI_FONT);
        g.setColor(Color.WHITE);

        double infoX = Game.window().getCenter().getX() - g.getFontMetrics().stringWidth(info) / 2.0;
        double infoY = Game.window().getResolution().getHeight() - g.getFontMetrics().getHeight() - 10;
        TextRenderer.render(g, info, infoX, infoY);

        double title_nameX = Game.window().getCenter().getX() - g.getFontMetrics().stringWidth(title_name) / 2.0;
        double title_nameY = g.getFontMetrics().getHeight() + 30;
        TextRenderer.render(g,title_name,title_nameX,title_nameY);


        playButton.setVisible(true);
        settingsButton.setVisible(true);
        exitButton.setVisible(true);
        super.render(g);
    }

    @Override
    public void prepare() {
        super.prepare();
        Input.keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> {
            if (this.isVisible()) {
                System.exit(0);
            }
        });

    }

    @Override
    protected void initializeComponents() {
        super.initializeComponents();
        double x = Game.window().getCenter().getX();
        double y = Game.window().getCenter().getY()/2;

        double width = Game.window().getResolution().getWidth() / 3;
        double height = Game.window().getResolution().getHeight() / 8;

        this.playButton = new ImageComponent(x - width / 2.0, (y + height / 2.0) , width, 60);
        this.playButton.setText("PLAY GAME");
        this.playButton.getAppearance().setForeColor(new Color(215,82,82));
        this.playButton.getAppearanceHovered().setForeColor(new Color(253,184,184));

        this.settingsButton = new ImageComponent(x - width / 2.0, (y + height / 2.0) + MENU_BUTTON_GAP , width, 60);
        this.settingsButton.setText("SETTINGS");
        this.settingsButton.getAppearance().setForeColor(new Color(215,82,82));
        this.settingsButton.getAppearanceHovered().setForeColor(new Color(253,184,184));

        this.exitButton = new ImageComponent(x - width / 2.0, (y + height / 2.0) + MENU_BUTTON_GAP*2, width, 60);
        this.exitButton.setText("EXIT GAME");
        this.exitButton.getAppearance().setForeColor(new Color(215,82,82));
        this.exitButton.getAppearanceHovered().setForeColor(new Color(253,184,184));

        this.getComponents().add(this.playButton);
        this.getComponents().add(this.settingsButton);
        this.getComponents().add(this.exitButton);

        initMenuEvents();

    }

    private void initMenuEvents() {
        this.exitButton.onClicked(e -> {
            System.exit(0);
        });
    }
}
