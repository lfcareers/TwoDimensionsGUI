import java.awt.*;

// Class representing Obstacle
class Obstacle extends BoardObject {
    public Obstacle(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x * 20, y * 20, 20, 20); // Adjust size as needed
    }
}