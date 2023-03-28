package bcit.comp2522.projectteama;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.awt.*;
import java.util.ArrayList;


public class Window extends PApplet{
  public Sprite sprite;
  public ArrayList<Creature> creatures;
  public EnemyManager eManager;
  public PlayerManager pManager;
  public BulletManager bManager;
  public StartMenuHandler startHandler;
  public GameStateManager gameStateManager;
  PImage backgroundImage;

  Background background;
  StartMenu startMenu;



  public void settings() {
    size(800,800);

  }

  public void setup() {
    this.init();
    surface.setTitle("Shooting Space");
    backgroundImage = loadImage("images/background.png");
    backgroundImage.resize(width, height);
    background = new Background(this);

    setupMenu();
  }

  /**
   * Sets up the menu.
   */
  public void setupMenu() {
    startMenu = new StartMenu(this);
    startMenu.menuButtons();
  }

  /**
   * initializes all the elements that are required.
   * these include the player and enemy.
   */
  public void init() {
    creatures = new ArrayList<Creature>();
    pManager = new PlayerManager(this);
    eManager = new EnemyManager(this);
    bManager = new BulletManager(this);
    startHandler = new StartMenuHandler(this);
    gameStateManager = new GameStateManager();

    pManager.add();

    for (int i = 0; i < 10; i++) {
      eManager.add();
    }
    creatures.addAll(eManager.getEnemies());
    creatures.add(pManager.getPlayer());

  }
  //Temporary implementation; Will change once button clicking is established
  public void draw() {
    background(backgroundImage);

    /**
    if (player.getLives() == 0) {
      gameStateManager.setActiveState(GameState.GAME_OVER);
    }
    */
    gameStateManager.getCurrentState();
    switch (gameStateManager.getCurrentState()) {
      case START_MENU:
        startMenu.displayMenu();
        break;
      case IN_GAME:
        for (Creature creature : creatures) {
          creature.draw();
        }
        break;
      //case PAUSED:
        // Draw paused screen
        //break;
      case GAME_OVER:
        // Draw game over screen
        break;
    }
  }

  public void mouseClicked() {
    if (startMenu.getNewGameButton().isMouseOver()) {
      gameStateManager.setInGameState();
      draw();
    }
    if (startMenu.getQuitButton().isMouseOver()) {
      exit();
    }
  }

  @Override
  public void keyPressed(KeyEvent event) {
    int keyCode = event.getKeyCode();
    switch (keyCode) {
      case LEFT:
        // handle left
        pManager.getPlayer().setDirection(pManager.getPlayer().getDirection().rotate(-Window.PI / 16));
        break;
      case RIGHT:
        // handle right
        pManager.getPlayer().setDirection(pManager.getPlayer().getDirection().rotate(Window.PI / 16));
        break;
    }
  }

  /**
   * Main function.
   *
   * @param passedArgs arguments from command line
   */
  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"shooter"};
    Window shooter = new Window();
    PApplet.runSketch(appletArgs, shooter);
  }

  public float getWidth() {
    return width;
  }

  public float getHeight() {
    return height;
  }
}
