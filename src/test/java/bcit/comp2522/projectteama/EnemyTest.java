package bcit.comp2522.projectteama;


import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
  Window shooter2;

  @Test
  void handleCollision() {
    // Create a new enemy and bullet object
    String[] appletArgs = new String[]{"shooter2"};
    shooter2 = new Window();
    PApplet.runSketch(appletArgs, shooter2);
    shooter2.init();
        Enemy enemy = new Enemy(new PVector(0, 0), new PVector(0, 0), 50, 50,
                        10, new Color(255, 0, 0), shooter2, new Rectangle(0, 0, 50, 50), 2, 10);
        Bullet bullet = new Bullet(new PVector(0, 0), new PVector(0, 0), 5, 10,
                        10, new Color(0, 255, 0), shooter2, new Rectangle(0, 0, 5, 10), 1);
        // Save the enemy's initial health
    int initialHealth = enemy.getHealth();

    // Call the handleCollision method with the bullet object
    enemy.handleCollision(bullet);

    // Verify that the enemy's health has been reduced by the bullet's damage
    int expectedHealth = initialHealth - bullet.getDamage();
    assertEquals(expectedHealth, enemy.getHealth());
  }
}