package bcit.comp2522.projectteama;

import java.awt.*;
import java.util.ArrayList;

import processing.core.PVector;

public class EnemyManager extends Manager{
  ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  private Window window;

  public EnemyManager(Window window) {
    this.window = window;
  }

  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  @Override
  public void add() {
    Enemy enemy = new Enemy(
            new PVector(random(0, window.width), random(0, window.height)),
            new PVector(random(-1, 1), random(-1, 1)),
            20, 20, 2, new Color(255, 255, 0),
            window, new Rectangle(0, 0, 20, 20), 3);

    enemies.add(enemy);
  }

  @Override
  public void remove() {

  }
}
