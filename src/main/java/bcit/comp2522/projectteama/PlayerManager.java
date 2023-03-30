package bcit.comp2522.projectteama;

import processing.core.PVector;

import java.awt.*;

public class PlayerManager extends Manager{

  private Player player;
  private Window window;

  public PlayerManager(Window window) {
    this.window = window;
  }

  public Player getPlayer() {
    return player;
  }

  @Override
  public void add() {
     player = new Player(new PVector(window.width/2 , window.height/2), new PVector(0, 0),
             30, 30, 2, new Color(0, 255, 0), window,
             new Rectangle(0, 0, 30, 30), 3);
  }

  @Override
  public void remove() {

  }
}
