package bcit.comp2522.projectteama;

import java.util.ArrayList;
import processing.core.PImage;
import java.awt.*;



public class StartMenu {

    Window window;

    boolean displayed = true;

    //Instantiate menu buttons
    private Button newGameButton;
    private Button quitButton;
    private StartMenuHandler startHandler;

    ArrayList<Button> buttons;

    //constructor
    public StartMenu(Window window) {
        this.window = window;
        startHandler = new StartMenuHandler(window);
        menuButtons();
    }

    public void display() {
        newGameButton.display();
        quitButton.display();
    }

    /**
    displayed getter
     */
    public boolean isDisplayed() {
        return displayed;
    }

    /**
    Set true or false value for whether menu is being displayed
     */
    public void setDisplayed(boolean displayed) {
        this.displayed = displayed;
    }


    public void menuButtons() {
        float width = window.getWidth() / 2 - 100;
        this.newGameButton = new Button(window, width, window.getHeight() / 2 - 100 , 200, 50, "New Game");
        this.quitButton = new Button(window, width, window.getHeight() / 2 + 125 , 200, 50, "Quit");

    }


}
