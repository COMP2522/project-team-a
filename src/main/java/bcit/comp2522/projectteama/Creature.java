package bcit.comp2522.projectteama;

import processing.core.PVector;

import java.awt.*;


public abstract class Creature<T> extends Sprite{
  protected int health;


  public Creature(PVector position, PVector direction, float width, float height, float speed, Color color, Window window, Rectangle hitBox, int health) {
    super(position, direction, width, height, speed, color, window, hitBox);
    this.health = health;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  abstract void takeDamage(T object);

}
