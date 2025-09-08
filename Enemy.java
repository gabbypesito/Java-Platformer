import java.awt.*;

public class Enemy {
    int x, y, width = 32, height = 32;
    boolean alive = true;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        if (alive) {
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
        }
    }
}
