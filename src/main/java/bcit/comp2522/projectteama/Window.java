package bcit.comp2522.projectteama;

import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;
import java.util.ArrayList;

public class Window extends PApplet{
  public Sprite sprite;
  public ArrayList<Creature> creatures;
  protected Window aa;
  public EnemyManager eMan;
  public PlayerManager pMan;

  public void setup() {
    this.init();
  }

  /**
   * initializes all the elements that are required.
   * these include the player and enemy.
   */
  public void init() {
    creatures = new ArrayList<Creature>();
    pMan = new PlayerManager(this);
    eMan = new EnemyManager(this);


    pMan.add();

    for (int i = 0; i < 10; i++) {
      eMan.add();
    }
    creatures.addAll(eMan.getEnemies());
    creatures.add(pMan.p);
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
        pMan.getP().setDirection(pMan.getP().getDirection().rotate(-Window.PI / 16));
        break;
      case RIGHT:
        // handle right
        pMan.getP().setDirection(pMan.getP().getDirection().rotate(Window.PI / 16));
        break;
    }
  }

  /**
   * Main function.
   *
   * @param passedArgs arguments from command line
   */
  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"aa"};
    Window aa = new Window();
    PApplet.runSketch(appletArgs, aa);
  }
}
