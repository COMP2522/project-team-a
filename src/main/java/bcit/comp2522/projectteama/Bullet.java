package bcit.comp2522.projectteama;

import processing.core.PVector;

import java.awt.*;

public class Bullet extends Sprite{
  protected int damage;

  public Bullet(PVector position, PVector direction, float width, float height,
                float speed, Color color, Window window, Rectangle hitBox, int damage) {
    super(position, direction, width, height, speed, color, window, hitBox);
    this.damage = damage;
  }
}
