package bcit.comp2522.projectteama;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;
import processing.core.PVector;

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
    //bManager = new BulletManager(this);
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
          creature.update();
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

  @Override
  public void keyPressed() {
    if (key == 'a' || key == 'A') {
      pManager.getPlayer().setVelocity(new PVector(-3, pManager.getPlayer().getVelocity().y));
    } else if (key == 'd' || key == 'D') {
      pManager.getPlayer().setVelocity(new PVector(3, pManager.getPlayer().getVelocity().y));
    } else if (key == 'w' || key == 'W') {
      pManager.getPlayer().setVelocity(new PVector(pManager.getPlayer().getVelocity().x, -3));
    } else if (key == 's' || key == 'S') {
      pManager.getPlayer().setVelocity(new PVector(pManager.getPlayer().getVelocity().x, 3));
    }
  }

  @Override
  public void keyReleased() {
    if ((key == 'a' || key == 'A') && pManager.getPlayer().getVelocity().x < 0) {
      pManager.getPlayer().setVelocity(new PVector(0, pManager.getPlayer().getVelocity().y));
    } else if ((key == 'd' || key == 'D') && pManager.getPlayer().getVelocity().x > 0) {
      pManager.getPlayer().setVelocity(new PVector(0, pManager.getPlayer().getVelocity().y));
    } else if ((key == 'w' || key == 'W') && pManager.getPlayer().getVelocity().y < 0) {
      pManager.getPlayer().setVelocity(new PVector(pManager.getPlayer().getVelocity().x, 0));
    } else if ((key == 's' || key == 'S') && pManager.getPlayer().getVelocity().y > 0) {
      pManager.getPlayer().setVelocity(new PVector(pManager.getPlayer().getVelocity().x, 0));
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
