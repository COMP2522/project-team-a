package bcit.comp2522.projectteama;

import processing.core.PApplet;
import processing.core.PConstants;

import java.awt.*;

public class Button {

    //Variables for button size and content
    float x, y, w, h;
    String text;

    //Displaying buttons in this window
    PApplet parent;
    Window window;

    Button(PApplet parent, float x, float y, float w, float h, String text) {
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.text = text;
    }

    //Formatting for the displayed buttons
    void display() {
        parent.stroke(0);
        parent.fill(200);
        parent.rect(x, y, w, h);
        parent.fill(0);
        parent.textSize(20);
        parent.textAlign(PConstants.CENTER, PConstants.CENTER);
        parent.text(text, x + w / 2, y + h / 2);
    }

    public boolean isMouseOver() {
        return parent.mouseX >= x && parent.mouseX <= x + w &&
                parent.mouseY >= y && parent.mouseY <= y + h;
    }
}
