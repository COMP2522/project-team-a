package bcit.comp2522.projectteama;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;


public class Window extends PApplet{

  private ArrayList<Creature> creatures;
  private EnemyManager eManager;
  private PlayerManager pManager;
  private BulletManager bManager;
  private StartMenuHandler startHandler;
  private GameOverMenuHandler gameOverHandler;
  private GameStateManager gameStateManager;
  private PImage backgroundImage;
  private PImage backgroundImage2;
  private PImage backgroundImage3;
  private PVector aimDirection = new PVector(0, -1);


  StartMenu startMenu;

  GameOverMenu gameOverMenu;
  /**
   * Sets window size
   */
  public void settings() {
    size(800,800);

  }

  public void setup() {
    this.init();
    surface.setTitle("Shooting Space"); // Constant
    backgroundImage = loadImage("images/background.png"); // Move to a constant
    backgroundImage.resize(width, height);
    backgroundImage2 = loadImage("images/backgroundI.png"); // TODO
    backgroundImage2.resize(width, height);
    backgroundImage3 = loadImage("images/GameOver.png");
    backgroundImage3.resize(width,height);
    setupStartMenu();
  }

  /**
   * Sets up the menu.
   */
  public void setupStartMenu() {
    startMenu = new StartMenu(this);
    startMenu.menuButtons();
  }

//  /**
//   * Sets up the menu.
//   */
//  public void setupGameOverMenu() {
//    gameOverMenu = new GameOverMenu(this);
//    gameOverMenu.GameOverMenuButtons();
//  }

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

    for (int i = 0; i < 10; i++) { // magic number
      eManager.add();
    }
    creatures.addAll(eManager.getEnemies());
    creatures.add(pManager.getPlayer());

  }

  public void draw() {


    /**
    if (player.getLives() == 0) {
      gameStateManager.setActiveState(GameState.GAME_OVER);
    }
    */
    gameStateManager.getCurrentState();
    switch (gameStateManager.getCurrentState()) {
      case START_MENU:
        background(backgroundImage2);
        startMenu.displayMenu();
        break;
      case IN_GAME:
        background(backgroundImage);
        for (Creature creature : creatures) {
          creature.update();
          creature.draw();
        }
        for (Bullet bullet : bManager.getBullets()) {
          bullet.update();
          bullet.draw();
        }
        break;
      //case PAUSED:
        // Draw paused screen
        //break;
      case GAME_OVER:
        background(backgroundImage3);
        gameOverMenu.displayMenu();
        //setupGameOverMenu();
        break;
    }
  }

  /**
   * Processes key presses to control the player sprite
   */
  @Override
  public void keyPressed() {
    //Handles movement
    if (key == 'a' || key == 'A') {
      pManager.getPlayer().setVelocity(new PVector(-3, pManager.getPlayer().getVelocity().y)); // TODO
    } else if (key == 'd' || key == 'D') {
      pManager.getPlayer().setVelocity(new PVector(3, pManager.getPlayer().getVelocity().y));
    } else if (key == 'w' || key == 'W') {
      pManager.getPlayer().setVelocity(new PVector(pManager.getPlayer().getVelocity().x, -3));
    } else if (key == 's' || key == 'S') {
      pManager.getPlayer().setVelocity(new PVector(pManager.getPlayer().getVelocity().x, 3));
      //Handles aiming
    } else if (keyCode == LEFT) {
      aimDirection = new PVector(-1,0).normalize();
    } else if (keyCode == RIGHT) {
      aimDirection = new PVector(1,0).normalize();
    } else if (keyCode == UP) {
      aimDirection = new PVector(0,-1).normalize();
    } else if (keyCode == DOWN) {
      aimDirection = new PVector(0, 1).normalize();
    }

  }

  public PVector getAimDirection() {
    return aimDirection;
  }

  /**
   *  Sets key pressed state back to non-pressed state
   */
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
    if (key == ' ') {
      pManager.getPlayer().doFire();
    }
  }

  public BulletManager getBManager() {
    return bManager;
  }

  public void mouseClicked() {
    if (startMenu.getNewGameButton().isMouseOver()) {
      gameStateManager.setInGameState();
      draw();
    }
    if (startMenu.getQuitButton().isMouseOver()) {
      exit();
    }
    if (startMenu.getScoreButton().isMouseOver()) {
      exit(); // changed this after the score board implemented;
    }
    if (startMenu.getSettingButton().isMouseOver()) {
      exit(); // changed this after the setting board implemented;
    }
//    if (gameOverMenu.getStartMenuButton1().isMouseOver()) {
//
//    }
//    if(gameOverMenu.getNewGameButton1().isMouseOver()) {
////      gameStateManager.setInGameState();
////      draw();
//    }
//    if (gameOverMenu.getQuitButton1().isMouseOver()) {
////      exit();
//    }
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

  public float getWidth() { // put above main
    return width;
  }

  public float getHeight() {
    return height;
  }
}
