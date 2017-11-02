import java.awt.Graphics;
import java.awt.Graphics2D;

import Game.GameWindow;
import Game.Drop.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Base.Window;
public class Main {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
			GameFrame gameframe = new GameFrame();
			GameWindow gamewindow = new GameWindow();
			gameframe.add(gamewindow);
			gameframe.pack();
            gameframe.setSize(800,600);
			gameframe.setVisible(true);
			gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		});
    }
}
