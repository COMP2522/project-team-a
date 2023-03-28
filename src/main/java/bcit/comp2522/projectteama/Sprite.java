package bcit.comp2522.projectteama;


import java.awt.*;

import processing.core.PVector;

/**
 * This class is responsible for the most common variables and methods
 * that are common for the player, enemy and wall class.
 */
public class Sprite {
  protected PVector position;
  protected PVector direction;
  protected float size;
  protected float speed;
  protected Color color;
  protected Window window;
  protected Rectangle hitBox;


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
  public Sprite(PVector position, PVector direction, float size,
                float speed, Color color, Window window) {
    this.position = position;
    this.direction = direction;
    this.size = size;
    this.speed = speed;
    this.window = window;
    this.color = color;
  }

  /**
   * this method draws an ellipse on the window.
   */
  public void draw() {
    window.pushStyle();
    window.fill(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
    window.ellipse(this.position.x, this.position.y, size, size);
    window.popStyle();
  }

  public PVector getDirection() {
    return direction.copy();
  }

  public PVector getPosition() {
    return position.copy();
  }

  public float getSize() {
    return size;
  }

  public void setDirection(PVector direction) {
    this.direction = direction;
  }

  public void setHitBox(Rectangle hitBox){
    this.hitBox = hitBox;
  }

}
