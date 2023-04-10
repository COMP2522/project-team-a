package bcit.comp2522.projectteama;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;


public class Window extends PApplet{

  private EnemyManager enemyManager;
  private PlayerManager playerManager;
  private BulletManager bulletManager;
  private DatabaseHandler databaseHandler;
  private GameStateManager gameStateManager;
  private PImage backgroundImage;
  private PImage backgroundImage2;
  private PImage backgroundImage3;
  private PVector aimDirection = new PVector(0, -1);
  private int currentScore = 0;
  StartMenu startMenu;
  GameOverMenu gameOverMenu;
  /**
   * Sets window size
   */
  public void settings() {
    size(800,800);

  }

  /**
   * Initializes all required elements
   */
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
    playerManager = new PlayerManager(this);
    enemyManager = new EnemyManager(this);
    bulletManager = new BulletManager(this);

    gameStateManager = new GameStateManager();
    databaseHandler = new DatabaseHandler("spaceShoot", "spaceshoot", this);

    playerManager.add();

    for (int i = 0; i < 10; i++) { // magic number
      enemyManager.add();
    }
  }

  /**
   *  Draws the current state of the window based on game state set
   *  by gameStateManager
   */
  public void draw() {
    //When player loses all health
    if(playerManager.getPlayer().getHealth() <= 0) {
      playerManager.remove(playerManager.getPlayer());
      databaseHandler.put("Score");
    }

    gameStateManager.getCurrentState();
    switch (gameStateManager.getCurrentState()) {
      case START_MENU:
        background(backgroundImage2);
        startMenu.displayMenu();
        break;
      case IN_GAME:
        background(backgroundImage);

        playerManager.getPlayer().update();
        playerManager.getPlayer().draw();

        for (Enemy enemy : enemyManager.enemies) {
          enemy.update();
          enemy.draw();
        }
        for (Bullet bullet : bulletManager.getBullets()) {
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
      databaseHandler.put("Score");
      playerManager.getPlayer().setVelocity(new PVector(-3, playerManager.getPlayer().getVelocity().y)); // TODO
    } else if (key == 'd' || key == 'D') {
      playerManager.getPlayer().setVelocity(new PVector(3, playerManager.getPlayer().getVelocity().y));
    } else if (key == 'w' || key == 'W') {
      playerManager.getPlayer().setVelocity(new PVector(playerManager.getPlayer().getVelocity().x, -3));
    } else if (key == 's' || key == 'S') {
      playerManager.getPlayer().setVelocity(new PVector(playerManager.getPlayer().getVelocity().x, 3));
      //Handles aiming
    } else if (keyCode == LEFT) {
      aimDirection = new PVector(-1, 0).normalize();
    } else if (keyCode == RIGHT) {
      aimDirection = new PVector(1, 0).normalize();
    } else if (keyCode == UP) {
      aimDirection = new PVector(0, -1).normalize();
    } else if (keyCode == DOWN) {
      aimDirection = new PVector(0, 1).normalize();
    }

  }

  /**
   * Gets the direction the player is currently aiming.
   * @return A PVector representing the aim direction
   */
  public PVector getAimDirection() {
    return aimDirection;
  }

  /**
   * Sets the current score.
   * @param currentScore The new current score value.
   */
  public void setCurrentScore(int currentScore) {
    this.currentScore = currentScore;
  }

  /**
   * Gets the current score.
   * @return The current score.
   */
  public int getCurrentScore() {
    return currentScore;
  }

  /**
   * Gets the height of the game window.
   * @return The height of the game window.
   */
  public float getHeight() {
    return height;
  }

  /**
   * Gets the width of the game window.
   * @return The width of the game window.
   */
  public float getWidth() { // put above main
    return width;
  }

  /**
   * Gets the game state manager.
   * @return The game state manager.
   */
  public GameStateManager getGameStateManager() {
    return gameStateManager;
  }

  /**
   * Gets the bullet manager.
   * @return The bullet manager.
   */
  public BulletManager getBManager() {
    return bulletManager;
  }

  /**
   * Gets the enemy manager.
   * @return The enemy manager.
   */
  public EnemyManager getEManager() {
    return enemyManager;
  }

  /**
   *  Sets key pressed state back to non-pressed state
   */
  @Override
  public void keyReleased() {
    if ((key == 'a' || key == 'A') && playerManager.getPlayer().getVelocity().x < 0) {
      playerManager.getPlayer().setVelocity(new PVector(0, playerManager.getPlayer().getVelocity().y));
    } else if ((key == 'd' || key == 'D') && playerManager.getPlayer().getVelocity().x > 0) {
      playerManager.getPlayer().setVelocity(new PVector(0, playerManager.getPlayer().getVelocity().y));
    } else if ((key == 'w' || key == 'W') && playerManager.getPlayer().getVelocity().y < 0) {
      playerManager.getPlayer().setVelocity(new PVector(playerManager.getPlayer().getVelocity().x, 0));
    } else if ((key == 's' || key == 'S') && playerManager.getPlayer().getVelocity().y > 0) {
      playerManager.getPlayer().setVelocity(new PVector(playerManager.getPlayer().getVelocity().x, 0));
    }
    if (key == ' ') {
      playerManager.getPlayer().doFire();
    }
  }

  /**
   * Handles mouse click events
   */
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

}
