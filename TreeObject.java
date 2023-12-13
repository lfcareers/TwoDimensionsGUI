import java.awt.*;
import java.io.Serializable;

// Abstract class for BoardObjects
abstract class TreeObject implements Serializable {
    protected int x, y;  // position on the board
    protected Color color;

    public TreeObject(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    abstract void draw(Graphics g);
}