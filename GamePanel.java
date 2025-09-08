public class GamePanel extends JPanel implements Runnable {
    final int WIDTH = 800, HEIGHT = 600;
    Thread gameThread;
    public Player player;
    List<Enemy> enemies;
    List<Tile> tiles;

    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        player = new Player();

        enemies = new ArrayList<>();
        enemies.add(new Enemy(500, 500));

        tiles = new ArrayList<>();
        // Add a floor
        for (int i = 0; i < WIDTH; i += 32) {
            tiles.add(new Tile(i, 550, 32));
        }

        this.addKeyListener(new InputHandler(this));
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / 60;
        double delta = 0;
        long lastTime = System.nanoTime();

        while (gameThread != null) {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        player.update(enemies, tiles);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Tile tile : tiles) tile.draw(g);
        for (Enemy e : enemies) e.draw(g);
        player.draw(g);
        g.dispose();
    }
}
