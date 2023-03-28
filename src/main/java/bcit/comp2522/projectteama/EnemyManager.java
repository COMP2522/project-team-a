package bcit.comp2522.projectteama;

import java.awt.*;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

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
            12,
            random(0, 2),
            new Color(255, 255, 0), window, 3
    );
    enemy.setHitBox(new Rectangle((int) enemy.getPosition().x, (int) enemy.getPosition().y, (int)enemy.getSize(), (int)enemy.getSize()));
    enemies.add(enemy);
  }

  @Override
  public void remove() {

  }
}
