package bcit.comp2522.projectteama;

import processing.core.PVector;

import java.awt.*;

public class Player extends Creature implements Collidable {

  public Player(PVector position, PVector direction, float width, float height,
                float speed, Color color, Window window, Rectangle hitBox, int health) {
    super(position, direction, width, height, speed, color, window, hitBox, health);
  }




  public void doFire(Bullet b) {

  }

  public void upgrade(){

  }
  @Override
  void takeDamage() {
    this.health--;
  }

  @Override
  public Rectangle getHitBox() {
    return hitBox;
  }

  @Override
  public void handleCollision(Collidable other) {
    if (other instanceof Enemy) {
      takeDamage();
    }
  }

  public void setDirection(PVector rotate) {
  }
}
