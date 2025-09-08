public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame("2D Platformer");
        GamePanel panel = new GamePanel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        panel.startGameThread();
    }
}
