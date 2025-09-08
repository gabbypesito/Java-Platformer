import java.awt.*;
import java.util.List;

public class Player {
    int x = 100, y = 100;
    int width = 32, height = 32;
    int speed = 4;
    double yVelocity = 0;
    final double gravity = 0.6;
    boolean onGround = false;
    boolean attacking = false;

    public void update(List<Enemy> enemies, List<Tile> tiles) {
        // Horizontal movement
        if (InputHandler.left) x -= speed;
        if (InputHandler.right) x += speed;

        // Apply gravity
        yVelocity += gravity;
        y += yVelocity;

        // Collision with tiles (basic ground collision)
        onGround = false;
        Rectangle playerRect = new Rectangle(x, y, width, height);
        for (Tile tile : tiles) {
            if (playerRect.intersects(tile.getBounds())) {
                y = tile.y - height; // place player on top
                yVelocity = 0;
                onGround = true;
            }
        }

        // Jump
        if (InputHandler.up && onGround) {
            yVelocity = -10;
        }

        // Combat
        if (attacking) {
            Rectangle attackBox = new Rectangle(x + width, y, 20, height);
            for (Enemy e : enemies) {
                if (e.alive && attackBox.intersects(e.getBounds())) {
                    e.alive = false;
                }
            }
            attacking = false;
        }
    }

    public void attack() {
        attacking = true;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}
