package bcit.comp2522.projectteama;

public class GameOverMenu {
    Window window;
    private Button newGameButton1;
    private Button startMenuButton1;
    private Button quitButton1;

    public GameOverMenu(Window window) {
        this.window = window;
        GameOverMenuButtons();
    }


    public Button getNewGameButton1() {
        return newGameButton1;
    }

    public Button getStartMenuButton1() {
        return startMenuButton1;
    }

    public Button getQuitButton1() {
        return quitButton1;
    }

    public void displayMenu() {
        newGameButton1.display();
        quitButton1.display();
        startMenuButton1.display();
    }

    public void GameOverMenuButtons() {
        float width = window.getWidth() / 2 - 100;
        this.newGameButton1 = new Button(window, window.getWidth() / 2 - 330, window.getHeight() / 2 - 50 , 130, 50, "New Game");
        this.quitButton1 = new Button(window, window.getWidth() / 2 + 200, window.getWidth() / 2 - 50, 130, 50, "Quit");
        this.startMenuButton1 = new Button(window, window.getWidth() / 2 + 100, window.getWidth() / 2 - 50, 130, 50, "StartMenu");

// TODO magic numbers
    }
}
