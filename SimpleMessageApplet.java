import java.applet.Applet;
import java.awt.Graphics;

public class SimpleMessageApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello, this is a simple message!", 20, 20);
    }
}
