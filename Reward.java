import java.awt.*;

// Class representing Reward
class Reward extends BoardObject {
    public Reward(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x * 20, y * 20, 20, 20); // Adjust size as needed
    }
}