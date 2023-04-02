package bcit.comp2522.projectteama;

import java.awt.*;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;
public class BulletManager extends Manager{
  private Window window;

  private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
  public BulletManager(Window window) {
    this.window = window;
  }

  public ArrayList<Bullet> getBullets() {
    return bullets;
  }

  //@Override
  public void add(PVector position, PVector direction) {
    Bullet bullet = new Bullet(position, direction, 15, 15,
            10, new Color(0, 0, 255), window,
            new Rectangle(0, 0, 30, 30), 1);
    bullets.add(bullet);
  }

  @Override
  public void add() {

  }



  //@Override
    public void remove() {

    }
}
