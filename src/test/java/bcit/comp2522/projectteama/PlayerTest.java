package bcit.comp2522.projectteama;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PVector;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

  private Window window;
  private Player player;

  @BeforeEach
  public void setUp() {
    window = new Window();
    window.settings();
    player = new Player(new PVector(window.getWidth() / 2, window.getHeight() / 2), new PVector(0, 0),
            30, 30, 2, new Color(0, 255, 0), window, new Rectangle(0, 0, 30, 30), 3);
  }

  @Test
  void getVelocity() {
  }

  @Test
  void setVelocity() {
  }

  @Test
  void testDoFire() {
    player.doFire();

  }

  @Test
  void takeDamage() {
  }

  @Test
  void getHitBox() {
  }

  @Test
  void handleCollision() {
  }
}