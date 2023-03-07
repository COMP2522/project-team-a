package bcit.comp2522.projectteama;

import processing.core.PVector;

import java.awt.*;

public class Bullet extends Sprite{
  protected int damage;
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
   */
  public Bullet(PVector position, PVector direction, float size, float speed, Color color, Window window, int damage) {
    super(position, direction, size, speed, color, window);
    this.damage = damage;
  }

}
