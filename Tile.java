import java.awt.*;

public class Tile {
    int x, y, size;
    public Tile(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, size, size);
    }
}
