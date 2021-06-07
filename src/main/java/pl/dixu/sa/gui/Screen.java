package pl.dixu.sa.gui;


import pl.dixu.sa.game.Battle;
import pl.dixu.sa.game.GameData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Screen extends JFrame {

    private GameView gameView;

    public Screen(GameData gameData) throws HeadlessException {
        this.gameView = new GameView(gameData);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Card game");
        setVisible(true);
        add(new GraphicPanel());
    }

    class GraphicPanel extends JPanel implements ActionListener, MouseListener {

        private Timer timer;

        public GraphicPanel() {
            timer = new Timer(1000 / 60, this);
            timer.start();
            setFocusable(true);
            addMouseListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            gameView.render(g);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            gameView.reactToClick(e.getX(), e.getY());
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public static void main(String[] args) {
        GameData game = new Battle();
        SwingUtilities.invokeLater(() -> new Screen(game));
    }


}
