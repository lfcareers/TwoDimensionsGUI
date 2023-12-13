import java.awt.*;
import java.io.Serializable;

// Abstract class for BoardObjects
abstract class GemItem implements Serializable {
    protected int x, y;  // position on the board
    protected Color color;

    public GemItem(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    abstract void draw(Graphics g);
}

public class GemItems {
}
