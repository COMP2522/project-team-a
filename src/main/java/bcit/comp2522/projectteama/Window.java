package bcit.comp2522.projectteama;

import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.ArrayList;

public class Window extends PApplet{
  public Sprite sprite;
  public ArrayList<Creature> creatures;
  public EnemyManager eManager;
  public PlayerManager pManager;

  Background background;
  StartMenu menu;


  public void settings() {
    size(1200,800);

  }

  public void setup() {
    this.init();
    surface.setTitle("Shooting Space");
    background = new Background(this);
    setupMenu();
  }

  /**
   * Sets up the menu.
   */
  public void setupMenu() {
    menu = new StartMenu(this);
    menu.menuButtons();
  }

  public void settings() {
    size(640, 360);
  }

  /**
   * initializes all the elements that are required.
   * these include the player and enemy.
   */
  public void init() {
    creatures = new ArrayList<Creature>();
    pManager = new PlayerManager(this);
    eManager = new EnemyManager(this);

<<<<<<<<< Temporary merge branch 1
    pMan.add();
=========
    pManager.add();
>>>>>>>>> Temporary merge branch 2

    for (int i = 0; i < 10; i++) {
      eManager.add();
    }
    creatures.addAll(eManager.getEnemies());
    creatures.add(pManager.player);
  }

  public void draw() {
    background(42);
    for (Creature creature : creatures) {
      creature.draw();
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
