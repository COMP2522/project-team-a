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
    private Button settingButton;
    private Button scoreButton;

    public Button getNewGameButton() {
        return newGameButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }

    public Button getScoreButton() {
        return scoreButton;
    }

    public Button getSettingButton() {
        return settingButton;
    }

    //constructor
    public StartMenu(Window window) {
        this.window = window;
        menuButtons();
    }

    public void displayMenu() {
        newGameButton.display();
        quitButton.display();
        scoreButton.display();
        settingButton.display();
    }

    public void menuButtons() {
        float width = window.getWidth() / 2 - 100;
        this.newGameButton = new Button(window, window.getWidth() / 2 - 330, window.getHeight() / 2 - 50 , 130, 50, "New Game");
        this.scoreButton = new Button(window, window.getWidth() / 2  - 150, window.getHeight() / 2 - 50 , 130, 50, "Score");
        this.quitButton = new Button(window, window.getWidth() / 2 + 200, window.getWidth() / 2 - 50, 130, 50, "Quit");
        this.settingButton = new Button(window, window.getWidth() / 2 + 25, window.getWidth() / 2 - 50, 130, 50, "Setting");
// TODO magic numbers
    }


}
