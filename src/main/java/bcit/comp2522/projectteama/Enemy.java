package bcit.comp2522.projectteama;

import processing.core.PVector;
import processing.core.PApplet;

import java.awt.*;

public class Enemy extends Creature<Bullet> implements Collidable{
  private int scoreGiven;
  public Enemy(PVector position, PVector direction, float width, float height,
               float speed, Color color, Window window, Rectangle hitBox, int health, int scoreGiven) {
    super(position, direction, width, height, speed, color, window, hitBox, health);
  }



  @Override
  void takeDamage(Bullet bullet) {
    health = health - bullet.getDamage();
    if (this.health == 0) {
      window.getEManager().remove(this);

    }
  }

  @Override
  public Rectangle getHitBox() {
    return null;
  }

  @Override
  public void handleCollision(Collidable other) {
    if (other instanceof Bullet) {
      if (this.isCollidingWith(other)) {
        this.takeDamage((Bullet) other);
      }
    }
  }
}
