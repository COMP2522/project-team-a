package bcit.comp2522.projectteama;

import java.awt.*;

import processing.core.PVector;

public class PlayerManager extends Manager{

  Player p;
  private Window window;

  public PlayerManager(Window window) {
    this.window = window;
  }

  public Player getP() {
    return p;
  }

  @Override
  public void add() {
     p = new Player( new PVector(this.width / 2, this.height / 2),
            new PVector(0, 1),
            9,
            2,
            new Color(0, 255, 0), window, 3);

  }



  @Override
  public void remove() {

  }
}
