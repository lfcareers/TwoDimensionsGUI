import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;

// Class representing the game board
class Board extends JPanel {
    private static final long serialVersionUID = 1L;
    private BoardObject[][] boardObjects;
    private int entranceX, entranceY, exitX, exitY;

    public Board() {
        boardObjects = new BoardObject[32][32];
        generateBoard();
    }

    public void generateBoard() {
        clearBoard();
        Random rand = new Random();

        // Set entrance and exit
        entranceX = rand.nextInt(32);
        entranceY = 0;
        exitX = rand.nextInt(32);
        exitY = 31;

        // Add obstacles
        for (int i = 0; i < 256; i++) {
            int obstacleX = rand.nextInt(32);
            int obstacleY = rand.nextInt(32);
            if (boardObjects[obstacleX][obstacleY] == null && (obstacleX != entranceX || obstacleY != entranceY)
                    && (obstacleX != exitX || obstacleY != exitY)) {
                boardObjects[obstacleX][obstacleY] = new Obstacle(obstacleX, obstacleY, Color.BLACK);
            } else {
                i--;
            }
        }

        // Add rewards
        for (int i = 0; i < 16; i++) {
            int rewardX = rand.nextInt(32);
            int rewardY = rand.nextInt(32);
            if (boardObjects[rewardX][rewardY] == null && (rewardX != entranceX || rewardY != entranceY)
                    && (rewardX != exitX || rewardY != exitY)) {
                boardObjects[rewardX][rewardY] = new Reward(rewardX, rewardY, Color.CYAN);
            } else {
                i--;
            }
        }

        repaint();
    }

    private void clearBoard() {
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                boardObjects[i][j] = null;
            }
        }
    }

    public void loadBoard(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            boardObjects = (BoardObject[][]) ois.readObject();
            repaint();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveBoard(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(boardObjects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the board, obstacles, rewards, etc.
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if (boardObjects[i][j] != null) {
                    boardObjects[i][j].draw(g);
                } else if (i == entranceX && j == entranceY) {
                    g.setColor(Color.RED);
                    g.fillRect(i * 20, j * 20, 20, 20);
                } else if (i == exitX && j == exitY) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
            }
        }
    }
}