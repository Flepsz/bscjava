package BreakoutGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BreakoutGame extends JPanel implements KeyListener, ActionListener {
    private int ballX = 150;
    private int ballY = 300;
    private int ballXDir = -2;
    private int ballYDir = -3;

    private int playerX = 300;

    private Timer timer;
    private int delay = 8;

    private ArrayList<ArrayList<Integer>> bricks;
    private int brickRows = 2;
    private int brickColumns = 7;
    private int brickWidth = 80;
    private int brickHeight = 30;

    private int score = 0;
    private boolean gameWon = false;
    private boolean gameOver = false;

    private int scoreX = 10;
    private int scoreY = 30;

    public BreakoutGame() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();

        initializeBricks();
    }

    private void initializeBricks() {
        bricks = new ArrayList<>();
        for (int i = 0; i < brickRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < brickColumns; j++) {
                row.add(1);
            }
            bricks.add(row);
        }
    }

    public void paint(Graphics g) {
        // Background
        g.setColor(Color.decode("#1c1c1c"));
        g.fillRect(0, 0, 700, 600);

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("Score: " + score, scoreX, scoreY);

        // Draw bricks
        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickColumns; j++) {
                if (bricks.get(i).get(j) == 1) {
                    g.setColor(Color.blue);
                    int brickX = j * (brickWidth + 2) + 30;
                    int brickY = i * (brickHeight + 2) + 50;
                    g.fillRect(brickX, brickY, brickWidth, brickHeight);
                    g.setColor(Color.black);
                    g.drawRect(brickX, brickY, brickWidth, brickHeight);
                }
            }
        }

        // Paddle
        g.setColor(Color.decode("#99999"));
        g.fillRect(playerX, 550, 100, 8);

        // Ball
        g.setColor(Color.yellow);
        g.fillOval(ballX, ballY, 20, 20);

        // Game over or game won
        if (gameOver || gameWon) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            String message = gameOver ? "Game Over" : "You Win!";
            g.drawString(message, 250, 300);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 230, 350);
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        ballX += ballXDir;
        ballY += ballYDir;

        // Bouncing off the walls
        if (ballX < 0 || ballX > 660) {
            ballXDir = -ballXDir;
        }
        if (ballY < 0) {
            ballYDir = -ballYDir;
        }

        // Ball falls off
        if (ballY > 570) {
            gameOver = true;
        }

        // Paddle collision
        if (new Rectangle(ballX, ballY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
            ballYDir = -ballYDir;
        }

        // Bricks collision
        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickColumns; j++) {
                if (bricks.get(i).get(j) == 1) {
                    int brickX = j * (brickWidth + 2) + 30;
                    int brickY = i * (brickHeight + 2) + 50;
                    Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                    Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);

                    if (ballRect.intersects(brickRect)) {
                        bricks.get(i).set(j, 0);
                        int ballCenterX = ballX + 10;
                        int ballCenterY = ballY + 10;
                        boolean fromLeft = ballCenterX <= brickX || ballCenterX >= brickX + brickWidth;
                        boolean fromTop = ballCenterY <= brickY || ballCenterY >= brickY + brickHeight;

                        if (fromLeft) {
                            ballXDir = -ballXDir;
                        }
                        if (fromTop) {
                            ballYDir = -ballYDir;
                        }

                        score += 5;

                        int totalBricks = brickRows * brickColumns;
                        if (score == totalBricks * 5) {
                            gameWon = true;
                        }
                    }
                }
            }
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 590) {
                playerX = 590;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX <= 0) {
                playerX = 0;
            } else {
                moveLeft();
            }
        }

        if ((gameOver || gameWon) && e.getKeyCode() == KeyEvent.VK_ENTER) {
            ballX = 150;
            ballY = 300;
            ballXDir = -2;
            ballYDir = -3;
            playerX = 300;
            initializeBricks();
            score = 0;
            gameWon = false;
            gameOver = false;
            repaint();
        }
    }

    private void moveRight() {
        playerX += 20;
    }

    private void moveLeft() {
        playerX -= 20;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout Game");
        BreakoutGame game = new BreakoutGame();
        frame.setBounds(10, 10, 700, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
    }
}