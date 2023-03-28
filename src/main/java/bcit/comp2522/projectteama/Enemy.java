package bcit.comp2522.projectteama;

import processing.core.PVector;

import java.awt.*;

public class Enemy extends Creature implements Collidable{

  /**
   * this is a constuctor for the Sprite class that equips the objects with basic
   * functionalities.
   *
   * @param position  the PVector position.
   * @param direction the PVector direction.
   * @param size      float size.
   * @param speed     float speed.
   * @param color     Color color.
   * @param window    Window window.
   * @param lives
   */
  public Enemy(PVector position, PVector direction, float size, float speed, Color color, Window window, int lives) {
    super(position, direction, size, speed, color, window, lives);
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
