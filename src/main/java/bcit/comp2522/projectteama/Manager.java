package bcit.comp2522.projectteama;

import processing.core.PApplet;

public abstract class Manager<T> extends PApplet {
  public abstract void add();
  public abstract void remove(T object);
}
