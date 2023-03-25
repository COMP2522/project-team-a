package bcit.comp2522.projectteama;

import java.util.ArrayList;

public class StartMenu {

    Window window;

    //Instantiate menu buttons
    Button newGameButton;
    Button quitButton;

    ArrayList<Button> buttons;

    //constructor
    public StartMenu(Window window) {
        this.window = window;
        menuButtons();
    }

    public void menuButtons() {
        float width = window.getWidth() / 2 - 100;
        this.newGameButton = new Button(window, window.getWidth() / 2 - 100, window.getHeight() / 2 - 100 , 200, 50, "New Game");
        this.quitButton = new Button(window, window.getWidth() / 2 - 100, window.getHeight() / 2 + 125 , 200, 50, "Quit");

    }
}
