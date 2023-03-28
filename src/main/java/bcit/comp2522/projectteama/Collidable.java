package bcit.comp2522.projectteama;

import java.awt.*;

public interface Collidable {
  Rectangle getHitBox();

  default boolean isCollidingWith(Collidable other) {
    Rectangle thisBox = this.getHitBox();
    Rectangle otherBox = other.getHitBox();

    return thisBox.getX() < otherBox.getX() + otherBox.getWidth() &&
            thisBox.getX() + thisBox.getWidth() > otherBox.getX() &&
            thisBox.getY() < otherBox.getY() + otherBox.getHeight() &&
            thisBox.getY() + thisBox.getHeight() > otherBox.getY();
  }

  void handleCollision(Collidable other);

}
