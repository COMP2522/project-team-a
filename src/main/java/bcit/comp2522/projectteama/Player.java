package bcit.comp2522.projectteama;

import processing.core.PVector;

import java.awt.*;

public class Player extends Creature {
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
  public Player(PVector position, PVector direction, float size, float speed, Color color, Window window, int lives) {
    super(position, direction, size, speed, color, window, lives);
  }

  public void doFire(Bullet b) {

  }

  public void upgrade(){

  }
  @Override
  void takeDamage() {

  }
}
