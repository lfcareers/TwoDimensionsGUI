import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class for the GUI
class BoardGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private Board board;

    public BoardGUI() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);

        board = new Board();
        add(board);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        JMenuItem newBoardItem = new JMenuItem("New Board");
        newBoardItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.generateBoard();
            }
        });

        JMenuItem loadBoardItem = new JMenuItem("Load Board");
        loadBoardItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    board.loadBoard(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        JMenuItem saveBoardItem = new JMenuItem("Save Board");
        saveBoardItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    board.saveBoard(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        menu.add(newBoardItem);
        menu.add(loadBoardItem);
        menu.add(saveBoardItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BoardGUI();
        });
    }
}