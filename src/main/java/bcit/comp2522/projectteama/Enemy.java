package bcit.comp2522.projectteama;

import processing.core.PVector;
import processing.core.PApplet;

import java.awt.*;

public class Enemy extends Creature implements Collidable{
  public Enemy(PVector position, PVector direction, float width, float height,
               float speed, Color color, Window window, Rectangle hitBox, int health) {
    super(position, direction, width, height, speed, color, window, hitBox, health);
  }



  @Override
  void takeDamage() {

  }

  @Override
  public Rectangle getHitBox() {
    return null;
  }

  @Override
  public void handleCollision(Collidable other) {

  }
}
