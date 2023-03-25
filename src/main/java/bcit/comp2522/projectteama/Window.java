package bcit.comp2522.projectteama;

import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.ArrayList;

public class Window extends PApplet{
  public Sprite sprite;
  public ArrayList<Creature> creatures;
  public EnemyManager eManager;
  public PlayerManager pManager;

  public void setup() {
    this.init();
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

    pManager.add();

    for (int i = 0; i < 10; i++) {
      eManager.add();
    }
    creatures.addAll(eManager.getEnemies());
    creatures.add(pManager.player);
  }

  public void draw() {
    background(0);
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
}
