package bcit.comp2522.projectteama;

import processing.core.PImage;

public class Background {

    private PImage image;
    private Window window;

    public Background(Window window) {
        this.window = window;
        image = window.loadImage("images/background.png");
    }

}
