package bcit.comp2522.projectteama;

import java.awt.*;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

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
     player = new Player( new PVector(window.width/2 , window.height/2 ),
            new PVector(0, 1),
            15,
            2,
            new Color(0, 255, 0), window, 3);
     player.setHitBox(new Rectangle((int) player.getPosition().x,
             (int) player.getPosition().y, (int) player.getSize(), (int)player.getSize()));
  }



  @Override
  public void remove() {

  }
}
