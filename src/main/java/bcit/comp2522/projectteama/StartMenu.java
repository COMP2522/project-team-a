package bcit.comp2522.projectteama;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
import java.awt.*;



public class StartMenu {

    Window window;

    //Instantiate menu buttons
    private Button newGameButton;
    private Button quitButton;

    ArrayList<Button> buttons;

    public Button getNewGameButton() {
        return newGameButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }

    //constructor
    public StartMenu(Window window) {
        this.window = window;
        menuButtons();
    }

    public void displayMenu() {
        newGameButton.display();
        quitButton.display();
    }

    public void menuButtons() {
        float width = window.getWidth() / 2 - 100;
        this.newGameButton = new Button(window, window.getWidth() / 2 - 250, window.getHeight() / 2 - 50 , 200, 50, "New Game");
        this.quitButton = new Button(window, window.getWidth() / 2  + 72, window.getHeight() / 2 - 50 , 200, 50, "Quit");
// TODO magic numbers
    }


}
