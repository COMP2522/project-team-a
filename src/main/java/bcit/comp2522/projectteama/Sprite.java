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
  protected float width;
  protected float height;
  protected float speed;
  protected Color color;
  protected Window window;
  protected Rectangle hitBox;

  public Sprite(PVector position, PVector direction, float width, float height, float speed, Color color, Window window, Rectangle hitBox) {
    this.position = position;
    this.direction = direction;
    this.width = width;
    this.height = height;
    this.speed = speed;
    this.color = color;
    this.window = window;
    this.hitBox = hitBox;
  }

  /**
   * this method draws an ellipse on the window.
   */
  public void draw() {
    window.pushStyle();
    window.fill(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
    window.ellipse(this.position.x, this.position.y, getRadius(), getRadius());
    window.popStyle();
  }

  public void update() {
    this.position = this.getPosition().add(this.direction.copy().mult(speed));
  }

  public void setPosition(PVector position) {
    this.position = position;
  }
  public PVector getPosition() {
    return position.copy();
  }


  public void setDirection(PVector direction) {
    this.direction = direction;
  }

  public PVector getDirection() {
    return direction.copy();
  }

  public float getWidth() {
    return width;
  }

  public void setWidth(float width) {
    this.width = width;
  }

  public float getHeight() {
    return height;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public float getSpeed() {
    return speed;
  }

  public void setSpeed(float speed) {
    this.speed = speed;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Window getWindow() {
    return window;
  }

  public void setWindow(Window window) {
    this.window = window;
  }

  public Rectangle getHitBox() {
    return hitBox;
  }

  public float getRadius() {
    return height/2;
  }


  public void setHitBox(Rectangle hitBox) {
    this.hitBox = new Rectangle((int) getPosition().x,
            (int) getPosition().y, (int) getWidth(), (int)getHeight());
  }
}
