package bcit.comp2522.projectteama;

import java.awt.*;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

public class EnemyManager extends Manager{
  ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  private Window window;
  int minSize = 10;
  int maxSize = 15;

  public EnemyManager(Window window) {
    this.window = window;
  }

  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  @Override
  public void add() {
    enemies.add(new Enemy(
            new PVector(random(0, window.width), random(0, window.height)),
            new PVector(random(-1, 1), random(-1, 1)),
            random(minSize, maxSize),
            random(0, 2),
            new Color(255, 0, 0), window, 3
    ));
  }

  @Override
  public void remove() {

  }
}
