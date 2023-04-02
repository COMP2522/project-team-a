package bcit.comp2522.projectteama;

import processing.core.PVector;

import java.awt.*;

public class Player extends Creature implements Collidable {

  public Player(PVector position, PVector direction, float width, float height,
                float speed, Color color, Window window, Rectangle hitBox, int health) {
    super(position, direction, width, height, speed, color, window, hitBox, health);

  }

  /**
   * Calculates and returns the current velocity of the sprite based on its direction and speed.
   */
  public PVector getVelocity() {
    return PVector.mult(direction, speed);
  }

  /**
   * Sets the velocity of the sprite based on the given velocity vector by updating its direction and speed fields.
   */
  public void setVelocity(PVector velocity) {
    this.direction = velocity.copy().normalize();
    this.speed = velocity.mag();
  }

  public void doFire() {
    window.getBManager().add(this.position, window.getAimDirection());
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

}
